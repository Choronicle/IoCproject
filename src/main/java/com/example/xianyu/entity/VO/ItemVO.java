package com.example.xianyu.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemVO {
    Integer iid;
    String title;
    String price;
    String imgURL;
}
