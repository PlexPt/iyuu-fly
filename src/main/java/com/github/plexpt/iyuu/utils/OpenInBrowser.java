package com.github.plexpt.iyuu.utils;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-11 20:27
 */
public class OpenInBrowser {

    public static void open(String url) {
        //判断当前系统是否支持Java AWT Desktop扩展
        if (Desktop.isDesktopSupported()) {
            try {
                // 创建一个URI实例
                URI uri = URI.create(url);
                // 获取当前系统桌面扩展
                Desktop dp = Desktop.getDesktop();
                // 判断系统桌面是否支持要执行的功能
                if (dp.isSupported(Desktop.Action.BROWSE)) {
                    // 获取系统默认浏览器打开链接
                    dp.browse(uri);
                }

            } catch (java.lang.NullPointerException e) {
                e.printStackTrace();
                //此为uri为空时抛出异常
            } catch (java.io.IOException e) {
                e.printStackTrace();

                //此为无法获取系统默认浏览器
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * Mac：
     * open 'http://blog.csdn.net/jiezhi2013'
     * <p>
     * Linux:
     * x-www-browser 'http://blog.csdn.net/jiezhi2013'
     * <p>
     * Windows:
     * cmd /c start http://blog.csdn.net/jiezhi2013
     *
     * @param url
     */
    public static void openByCmd(String url) {
        try {
            if (OSUtil.isWindows()) {
                Runtime.getRuntime().exec("cmd /c start " + url);
            } else if (OSUtil.isMacOSX()) {
                Runtime.getRuntime().exec("open " + url);
            } else if (OSUtil.isLinux()) {
                Runtime.getRuntime().exec("x-www-browser " + url);
            } else {
                System.out.println("打开浏览器失败：未知操作系统");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
