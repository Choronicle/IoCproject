package com.example.xianyu.service.impl;

import com.example.xianyu.entity.DTO.UserDto;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import com.example.xianyu.mapper.ItemMapper;
import com.example.xianyu.mapper.SaleMapper;
import com.example.xianyu.mapper.UserMapper;
import com.example.xianyu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return userMapper.registerUser(user) > 0;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userMapper.getUserByUsername(username);
//        if(user == null)
//            throw new UsernameNotFoundException("登录失败，用户名或密码错误！");
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .roles("user")
//                .build();
//    }

    @Override
    public User login(UserDto userDto){
        User user = userMapper.getUserByUsername(userDto.getUser_input());
        if(!user.getPassword().equals(userDto.getPass_input())){
            user = null;
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