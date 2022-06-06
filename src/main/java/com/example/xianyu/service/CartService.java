package com.example.xianyu.service;

import com.example.xianyu.entity.CartItem;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.VO.ItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    boolean addCart(CartItem cartItem);
    boolean deleteCart(Integer user_id, Integer item_id);
    List<ItemVO> loadCart(Integer user_id);
}
