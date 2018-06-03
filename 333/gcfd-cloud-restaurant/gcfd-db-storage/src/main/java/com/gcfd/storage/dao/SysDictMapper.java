package com.gcfd.storage.dao;

import com.gcfd.storage.entity.SysDict;
import com.gcfd.storage.entity.SysDictKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysDictMapper {
    int deleteByPrimaryKey(SysDictKey key);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(@Param("code")String code,@Param("id")String id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    List<SysDict> getAllSysDictByCode(String code);
}