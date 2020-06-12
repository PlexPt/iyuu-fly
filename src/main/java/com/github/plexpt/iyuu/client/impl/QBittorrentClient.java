package com.github.plexpt.iyuu.client.impl;

import com.alibaba.fastjson.JSON;
import com.github.plexpt.iyuu.client.BaseClient;
import com.github.plexpt.iyuu.client.enums.QBittorrentApiEndpoint;
import com.github.plexpt.iyuu.pojo.KvEntity;
import com.github.plexpt.iyuu.pojo.QBittorrentInfo;

import net.dreamlu.mica.http.HttpRequest;
import net.dreamlu.mica.http.LogLevel;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import okhttp3.Cookie;
import okhttp3.FormBody;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 12:59
 */
public class QBittorrentClient extends BaseClient {


    private String url;

    private boolean isApi2 = true;

    Cookie cookie;

    LogLevel logLevel = LogLevel.BODY;

    public QBittorrentClient(String aurl, String username, String password) {

        this.url = aurl.trim();
        if (url.endsWith("/")) {
            StringUtils.removeEnd(url, "/");
        }
        this.username = username;
        this.password = password;

    }


    @Override
    public String status() {
        return appVersion();

    }

    @Override
    public String getList(HashMap move) {
        String data = getData(QBittorrentApiEndpoint.torrent_list);
        QBittorrentInfo info = JSON.parseObject(data, QBittorrentInfo.class);
        return data;
//        $result = $this->getData('torrent_list');
//        $res = json_decode($result, true);
//        if (empty($res)) {
//            echo "获取种子列表失败，可能qBittorrent暂时无响应，请稍后重试！".PHP_EOL;
//            return array();
//        }
//        // 过滤，只保留正常做种
//        $res = array_filter($res, function ($v) {
//            if (isset($v['state']) && in_array($v['state'], array('uploading','stalledUP','pausedUP','queuedUP','checkingUP','forcedUP'))) {
//                return true;
//            }
//            return false;
//        }, ARRAY_FILTER_USE_BOTH);
//
//        if (empty($res)) {
//            echo "未获取到正常做种数据，请多保种，然后重试！".PHP_EOL;
//            return array();
//        }
//        // 提取数组：hashString
//        $info_hash = array_column($res, 'hash');
//        // 升序排序
//        sort($info_hash);
//        $json = json_encode($info_hash, JSON_UNESCAPED_UNICODE);
//        // 去重 应该从文件读入，防止重复提交
//        $sha1 = sha1($json);
//        // 组装返回数据
//        $hashArray['hash'] = $json;
//        $hashArray['sha1'] = $sha1;
//        // 变换数组：hashString为键
//        $hashArray['hashString'] = array_column($res, "save_path", 'hash');
//        return $hashArray;
    }

    /**
     * @param extra_options array(
     *                      'urls'    =>  '',
     *                      'savepath'    =>  '',
     *                      'cookie'    =>  '',
     *                      'category'    =>  '',
     *                      'skip_checking'    =>  true,
     *                      'paused'    =>  true,
     *                      'root_folder'    =>  true,
     *                      )
     * @return array
     */
    @Override
    public String add(String torrent_url, String save_path, KvEntity... extra_options) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("urls", torrent_url);
        map.put("skip_checking", true);
        map.put("autoTMM", false);

        for (KvEntity option : extra_options) {
            map.put(option.getKey(), option.getValue());
        }

        if (!StringUtils.isEmpty(save_path)) {
            map.put("savepath", save_path);
        }


        String end = QBittorrentApiEndpoint.torrent_add.getV2();

        if (!isApi2) {
            end = QBittorrentApiEndpoint.torrent_add.getV1();
        }

        return HttpRequest.get(url + end)
                .log(logLevel)
                .multipartFormBuilder()
                .addMap(map)
                .build()
                .execute()
                .asString();


