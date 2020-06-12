package com.github.plexpt.iyuu.controller;


import com.github.plexpt.iyuu.config.GlobalConfig;
import com.github.plexpt.iyuu.config.IyuuConfig;
import com.github.plexpt.iyuu.config.UserConfig;
import com.github.plexpt.iyuu.config.dto.ClientConfig;
import com.github.plexpt.iyuu.config.dto.IyuuSite;
import com.github.plexpt.iyuu.utils.AutoReseedUtils;
import com.github.plexpt.iyuu.utils.IyuuOauth;
import com.github.plexpt.iyuu.utils.R;
import com.github.plexpt.iyuu.utils.UserConfigUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;


/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-09 20:02
 */
@Slf4j
@RestController
@RequestMapping("api/setting")
public class SettingController {


    @Autowired
    AutoReseedUtils autoReseedUtils;

    @Autowired
    IyuuOauth oauth;

    @Autowired
    IyuuConfig config;


    /**
     * @return 获取设置
     */
    @GetMapping("")
    public R setting() {
        return R.ok().putData(GlobalConfig.userConfig);
    }

    /**
     * @return 修改设置
     */
    @PostMapping("")
    public R editsetting(@RequestBody UserConfig config) {

        UserConfig config1 = UserConfigUtils.setConfig(config);

        return R.ok().putData(config1);
    }


    /**
     * @return 新增客户端
     */
    @PostMapping("clent")
    public R clentadd(@RequestBody ClientConfig config) {

        List<ClientConfig> clients = GlobalConfig.userConfig.getClients();

        Optional<ClientConfig> max = clients.stream().max(Comparator.comparing(ClientConfig::getId));
        int id;
        if (max.isPresent()) {
            id = max.get().getId() + 1;
        } else {
            id = 1;
        }
        config.setId(id);

        clients.add(config);

        GlobalConfig.userConfig.setClients(clients);

        UserConfig config1 = UserConfigUtils.setConfig(GlobalConfig.userConfig);

        return R.ok().putData(config1);
    }

    /**
     * @return 新增客户端
     */
    @GetMapping("clent/info/{id}")
    public R clentInfo(@PathVariable Integer id) {

        List<ClientConfig> clients = GlobalConfig.userConfig.getClients();

        for (ClientConfig client : clients) {
            if (client.getId().equals(id)) {
                return R.ok().putData(client);
            }
        }

        return R.error("id不存在");
    }


    /**
     * @return 删除客户端
     */
    @DeleteMapping("clent")
    public R clentdel(@RequestBody Integer[] ids) {

        List<ClientConfig> clients = GlobalConfig.userConfig.getClients();
        List<Integer> idList = Arrays.asList(ids);

        List<ClientConfig> clientConfigs = clients.stream()
                .filter(c -> !idList.contains(c.getId()))
                .collect(Collectors.toList());

        GlobalConfig.userConfig.setClients(clientConfigs);

        UserConfig config1 = UserConfigUtils.setConfig(GlobalConfig.userConfig);

        return R.ok().putData(config1);
    }


    /**
     * @return 修改客户端
     */
    @PutMapping("clent")
    public R clentedit(@RequestBody ClientConfig config) {
        List<ClientConfig> clients = GlobalConfig.userConfig.getClients();

        ClientConfig tmp = null;
        for (ClientConfig client : clients) {
            if (client.getId().equals(config.getId())) {
                tmp = client;
                break;
            }
        }
        if (tmp != null) {
            clients.remove(tmp);
            clients.add(config);
        }

        GlobalConfig.userConfig.setClients(clients);
        UserConfig config1 = UserConfigUtils.setConfig(GlobalConfig.userConfig);

        return R.ok().putData(config1);
    }


    /**
     * @return 新增site
     */
    @PostMapping("site")
    public R siteadd(@RequestBody IyuuSite iyuuSite) {

        Optional<IyuuSite> site = GlobalConfig.userConfig.getSiteByName(iyuuSite.getName());

        if (site.isPresent()) {
            return R.error400("该站点已添加过，不能重复添加");
        }
        GlobalConfig.userConfig.getSites().add(iyuuSite);

        UserConfig config1 = UserConfigUtils.setConfig(GlobalConfig.userConfig);

        return R.ok().putData(config1);
    }

    /**
     * @return site
     */
    @GetMapping("site/info/{name}")
    public R siteInfo(@PathVariable String name) {
        Optional<IyuuSite> site = GlobalConfig.userConfig.getSiteByName(name);

        if (site.isPresent()) {
            return R.ok().putData(site.get());
        }


        return R.error("不存在");
    }


    /**
     * @return 删除site
     */
    @DeleteMapping("site")
    public R sitedel(@RequestBody String[] names) {

        List<IyuuSite> sites = GlobalConfig.userConfig.getSites();
        List<String> idList = Arrays.asList(names);

        List<IyuuSite> siteList = sites.stream()
                .filter(c -> !idList.contains(c.getName()))
                .collect(Collectors.toList());

        GlobalConfig.userConfig.setSites(siteList);

        UserConfig config1 = UserConfigUtils.setConfig(GlobalConfig.userConfig);

        return R.ok().putData(config1);
    }


    /**
     * @return 修改site
     */
    @PutMapping("site")
    public R siteedit(@RequestBody IyuuSite iyuuSite) {

        IyuuSite tmp = null;
        List<IyuuSite> sites = GlobalConfig.userConfig.getSites();
        for (IyuuSite site : sites) {
            if (site.getName().equals(iyuuSite.getName())) {
                tmp = site;
                break;
            }
        }
        if (tmp != null) {
            sites.remove(tmp);
            sites.add(iyuuSite);
        }

        GlobalConfig.userConfig.setSites(sites);

        UserConfig config1 = UserConfigUtils.setConfig(GlobalConfig.userConfig);

        return R.ok().putData(config1);
    }


}
