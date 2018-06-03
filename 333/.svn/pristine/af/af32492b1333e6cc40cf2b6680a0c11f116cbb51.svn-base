package com.gcfd.storage.dao;

import com.gcfd.storage.entity.OrderLabel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderLabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderLabel record);

    int insertSelective(OrderLabel record);

    OrderLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderLabel record);

    int updateByPrimaryKey(OrderLabel record);

    //获得当前机构订单标签
    List<OrderLabel> getCurLabel(String branchId);
}