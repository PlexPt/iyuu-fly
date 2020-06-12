package com.example.demo;

import com.github.plexpt.iyuu.config.dto.IyuuSite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-12 19:13
 */
public class main {

    public static void main(String[] args) {
        List<IyuuSite> list = new ArrayList<>();
        list.add(new IyuuSite().setName("1"));
        list.add(new IyuuSite().setName("2"));
        list.add(new IyuuSite().setName("3"));
        list.add(new IyuuSite().setName("4"));
        list.add(new IyuuSite().setName("5"));


        System.out.println(list.stream().map(IyuuSite::getName).collect(Collectors.toList()));


        IyuuSite site2 = null;
        IyuuSite site3 = new IyuuSite().setName("333");
        for (IyuuSite site : list) {
//            site = new IyuuSite().setName("8");
            site2 = site;
            break;
        }


        System.out.println(list.stream().map(IyuuSite::getName).collect(Collectors.toList()));

    }
}
