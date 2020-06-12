package com.github.plexpt.iyuu.config;

import com.github.plexpt.iyuu.config.dto.ClientConfig;
import com.github.plexpt.iyuu.config.dto.IyuuSite;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

/**
 * @author pt
 * @email plexpt@gmail.com
 * @date 2020-06-10 19:24
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "iyuu")
public class IyuuConfig {

    String version = "1.0";

    String userAgent = "";


}
