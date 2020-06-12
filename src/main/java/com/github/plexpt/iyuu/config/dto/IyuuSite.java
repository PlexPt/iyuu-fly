package com.github.plexpt.iyuu.config.dto;

import java.util.HashMap;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 19:34
 */

@Data
@Accessors(chain = true)
public class IyuuSite {

    Integer id;
    String name= "";
    String passkey = "";
    String cookie = "";
    String watch;
    HashMap filter;
    HashMap clients;

    IpType ip_type;

    Integer status;

    String authkey;


}
