package com.xinbang.credit.zj.dao.auth.model;

import java.util.Date;

public class CustomerImageAuthInfo {
    private String id;

    private String contractNo;

    private String contractName;

    private String idNo;

    private String status;

    private String identityCardType;

    private String identityCardFrontKey;

    private String identityCardReverseKey;

    private String selfBaseKey;

    private String selfPortraitKey;

    private Integer confidence;

    private String remark;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIdentityCardType() {
        return identityCardType;
    }

    public void setIdentityCardType(String identityCardType) {
        this.identityCardType = identityCardType == null ? null : identityCardType.trim();
    }

    public String getIdentityCardFrontKey() {
        return identityCardFrontKey;
    }

    public void setIdentityCardFrontKey(String identityCardFrontKey) {
        this.identityCardFrontKey = identityCardFrontKey == null ? null : identityCardFrontKey.trim();
    }

    public String getIdentityCardReverseKey() {
        return identityCardReverseKey;
    }

    public void setIdentityCardReverseKey(String identityCardReverseKey) {
        this.identityCardReverseKey = identityCardReverseKey == null ? null : identityCardReverseKey.trim();
    }

    public String getSelfBaseKey() {
        return selfBaseKey;
    }

    public void setSelfBaseKey(String selfBaseKey) {
        this.selfBaseKey = selfBaseKey == null ? null : selfBaseKey.trim();
    }

    public String getSelfPortraitKey() {
        return selfPortraitKey;
    }

    public void setSelfPortraitKey(String selfPortraitKey) {
        this.selfPortraitKey = selfPortraitKey == null ? null : selfPortraitKey.trim();
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}