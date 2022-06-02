package com.example.xianyu.controller;

import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
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
    public boolean buy(@RequestBody Sale sale, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/login");//TODO:login页面跳转路径
            return false;
        }
        sale.setBuyer_id(user.getUid());
        return saleService.buy(sale);
    }

}
