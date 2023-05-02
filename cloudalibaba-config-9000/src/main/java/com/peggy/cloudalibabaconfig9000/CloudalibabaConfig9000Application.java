package com.peggy.cloudalibabaconfig9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaConfig9000Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConfig9000Application.class, args);
    }

}
