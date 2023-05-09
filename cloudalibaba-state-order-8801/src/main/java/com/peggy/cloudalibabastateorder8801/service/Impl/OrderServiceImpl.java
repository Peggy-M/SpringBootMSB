package com.peggy.cloudalibabastateorder8801.service.Impl;

import com.peggy.cloudalibabastateorder8801.client.StockClient;
import com.peggy.cloudalibabastateorder8801.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Peggy
 * @Date 2023-05-09 21:01
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    StockClient stockClient;

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create() {
        //减少库存
//        stockClient.decrement();
        //添加异常
        int i = 1 / 0;

        //创建订单
        jdbcTemplate.update("insert into order_at (count) values (1)");
    }
}
