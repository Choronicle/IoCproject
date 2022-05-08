package com.example.xianyu.entity;

import lombok.Data;

@Data
public class Item {
    private Integer iid;
    private String name;
    private Double price;
    private String description;
    private Integer saler_id;
    private String item_status;
    private String image_addr;
    private String update_time;
    private Integer tid;
}
