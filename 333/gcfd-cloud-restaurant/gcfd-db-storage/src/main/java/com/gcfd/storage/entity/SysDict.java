package com.gcfd.storage.entity;

import java.io.Serializable;
import java.util.Date;

public class SysDict extends SysDictKey implements Serializable {
    private String name;

    private String description;

    private Integer num;

    private String createUserId;

    private Date createTime;

    private String lstModifyUserId;

    private Date lstModifyTime;

    private String isDel;

    private String branchId;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
}