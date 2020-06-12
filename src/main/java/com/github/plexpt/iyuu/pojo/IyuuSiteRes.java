package com.github.plexpt.iyuu.pojo;

import com.github.plexpt.iyuu.config.exception.RestException;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 19:52
 */
@NoArgsConstructor
@Data
public class IyuuSiteRes {


    /**
     * ret : 200
     * data : {"sites":[{"id":1,"site":"keepfrds","base_url":"pt.keepfrds.com","download_page":"download.php?id={}","is_https":1},{"id":2,"site":"pthome","base_url":"pthome.net","download_page":"download.php?id={}","is_https":1},{"id":3,"site":"m-team","base_url":"pt.m-team.cc","download_page":"download.php?id={}","is_https":1},{"id":4,"site":"hdsky","base_url":"hdsky.me","download_page":"download.php?id={}","is_https":1},{"id":5,"site":"tjupt","base_url":"tjupt.org","download_page":"download.php?id={}","is_https":1},{"id":6,"site":"pter","base_url":"pterclub.com","download_page":"download.php?id={}","is_https":1},{"id":7,"site":"hdhome","base_url":"hdhome.org","download_page":"download.php?id={}","is_https":1},{"id":8,"site":"btschool","base_url":"pt.btschool.club","download_page":"download.php?id={}","is_https":1},{"id":9,"site":"ourbits","base_url":"ourbits.club","download_page":"download.php?id={}","is_https":1},{"id":10,"site":"hddolby","base_url":"www.hddolby.com","download_page":"download.php?id={}","is_https":1},{"id":11,"site":"torrentccf","base_url":"et8.org","download_page":"download.php?id={}","is_https":1},{"id":12,"site":"ptmsg","base_url":"pt.msg.vg","download_page":"download.php?id={}","is_https":1},{"id":13,"site":"moecat","base_url":"moecat.best","download_page":"download.php?id={}","is_https":1},{"id":14,"site":"ttg","base_url":"totheglory.im","download_page":"dl/{}","is_https":1},{"id":15,"site":"nanyangpt","base_url":"nanyangpt.com","download_page":"download.php?id={}","is_https":1},{"id":16,"site":"yingk","base_url":"yingk.com","download_page":"download.php?id={}","is_https":1},{"id":17,"site":"hdcity","base_url":"hdcity.city","download_page":"download?id={}","is_https":1},{"id":18,"site":"nicept","base_url":"www.nicept.net","download_page":"download.php?id={}","is_https":1},{"id":19,"site":"52pt","base_url":"52pt.site","download_page":"download.php?id={}","is_https":1},{"id":21,"site":"beitai","base_url":"www.beitai.pt","download_page":"download.php?id={}","is_https":1},{"id":22,"site":"eastgame","base_url":"pt.eastgame.org","download_page":"download.php?id={}","is_https":1},{"id":23,"site":"ssd","base_url":"springsunday.net","download_page":"download.php?id={}","is_https":1},{"id":24,"site":"soulvoice","base_url":"pt.soulvoice.club","download_page":"download.php?id={}","is_https":1},{"id":25,"site":"chdbits","base_url":"chdbits.co","download_page":"download.php?id={}","is_https":1},{"id":26,"site":"leaguehd","base_url":"leaguehd.com","download_page":"download.php?id={}","is_https":1},{"id":27,"site":"ptsbao","base_url":"ptsbao.club","download_page":"download.php?id={}","is_https":1},{"id":28,"site":"hdchina","base_url":"hdchina.org","download_page":"download.php?hash={}","is_https":1},{"id":29,"site":"hdarea","base_url":"www.hdarea.co","download_page":"download.php?id={}","is_https":1},{"id":30,"site":"hdtime","base_url":"hdtime.org","download_page":"download.php?id={}","is_https":1},{"id":31,"site":"1ptba","base_url":"1ptba.com","download_page":"download.php?id={}","is_https":1},{"id":32,"site":"hd4fans","base_url":"pt.hd4fans.org","download_page":"download.php?id={}","is_https":1},{"id":33,"site":"opencd","base_url":"open.cd","download_page":"download.php?id={}","is_https":1},{"id":34,"site":"hdbug","base_url":"hddisk.life","download_page":"download.php?id={}","is_https":1},{"id":35,"site":"hdstreet","base_url":"hdstreet.club","download_page":"download.php?id={}","is_https":1},{"id":36,"site":"joyhd","base_url":"www.joyhd.net","download_page":"download.php?id={}","is_https":1},{"id":37,"site":"dmhy","base_url":"u2.dmhy.org","download_page":"download.php?id={}","is_https":1},{"id":38,"site":"upxin","base_url":"pt.upxin.net","download_page":"download.php?id={}","is_https":1},{"id":39,"site":"oshen","base_url":"www.oshen.win","download_page":"download.php?id={}","is_https":1},{"id":40,"site":"discfan","base_url":"discfan.net","download_page":"download.php?id={}","is_https":1},{"id":41,"site":"hdzone","base_url":"hdzone.me","download_page":"download.php?id={}","is_https":1},{"id":44,"site":"hdbd","base_url":"pt.hdbd.us","download_page":"download.php?id={}","is_https":1},{"id":45,"site":"byr","base_url":"bt.byr.cn","download_page":"download.php?id={}","is_https":1},{"id":47,"site":"ccfbits","base_url":"ccfbits.org","download_page":"feeddownload.php/{}/{passkey}/{}.torrent","is_https":1},{"id":48,"site":"hdbits","base_url":"hdbits.org","download_page":"download.php?id={}","is_https":1},{"id":49,"site":"ptpbd","base_url":"passthepopcorn.me","download_page":"torrents.php?action=download&authkey={authkey}&torrent_pass={torrent_pass}&id={}","is_https":1},{"id":50,"site":"hd-torrents","base_url":"hd-torrents.org","download_page":"download.php?id={}","is_https":1},{"id":51,"site":"dicmusic","base_url":"dicmusic.club","download_page":"torrents.php?action=download&id={}&authkey={authkey}&torrent_pass={torrent_pass}","is_https":1},{"id":52,"site":"skyeysnow","base_url":"skyeysnow.com","download_page":"download.php?id={}","is_https":1},{"id":53,"site":"pt","base_url":"pt.sjtu.edu.cn","download_page":"download.php?id={}","is_https":1},{"id":54,"site":"hdroute","base_url":"www.hdroute.org","download_page":"download.php?id={}&passkey={passkey}&from=rss","is_https":0},{"id":56,"site":"haidan","base_url":"www.haidan.video","download_page":"download.php?id={}","is_https":2}]}
     * msg :
     * version : 1.7.0
     */

    private int ret;
    private DataBean data;
    private String msg;
    private String version;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        private List<SitesBean> sites;

        @NoArgsConstructor
        @Data
        public static class SitesBean {
            /**
             * id : 1
             * site : keepfrds
             * base_url : pt.keepfrds.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private long id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        public SitesBean getById(long id) {
            for (SitesBean site : sites) {
                if (site.getId() == id) {
                    return site;
                }
            }
            return null;
        }
    }
}
