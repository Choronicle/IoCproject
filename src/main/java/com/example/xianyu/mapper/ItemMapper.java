package com.example.xianyu.mapper;

import com.example.xianyu.entity.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Options(useGeneratedKeys = true, keyColumn = "iid", keyProperty = "iid")
    @Insert("insert into item(name, price, description, saler_id, item_status, image_addr, type_id) " +
            "values(#{name}, #{price}, #{description}, #{saler_id}, #{item_status}, #{image_addr}, #{type_id})")
    int addItem(Item item);

    @Update("update item set item_status = 'offMarket' where iid = #{iid}")
    int falseDeleteItemByIid(@Param("iid") Integer iid);

    @Update("update item set item_status = 'sold' where iid = #{iid}")
    int setItemSold(@Param("iid") Integer iid);

    @Select("select * from item where saler_id = #{saler_id} and item_status = 'forSale'")
    List<Item> getItemBySalerId(@Param("saler_id") Integer saler_id);

    @Select("select * from item where iid = #{iid}")
    Item getItemByIid(@Param("iid") Integer iid);

    @Select("select * from item where type_id = #{tid} and item_status = 'forSale'")
    List<Item> getItemByTid(@Param("tid") Integer tid);

    @Select("select * from item where item_status = 'forSale'")
    List<Item> getAllAvailableItem();

    @Select("select * from item where name like #{input} union select a.* from item a inner join item_type b on a.type_id =  b.tid where b.type_name like #{input} and a.item_status = 'forSale'")
    List<Item> getItemBySearching(@Param("input") String input);

    @Select("select saler_id from item where iid = #{item_id}")
    Integer getSalerIdByIid(@Param("item_id") Integer iid);
}
