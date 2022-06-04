package com.example.xianyu.service.impl;

import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.VO.ItemVO;
import com.example.xianyu.mapper.ItemMapper;
import com.example.xianyu.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
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

    @Override
    public List<ItemVO> getItemByTid(String type) {
        int tid = -1;
        if (type.equals("title1"))tid = 1;
        if (type.equals("title2"))tid = 2;
        if (type.equals("title3"))tid = 3;
        List<Item> itemList = itemMapper.getItemByTid(tid);
        List<ItemVO> itemVOList = new LinkedList<>();
        for (Item i:itemList) {
            itemVOList.add(new ItemVO(i.getName(), i.getPrice().toString()));
        }
        return itemVOList;
    }

    @Override
    public List<Item> getItemBySearching(String input) {
        if(input == null){
            return null;
        }
        input = "%" + input + "%";
        return itemMapper.getItemBySearching(input);
    }
}

