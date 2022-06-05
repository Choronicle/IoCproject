package com.example.xianyu.entity;

import com.example.xianyu.entity.VO.UploadItemVO;
import lombok.Data;

@Data
public class Item {
    private Integer iid;//pk,自增,
    private String name;
    private Double price;
    private String description;
    private Integer saler_id;
    private String item_status;
    private String image_addr;
    private String update_time;
    private Integer type_id;
}
