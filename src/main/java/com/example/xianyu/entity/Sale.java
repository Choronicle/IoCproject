package com.example.xianyu.entity;

import lombok.Data;

@Data
public class Sale {
    private Integer sid;
    private Integer buyer_id;
    private Integer saler_id;
    private Integer item_id;
    private String create_time;
}
