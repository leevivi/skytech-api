package com.skytech.api.model.base;

import com.owthree.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2018-12-14 22:27:58
*/
public class BaseHeartRate extends BaseModel<String>{

    private String accountSid;

    private String accountName;

    private String data;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startDatetime;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endDatetime;

    private String deviceSid;

    public BaseHeartRate() {}

    public BaseHeartRate(String sid, String accountSid, String accountName, String data, Date startDatetime, Date createdDatetime, Date endDatetime, String deviceSid) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.accountName = accountName;
        this.data = data;
        this.startDatetime = startDatetime;
        this.createdDatetime = createdDatetime;
        this.endDatetime = endDatetime;
        this.deviceSid = deviceSid;
    }

    /********** get/set ***********/
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
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }
    public String getDeviceSid() {
        return deviceSid;
    }

    public void setDeviceSid(String deviceSid) {
        this.deviceSid = deviceSid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", accountSid=").append(accountSid);
        sb.append(", accountName=").append(accountName);
        sb.append(", data=").append(data);
        sb.append(", startDatetime=").append(startDatetime);
        sb.append(", createdDatetime=").append(createdDatetime);
        sb.append(", endDatetime=").append(endDatetime);
        sb.append(", deviceSid=").append(deviceSid);
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
        BaseHeartRate other = (BaseHeartRate) that;
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