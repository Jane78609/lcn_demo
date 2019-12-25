package com.leeue.mapper;

import com.leeue.stock.api.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface OrderMapper {

    @Insert(value = "INSERT INTO `order` VALUES (#{id}, #{name}, #{orderCreatetime}, #{orderMoney}, #{orderState}, #{commodityId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int addOrder(OrderEntity orderEntity);

}
