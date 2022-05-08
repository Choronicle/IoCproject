package com.example.xianyu.service;

import com.example.xianyu.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    boolean addCart(Integer user_id, Integer item_id);
    boolean deleteCart(Integer user_id, Integer item_id);
    List<Integer> loadCart(Integer user_id);
}
