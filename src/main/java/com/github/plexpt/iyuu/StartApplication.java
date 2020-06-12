package com.github.plexpt.iyuu;

import net.dreamlu.mica.core.utils.PathUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {


        System.out.println("应用目录：" + PathUtil.getJarPath());

        long t1 = System.currentTimeMillis();
        SpringApplication.run(StartApplication.class, args);
        long t2 = System.currentTimeMillis();

        System.out.println("启动耗时(ms)：" + (t2 - t1));
    }

}
