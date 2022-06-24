package com.example.xianyu.controller;

import com.example.xianyu.entity.Item;


import com.example.xianyu.entity.VO.DeleteVO;
import com.example.xianyu.entity.VO.ItemVO;
import com.example.xianyu.entity.VO.UploadItemVO;
import com.example.xianyu.service.impl.ItemServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @Resource
    ItemServiceImpl itemService;

    //成功添加则返回true
    @PostMapping("/upload")
    public boolean upload(@RequestBody UploadItemVO vo){
        Item item = new Item();
        item.setName(vo.getGoodName());
        item.setImage_addr(vo.getImgURL());
        item.setDescription(vo.getDesc());
        item.setPrice(Double.valueOf(vo.getGoodPrice()));
        item.setSaler_id(vo.getUid());
        item.setItem_status("forSale");
        item.setType_id(1);
        return itemService.addItem(item);
    }

    //首页商品加载可用
    @GetMapping("/defaultLoad")
    public List<Item> defaultLoad(){
        return itemService.defaultLoadItem();
    }

    @GetMapping("/getByType")
    public List<ItemVO> getByType(@Param("type") String type){
        return itemService.getItemByTid(type);
    }

    //根据商品id删除商品
    @PostMapping("/delete")
    public boolean delete(@RequestBody DeleteVO vo){
        return itemService.deleteItem(vo.getIid());
    }

    //根据商品id访问商品
    @GetMapping("/get")
    public Item getItem(@RequestParam("iid") Integer iid){
        return itemService.getItemByIid(iid);
    }

    @GetMapping("/search")
    public List<ItemVO> getItemBySearching(@Param("input") String input){
        return itemService.getItemBySearching(input);
    }
}
