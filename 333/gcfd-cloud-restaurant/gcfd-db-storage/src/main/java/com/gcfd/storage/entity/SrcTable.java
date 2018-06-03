package com.gcfd.storage.entity;

import java.io.Serializable;
import java.util.Date;

public class SrcTable implements Serializable {
    private Integer id;

    private String tableName;

    private String tableCode;

    private Integer seq;

    private String createUserId;

    private Date createTime;

    private String lstModifyUserId;

    private Date lstModifyTime;

    private String isDel;

    private String branchId;

    private Integer orderId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode == null ? null : tableCode.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}