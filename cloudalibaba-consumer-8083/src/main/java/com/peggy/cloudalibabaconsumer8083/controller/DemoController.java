package com.peggy.cloudalibabaconsumer8083.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author peggy
 * @date 2023-03-31 19:49
 */
@RestController
public class DemoController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "consumer/nacos")
    public String getDiscovery(){
        return restTemplate.getForObject(serverURL+"/peggy",String.class);
    }
}
