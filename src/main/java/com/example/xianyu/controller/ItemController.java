package com.example.xianyu.controller;

import com.example.xianyu.entity.Item;

import com.example.xianyu.entity.User;
import com.example.xianyu.service.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    ItemServiceImpl itemService;

    //成功添加则返回true
    @PostMapping("/upload")
    public boolean upload(@RequestBody Item item, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect();//TODO:login页面跳转路径
            return false;
        }
        item.setSaler_id(user.getUid());
        return itemService.addItem(item);
    }

    //首页商品加载可用
    @GetMapping("/defaultLoad")
    public List<Item> defaultLoad(){
        return itemService.defaultLoadItem();
    }

    //根据商品id删除商品
    @PostMapping("/delete")
    public boolean delete(@RequestParam("iid") Integer iid, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect();//TODO:login页面跳转路径
            return false;
        }
        return itemService.deleteItem(iid);
    }

    //根据商品id访问商品
    @PostMapping("/get")
    public Item getItem(@RequestParam("iid") Integer iid, HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect();//TODO:login页面跳转路径
            return null;
        }
        return itemService.getItemByIid(iid);
    }
}
