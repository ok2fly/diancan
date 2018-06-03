package com.gcfd.storage.entity;

import java.io.Serializable;

public class SysBranch implements Serializable {
    private Integer id;

    private String branchId;

    private String branchName;

    private String branchShortName;

    private String branchAddr;

    private String branchNo;

    private String branchContacts;

    private String branchContactsPhone;

    private String memo;

    private String branchPic;

    private String branchDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getBranchShortName() {
        return branchShortName;
    }

    public void setBranchShortName(String branchShortName) {
        this.branchShortName = branchShortName == null ? null : branchShortName.trim();
    }

    public String getBranchAddr() {
        return branchAddr;
    }

    public void setBranchAddr(String branchAddr) {
        this.branchAddr = branchAddr == null ? null : branchAddr.trim();
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public String getBranchContacts() {
        return branchContacts;
    }

    public void setBranchContacts(String branchContacts) {
        this.branchContacts = branchContacts == null ? null : branchContacts.trim();
    }

    public String getBranchContactsPhone() {
        return branchContactsPhone;
    }

    public void setBranchContactsPhone(String branchContactsPhone) {
        this.branchContactsPhone = branchContactsPhone == null ? null : branchContactsPhone.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getBranchPic() {
        return branchPic;
    }

    public void setBranchPic(String branchPic) {
        this.branchPic = branchPic == null ? null : branchPic.trim();
    }

    public String getBranchDesc() {
        return branchDesc;
    }

    public void setBranchDesc(String branchDesc) {
        this.branchDesc = branchDesc == null ? null : branchDesc.trim();
    }
}