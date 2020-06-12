package com.github.plexpt.iyuu.client.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 13:29
 */
@Getter
@AllArgsConstructor
public enum QBittorrentApiEndpoint {

    login("login", "/login", "/api/v2/auth/login"),
    app_version("app_version", "/version/qbittorrent", "/api/v2/app/version"),
    api_version("api_version", "/version/api", "/api/v2/app/webapiVersion"),
    build_info("build_info", "", "/api/v2/app/buildInfo"),
    preferences("preferences", "", "/api/v2/app/preferences"),
    setPreferences("setPreferences", "", "/api/v2/app/setPreferences"),
    defaultSavePath("defaultSavePath", "", "/api/v2/app/defaultSavePath"),
    torrent_list("torrent_list", "", "/api/v2/torrents/info"),
    torrent_add("torrent_add", "", "/api/v2/torrents/add"),
    torrent_delete("torrent_delete", "", "/api/v2/torrents/delete"),
    torrent_pause("torrent_pause", "", "/api/v2/torrents/pause"),
    torrent_resume("torrent_resume", "", "/api/v2/torrents/resume"),
    set_torrent_location("set_torrent_location", "", "/api/v2/torrents/setLocation"),
    maindata("maindata", "", "/api/v2/sync/maindata"),

    ;

    String action;
    String v1;
    String v2;

}
