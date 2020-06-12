package com.github.plexpt.iyuu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 13:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KvEntity<T> {

    String key;

    T value;

    public static <T> KvEntity of(String key, T v) {
        return new KvEntity<T>(key, v);
    }
}
