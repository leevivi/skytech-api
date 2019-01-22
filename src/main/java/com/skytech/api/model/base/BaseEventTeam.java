package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2018-11-06 14:36:15
*/
public class BaseEventTeam extends BaseModel<String>{

    private String eventSid;

    private String eventName;

    private String teamSid;

    private String teamName;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date joinedDatetime;

    public BaseEventTeam() {}

    public BaseEventTeam(String sid, String eventSid, String eventName, String teamSid, String teamName, Date joinedDatetime) {
        this.sid = sid;
        this.eventSid = eventSid;
        this.eventName = eventName;
        this.teamSid = teamSid;
        this.teamName = teamName;
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
    public String getTeamSid() {
        return teamSid;
    }

    public void setTeamSid(String teamSid) {
        this.teamSid = teamSid;
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
        sb.append(", teamSid=").append(teamSid);
        sb.append(", teamName=").append(teamName);
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
        BaseEventTeam other = (BaseEventTeam) that;
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