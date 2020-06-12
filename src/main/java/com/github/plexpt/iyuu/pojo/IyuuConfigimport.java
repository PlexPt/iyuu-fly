package com.github.plexpt.iyuu.pojo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 17:51
 */
@NoArgsConstructor
@Data
public class IyuuConfigimport {

    private String _$IyuuCn325; // FIXME check this code
    private DefaultBean defaultX;
    private String _$ScFtqqCom164; // FIXME check this code
    private String secret;
    private OurbitsBean ourbits;
    private HddolbyBean hddolby;
    private HdhomeBean hdhome;
    private PthomeBean pthome;
    private MoecatBean moecat;
    private MteamBean mteam;
    private KeepfrdsBean keepfrds;
    private PterBean pter;
    private TjuptBean tjupt;
    private BtschoolBean btschool;
    private HdskyBean hdsky;
    private TorrentccfBean torrentccf;
    private PtmsgBean ptmsg;
    private TtgBean ttg;
    private NanyangptBean nanyangpt;
    private SsdBean ssd;
    private YingkBean yingk;
    private HdcityBean hdcity;
    private _$52ptBean _$52pt;
    private BrobitsBean brobits;
    private BeitaiBean beitai;
    private EastgameBean eastgame;
    private SoulvoiceBean soulvoice;
    private ChdbitsBean chdbits;
    private LeaguehdBean leaguehd;
    private PtsbaoBean ptsbao;
    private HdchinaBean hdchina;
    private HaidanBean haidan;
    private HdareaBean hdarea;
    private HdtimeBean hdtime;
    private _$1ptbaBean _$1ptba;
    private Hd4fansBean hd4fans;
    private HdbugBean hdbug;
    private OpencdBean opencd;
    private HdstreetBean hdstreet;
    private JoyhdBean joyhd;
    private DmhyBean dmhy;
    private UpxinBean upxin;
    private OshenBean oshen;
    private DiscfanBean discfan;
    private HdzoneBean hdzone;
    private NiceptBean nicept;
    private HdbdBean hdbd;
    private ByrBean byr;
    private CcfbitsBean ccfbits;
    private HdbitsBean hdbits;
    private PtpbdBean ptpbd;
    private HdtorrentsBean hdtorrents;
    private SkyeysnowBean skyeysnow;
    private PtBean pt;
    private HdrouteBean hdroute;
    private SitesALLBean sitesALL;

    @NoArgsConstructor
    @Data
    public static class DefaultBean {


        private String userAgent;
        private MoveBean move;
        private int workingMode;
        private String watch;
        private FilterBean filter;
        private int CONNECTTIMEOUT;
        private int TIMEOUT;
        private List<ClientsBean> clients;

        @NoArgsConstructor
        @Data
        public static class MoveBean {
            /**
             * type : 0
             * path : {"/downloads":"/volume1"}
             * paused : 0
             * skip_check : 0
             * delete_torrent : 0
             */

            private int type;
            private PathBean path;
            private int paused;
            private int skip_check;
            private int delete_torrent;

            @NoArgsConstructor
            @Data
            public static class PathBean {
                private String _$Downloads75; // FIXME check this code
            }
        }

        @NoArgsConstructor
        @Data
        public static class FilterBean {
            /**
             * size : {"min":"1GB","max":"280GB"}
             * seeders : {"min":1,"max":3}
             * leechers : {"min":0,"max":10000}
             * completed : {"min":0,"max":10000}
             */

            private SizeBean size;
            private SeedersBean seeders;
            private LeechersBean leechers;
            private CompletedBean completed;

            @NoArgsConstructor
            @Data
            public static class SizeBean {
                /**
                 * min : 1GB
                 * max : 280GB
                 */

                private String min;
                private String max;
            }

            @NoArgsConstructor
            @Data
            public static class SeedersBean {
                /**
                 * min : 1
                 * max : 3
                 */

                private int min;
                private int max;
            }

            @NoArgsConstructor
            @Data
            public static class LeechersBean {
                /**
                 * min : 0
                 * max : 10000
                 */

                private int min;
                private int max;
            }

            @NoArgsConstructor
            @Data
            public static class CompletedBean {
                /**
                 * min : 0
                 * max : 10000
                 */

