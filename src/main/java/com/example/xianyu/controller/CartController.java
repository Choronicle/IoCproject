package com.example.xianyu.controller;

import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.User;
import com.example.xianyu.service.impl.CartServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Resource
    CartServiceImpl cartService;

    @GetMapping("/")
    public List<Integer> load(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/login");//TODO:login页面跳转路径
            return null;
        }
        return cartService.loadCart(user.getUid());
    }

    @PostMapping("/addCart")
    public boolean addCart(@Param("item_id") Integer item_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/login");//TODO:login页面跳转路径
            return false;
        }
        return cartService.addCart(user.getUid(), item_id);
    }

    @PostMapping("/deleteCart")
    public boolean deleteCart(@Param("item_id") Integer item_id,  HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/login");//TODO:login页面跳转路径
            return false;
        }
        return cartService.deleteCart(user.getUid(), item_id);
    }
}
