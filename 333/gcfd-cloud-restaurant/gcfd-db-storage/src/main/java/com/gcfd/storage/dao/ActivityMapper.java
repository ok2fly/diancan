package com.gcfd.storage.dao;

import com.gcfd.common.DataCenter;
import com.gcfd.storage.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    //获得当前机构活动
    List<Activity> getCurActivity(String branchId);

    //获得订单折扣活动
    Activity getOrderDiscountActivity(String branchId);

    List<Activity> getActivityList(DataCenter<Activity> dataCenter);
    Integer getActivityCount();
}