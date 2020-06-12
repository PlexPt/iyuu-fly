package com.github.plexpt.iyuu.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.plexpt.iyuu.client.BaseClient;
import com.github.plexpt.iyuu.config.GlobalConfig;
import com.github.plexpt.iyuu.config.IyuuConfig;
import com.github.plexpt.iyuu.config.dto.ClientConfig;
import com.github.plexpt.iyuu.config.dto.IpType;
import com.github.plexpt.iyuu.config.dto.IyuuSite;
import com.github.plexpt.iyuu.config.exception.RestException;
import com.github.plexpt.iyuu.pojo.IyuuHashDto;
import com.github.plexpt.iyuu.pojo.IyuuSiteRes;
import com.github.plexpt.iyuu.pojo.QBittorrentInfo;

import net.dreamlu.mica.http.HttpRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 17:44
 */
@Slf4j
@Component
public class AutoReseedUtils {

    @Autowired
    IyuuOauth oauth;

    @Autowired
    IyuuConfig config;
//
//    @Autowired
//    UserConfig userConfig;

    // cookie检查
    private static List<String> cookieCheck = Arrays.asList("hdchina", "hdcity");


    /**
     * 显示支持站点列表
     */
    public IyuuSiteRes getSites() {

        log.info("正在连接IYUUAutoReseed服务器，查询支持列表…… ");

        String res = HttpRequest.get("http://api.iyuu.cn/api/sites?sign=" + oauth.getSign())
                .execute()
                .asString();


        IyuuSiteRes iyuuSiteRes = JSON.parseObject(res, IyuuSiteRes.class);

        if (iyuuSiteRes.getRet() == 200) {

        } else {
            String msg = iyuuSiteRes.getMsg();
            log.error(msg);

        }
        return iyuuSiteRes;

    }


    /**
     * 微信模板消息拼接方法
     */
//    public void wechatMessage() {
//        $br = PHP_EOL;
//        String text = "IYUU自动辅种-统计报表";
//        $desp = "版本号：" + config.getVersion();
//        $desp. = "总做种：".self::$wechatMsg["hashCount"] ."  [客户端正在做种的hash总数]".$br;
//        $desp. = "返回数据：".self::$wechatMsg["reseedCount"]."  [服务器返回的可辅种数据]".$br;
//        $desp. = "支持站点：".self::$wechatMsg["sitesCount"]."  [当前支持自动辅种的站点数量]".$br;
//        $desp. = "成功：".self::$wechatMsg["reseedSuccess"]."  [辅种成功，会把hash加入缓存]".$br;
//        $desp. = "失败：".self::$wechatMsg["reseedError"]."  [下载器下载种子失败或网络超时引起，可以重试]".$br;
//        $desp. = "重复：".self::$wechatMsg["reseedRepeat"]."  [客户端已做种]".$br;
//        $desp. = "跳过：".self::$wechatMsg["reseedSkip"]."  [未设置passkey]".$br;
//        $desp. = "忽略：".self::$wechatMsg["reseedPass"]."  [成功添加存在缓存]".$br;
//        return ff($text, $desp);
//    }

    /**
     * 微信推送 爱语飞飞
     *
     * @param string $text
     * @param string $desp
     * @return false|string
     */
//    function ff($text="", $desp="") {
//        global $configALL;
//        $token = $configALL["iyuu.cn"];
//        $desp = ($desp == "") ? date("Y-m-d H:i:s") : $desp;
//        $postdata = http_build_query(array(
//                "text" = > $text,
//                "desp" = > $desp
//    ));
//        $opts = array("http" = > array(
//                "method" = > "POST",
//                "header" =>"Content-type: application/x-www-form-urlencoded",
//                "content" =>$postdata
//    ));
//        $context = stream_context_create($opts);
//        $result = file_get_contents("http://iyuu.cn/".$token.".send", false, $context);
//        return $result;
//    }

