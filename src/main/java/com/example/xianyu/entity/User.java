package com.example.xianyu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Options;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class User {
    private Integer uid;
    private String username;
    private String password;
    private BigInteger phone;
    private String email;
    private String address;

    public User(String username, String password, BigInteger phone, String email, String address){
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
