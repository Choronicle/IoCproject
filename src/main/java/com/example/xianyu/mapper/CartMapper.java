package com.example.xianyu.mapper;

import com.example.xianyu.entity.CartItem;
import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.VO.ItemVO;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CartMapper {

    @Insert("insert into cart(user_id,item_id) values(#{user_id}, #{item_id})")
    int addCart(@Param("user_id") Integer user_id, @Param("item_id") Integer item_id);

    @Select("select i.* from cart c inner join item i on i.iid = c.item_id where c.user_id = #{user_id}")
    List<ItemVO> getCartItemByUserId(@Param("user_id") Integer user_id);

    @Select("select * from cart where user_id = #{user_id} and item_id = #{item_id}")
    CartItem getCartItemByUserIdAndItemId(@Param("user_id") Integer user_id, @Param("item_id") Integer item_id);

    @Delete("delete from cart where user_id = #{user_id} and item_id = #{item_id}")
    int deleteCart(@Param("user_id") Integer user_id, @Param("item_id") Integer item_id);
}
