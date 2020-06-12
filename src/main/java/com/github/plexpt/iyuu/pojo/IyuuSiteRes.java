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
     * data : {"sites":[{"id":1,"site":"keepfrds","base_url":"pt.keepfrds.com","download_page":"download.php?id={}",
     * "is_https":1},
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
