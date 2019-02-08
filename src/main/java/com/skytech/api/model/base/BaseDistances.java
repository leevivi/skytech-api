package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 剑神卓凌昭
 * @date 2019-02-01 22:08:44
 */
public class BaseDistances extends BaseModel<String> {

    private String accountSid;

    private BigDecimal distance;

    private BigDecimal cal;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    public BaseDistances() {
    }

    public BaseDistances(String sid, String accountSid, BigDecimal distance, BigDecimal cal, Date createdDatetime) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.distance = distance;
        this.cal = cal;
        this.createdDatetime = createdDatetime;
    }

    /********** get/set ***********/
    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getCal() {
        return cal;
    }

    public void setCal(BigDecimal cal) {
        this.cal = cal;
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
        sb.append(", distance=").append(distance);
        sb.append(", cal=").append(cal);
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
        BaseDistances other = (BaseDistances) that;
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