package com.example.xianyu.service.impl;

import com.example.xianyu.entity.VO.LoginVO;
import com.example.xianyu.entity.VO.UserVO;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import com.example.xianyu.mapper.ItemMapper;
import com.example.xianyu.mapper.SaleMapper;
import com.example.xianyu.mapper.UserMapper;
import com.example.xianyu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    ItemMapper itemMapper;

    @Resource
    SaleMapper saleMapper;

    @Override
    public boolean register(User user) {
        User tmp = userMapper.getUserByUsername(user.getUsername());
        if(tmp != null) return false;
        return userMapper.registerUser(user) > 0;
    }


    @Override
    public User login(UserVO userVO){
        User user = userMapper.getUserByUsername(userVO.getUserInput());
        if(!user.getPassword().equals(userVO.getPassInput())){
            return null;
        }
        return user;
    }

    @Override
    public List<Sale> getBuyerSale(Integer uid) {
        return saleMapper.getSaleByBuyerId(uid);
    }

    @Override
    public List<Item> getUserItemForSale(Integer uid) {
        return itemMapper.getItemBySalerId(uid);
    }

    @Override
    public List<Sale> getSalerSale(Integer uid) {
        return saleMapper.getSaleBySalerId(uid);
    }
}