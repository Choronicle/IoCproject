package com.example.xianyu.controller;

import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import com.example.xianyu.entity.VO.GoodVO;
import com.example.xianyu.entity.VO.SaleVO;
import com.example.xianyu.service.impl.SaleServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/sale")
public class SaleController {

    @Resource
    SaleServiceImpl saleService;

    @PostMapping("/buy")
    public boolean buy(@RequestBody SaleVO saleVO){
        boolean flag = true;
        for (GoodVO g: saleVO.getGoods()) {
            Sale sale = new Sale();
            Integer iid = Integer.valueOf(g.getIid());
            sale.setItem_id(iid);
            sale.setSaler_id(saleService.getSalerIdByIid(iid));
            sale.setBuyer_id(saleVO.getUid());
            flag = saleService.buy(sale);
            if(!flag)break;
        }
        return flag;
    }

}
