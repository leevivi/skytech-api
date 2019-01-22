package com.skytech.api.model.base;

import com.owthree.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2019-01-06 14:22:51
*/
public class BaseSteps extends BaseModel<String>{

    private String accountSid;

    private String deviceSid;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date recordDate;

    private Integer stepNum;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    public BaseSteps() {}

    public BaseSteps(String sid, String accountSid, String deviceSid, Date recordDate, Integer stepNum, Date createdDatetime) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.deviceSid = deviceSid;
        this.recordDate = recordDate;
        this.stepNum = stepNum;
        this.createdDatetime = createdDatetime;
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
    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
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
        sb.append(", recordDate=").append(recordDate);
        sb.append(", stepNum=").append(stepNum);
        sb.append(", createdDatetime=").append(createdDatetime);
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
        BaseSteps other = (BaseSteps) that;
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