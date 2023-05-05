package com.peggy.cloudalibabaopenfeignconsumer8888application.controller;

import com.peggy.cloudalibabacommons.entity.JsonResult;
import com.peggy.cloudalibabaopenfeignconsumer8888application.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Peggy
 * @Date 2023-05-04 22:36
 **/
@RestController
public class OpenFeginController {
    @Autowired
    OpenFeignService openFeignService;

    @GetMapping("getInfo/{id}")
    public JsonResult<String> getInfo(@PathVariable("id") Long id){
        return openFeignService.getInfo(id);
    }
}
