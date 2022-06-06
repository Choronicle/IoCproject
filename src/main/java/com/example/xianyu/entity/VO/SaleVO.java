package com.example.xianyu.entity.VO;

import lombok.Data;

import java.util.List;

@Data
public class SaleVO {
    List<GoodVO> goods;
    Integer uid;
}
