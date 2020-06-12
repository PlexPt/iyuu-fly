package com.github.plexpt.iyuu.controller;


import com.github.plexpt.iyuu.client.impl.QBittorrentClient;
import com.github.plexpt.iyuu.config.GlobalConfig;
import com.github.plexpt.iyuu.config.IyuuConfig;
import com.github.plexpt.iyuu.pojo.IyuuSiteRes;
import com.github.plexpt.iyuu.pojo.LoginDto;
import com.github.plexpt.iyuu.utils.AutoReseedUtils;
import com.github.plexpt.iyuu.utils.IyuuOauth;
import com.github.plexpt.iyuu.utils.R;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-09 20:02
 */
@Slf4j
@RestController
@RequestMapping("api")
public class ApiController {


    @Autowired
    AutoReseedUtils autoReseedUtils;

    @Autowired
    IyuuOauth oauth;

    @Autowired
    IyuuConfig config;


    @PostMapping("login")
    public R login(@RequestBody LoginDto dto) {

        String user = GlobalConfig.userConfig.getUser();

        String password = GlobalConfig.userConfig.getPassword();

        if (StringUtils.isBlank(user)) {
            return R.error("请先初始化");
        }

        String sha256Hex = DigestUtil.sha256Hex(dto.getPassword());

        if (dto.getUsername().equals(user) && password.equals(sha256Hex)) {
            return R.ok().putData("");
        }

        return R.error400("用户名或密码错误");
    }

    @PostMapping("auth")
    public R auth(@RequestBody LoginDto dto) {
        QBittorrentClient client = new QBittorrentClient("http://127.0.0.1:12345",
                "admin", "meiyoumima");


        boolean authenticate = client.authenticate();

        String status = client.status();
        System.out.println(status);
        String list = client.getList(null);
        log.error(list);
        return R.ok().putData(status);
    }


    @RequestMapping("reseed")
    public R reseed() {

        autoReseedUtils.reseed();

        return R.ok();
    }


    /**
     * 获取支持站点
     *
     * @return
     */
    @GetMapping("all-site")
    public R site() {
        IyuuSiteRes sites = autoReseedUtils.getSites();
        if (sites.getRet() == 200) {
            return R.ok().putData(sites.getData().getSites());
        } else if (sites.getRet() == 400) {
            return R.error(sites.getRet(), "请先正确配置 token");

        }

        return R.error(sites.getRet(), sites.getMsg());
    }


}
