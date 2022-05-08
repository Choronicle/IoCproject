package com.example.xianyu.controller;

import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import com.example.xianyu.service.impl.SaleServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Resource
    SaleServiceImpl saleService;

    @PostMapping("/buy")
    public boolean buy(@RequestBody Sale sale, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect();//TODO:login页面跳转路径
            return false;
        }
        sale.setBuyer_id(user.getUid());
        return saleService.buy(sale);
    }

}
