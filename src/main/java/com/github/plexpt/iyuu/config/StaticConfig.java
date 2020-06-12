//package com.github.plexpt.tinyserver.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @author pt
// * @email plexpt@gmail.com
// * @date 2020-06-07 23:30
// */
//@Configuration
//public class StaticConfig extends WebMvcConfigurerAdapter {
//
//    @Controller
//    static class Routes {
//        @RequestMapping(
//                value = "{_:^(?!index\\.html|api|css|js|fonts).*}/**",
//                method = RequestMethod.GET)
//        public String index() {
//            return "/index.html";
//        }
//    }
//}
