package com.gcfd.storage.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private String productNo;

    private String productName;

    private String productBussinessType;

    private String productAttributeType;

    private String productSpecification;

    private String productUnit;

    private String productDesc;

    private BigDecimal prodcutPrice;

    private String productCover;

    private String isPreferentialInOrder;

    private String createUserId;

    private Date createTime;

    private String lstModifyUserId;

    private Date lstModifyTime;

    private String isDel;

    private String branchId;

    private int limitAmount;

    private String productBussinessTypeName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductBussinessType() {
        return productBussinessType;
    }

    public void setProductBussinessType(String productBussinessType) {
        this.productBussinessType = productBussinessType == null ? null : productBussinessType.trim();
    }

    public String getProductAttributeType() {
        return productAttributeType;
    }

    public void setProductAttributeType(String productAttributeType) {
        this.productAttributeType = productAttributeType == null ? null : productAttributeType.trim();
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification == null ? null : productSpecification.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public BigDecimal getProdcutPrice() {
        return prodcutPrice;
    }

    public void setProdcutPrice(BigDecimal prodcutPrice) {
        this.prodcutPrice = prodcutPrice;
    }

    public String getProductCover() {
        return productCover;
    }

    public void setProductCover(String productCover) {
        this.productCover = productCover == null ? null : productCover.trim();
    }

    public String getIsPreferentialInOrder() {
        return isPreferentialInOrder;
    }

    public void setIsPreferentialInOrder(String isPreferentialInOrder) {
        this.isPreferentialInOrder = isPreferentialInOrder == null ? null : isPreferentialInOrder.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLstModifyUserId() {
        return lstModifyUserId;
    }

    public void setLstModifyUserId(String lstModifyUserId) {
        this.lstModifyUserId = lstModifyUserId == null ? null : lstModifyUserId.trim();
    }

    public Date getLstModifyTime() {
        return lstModifyTime;
    }

    public void setLstModifyTime(Date lstModifyTime) {
        this.lstModifyTime = lstModifyTime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }
    private Integer maxAmount;

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    private String productAttributeTypeName;

    public String getProductAttributeTypeName() {
        return productAttributeTypeName;
    }

    public void setProductAttributeTypeName(String productAttributeTypeName) {
        this.productAttributeTypeName = productAttributeTypeName;
    }
    public Integer getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Integer limitAmount) {
        this.limitAmount = limitAmount;
    }
    public String getProductBussinessTypeName() {
        return productBussinessTypeName;
    }

    public void setProductBussinessTypeName(String productBussinessTypeName) {
        this.productBussinessTypeName = productBussinessTypeName;
    }

    private Integer num;
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}