                private int min;
                private int max;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ClientsBean {
            /**
             * type : transmission
             * host : http://127.0.0.1:9091/transmission/rpc
             * username :
             * password :
             * BT_backup : /var/lib/transmission/torrents
             * move : 0
             */

            private String type;
            private String host;
            private String username;
            private String password;
            private String BT_backup;
            private int move;
        }
    }

    @NoArgsConstructor
    @Data
    public static class OurbitsBean {
        /**
         * cookie :
         * passkey :
         * id : 47794
         * workingMode : 0
         * watch : /root/downloads
         * filter : {"size":{"min":"1GB","max":"280GB"}}
         */

        private String cookie;
        private String passkey;
        private int id;
        private int workingMode;
        private String watch;
        private FilterBeanX filter;

        @NoArgsConstructor
        @Data
        public static class FilterBeanX {
            /**
             * size : {"min":"1GB","max":"280GB"}
             */

            private SizeBeanX size;

            @NoArgsConstructor
            @Data
            public static class SizeBeanX {
                /**
                 * min : 1GB
                 * max : 280GB
                 */

                private String min;
                private String max;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class HddolbyBean {
        /**
         * cookie :
         * passkey :
         * id : 18846
         */

        private String cookie;
        private String passkey;
        private int id;
    }

    @NoArgsConstructor
    @Data
    public static class HdhomeBean {
        /**
         * cookie :
         * passkey :
         * id : 115785
         */

        private String cookie;
        private String passkey;
        private int id;
    }

    @NoArgsConstructor
    @Data
    public static class PthomeBean {
        /**
         * cookie :
         * passkey :
         * id : 119386
         */

        private String cookie;
        private String passkey;
        private int id;
    }

    @NoArgsConstructor
    @Data
    public static class MoecatBean {
        /**
         * cookie :
         * passkey :
         * id : 60287
         * ip_type : ipv4
         */

        private String cookie;
        private String passkey;
        private int id;
        private String ip_type;
    }

    @NoArgsConstructor
    @Data
    public static class MteamBean {
        /**
         * cookie : tp=
         * passkey :
         * ip_type : ipv4
         * clients : [{"type":"transmission","host":"http://127.0.0.1:9091/transmission/rpc","username":"","password":"","downloadDir":""}]
         * workingMode : 1
         * watch :
         * filter : {"size":{"min":"1GB","max":"280GB"}}
         */

        private String cookie;
        private String passkey;
        private String ip_type;
        private int workingMode;
        private String watch;
        private FilterBeanXX filter;
        private List<ClientsBeanX> clients;

        @NoArgsConstructor
        @Data
        public static class FilterBeanXX {
            /**
             * size : {"min":"1GB","max":"280GB"}
             */

            private SizeBeanXX size;

            @NoArgsConstructor
            @Data
            public static class SizeBeanXX {
                /**
                 * min : 1GB
                 * max : 280GB
                 */

                private String min;
                private String max;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ClientsBeanX {
            /**
             * type : transmission
             * host : http://127.0.0.1:9091/transmission/rpc
             * username :
             * password :
             * downloadDir :
             */

            private String type;
            private String host;
            private String username;
            private String password;
            private String downloadDir;
        }
    }

    @NoArgsConstructor
    @Data
    public static class KeepfrdsBean {
        /**
         * cookie :
         * passkey :
         * workingMode : 1
         * watch :
         * filter : {"size":{"min":"1GB","max":"280GB"}}
         */

        private String cookie;
        private String passkey;
        private int workingMode;
        private String watch;
        private FilterBeanXXX filter;

        @NoArgsConstructor
        @Data
        public static class FilterBeanXXX {
            /**
             * size : {"min":"1GB","max":"280GB"}
             */

            private SizeBeanXXX size;

            @NoArgsConstructor
            @Data
            public static class SizeBeanXXX {
                /**
                 * min : 1GB
                 * max : 280GB
                 */

                private String min;
                private String max;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class PterBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class TjuptBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class BtschoolBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdskyBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class TorrentccfBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class PtmsgBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class TtgBean {
        /**
         * cookie :
         * passkey :
         * rss :
         */

        private String cookie;
        private String passkey;
        private String rss;
    }

