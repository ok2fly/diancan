package com.gcfd.storage.dao;

import com.gcfd.storage.entity.OrderDispatching;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDispatchingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDispatching record);

    int insertSelective(OrderDispatching record);

    OrderDispatching selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDispatching record);

    int updateByPrimaryKey(OrderDispatching record);

    //根据订单编号获得订单配送信息
    OrderDispatching getOrderDispatchingInfo(String orderNo);
}