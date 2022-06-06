package com.example.xianyu.service;

import com.example.xianyu.entity.Sale;
import org.springframework.stereotype.Service;

@Service
public interface SaleService {
    boolean buy(Sale sale);
    Integer getSalerIdByIid(Integer iid);
}
