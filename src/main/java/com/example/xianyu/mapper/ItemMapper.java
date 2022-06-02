package com.example.xianyu.mapper;

import com.example.xianyu.entity.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Options(useGeneratedKeys = true, keyColumn = "iid", keyProperty = "iid")
    @Insert("insert into item(name, price, description, saler_id, item_status, image_addr) " +
            "values(#{name}, #{price}, #{description}, #{saler_id}, #{item_status}, #{image_addr})")
    int addItem(Item item);

    @Update("update item set item_status = 'offMarket' where iid = #{iid}")
    int falseDeleteItemByIid(@Param("iid") Integer iid);

    @Select("select * from item where saler_id = #{saler_id}")
    List<Item> getItemBySalerId(@Param("saler_id") Integer saler_id);

    @Select("select * from item where iid = #{iid}")
    Item getItemByIid(@Param("iid") Integer iid);

    @Select("select * from item where type_id = #{tid}")
    List<Item> getItemByTid(@Param("tid") Integer tid);

    @Select("select * from item where item_status = 'forSale'")
    List<Item> getAllAvailableItem();
}
