package com.peggy.cloudalibabaconfig3377.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peggy
 * @date 2023-03-31 21:07
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo; //这里使用的 nacos 配置中的配置文件

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