    @NoArgsConstructor
    @Data
    public static class NanyangptBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class SsdBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class YingkBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdcityBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class _$52ptBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class BrobitsBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class BeitaiBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class EastgameBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class SoulvoiceBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class ChdbitsBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class LeaguehdBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class PtsbaoBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdchinaBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HaidanBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdareaBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdtimeBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class _$1ptbaBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class Hd4fansBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdbugBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class OpencdBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdstreetBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class JoyhdBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class DmhyBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class UpxinBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class OshenBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class DiscfanBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdzoneBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class NiceptBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdbdBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class ByrBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class CcfbitsBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdbitsBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class PtpbdBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdtorrentsBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class SkyeysnowBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class PtBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class HdrouteBean {
        /**
         * cookie :
         * passkey :
         */

        private String cookie;
        private String passkey;
    }

    @NoArgsConstructor
    @Data
    public static class SitesALLBean {
        /**
         * 1ptba : {"id":31,"site":"1ptba","base_url":"1ptba.com","download_page":"download.php?id={}","is_https":1}
         * 52pt : {"id":19,"site":"52pt","base_url":"52pt.site","download_page":"download.php?id={}","is_https":1}
         * beitai : {"id":21,"site":"beitai","base_url":"www.beitai.pt","download_page":"download.php?id={}","is_https":1}
         * btschool : {"id":8,"site":"btschool","base_url":"pt.btschool.club","download_page":"download.php?id={}","is_https":1}
         * byr : {"id":45,"site":"byr","base_url":"bt.byr.cn","download_page":"download.php?id={}","is_https":1}
         * ccfbits : {"id":47,"site":"ccfbits","base_url":"ccfbits.org","download_page":"feeddownload.php/{}/{passkey}/{}.torrent","is_https":1}
         * chdbits : {"id":25,"site":"chdbits","base_url":"chdbits.co","download_page":"download.php?id={}","is_https":1}
         * dicmusic : {"id":51,"site":"dicmusic","base_url":"dicmusic.club","download_page":"torrents.php?action=download&id={}&authkey={authkey}&torrent_pass={torrent_pass}","is_https":1}
         * discfan : {"id":40,"site":"discfan","base_url":"discfan.net","download_page":"download.php?id={}","is_https":1}
         * dmhy : {"id":37,"site":"dmhy","base_url":"u2.dmhy.org","download_page":"download.php?id={}","is_https":1}
         * eastgame : {"id":22,"site":"eastgame","base_url":"pt.eastgame.org","download_page":"download.php?id={}","is_https":1}
         * haidan : {"id":56,"site":"haidan","base_url":"www.haidan.video","download_page":"download.php?id={}","is_https":2}
         * hd-torrents : {"id":50,"site":"hd-torrents","base_url":"hd-torrents.org","download_page":"download.php?id={}","is_https":1}
         * hd4fans : {"id":32,"site":"hd4fans","base_url":"pt.hd4fans.org","download_page":"download.php?id={}","is_https":1}
         * hdarea : {"id":29,"site":"hdarea","base_url":"www.hdarea.co","download_page":"download.php?id={}","is_https":1}
         * hdbd : {"id":44,"site":"hdbd","base_url":"pt.hdbd.us","download_page":"download.php?id={}","is_https":1}
         * hdbits : {"id":48,"site":"hdbits","base_url":"hdbits.org","download_page":"download.php?id={}","is_https":1}
         * hdbug : {"id":34,"site":"hdbug","base_url":"hddisk.life","download_page":"download.php?id={}","is_https":1}
         * hdchina : {"id":28,"site":"hdchina","base_url":"hdchina.org","download_page":"download.php?hash={}","is_https":1}
         * hdcity : {"id":17,"site":"hdcity","base_url":"hdcity.city","download_page":"download?id={}","is_https":1}
         * hddolby : {"id":10,"site":"hddolby","base_url":"www.hddolby.com","download_page":"download.php?id={}","is_https":1}
         * hdhome : {"id":7,"site":"hdhome","base_url":"hdhome.org","download_page":"download.php?id={}","is_https":1}
         * hdroute : {"id":54,"site":"hdroute","base_url":"www.hdroute.org","download_page":"download.php?id={}&passkey={passkey}&from=rss","is_https":0}
         * hdsky : {"id":4,"site":"hdsky","base_url":"hdsky.me","download_page":"download.php?id={}","is_https":1}
         * hdstreet : {"id":35,"site":"hdstreet","base_url":"hdstreet.club","download_page":"download.php?id={}","is_https":1}
         * hdtime : {"id":30,"site":"hdtime","base_url":"hdtime.org","download_page":"download.php?id={}","is_https":1}
         * hdzone : {"id":41,"site":"hdzone","base_url":"hdzone.me","download_page":"download.php?id={}","is_https":1}
         * joyhd : {"id":36,"site":"joyhd","base_url":"www.joyhd.net","download_page":"download.php?id={}","is_https":1}
         * keepfrds : {"id":1,"site":"keepfrds","base_url":"pt.keepfrds.com","download_page":"download.php?id={}","is_https":1}
         * leaguehd : {"id":26,"site":"leaguehd","base_url":"leaguehd.com","download_page":"download.php?id={}","is_https":1}
         * m-team : {"id":3,"site":"m-team","base_url":"pt.m-team.cc","download_page":"download.php?id={}","is_https":1}
         * moecat : {"id":13,"site":"moecat","base_url":"moecat.best","download_page":"download.php?id={}","is_https":1}
         * nanyangpt : {"id":15,"site":"nanyangpt","base_url":"nanyangpt.com","download_page":"download.php?id={}","is_https":1}
         * nicept : {"id":18,"site":"nicept","base_url":"www.nicept.net","download_page":"download.php?id={}","is_https":1}
         * opencd : {"id":33,"site":"opencd","base_url":"open.cd","download_page":"download.php?id={}","is_https":1}
         * oshen : {"id":39,"site":"oshen","base_url":"www.oshen.win","download_page":"download.php?id={}","is_https":1}
         * ourbits : {"id":9,"site":"ourbits","base_url":"ourbits.club","download_page":"download.php?id={}","is_https":1}
         * pt : {"id":53,"site":"pt","base_url":"pt.sjtu.edu.cn","download_page":"download.php?id={}","is_https":1}
         * pter : {"id":6,"site":"pter","base_url":"pterclub.com","download_page":"download.php?id={}","is_https":1}
         * pthome : {"id":2,"site":"pthome","base_url":"pthome.net","download_page":"download.php?id={}","is_https":1}
         * ptmsg : {"id":12,"site":"ptmsg","base_url":"pt.msg.vg","download_page":"download.php?id={}","is_https":1}
         * ptpbd : {"id":49,"site":"ptpbd","base_url":"passthepopcorn.me","download_page":"torrents.php?action=download&authkey={authkey}&torrent_pass={torrent_pass}&id={}","is_https":1}
         * ptsbao : {"id":27,"site":"ptsbao","base_url":"ptsbao.club","download_page":"download.php?id={}","is_https":1}
         * skyeysnow : {"id":52,"site":"skyeysnow","base_url":"skyeysnow.com","download_page":"download.php?id={}","is_https":1}
         * soulvoice : {"id":24,"site":"soulvoice","base_url":"pt.soulvoice.club","download_page":"download.php?id={}","is_https":1}
         * ssd : {"id":23,"site":"ssd","base_url":"springsunday.net","download_page":"download.php?id={}","is_https":1}
         * tjupt : {"id":5,"site":"tjupt","base_url":"tjupt.org","download_page":"download.php?id={}","is_https":1}
         * torrentccf : {"id":11,"site":"torrentccf","base_url":"et8.org","download_page":"download.php?id={}","is_https":1}
         * ttg : {"id":14,"site":"ttg","base_url":"totheglory.im","download_page":"dl/{}","is_https":1}
         * upxin : {"id":38,"site":"upxin","base_url":"pt.upxin.net","download_page":"download.php?id={}","is_https":1}
         * yingk : {"id":16,"site":"yingk","base_url":"yingk.com","download_page":"download.php?id={}","is_https":1}
         */

