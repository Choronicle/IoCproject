package com.example.xianyu.service.impl;

import com.example.xianyu.entity.Sale;
import com.example.xianyu.mapper.SaleMapper;
import com.example.xianyu.service.SaleService;

import javax.annotation.Resource;

public class SaleServiceImpl implements SaleService {
    @Resource
    SaleMapper saleMapper;

    @Override
    public boolean buy(Sale sale) {
        return saleMapper.addSale(sale) > 0;
    }
}
