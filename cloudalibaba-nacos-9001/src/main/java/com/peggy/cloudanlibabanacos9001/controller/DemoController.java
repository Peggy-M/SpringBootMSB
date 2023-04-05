package com.peggy.cloudanlibabanacos9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peggy
 * @date 2023-03-31 19:43
 */
@RestController
public class DemoController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/peggy")
    public String getServerPort() {
        return " Hello Nacos Discovery " + serverPort;
    }
}
