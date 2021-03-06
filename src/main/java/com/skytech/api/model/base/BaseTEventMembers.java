package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTEventMembers extends BaseModelOne<Integer>{

    private Integer eventId;

    private String eventName;

    private String accountSid;

    private String accountName;

    private Integer memberId;

    private Date joinedTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    private String bak4;

    private String bak5;

    public BaseTEventMembers() {
    }

    public BaseTEventMembers(Integer id, Integer eventId, String eventName, String accountSid, String accountName, Integer memberId, Date joinedTime, Date createdTime, Date updatedTime, String bak4, String bak5) {
        this.id = id;
        this.eventId = eventId;
        this.eventName = eventName;
        this.accountSid = accountSid;
        this.accountName = accountName;
        this.memberId = memberId;
        this.joinedTime = joinedTime;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.bak4 = bak4;
        this.bak5 = bak5;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid == null ? null : accountSid.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(Date joinedTime) {
        this.joinedTime = joinedTime;
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

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4 == null ? null : bak4.trim();
    }

    public String getBak5() {
        return bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5 == null ? null : bak5.trim();
    }
}