        private _$1ptbaBeanX _$1ptba;
        private _$52ptBeanX _$52pt;
        private BeitaiBeanX beitai;
        private BtschoolBeanX btschool;
        private ByrBeanX byr;
        private CcfbitsBeanX ccfbits;
        private ChdbitsBeanX chdbits;
        private DicmusicBean dicmusic;
        private DiscfanBeanX discfan;
        private DmhyBeanX dmhy;
        private EastgameBeanX eastgame;
        private HaidanBeanX haidan;
        private HdtorrentsBeanX hdtorrents;
        private Hd4fansBeanX hd4fans;
        private HdareaBeanX hdarea;
        private HdbdBeanX hdbd;
        private HdbitsBeanX hdbits;
        private HdbugBeanX hdbug;
        private HdchinaBeanX hdchina;
        private HdcityBeanX hdcity;
        private HddolbyBeanX hddolby;
        private HdhomeBeanX hdhome;
        private HdrouteBeanX hdroute;
        private HdskyBeanX hdsky;
        private HdstreetBeanX hdstreet;
        private HdtimeBeanX hdtime;
        private HdzoneBeanX hdzone;
        private JoyhdBeanX joyhd;
        private KeepfrdsBeanX keepfrds;
        private LeaguehdBeanX leaguehd;
        private MteamBeanX mteam;
        private MoecatBeanX moecat;
        private NanyangptBeanX nanyangpt;
        private NiceptBeanX nicept;
        private OpencdBeanX opencd;
        private OshenBeanX oshen;
        private OurbitsBeanX ourbits;
        private PtBeanX pt;
        private PterBeanX pter;
        private PthomeBeanX pthome;
        private PtmsgBeanX ptmsg;
        private PtpbdBeanX ptpbd;
        private PtsbaoBeanX ptsbao;
        private SkyeysnowBeanX skyeysnow;
        private SoulvoiceBeanX soulvoice;
        private SsdBeanX ssd;
        private TjuptBeanX tjupt;
        private TorrentccfBeanX torrentccf;
        private TtgBeanX ttg;
        private UpxinBeanX upxin;
        private YingkBeanX yingk;

