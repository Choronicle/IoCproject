package com.example.xianyu.mapper;

import com.example.xianyu.entity.Item;
import com.example.xianyu.entity.Sale;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SaleMapper {
    @Options(useGeneratedKeys = true, keyColumn = "sid", keyProperty = "sid")
    @Insert("insert into sale(buyer_id, saler_id, item_id) values(#{buyer_id}, #{saler_id}, #{item_id})")
    int addSale(Sale sale);

    @Select("select * from sale where item_id = #{item_id}")
    Sale getSaleByIid(@Param("item_id") Integer iid);

    @Select("select i.* from sale s inner join item i on i.iid = s.item_id where s.buyer_id = #{buyer_id}")
    List<Item> getSaleByBuyerId(@Param("buyer_id") Integer buyer_id);

    @Select("select * from sale where saler_id = #{saler_id}")
    List<Sale> getSaleBySalerId(@Param("saler_id") Integer saler_id);
}
