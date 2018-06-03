package com.gcfd.storage.dao;

import com.gcfd.common.DataCenter;
import com.gcfd.storage.entity.Fee;
import org.apache.ibatis.annotations.Mapper;
import  java.util.List;

@Mapper
public interface FeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fee record);

    int insertSelective(Fee record);

    Fee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fee record);

    int updateByPrimaryKey(Fee record);

    /**
     * 获取机构的固定费用列表
     * @param branchId
     * @return
     */
    List<Fee> getBranchFixedFeeList(String branchId);

    List<Fee> getFeeList(DataCenter<Fee> dataCenter);

    Integer getFeeCount();
}