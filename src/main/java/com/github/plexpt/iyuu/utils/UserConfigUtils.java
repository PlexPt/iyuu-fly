package com.github.plexpt.iyuu.utils;

import com.alibaba.fastjson.JSON;
import com.github.plexpt.iyuu.config.GlobalConfig;
import com.github.plexpt.iyuu.config.UserConfig;

import net.dreamlu.mica.core.utils.PathUtil;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-12 11:56
 */
@Slf4j
public class UserConfigUtils {

    public static UserConfig getConfig() {
        UserConfig config = new UserConfig();

        File file = FileUtil.file(PathUtil.getJarPath(), "config/userconfig.json");

        if (file != null && file.exists()) {
            log.warn("配置文件 加载中...");

            String string = FileUtil.readUtf8String(file);
            config = JSON.parseObject(string, UserConfig.class);
        } else {
            log.warn("配置文件不存在:" + file.toString());
        }

        return config;

    }

    public static UserConfig setConfig(UserConfig config) {

        File file = FileUtil.file(PathUtil.getJarPath(), "config/userconfig.json");

        String configString = JSON.toJSONString(config, true);

        FileUtil.writeUtf8String(configString, file);

        GlobalConfig.userConfig = config;

        log.warn("配置文件 修改成功");

        return config;

    }
}
