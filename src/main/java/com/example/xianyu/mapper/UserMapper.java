package com.example.xianyu.mapper;

import com.example.xianyu.entity.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User getUserByUsername(@Param("username") String username);

    @Options(useGeneratedKeys = true, keyColumn = "uid", keyProperty = "uid")
    @Insert("insert into user(username, password, phone, email, address) values(#{username}, #{password}, #{phone}, #{email}, #{address})")
    int registerUser(User user);
}
