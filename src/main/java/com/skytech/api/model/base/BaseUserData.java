package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.math.BigDecimal;
import java.util.Date;

public class BaseUserData extends BaseModelOne<Integer>{

    private String accountSid;

    private Integer memberId;

    private Integer userdataId;

    private BigDecimal dataActual;

    private BigDecimal dataGoal;

    private Integer upToStandard;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    public BaseUserData() {
    }

    public BaseUserData(Integer id, String accountSid, Integer memberId, Integer userdataId, BigDecimal dataActual, BigDecimal dataGoal, Integer upToStandard, Date createdTime, Date updatedTime) {
        this.id = id;
        this.accountSid = accountSid;
        this.memberId = memberId;
        this.userdataId = userdataId;
        this.dataActual = dataActual;
        this.dataGoal = dataGoal;
        this.upToStandard = upToStandard;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid == null ? null : accountSid.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getUserdataId() {
        return userdataId;
    }

    public void setUserdataId(Integer userdataId) {
        this.userdataId = userdataId;
    }

    public BigDecimal getDataActual() {
        return dataActual;
    }

    public void setDataActual(BigDecimal dataActual) {
        this.dataActual = dataActual;
    }

    public BigDecimal getDataGoal() {
        return dataGoal;
    }

    public void setDataGoal(BigDecimal dataGoal) {
        this.dataGoal = dataGoal;
    }

    public Integer getUpToStandard() {
        return upToStandard;
    }

    public void setUpToStandard(Integer upToStandard) {
        this.upToStandard = upToStandard;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}