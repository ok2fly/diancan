package com.gcfd.storage.dao;

import com.gcfd.storage.entity.OrderProductDetail;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderProductDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderProductDetail record);

    int insertSelective(OrderProductDetail record);

    OrderProductDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderProductDetail record);

    int updateByPrimaryKey(OrderProductDetail record);

    //根据orderNo获得订单产品信息
    List<OrderProductDetail> getOrderProductList(String orderNo);
}