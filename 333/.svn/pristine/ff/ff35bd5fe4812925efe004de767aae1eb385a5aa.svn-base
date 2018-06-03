package com.gcfd.storage.dao;

import com.gcfd.storage.entity.ProductUserRel;
import com.gcfd.storage.entity.ProductUserRelKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductUserRelMapper {
    int deleteByPrimaryKey(ProductUserRelKey key);

    int insert(ProductUserRel record);

    int insertSelective(ProductUserRel record);

    ProductUserRel selectByPrimaryKey(ProductUserRelKey key);

    int updateByPrimaryKeySelective(ProductUserRel record);

    int updateByPrimaryKey(ProductUserRel record);
}