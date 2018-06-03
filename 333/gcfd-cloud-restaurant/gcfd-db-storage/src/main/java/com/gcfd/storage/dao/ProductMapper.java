package com.gcfd.storage.dao;

import com.gcfd.storage.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //获得机构的菜单列表
    List<Product> getBranchProductList(@Param("branchId") String branchId, @Param("keywords") String keywords);
    //获得产品的详情
    Product getProductInfo(Integer productId);

    List<Product> getProductLimitList(@Param("isDel")String isDel,@Param("keywords")String keywords);
    List<Product> getProductList(@Param("productBussinessType")String productBussinessType,@Param("keywords")String keywords);
    int getMaxProductNo();
}