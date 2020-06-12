package com.github.plexpt.iyuu.utils;

import org.springframework.boot.system.ApplicationHome;

import lombok.experimental.UtilityClass;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-11 3:08
 */
@UtilityClass
public class TestUtil {

    public void test() {

        System.out.println("JAR");
        String path = new ApplicationHome(TestUtil.class)
                .getSource()
                .getParentFile()
                .toString();
        System.out.println(path);


    }
}