        @NoArgsConstructor
        @Data
        public static class _$1ptbaBeanX {
            /**
             * id : 31
             * site : 1ptba
             * base_url : 1ptba.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class _$52ptBeanX {
            /**
             * id : 19
             * site : 52pt
             * base_url : 52pt.site
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class BeitaiBeanX {
            /**
             * id : 21
             * site : beitai
             * base_url : www.beitai.pt
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class BtschoolBeanX {
            /**
             * id : 8
             * site : btschool
             * base_url : pt.btschool.club
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class ByrBeanX {
            /**
             * id : 45
             * site : byr
             * base_url : bt.byr.cn
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class CcfbitsBeanX {
            /**
             * id : 47
             * site : ccfbits
             * base_url : ccfbits.org
             * download_page : feeddownload.php/{}/{passkey}/{}.torrent
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class ChdbitsBeanX {
            /**
             * id : 25
             * site : chdbits
             * base_url : chdbits.co
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class DicmusicBean {
            /**
             * id : 51
             * site : dicmusic
             * base_url : dicmusic.club
             * download_page : torrents.php?action=download&id={}&authkey={authkey}&torrent_pass={torrent_pass}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class DiscfanBeanX {
            /**
             * id : 40
             * site : discfan
             * base_url : discfan.net
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class DmhyBeanX {
            /**
             * id : 37
             * site : dmhy
             * base_url : u2.dmhy.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class EastgameBeanX {
            /**
             * id : 22
             * site : eastgame
             * base_url : pt.eastgame.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HaidanBeanX {
            /**
             * id : 56
             * site : haidan
             * base_url : www.haidan.video
             * download_page : download.php?id={}
             * is_https : 2
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdtorrentsBeanX {
            /**
             * id : 50
             * site : hd-torrents
             * base_url : hd-torrents.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class Hd4fansBeanX {
            /**
             * id : 32
             * site : hd4fans
             * base_url : pt.hd4fans.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdareaBeanX {
            /**
             * id : 29
             * site : hdarea
             * base_url : www.hdarea.co
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdbdBeanX {
            /**
             * id : 44
             * site : hdbd
             * base_url : pt.hdbd.us
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdbitsBeanX {
            /**
             * id : 48
             * site : hdbits
             * base_url : hdbits.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdbugBeanX {
            /**
             * id : 34
             * site : hdbug
             * base_url : hddisk.life
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdchinaBeanX {
            /**
             * id : 28
             * site : hdchina
             * base_url : hdchina.org
             * download_page : download.php?hash={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdcityBeanX {
            /**
             * id : 17
             * site : hdcity
             * base_url : hdcity.city
             * download_page : download?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HddolbyBeanX {
            /**
             * id : 10
             * site : hddolby
             * base_url : www.hddolby.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdhomeBeanX {
            /**
             * id : 7
             * site : hdhome
             * base_url : hdhome.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdrouteBeanX {
            /**
             * id : 54
             * site : hdroute
             * base_url : www.hdroute.org
             * download_page : download.php?id={}&passkey={passkey}&from=rss
             * is_https : 0
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdskyBeanX {
            /**
             * id : 4
             * site : hdsky
             * base_url : hdsky.me
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdstreetBeanX {
            /**
             * id : 35
             * site : hdstreet
             * base_url : hdstreet.club
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdtimeBeanX {
            /**
             * id : 30
             * site : hdtime
             * base_url : hdtime.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class HdzoneBeanX {
            /**
             * id : 41
             * site : hdzone
             * base_url : hdzone.me
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class JoyhdBeanX {
            /**
             * id : 36
             * site : joyhd
             * base_url : www.joyhd.net
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class KeepfrdsBeanX {
            /**
             * id : 1
             * site : keepfrds
             * base_url : pt.keepfrds.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class LeaguehdBeanX {
            /**
             * id : 26
             * site : leaguehd
             * base_url : leaguehd.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class MteamBeanX {
            /**
             * id : 3
             * site : m-team
             * base_url : pt.m-team.cc
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class MoecatBeanX {
            /**
             * id : 13
             * site : moecat
             * base_url : moecat.best
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class NanyangptBeanX {
            /**
             * id : 15
             * site : nanyangpt
             * base_url : nanyangpt.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class NiceptBeanX {
            /**
             * id : 18
             * site : nicept
             * base_url : www.nicept.net
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class OpencdBeanX {
            /**
             * id : 33
             * site : opencd
             * base_url : open.cd
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class OshenBeanX {
            /**
             * id : 39
             * site : oshen
             * base_url : www.oshen.win
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class OurbitsBeanX {
            /**
             * id : 9
             * site : ourbits
             * base_url : ourbits.club
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class PtBeanX {
            /**
             * id : 53
             * site : pt
             * base_url : pt.sjtu.edu.cn
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class PterBeanX {
            /**
             * id : 6
             * site : pter
             * base_url : pterclub.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class PthomeBeanX {
            /**
             * id : 2
             * site : pthome
             * base_url : pthome.net
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class PtmsgBeanX {
            /**
             * id : 12
             * site : ptmsg
             * base_url : pt.msg.vg
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class PtpbdBeanX {
            /**
             * id : 49
             * site : ptpbd
             * base_url : passthepopcorn.me
             * download_page : torrents.php?action=download&authkey={authkey}&torrent_pass={torrent_pass}&id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class PtsbaoBeanX {
            /**
             * id : 27
             * site : ptsbao
             * base_url : ptsbao.club
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class SkyeysnowBeanX {
            /**
             * id : 52
             * site : skyeysnow
             * base_url : skyeysnow.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class SoulvoiceBeanX {
            /**
             * id : 24
             * site : soulvoice
             * base_url : pt.soulvoice.club
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class SsdBeanX {
            /**
             * id : 23
             * site : ssd
             * base_url : springsunday.net
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class TjuptBeanX {
            /**
             * id : 5
             * site : tjupt
             * base_url : tjupt.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class TorrentccfBeanX {
            /**
             * id : 11
             * site : torrentccf
             * base_url : et8.org
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class TtgBeanX {
            /**
             * id : 14
             * site : ttg
             * base_url : totheglory.im
             * download_page : dl/{}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class UpxinBeanX {
            /**
             * id : 38
             * site : upxin
             * base_url : pt.upxin.net
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }

        @NoArgsConstructor
        @Data
        public static class YingkBeanX {
            /**
             * id : 16
             * site : yingk
             * base_url : yingk.com
             * download_page : download.php?id={}
             * is_https : 1
             */

            private int id;
            private String site;
            private String base_url;
            private String download_page;
            private int is_https;
        }
    }
}
