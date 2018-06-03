package com.gcfd.storage.dao;

import com.gcfd.common.DataCenter;
import com.gcfd.storage.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByBranchIdAndTableNo(@Param("branchId") String branchId,@Param("tableNo")  String tableNo);
    Order selectByOrderNo(String orderNo);
    List<Order> getCookeringOrderList();
    List<Order> getCookeredOrderList(DataCenter<Order> dataCenter);
    Integer getCookeredOrderCount();
    List<Order> getWaiteringOrderList();
    List<Order> getWaiteredOrderList(DataCenter<Order> dataCenter);
    Integer getWaiteredOrderCount();
}