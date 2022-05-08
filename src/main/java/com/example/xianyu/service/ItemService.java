package com.example.xianyu.service;

import com.example.xianyu.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    boolean addItem(Item item);
    List<Item> defaultLoadItem();
    boolean deleteItem(Integer iid);
    Item getItemByIid(Integer iid);
}