    /**
     * 获取站点种子的URL
     */
    public String getTorrentUrl(String site, String surl) {

        String url;

        IyuuSite currentSite = GlobalConfig.userConfig.getSiteByName(site).get();

        switch (site) {
            case "ttg":
                url = surl + "/" + currentSite.getPasskey();
                break;
            case "m-team":
            case "moecat":
            case "hdbd":
                String ip_type = "";

                if (Objects.nonNull(currentSite.getIp_type())) {

                    ip_type = IpType.ipv6.equals(currentSite.getIp_type()) ? "&ipv6=1" : "";
                }
                url = surl + "&passkey=" + currentSite.getPasskey() + ip_type + "&https=1";
                break;
            case "dicmusic":
                surl = StringUtils.replace(surl, "{torrent_pass}", currentSite.getPasskey());
                url = StringUtils.replace(surl, "{authkey}", currentSite.getAuthkey());
                break;
            case "ccfbits":
            case "hdroute":
                url = StringUtils.replace(surl, "{passkey}", currentSite.getPasskey());
                break;
            default:
                url = surl + "&passkey=" + currentSite.getPasskey();
                break;
        }
        return url;
    }

    /**
     * IYUUAutoReseed辅种
     */
    public void reseed() {
//        global $configALL;
        // 支持站点数量
//        self::$wechatMsg[ "sitesCount "] =count(self::$sites);
//        $sites = self::$sites;
        // 按客户端循环辅种 开始
        List<BaseClient> clients = links();
        IyuuSiteRes sites = getSites();
        for (BaseClient client : clients) {
            // 过滤无需辅种的客户端
            if (client.getClientConfig().getMove() != 0) {
                log.info("clients_" + client.getClientConfig().getHost() + " 根据设置无需辅种，已跳过！");
                continue;
            }
            log.info("正在从下载器 clients_" + client.getClientConfig().getHost() + " 获取种子哈希……");

            String list = client.getList(null);

            List<QBittorrentInfo> infos = JSON.parseArray(list, QBittorrentInfo.class);

            if (CollectionUtils.isEmpty(infos)) {
                continue;
            }

            List<String> hashs = new ArrayList<>();
            for (QBittorrentInfo info : infos) {

                hashs.add(info.getHash());
            }

            log.info("正在向服务器提交 clients_" + client.getClientConfig().getHost() + " 种子哈希……");

            FormBody body = new FormBody.Builder()
                    .add("timestamp", String.valueOf(System.currentTimeMillis() / 1000))
                    .add("sign", oauth.getSign())
                    .add("version", "1.7.9")
                    .add("hash", JSON.toJSONString(hashs))
                    .add("sha1", DigestUtil.sha1Hex(String.valueOf(System.currentTimeMillis())))
                    .build();

            IyuuHashDto dto = HttpRequest.post("http://api.iyuu.cn/api/infohash")
                    .body(body)
                    .execute()
                    .asValue(IyuuHashDto.class);

            if (dto.getRet() != 200) {
                log.error(client.getClientConfig().getHost() + " 查询辅种出错");
                log.error("-----辅种失败，原因： " + dto.getMsg());

                continue;
            }
            if (CollectionUtils.isEmpty(dto.getData())) {
                log.error(client.getClientConfig().getHost() + " 没有查询到可辅种数据");

                continue;
            }

            if (StringUtils.isBlank(dto.getMsg())) {
                //成功
                log.info("clients_" + client.getClientConfig().getHost() + " 辅种数据下载成功！！！");
            } else {
                continue;
            }

            Map<String, String> hashpath = infos.stream()
                    .collect(Collectors.toMap(QBittorrentInfo::getHash, QBittorrentInfo::getSave_path));

            for (String hashkey : dto.getData().keySet()) {
                IyuuHashDto.DatasBean datasBean = dto.getData().get(hashkey);
                String dir = hashpath.get(hashkey);
                for (IyuuHashDto.DatasBean.TorrentBean torrentBean : datasBean.getTorrent()) {

                    String surl = "";
                    String download_page = "";
                    String details_url = "";
                    // 站点id
                    long sid = torrentBean.getSid();
                    // 种子id
                    long torrentId = torrentBean.getTorrent_id();
                    IyuuSiteRes.DataBean.SitesBean sitesBean = sites.getData().getById(sid);
                    if (sitesBean == null) {
                        log.error("-----当前站点不受支持，已跳过。 ");
                        continue;
                    }
                    // 站点名
                    String siteName = sitesBean.getSite();

                    // 页面规则
                    download_page = StringUtils.replace(sitesBean.getDownload_page(), "{}", String.valueOf(torrentId));
                    surl = "https:// " + sitesBean.getBase_url() + "/ " + download_page;


                    /**
                     * 前置检测
                     */
                    // passkey检测
                    if (StringUtils.isEmpty(GlobalConfig.userConfig.getSiteByName(siteName).get().getPasskey())) {

                        continue;
                    } else {
                        log.info("clients_" + client.getClientConfig().getHost() + "正在辅种... {$siteName}");
                    }
                    // cookie检测
                    if (cookieCheck.contains(siteName) &&
                            StringUtils.isEmpty(
                                    GlobalConfig.userConfig.getSiteByName(siteName).get().getCookie())) {
                        log.error("-------因当前 " + "站点未设置cookie，已跳过！！ ");
                        continue;
                    }
                    //todo 流控检测

                    // 重复做种检测
                    if (StringUtils.isNotEmpty(hashpath.get(torrentBean.getInfo_hash()))) {
                        log.error("-------与客户端现有种子重复：，已跳过！！ ");

                        continue;
                    }
                    //todo 历史添加检测
                    //todo 检查站点是否可以辅种

                    /**
                     * 种子URL组合方式区分
                     */
                    String url = getTorrentUrl(siteName, surl);
                    boolean reseedPass = false;
                    // 特殊站点：种子元数据推送给下载器
                    switch (siteName) {
                        case "hdchina":
                            String cookie = GlobalConfig.userConfig.getSiteByName(siteName).get().getCookie();
                            // 拼接URL
                            String details_page = StringUtils.replace("details.php?id={}&hit=1", "{}", String.valueOf(torrentId));
                            details_url = "https:// " + sitesBean.getBase_url() + details_page;
                            log.info("种子详情页：" + details_url);

                            //todo 检测cookie过期 种子删除

                            //todo 提取种子下载地址
                            download_page = StringUtils.replace(sitesBean.getDownload_page(), "{}", "");
//                            offset = strpos(details_html, download_page);
//                            urlTemp = substr(details_html, offset, 50);
//                            // 种子地址
//                            _url = substr(urlTemp, 0, strpos(urlTemp, "" > "));
//                            if (empty(_url)) {
//                                echo "未知错误，未提取到种子URL，请联系脚本作者！ ".PHP_EOL;
//                                // 标志：跳过辅种
//                                reseedPass = true;
//                                break;
//                            }
//                            _url = "https:// ".sites[sid]["base_url "]. "/ "._url;
//                            print "种子下载页："._url.PHP_EOL;
//                            url = download(_url, cookie, userAgent);
//                            #p(url);
//                            if (strpos(url, "第一次下载提示 ") != false) {
//                                echo "当前站点触发第一次下载提示，已加入排除列表".PHP_EOL;
//                                echo "请进入瓷器详情页，点右上角蓝色框：下载种子，成功后更新cookie！".PHP_EOL;
//                                t = 30;
//                                do {
//                                    echo microtime (true).
//                                    " 请进入瓷器详情页，点右上角蓝色框：下载种子，成功后更新cookie！，{t}秒后继续...".PHP_EOL;
//                                    sleep(1);
//                                } while (--t > 0);
//                                ff(siteName."站点，辅种时触发第一次下载提示！ ");
//                                self::noReseed[] ="hdchina ";
//                                // 标志：跳过辅种
//                                reseedPass = true;
//                            }
//                            if (strpos(url, "系统检测到过多的种子下载请求 ") != false) {
//                                echo "当前站点触发人机验证，已加入排除列表".PHP_EOL;
//                                ff(siteName."站点，辅种时触发人机验证！ ");
//                                configALL[siteName]["limit "] = 1;
//                                self::noReseed[] ="hdchina ";
//                                // 标志：跳过辅种
//                                reseedPass = true;
//                            }
                            break;
                        case "hdcity":

                        default:
                            // 默认站点：推送给下载器种子URL链接
                            break;
                    }
                    // 检查switch内是否异常
                    if (reseedPass) {
                        continue;
                    }
                    // 把拼接的种子URL，推送给下载器
                    log.info("推送种子： " + url);
                    // 成功返回：true
                    boolean ret = add(client, url, dir);

                }
            }
        }
    }

