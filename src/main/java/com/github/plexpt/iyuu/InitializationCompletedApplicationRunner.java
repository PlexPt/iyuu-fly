package com.github.plexpt.iyuu;


import com.github.plexpt.iyuu.config.GlobalConfig;
import com.github.plexpt.iyuu.utils.OpenInBrowser;
import com.github.plexpt.iyuu.utils.UserConfigUtils;

import net.dreamlu.mica.http.HttpRequest;
import net.dreamlu.mica.http.LogLevel;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * InitializationCompleted
 *
 * @author pt
 */
@Component
@Order(1)
@Slf4j
public class InitializationCompletedApplicationRunner implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void run(ApplicationArguments applicationArguments) {
        log.info("==================启动完成===================");
        try {
            GlobalConfig.userConfig = UserConfigUtils.getConfig();

            printInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * @return
     */
    private Environment printInfo() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "启动完成，时间:" + formatter.format(new Date());

        Environment env = applicationContext.getEnvironment();
        String local = NetUtil.getLocalhostStr();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");

        if (StringUtils.isEmpty(path)) {
            path = "/";
        }
        OpenInBrowser.openByCmd("http://" + local + ":" + port + path);

        String ip = getIp();

        String scheme =
                "\n\t============================================================\n\t" +
                        time + "\n\t" +
                        "访问 URLs:\n\t" +
                        "本地: \t http://" + local + ":" + port + path + "\n\t" +
                        "外网: \t http://" + ip + ":" + port + path + "\n\t" +
                        "============================================================";
        log.info(scheme);

        return env;
    }


    String getIp() {
        return HttpRequest
                .get("http://ip.sb")
                .log(LogLevel.NONE)
                .userAgent("curl/7.6.0")
                .execute()
                .asString()
                .trim();
    }


}