        // 关键 上传文件流 multipart/form-data【严格按照api文档编写】
//        $post_data = $this -> buildUrls($extra_options);
//        #p($post_data);
//        // 设置请求头
//        $this -> curl -> setHeader('Content-Type', 'multipart/form-data; boundary='.$this->delimiter)
//        ;
//        $this -> curl -> setHeader('Content-Length', strlen($post_data));
//        return $this -> postData('torrent_add', $post_data);
    }

    @Override
    public String add_metainfo(File torrent, String save_path, KvEntity... extra_options) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("skip_checking", true); //跳校验
        map.put("'torrents'", torrent);

        for (KvEntity option : extra_options) {
            map.put(option.getKey(), option.getValue());
        }
        if (!StringUtils.isEmpty(save_path)) {
            map.put("savepath", save_path);
        }

        String end = QBittorrentApiEndpoint.torrent_add.getV2();

        if (!isApi2) {
            end = QBittorrentApiEndpoint.torrent_add.getV1();
        }

        return HttpRequest.get(url + end)
                .log(logLevel)
                .multipartFormBuilder()
                .addMap(map)
                .build()
                .execute()
                .asString();


//        $extra_options['torrents'] = $torrent_metainfo;
        // 关键 上传文件流 multipart/form-data【严格按照api文档编写】
//        $post_data = $this->buildData($extra_options);
//        // 设置请求头
//        $this->curl->setHeader('Content-Type', 'multipart/form-data; boundary='.$this->delimiter);
//        $this->curl->setHeader('Content-Length', strlen($post_data));
//        return $this->postData('torrent_add', $post_data);
    }

    @Override
    public String delete(String hash, boolean deleteFiles) {


        FormBody formBody = new FormBody.Builder()
                .add("hashes", hash)
                .add("deleteFiles", String.valueOf(deleteFiles))
                .build();
        return this.postData(QBittorrentApiEndpoint.torrent_delete, formBody);
    }


    public String appVersion() {
        return getData(QBittorrentApiEndpoint.app_version);
    }

    public String apiVersion() {
        return getData(QBittorrentApiEndpoint.api_version);

    }

    public String buildInfo() {
        return getData(QBittorrentApiEndpoint.build_info);

    }

    public String preferences() {

//        if (data != null) {
//
//            FormBody formBody = new FormBody.Builder()
//                    .add("username", username)
//                    .add("password", password)
//                    .build();
//
//            return postData(QBittorrentApi.setPreferences,  (data));
//
//        }
        return getData(QBittorrentApiEndpoint.preferences);

    }

    public String torrentList() {
        return getData(QBittorrentApiEndpoint.torrent_list);
    }


    public boolean authenticate() {


        FormBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        String end = QBittorrentApiEndpoint.login.getV2();

        if (!isApi2) {
            end = QBittorrentApiEndpoint.login.getV1();
        }

        AtomicBoolean ok = new AtomicBoolean(false);
        HttpRequest.post(url + end)
                .log(logLevel)
                .body(formBody)
                .execute()
                .onResponse(res -> {

                    if (res.code() == 200) {
                        System.out.println(res);
                        for (Cookie cookie1 : res.cookies()) {
                            if (cookie1.name().equalsIgnoreCase("SID")) {
                                cookie = cookie1;
                                ok.set(true);
                                System.out.println("登陆成功");
                                break;
                            }
                        }
                    }
                    return res;
                });

        if (ok.get()) {
            return true;
        } else {
            return false;
        }

////        String data = postData(QBittorrentApi.login, GsonUtils.toJsonString(map));
//
//
////        $this->curl->post($this->url . $this->endpoints['login'][$this->api_version], [
////        'username' => $this->username,
////            'password' => $this->password
////        ]);
//
//
//        // Find authentication cookie and set in curl connection
//        foreach($this -> curl -> response_headers as $header) {
//            if (preg_match('/SID=(\S[^;]+)/', $header, $matches)) {
//                $this -> curl -> setHeader('Cookie', $matches[0]);
//                return true;
//            }
//        }
//        ;
//
//        return false;
    }

    private String getData(QBittorrentApiEndpoint endpoint) {

        String end = endpoint.getV2();

        if (!isApi2) {
            end = endpoint.getV1();
        }

        return HttpRequest.get(url + end)
                .log(logLevel)
                .addCookie(cookie)
                .execute()
                .asString();

//
//        if ($this -> curl -> error) {
//            return $this -> errorMessage();
//        }
//
//        return $this -> curl -> response;
    }

    private String postData(QBittorrentApiEndpoint endpoint, FormBody data) {

        String end = endpoint.getV2();

        if (!isApi2) {
            end = endpoint.getV1();
        }

        return HttpRequest.post(url + end)
                .log(logLevel)
                .addCookie(cookie)
                .body(data)
                .execute()
                .asString();


//
//        if ($this -> curl -> error) {
//            return $this -> errorMessage();
//        }
//
//        return $this -> curl -> response;
    }


}
