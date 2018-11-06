package com.skytech.api.model.base;

import com.owthree.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2018-11-06 14:36:15
*/
public class BaseEvent extends BaseModel<String>{

    private String eventName;

    private String info;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    private String cover;

    public BaseEvent() {}

    public BaseEvent(String sid, String eventName, String info, Date createdDatetime, String cover) {
        this.sid = sid;
        this.eventName = eventName;
        this.info = info;
        this.createdDatetime = createdDatetime;
        this.cover = cover;
    }

    /********** get/set ***********/
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", eventName=").append(eventName);
        sb.append(", info=").append(info);
        sb.append(", createdDatetime=").append(createdDatetime);
        sb.append(", cover=").append(cover);
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
        BaseEvent other = (BaseEvent) that;
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