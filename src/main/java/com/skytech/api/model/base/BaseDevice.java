package com.skytech.api.model.base;

import com.owthree.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2018-12-01 23:22:09
*/
public class BaseDevice extends BaseModel<String>{

    private String model;

    private String deviceId;

    private String batch;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    public BaseDevice() {}

    public BaseDevice(String sid, String model, String deviceId, String batch, Date createdDatetime) {
        this.sid = sid;
        this.model = model;
        this.deviceId = deviceId;
        this.batch = batch;
        this.createdDatetime = createdDatetime;
    }

    /********** get/set ***********/
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
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
        sb.append(", model=").append(model);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", batch=").append(batch);
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
        BaseDevice other = (BaseDevice) that;
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