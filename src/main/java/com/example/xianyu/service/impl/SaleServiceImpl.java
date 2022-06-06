package com.example.xianyu.service.impl;

import com.example.xianyu.entity.Sale;
import com.example.xianyu.mapper.ItemMapper;
import com.example.xianyu.mapper.SaleMapper;
import com.example.xianyu.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaleServiceImpl implements SaleService {
    @Resource
    SaleMapper saleMapper;

    @Resource
    ItemMapper itemMapper;

    @Override
    public boolean buy(Sale sale) {
        if(saleMapper.getSaleByIid(sale.getItem_id()) != null)return false;
        return saleMapper.addSale(sale) > 0;
    }

    @Override
    public Integer getSalerIdByIid(Integer iid) {
        return itemMapper.getSalerIdByIid(iid);
    }


}
