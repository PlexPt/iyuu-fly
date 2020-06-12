package com.github.plexpt.iyuu.client.impl;

import com.github.plexpt.iyuu.client.BaseClient;
import com.github.plexpt.iyuu.pojo.KvEntity;

import java.io.File;
import java.util.HashMap;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 12:59
 */
public class TransmissionClient extends BaseClient {


    private String debug;
    private String url;
    private String api_version;
    private String curl;
    protected String delimiter;

    public TransmissionClient(String username, String password) {

        this.username = username;
        this.password = password;

    }


    @Override
    public String status() {
        return null;
    }

    @Override
    public String getList(HashMap move) {
        return null;
    }

    @Override
    public String add(String torrent_url, String save_path, KvEntity... extra_options) {
        return null;
    }

    @Override
    public String add_metainfo(File torrent, String save_path, KvEntity... extra_options) {
        return null;
    }

    @Override
    public String delete(String hash, boolean deleteFiles) {
        return null;
    }
}
