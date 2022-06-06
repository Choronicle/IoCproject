package com.example.xianyu.service.impl;

import com.example.xianyu.entity.VO.ItemVO;
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
import java.util.LinkedList;
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
        if(user == null)return null;
        if(!user.getPassword().equals(userVO.getPassInput())){
            return null;
        }
        return user;
    }

    @Override
    public List<ItemVO> getBuyerSale(Integer uid) {
        List<Item> itemList = saleMapper.getSaleByBuyerId(uid);
        List<ItemVO> itemVOList = new LinkedList<>();
        for (Item i: itemList) {
            ItemVO tmp = new ItemVO(i.getIid(),i.getName(),Double.toString(i.getPrice()),i.getImage_addr());
            itemVOList.add(tmp);
        }
        return itemVOList;
    }

    @Override
    public List<ItemVO> getUserItemForSale(Integer uid) {
        List<Item> itemList = itemMapper.getItemBySalerId(uid);
        List<ItemVO> itemVOList = new LinkedList<>();
        for (Item i: itemList) {
            ItemVO tmp = new ItemVO(i.getIid(),i.getName(),Double.toString(i.getPrice()),i.getImage_addr());
            itemVOList.add(tmp);
        }
        return itemVOList;
    }

    @Override
    public List<Sale> getSalerSale(Integer uid) {
        return saleMapper.getSaleBySalerId(uid);
    }
}