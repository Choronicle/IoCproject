package com.example.xianyu.entity;

import lombok.Data;

@Data
public class Cart {
    private Integer user_id;
    private Integer[] item_id;
}
