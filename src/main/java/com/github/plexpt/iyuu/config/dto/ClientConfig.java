package com.github.plexpt.iyuu.config.dto;

import com.github.plexpt.iyuu.client.enums.ClientType;

import lombok.Data;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 19:38
 */
@Data
public class ClientConfig {

    Integer id;
    ClientType type;
    String host;
    String username;
    String password;
    String BT_backup;
    String remark;
    Integer move;
    Integer status = 0;
}
