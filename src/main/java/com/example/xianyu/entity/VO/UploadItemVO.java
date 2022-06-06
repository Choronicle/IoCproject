package com.example.xianyu.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadItemVO {
    String imgURL;
    String desc;
    String shopInfo;
    String goodName;
    String goodPrice;
    Integer uid;
}
