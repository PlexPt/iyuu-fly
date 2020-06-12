package com.github.plexpt.iyuu.config;

import com.github.plexpt.iyuu.config.dto.ClientConfig;
import com.github.plexpt.iyuu.config.dto.IyuuSite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 19:24
 */

@Data
@Accessors(chain = true)
public class UserConfig {

    String token = "";

    String user = "";
    String password = "";

    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.1303.189 Safari/537.36";

    HashMap move;

    String workingMode = "";

    String watch = "";

    HashMap filter;

    String ftqq = "";

    // 10.发布员鉴权
    String secret = "";

    List<ClientConfig> clients = new ArrayList<>();

    List<IyuuSite> sites = new ArrayList<>();

    public Optional<IyuuSite> getSiteByName(String name) {
        for (IyuuSite site : sites) {
            if (site.getName().equalsIgnoreCase(name)) {
                return Optional.ofNullable(site);
            }
        }

        return Optional.empty();
    }
}