    /**
     * 连接远端RPC下载器
     */
    public List<BaseClient> links() {

        List<ClientConfig> clients = GlobalConfig.userConfig.getClients();
        if (clients.size() == 0) {
            throw new RestException("未配置客户端", 41);
        }
        List<BaseClient> clientList = new ArrayList<>();
        for (ClientConfig client : clients) {

            BaseClient client1 = BaseClient.create(client.getType(), client.getHost(), client.getUsername(), client.getPassword());
            clientList.add(client1);
        }
        return clientList;
    }

    /**
     * $torrent 种子元数据
     * $save_path 保存路径
     *
     * @param client
     * @param url
     * @param dir
     * @return bool
     * @brief 添加下载任务
     */
    public boolean add(BaseClient client, String url, String dir) {
        try {
            boolean is_url = false;
            if (StringUtils.containsIgnoreCase(url, "http://") ||
                    StringUtils.containsIgnoreCase(url, "https://") ||
                    StringUtils.containsIgnoreCase(url, "magnet:?xt=urn:btih:")) {
                is_url = true;
            }
            // 下载服务器类型
            // 判断
            switch (client.getClientConfig().getType()) {
                case transmission:
                    String result = "";
//                    extra_options["paused "] = isset(extra_options["paused "]) ? extra_options["paused "] : true;
                    if (is_url) {
                        result = client.add(url, dir);            // 种子URL添加下载任务
                    } else {
                        //转移
//                        result = client.add_metainfo(url, dir);    // 种子元数据添加下载任务
                    }
                    JSONObject jsonResult = JSON.parseObject(result);

                    if ("success".equals(jsonResult.getString("result"))) {
                        String name = "";
                        int id;
                        JSONObject arguments = jsonResult.getJSONObject("arguments").getJSONObject("torrent-duplicate");
                        JSONObject arguments2 = jsonResult.getJSONObject("arguments").getJSONObject("torrent-added");
                        if (!arguments.isEmpty()) {
                            id = arguments.getInteger("id");
                            name = arguments.getString("name");
                        } else if (!arguments2.isEmpty()) {
                            id = arguments2.getInteger("id");
                            name = arguments2.getString("name");
                        }
                        log.info("名字：" + name);
                        log.info("********RPC添加下载任务成功  " + JSON.toJSONString(result));

                        return true;
                    } else {
                        String errmsg = jsonResult.getString("result");
                        if (StringUtils.isEmpty(errmsg)) {
                            errmsg = "未知错误，请稍后重试！ ";
                        }

                        log.error("-----RPC添加种子任务，失败  " + errmsg);
                    }
                    break;
                case qbittorrent:
                    String result2 = "";

//                    if (isset(extra_options["paused "])) {
//                        extra_options["paused "] = extra_options["paused "] ? "true " : "false ";
//                    } else {
//                        extra_options["paused "] = "true ";
//                    }


                    if (is_url) {
                        result2 = client.add(url, dir);            // 种子URL添加下载任务
                    } else {
                        //todo
//                        extra_options["name "] = "torrents ";
//                        rand = mt_rand(10, 42949672);
//                        extra_options["filename "] = intval(rand). ".torrent ";
//                        result = self::links[rpcKey]["rpc "]->
//                        add_metainfo(torrent, save_path, extra_options);    // 种子元数据添加下载任务
                    }
                    if (result2.contains("Ok.")) {

                        log.info("********RPC添加下载任务成功  " + result2);
                        return true;
                    } else {
                        log.error("-----RPC添加种子任务，失败  " + result2);
                    }
                    break;
                default:
                    log.error("-----RPC添加种子任务，失败  add ERROR");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


        return false;
    }


}
