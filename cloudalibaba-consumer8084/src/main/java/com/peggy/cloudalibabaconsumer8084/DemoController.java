package com.peggy.cloudalibabaconsumer8084;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.peggy.cloudalibabacommons.entity.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

/**
 * @Author Peggy
 * @Date 2023-05-04 17:36
 **/
@RestController
@Slf4j
public class DemoController {
    //服务提供者URL
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
            fallback = "fallbackHandler",
            blockHandler = "blockHandler",
            //排除 NullPointerException 异常
            exceptionsToIgnore = {NullPointerException.class}
    )
    public JsonResult<String> fallback(@PathVariable Long id) {
        if (id == 1) {
            //通过Ribbon发起远程访问，访问9003/9004
            JsonResult<String> result = restTemplate.getForObject(SERVICE_URL + "/info/" + id, JsonResult.class);
            return result;
        }
        if (id == 2) {
            throw new NullPointerException("没有对应的数据");
        }
        if (id == 3) {
            throw new RuntimeException("运行异常请求处理");
        }
        return null;
    }

    //处理 java 异常
    public JsonResult<String> fallbackHandler(Long id, Throwable throwable) {
        JsonResult<String> result = new JsonResult<>(444, "出现未知商品" + id);
        return result;
    }

    //处理 Sentinel 异常
    public JsonResult<String> blockHandler(Long id, BlockException blockException) {
        JsonResult<String> result = new JsonResult<>(555, "商品限流" + id);
        return result;
    }
}
