package com.gcfd.storage.dao;

import com.gcfd.storage.entity.OrderFeeDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderFeeDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderFeeDetail record);

    int insertSelective(OrderFeeDetail record);

    OrderFeeDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderFeeDetail record);

    int updateByPrimaryKey(OrderFeeDetail record);

    //根据orderNo获得订单产品信息
    List<OrderFeeDetail> getOrderFeeList(String orderNo);
}