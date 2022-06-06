package com.example.xianyu.service;

import com.example.xianyu.entity.VO.ItemVO;
import com.example.xianyu.entity.VO.UserVO;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.Sale;
import com.example.xianyu.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean register(User user);
    User login(UserVO userVO);
    List<ItemVO> getBuyerSale(Integer uid);
    List<ItemVO> getUserItemForSale(Integer uid);
    List<Sale> getSalerSale(Integer uid);
}
