package com.example.xianyu.controller;

import com.example.xianyu.entity.DTO.UserDto;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import com.example.xianyu.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    //登录成功返回用户信息，登录失败则返回空
    @PostMapping("/login")
    public User login(@RequestBody UserDto userDto, HttpServletRequest request) {
        String username = userDto.getUser_input();
        String password = userDto.getPass_input();
        if (username.isBlank() || password.isBlank()) {
            return null;
        }
        User user =  userService.login(userDto);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return user;
    }

    //注册成功返回true
    @PostMapping("/signUp")
    public boolean signUp(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/bought")
    public List<Sale> buyerSales(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect();//TODO:login页面跳转路径
            return null;
        }
        return userService.getBuyerSale(user.getUid());
    }

    @GetMapping("/sold")
    public List<Sale> salerSales(HttpServletRequest request, HttpServletResponse response) throws IOException{
    HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect();//TODO:login页面跳转路径
            return null;
        }
        return userService.getSalerSale(user.getUid());
    }

    @GetMapping("/forSale")
    public List<Item> itemForSale(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect();//TODO:login页面跳转路径
            return null;
        }
        return userService.getUserItemForSale(user.getUid());
    }

}
