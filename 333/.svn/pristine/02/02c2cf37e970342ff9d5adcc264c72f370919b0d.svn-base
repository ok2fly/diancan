package com.gcfd.storage.dao;

import com.gcfd.storage.entity.SrcTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrcTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SrcTable record);

    int insertSelective(SrcTable record);

    SrcTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SrcTable record);

    int updateByPrimaryKey(SrcTable record);

    //根据桌号获取桌信息
    SrcTable getSrcTableInfoByTableNo(String tableNo);
        }