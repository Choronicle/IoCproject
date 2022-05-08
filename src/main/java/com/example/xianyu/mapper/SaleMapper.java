package com.example.xianyu.mapper;

import com.example.xianyu.entity.Sale;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SaleMapper {
    @Options(useGeneratedKeys = true, keyColumn = "sid", keyProperty = "sid")
    @Insert("insert into sale(buyer_id, saler_id, item_id) values(#{buyer_id}, #{saler_id}, #{item_id})")
    int addSale(Sale sale);

    @Select("select * from sale where buyer_id = #{buyer_id}")
    List<Sale> getSaleByBuyerId(@Param("buyer_id") Integer buyer_id);

    @Select("select * from sale where saler_id = #{saler_id}")
    List<Sale> getSaleBySalerId(@Param("saler_id") Integer saler_id);
}
