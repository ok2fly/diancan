package com.gcfd.storage.dao;

import com.gcfd.storage.entity.SysUserGroupRelKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserGroupRelMapper {
    int deleteByPrimaryKey(SysUserGroupRelKey key);

    int insert(SysUserGroupRelKey record);

    int insertSelective(SysUserGroupRelKey record);
}