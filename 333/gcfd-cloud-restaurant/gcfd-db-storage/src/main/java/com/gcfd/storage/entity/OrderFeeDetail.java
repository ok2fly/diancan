package com.gcfd.storage.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderFeeDetail implements Serializable {
    private Long id;

    private String orderNo;

    private Integer feeId;

    private String feeName;

    private Integer amount;

    private BigDecimal origPrice;

    private BigDecimal specPrice;

    private BigDecimal realTotal;

    private String createUserId;

    private Date createTime;

    private String lstModifyUserId;

    private Date lstModifyTime;

    private String isDel;

    private String feeNo;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName == null ? null : feeName.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrigPrice() {
        return origPrice;
    }

    public void setOrigPrice(BigDecimal origPrice) {
        this.origPrice = origPrice;
    }

    public BigDecimal getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(BigDecimal specPrice) {
        this.specPrice = specPrice;
    }

    public BigDecimal getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(BigDecimal realTotal) {
        this.realTotal = realTotal;
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

    public String getFeeNo() {
        return feeNo;
    }

    public void setFeeNo(String feeNo) {
        this.feeNo = feeNo == null ? null : feeNo.trim();
    }
}