package com.peggy.cloudalibabastatestock8802.controller;

import com.peggy.cloudalibabastatestock8802.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Peggy
 * @Date 2023-05-09 21:29
 **/
@RestController
public class StockController {
    @Resource
    StockService stockService;

    @RequestMapping("/stock/decr")
    public String decrement(){
        stockService.dock();
        return "库存-1";
    }
}
