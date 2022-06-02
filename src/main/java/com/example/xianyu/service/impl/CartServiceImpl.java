package com.example.xianyu.service.impl;

import com.example.xianyu.entity.Item;
import com.example.xianyu.mapper.CartMapper;
import com.example.xianyu.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    CartMapper cartMapper;


    @Override
    public boolean addCart(Integer user_id, Integer item_id) {
        if(cartMapper.getCartItemByUserIdAndItemId(user_id, item_id) == null)return cartMapper.addCart(user_id, item_id) > 0;
        return false;
    }

    @Override
    public boolean deleteCart(Integer user_id, Integer item_id) {
        return cartMapper.deleteCart(user_id, item_id) > 0;
    }

    @Override
    public List<Integer> loadCart(Integer user_id) {
        return cartMapper.getCartItemByUserId(user_id);
    }
}
