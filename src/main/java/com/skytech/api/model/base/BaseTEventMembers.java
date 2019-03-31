package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTEventMembers extends BaseModelOne<Integer>{

    private Integer eventId;

    private String eventName;

    private String accountSid;

    private String accountName;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date joinedTime;

    private String bak1;

    private String bak2;

    private String bak3;

    private String bak4;

    private String bak5;

    public BaseTEventMembers() {
    }

    public BaseTEventMembers(Integer id, Integer eventId, String eventName, String accountSid, String accountName, Date joinedTime, String bak1, String bak2, String bak3, String bak4, String bak5) {
        this.id = id;
        this.eventId = eventId;
        this.eventName = eventName;
        this.accountSid = accountSid;
        this.accountName = accountName;
        this.joinedTime = joinedTime;
        this.bak1 = bak1;
        this.bak2 = bak2;
        this.bak3 = bak3;
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

    public Date getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(Date joinedTime) {
        this.joinedTime = joinedTime;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
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