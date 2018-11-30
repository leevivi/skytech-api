package com.skytech.api.model.base;

import com.owthree.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2018-11-29 19:11:47
*/
public class BaseEventMembers extends BaseModel<String>{

    private String eventSid;

    private String eventName;

    private String accountSid;

    private String accountName;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date joinedDatetime;

    public BaseEventMembers() {}

    public BaseEventMembers(String sid, String eventSid, String eventName, String accountSid, String accountName, Date joinedDatetime) {
        this.sid = sid;
        this.eventSid = eventSid;
        this.eventName = eventName;
        this.accountSid = accountSid;
        this.accountName = accountName;
        this.joinedDatetime = joinedDatetime;
    }

    /********** get/set ***********/
    public String getEventSid() {
        return eventSid;
    }

    public void setEventSid(String eventSid) {
        this.eventSid = eventSid;
    }
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public Date getJoinedDatetime() {
        return joinedDatetime;
    }

    public void setJoinedDatetime(Date joinedDatetime) {
        this.joinedDatetime = joinedDatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", eventSid=").append(eventSid);
        sb.append(", eventName=").append(eventName);
        sb.append(", accountSid=").append(accountSid);
        sb.append(", accountName=").append(accountName);
        sb.append(", joinedDatetime=").append(joinedDatetime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BaseEventMembers other = (BaseEventMembers) that;
        return (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        return result;
    }
}