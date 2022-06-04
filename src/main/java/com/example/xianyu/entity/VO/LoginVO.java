package com.example.xianyu.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class LoginVO {
    private String username;
    private String password;
    private BigInteger phone;
    private String email;
    private String address;
}
