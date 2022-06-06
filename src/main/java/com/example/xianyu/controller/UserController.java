package com.example.xianyu.controller;

import com.example.xianyu.entity.VO.ItemVO;
import com.example.xianyu.entity.VO.LoginVO;
import com.example.xianyu.entity.VO.UserVO;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import com.example.xianyu.service.impl.UserServiceImpl;
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
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    //登录成功返回用户信息，登录失败则返回空
    @GetMapping("/login")
    public Integer login(@Param("username") String username, @Param("password") String password) {
        if (username == null || password == null) {
            return 0;
        }
        UserVO userVO = new UserVO(username,password);
        User user =  userService.login(userVO);
        if(user == null){
            return 0;
        }else{
            return user.getUid();
        }
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
    public List<ItemVO> buyerSales(@RequestParam(name = "userID") Integer uid){
        return userService.getBuyerSale(uid);
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
    public List<ItemVO> itemForSale(@RequestParam(name = "sellID") Integer uid){
        return userService.getUserItemForSale(uid);
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