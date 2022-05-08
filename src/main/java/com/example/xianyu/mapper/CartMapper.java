package com.example.xianyu.mapper;

import com.example.xianyu.entity.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CartMapper {

    @Insert("insert into cart(user_id,item_id) values(#{user_id}, #{item_id})")
    int addCart(@Param("user_id") Integer user_id, @Param("item_id") Integer item_id);

    @Select("select item_id from cart where user_id = #{user_id}")
    List<Integer> getCartItemByUserId(@Param("user_id") Integer user_id);

    @Delete("delete from cart where user_id = #{user_id} and item_id = #{item_id}")
    int deleteCart(@Param("user_id") Integer user_id, @Param("item_id") Integer item_id);
}
