package com.gcfd.storage.dao;

import com.gcfd.storage.entity.SysBranch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysBranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysBranch record);

    int insertSelective(SysBranch record);

    SysBranch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysBranch record);

    int updateByPrimaryKey(SysBranch record);


    //扩展方法
    SysBranch selectByBranchId(String branchId);
}