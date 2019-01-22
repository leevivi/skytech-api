package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2018-12-01 23:22:09
*/
public class BaseAccountDevice extends BaseModel<String>{

    private String accountSid;

    private String deviceSid;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    private Byte deviceStatus;

    public BaseAccountDevice() {}

    public BaseAccountDevice(String sid, String accountSid, String deviceSid, Date createdDatetime, Byte deviceStatus) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.deviceSid = deviceSid;
        this.createdDatetime = createdDatetime;
        this.deviceStatus = deviceStatus;
    }

    /********** get/set ***********/
    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
    public String getDeviceSid() {
        return deviceSid;
    }

    public void setDeviceSid(String deviceSid) {
        this.deviceSid = deviceSid;
    }
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
    public Byte getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Byte deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", accountSid=").append(accountSid);
        sb.append(", deviceSid=").append(deviceSid);
        sb.append(", createdDatetime=").append(createdDatetime);
        sb.append(", deviceStatus=").append(deviceStatus);
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
        BaseAccountDevice other = (BaseAccountDevice) that;
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