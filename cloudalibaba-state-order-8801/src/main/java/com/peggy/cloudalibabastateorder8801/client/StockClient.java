package com.peggy.cloudalibabastateorder8801.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Peggy
 * @Date 2023-05-09 21:33
 **/
@FeignClient(value = "seata-stock")
public interface StockClient {
    @GetMapping("/stock/decr")
    String decrement();
}