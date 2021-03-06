package com.example.xianyu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Options;

import java.math.BigInteger;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private BigInteger phone;
    private String email;
    private String address;
}
