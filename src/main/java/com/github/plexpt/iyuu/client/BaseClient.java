package com.github.plexpt.iyuu.client;

import com.github.plexpt.iyuu.client.enums.ClientType;
import com.github.plexpt.iyuu.client.impl.QBittorrentClient;
import com.github.plexpt.iyuu.config.dto.ClientConfig;
import com.github.plexpt.iyuu.pojo.KvEntity;

import java.io.File;
import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 12:55
 */
public abstract class BaseClient {

    @Getter
    @Setter
    ClientConfig clientConfig;


    public String username;
    public String password;

    /**
     * 公共方法：创建客户端实例
     */
    public static BaseClient create(ClientType type, String url, String username, String password) {

        switch (type) {
            case qbittorrent:
                return new QBittorrentClient(url, username, password);

            case transmission:
                return new QBittorrentClient(url, username, password);

            default:
                return new QBittorrentClient(url, username, password);

        }
    }

    /**
     * 公共方法：创建客户端实例
     */
    public static BaseClient create(ClientConfig clientConfig) {


        QBittorrentClient client = new QBittorrentClient(clientConfig.getHost(), clientConfig.getUsername(), clientConfig.getPassword());
        switch (clientConfig.getType()) {
            case qbittorrent:
                client.setClientConfig(clientConfig);
                return client;

            case transmission:
                return client;

            default:
                return client;

        }
    }

    /**
     * 查询Bittorrent客户端状态
     *
     * @return string
     */
    public abstract String status();

    /**
     * 获取种子列表
     *
     * @return array(
     *' hash ' = > string json,
     *' sha1 ' = > string,
     *' hashString ' = > array
     *)
     */
    abstract public String getList(HashMap move);


    /**
     * 添加种子连接
     */
    abstract public String add(String torrent_url, String save_path, KvEntity... extra_options);

    /**
     * 添加种子原数据
     */
    abstract public String add_metainfo(File torrent, String save_path, KvEntity... extra_options);

    /**
     * 删除种子
     */
    abstract public String delete(String hash, boolean deleteFiles);
}
