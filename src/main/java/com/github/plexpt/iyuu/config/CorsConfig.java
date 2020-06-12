

package com.github.plexpt.iyuu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

/**
 * CORS跨域
 *
 * @author pt
 */
@SuppressWarnings("all")
@Slf4j
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("Initializing CorsConfig");

        registry.addMapping("/**")    // 允许跨域访问的路径
                .allowedOrigins("*")    // 允许跨域访问的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")// 允许请求方法
                .allowedHeaders("*")  // 允许头部设置
                .allowCredentials(true)  // 是否发送cookie
                .exposedHeaders(HttpHeaders.SET_COOKIE)
                .maxAge(168000);     // 预检间隔时间
    }

}
