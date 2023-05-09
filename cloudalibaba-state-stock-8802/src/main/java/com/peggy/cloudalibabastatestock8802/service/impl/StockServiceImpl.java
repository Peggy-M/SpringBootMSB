package com.peggy.cloudalibabastatestock8802.service.impl;


import com.peggy.cloudalibabastatestock8802.service.StockService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Peggy
 * @Date 2023-05-09 21:27
 **/
@Service
public class StockServiceImpl implements StockService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void dock() {
        jdbcTemplate.update("update stock set count = count - 1 where product_id = 1");
    }
}
