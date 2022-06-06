package com.example.xianyu.service.impl;

import com.example.xianyu.entity.CartItem;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.VO.ItemVO;
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
    public boolean addCart(CartItem cartItem) {
        if(cartMapper.getCartItemByUserIdAndItemId(cartItem.getUid(), Integer.valueOf(cartItem.getIid())) == null)return cartMapper.addCart(cartItem.getUid(), Integer.valueOf(cartItem.getIid())) > 0;
        return false;
    }

    @Override
    public boolean deleteCart(Integer user_id, Integer item_id) {
        return cartMapper.deleteCart(user_id, item_id) > 0;
    }

    @Override
    public List<ItemVO> loadCart(Integer user_id) {
        return cartMapper.getCartItemByUserId(user_id);
    }
}
