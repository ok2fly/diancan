package com.gcfd.storage.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPayInfo implements Serializable {
    private Long id;

    private String orderNo;

    private String payType;

    private BigDecimal payTotal;

    private Date payTime;

    private String createUserId;

    private Date createTime;

    private String lstModifyUserId;

    private Date lstModifyTime;

    private String isDel;

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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public BigDecimal getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(BigDecimal payTotal) {
        this.payTotal = payTotal;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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
}