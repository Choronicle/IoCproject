package com.example.xianyu.controller;

import com.example.xianyu.entity.VO.LoginVO;
import com.example.xianyu.entity.VO.UserVO;
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
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    //登录成功返回用户信息，登录失败则返回空
    @PostMapping("/login")
    public boolean login(@RequestBody UserVO userVO, HttpServletRequest request) {
        String username = userVO.getUserInput();
        String password = userVO.getPassInput();
        if (username == null || password == null) {
            return false;
        }
        User user =  userService.login(userVO);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return user != null;
    }

    //注册成功返回true
    @PostMapping("/signUp")
    public boolean signUp(@RequestBody LoginVO loginVO){
        User user = new User();
        user.setUsername(loginVO.getUsername());
        user.setPassword(loginVO.getPassword());
        user.setPhone(loginVO.getPhone());
        user.setEmail(loginVO.getEmail());
        user.setAddress(loginVO.getAddress());
        return userService.register(user);
    }


    @GetMapping("/bought")
    public List<Sale> buyerSales(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/login");//TODO:login页面跳转路径
            return null;
        }
        return userService.getBuyerSale(user.getUid());
    }

    @GetMapping("/sold")
    public List<Sale> salerSales(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/login");//TODO:login页面跳转路径
            return null;
        }
        return userService.getSalerSale(user.getUid());
    }

    @GetMapping("/forSale")
    public List<Item> itemForSale(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/login");//TODO:login页面跳转路径
            return null;
        }
        return userService.getUserItemForSale(user.getUid());
    }

}
//Resolved [org.springframework.web.HttpMediaTypeNotSupportedException:
//        Content type 'multipart/form-data;
//                        boundary=--------------------------338353724026830213271466;
//                        charset=UTF-8'
//        not supported]
//
//        Resolved [org.springframework.http.converter.HttpMessageNotReadableException:
//                Required request body is missing:
//                    public com.example.xianyu.entity.User
//                            com.example.xianyu.controller.UserController.login(com.example.xianyu.entity.VO.UserVO,javax.servlet.http.HttpServletRequest)]