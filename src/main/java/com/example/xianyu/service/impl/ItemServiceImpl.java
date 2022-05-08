package com.example.xianyu.service.impl;

import com.example.xianyu.entity.Item;
import com.example.xianyu.mapper.ItemMapper;
import com.example.xianyu.service.ItemService;

import javax.annotation.Resource;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Resource
    ItemMapper itemMapper;

    @Override
    public boolean addItem(Item item) {
        return itemMapper.addItem(item) > 0;
    }

    @Override
    public List<Item> defaultLoadItem() {
        return itemMapper.getAllAvailableItem();
    }

    @Override
    public boolean deleteItem(Integer iid) {
        return itemMapper.falseDeleteItemByIid(iid) > 0;
    }

    @Override
    public Item getItemByIid(Integer iid) {
        Item item = itemMapper.getItemByIid(iid);
        if(item.getItem_status().equals("forSale"))return item;
        return null;//用户只能访问forSale状态的商品
    }
}
