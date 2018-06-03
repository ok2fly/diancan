package com.gcfd.storage.dao;

import com.gcfd.storage.entity.SrcTableUserRel;
import com.gcfd.storage.entity.SrcTableUserRelKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrcTableUserRelMapper {
    int deleteByPrimaryKey(SrcTableUserRelKey key);

    int insert(SrcTableUserRel record);

    int insertSelective(SrcTableUserRel record);

    SrcTableUserRel selectByPrimaryKey(SrcTableUserRelKey key);

    int updateByPrimaryKeySelective(SrcTableUserRel record);

    int updateByPrimaryKey(SrcTableUserRel record);
}