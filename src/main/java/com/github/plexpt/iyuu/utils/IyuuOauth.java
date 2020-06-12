package com.github.plexpt.iyuu.utils;

import com.github.plexpt.iyuu.config.GlobalConfig;
import com.github.plexpt.iyuu.config.UserConfig;
import com.github.plexpt.iyuu.config.dto.IyuuSite;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 17:50
 */

@Component
public class IyuuOauth {

//    @Autowired
//    UserConfig config;

    /**
     * 从配置文件内读取爱语飞飞token作为鉴权参数
     */
    public String getSign() {
        // 爱语飞飞
        String token = GlobalConfig.userConfig.getToken();
        if (StringUtils.isBlank(token) || token.length() < 46) {
            System.out.println("缺少辅种接口请求参数：爱语飞飞token \n");
            System.out.println("请访问https://iyuu.cn 用微信扫码申请，并填入配置。\n\n");

            return "";
        }

        return token;
    }

    /**
     * 用户注册与登录
     * 作用：在服务器端实现微信用户与合作站点用户id的关联
     * 参数：爱语飞飞token + 合作站点用户id + sha1(合作站点密钥passkey) + 合作站点标识
     */
    public static String login(String apiUrl  , List<IyuuSite> sites)
    {
        return "";
//        global $configALL;
//        // 云端下发合作的站点标识
//        self::$sites = $sites ? $sites : self::$sites;
//        $ret = false;
//        self::$token = self::getSign();
//        foreach (self::$sites as $name) {
//        if (is_file(str_replace('{}', $name, self::$SiteLoginCache))) {
//            // 存在鉴权缓存
//            $ret = true;
//            continue;
//        }
//        if (isset($configALL[$name]['passkey']) && $configALL[$name]['passkey'] && isset($configALL[$name]['id']) && $configALL[$name]['id']) {
//            self::$user_id = $configALL[$name]['id'];
//            self::$passkey =  sha1($configALL[$name]['passkey']);     // 避免泄露用户passkey秘钥
//            self::$site = $name;
//
//            $curl = new Curl();
//            $curl->setOpt(CURLOPT_SSL_VERIFYPEER, false);
//            $data = [
//            'token'  => self::$token,
//                    'id'     => self::$user_id,
//                    'passkey'=> self::$passkey,
//                    'site'   => self::$site,
//                ];
//            $res = $curl->get($apiUrl, $data);
//            p($res->response);
//
//            $rs = json_decode($res->response, true);
//            if (isset($rs['ret']) && $rs['ret'] == 200 && isset($rs['data']['success']) && $rs['data']['success']) {
//                self::setSiteLoginCache($name, $rs);
//                $ret = true;
//            } else {
//                $msg = isset($rs['msg']) && $rs['msg'] ? $rs['msg'] : '远端服务器无响应，请稍后重试！';
//                $msg = isset($rs['data']['errmsg']) && $rs['data']['errmsg'] ? $rs['data']['errmsg'] : $msg;
//                echo $msg . PHP_EOL;
//            }
//        } else {
//            echo $name.'合作站点参数配置不完整，请同时填写passkey和用户id。' . PHP_EOL;
//            echo '合作站点鉴权配置，请查阅：https://www.iyuu.cn/archives/337/'. PHP_EOL. PHP_EOL;
//        }
//    }
//        return $ret;
    }
//    /**
//     * 写鉴权成功配置
//     */
//    private static function setSiteLoginCache($key = '', $array = [])
//    {
//        $json = json_encode($array, JSON_UNESCAPED_UNICODE);
//        $myfile = str_replace('{}', $key, self::$SiteLoginCache);
//        $file_pointer = @fopen($myfile, "w");
//        $worldsnum = @fwrite($file_pointer, $json);
//        @fclose($file_pointer);
//    }
}
