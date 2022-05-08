package com.example.xianyu.service;

import com.example.xianyu.entity.DTO.UserDto;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean register(User user);
    User login(UserDto userDto);
    List<Sale> getBuyerSale(Integer uid);
    List<Item> getUserItemForSale(Integer uid);
    List<Sale> getSalerSale(Integer uid);
}
