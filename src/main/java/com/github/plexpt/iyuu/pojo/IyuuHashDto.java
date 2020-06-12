package com.github.plexpt.iyuu.pojo;

import java.util.HashMap;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 21:22
 */
@NoArgsConstructor
@Data
public class IyuuHashDto {

    /**
     * ret : 200
     * data : {"a444850638e7a6f6220e2efdde94099c53358159":{
     * "torrent":[{"sid":23,"torrent_id":282511,"info_hash":"1234567890a22042d89a571ea1d83f67c18624c7"},{"sid":5,"torrent_id":205834,"info_hash":"1234567890bb6b8458fbb03c00f5e405cdbe656a"},{"sid":15,"torrent_id":110865,"info_hash":"12345678909976a768c819c16754a17f72af441e"},{"sid":11,"torrent_id":41447,"info_hash":"1234567890da905f58e3563037da398d84753fe3"}]},"cf7d88fd656d10fe5130d13567aec27068b96676":{"torrent":[{"sid":10,"torrent_id":36,"info_hash":"12345678908bf7927ec61a850959bca8405482f5"},{"sid":1,"torrent_id":7233,"info_hash":"12345678901288a30a54ad793fe615f81afdbb2b"},{"sid":8,"torrent_id":5821,"info_hash":"1234567890716982ecceff4b98c532fc538501ae"},{"sid":6,"torrent_id":689,"info_hash":"12345678901cf9c29f479701f26c6235a15c0668"},{"sid":14,"torrent_id":347591,"info_hash":"123456789016ab933c01fcc6ad3c64ddd4a3e19c"},{"sid":3,"torrent_id":227950,"info_hash":"1234567890a65b71a828141a96098fb00653b03d"},{"sid":16,"torrent_id":7021,"info_hash":"1234567890bd0c2638d7e1b54088f0fed2a25869"},{"sid":16,"torrent_id":4206,"info_hash":"12345678902cd26db8af3579640c6880260bd690"},{"sid":25,"torrent_id":32214,"info_hash":"1234567890a525468bb776d9db3fe8fde2c8e785"},{"sid":29,"torrent_id":19356,"info_hash":"1234567890d06501c4424365308091ed3ff9493c"},{"sid":40,"torrent_id":5907,"info_hash":"1234567890649313a465ca1466d403c87d0b36f6"},{"sid":15,"torrent_id":111560,"info_hash":"12345678908e297df95b4469507baee5424d8420"}]}}
     * msg :
     */

    private int ret;
    private String msg;
    private HashMap<String, DatasBean> data;


    @NoArgsConstructor
    @Data
    public static class DatasBean {
        private List<TorrentBean> torrent;

        @NoArgsConstructor
        @Data
        public static class TorrentBean {
            /**
             * sid : 23
             * torrent_id : 282511
             * info_hash : 1234567890a22042d89a571ea1d83f67c18624c7
             */

            private long sid;
            private long torrent_id;
            private String info_hash;
        }
    }

}
