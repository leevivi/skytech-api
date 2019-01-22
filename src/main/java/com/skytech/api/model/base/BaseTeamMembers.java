package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2018-11-06 14:36:15
*/
public class BaseTeamMembers extends BaseModel<String>{

    private String teamSid;

    private String teamName;

    private String accountSid;

    private String accountName;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date joinedDatetime;

    public BaseTeamMembers() {}

    public BaseTeamMembers(String sid, String teamSid, String teamName, String accountSid, String accountName, Date joinedDatetime) {
        this.sid = sid;
        this.teamSid = teamSid;
        this.teamName = teamName;
        this.accountSid = accountSid;
        this.accountName = accountName;
        this.joinedDatetime = joinedDatetime;
    }

    /********** get/set ***********/
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
        sb.append(", teamSid=").append(teamSid);
        sb.append(", teamName=").append(teamName);
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
        BaseTeamMembers other = (BaseTeamMembers) that;
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