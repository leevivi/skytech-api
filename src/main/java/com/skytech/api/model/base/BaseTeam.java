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
public class BaseTeam extends BaseModel<String>{

    private String teamName;

    private String info;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    private String cover;

    private String department;

    private String staffId;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatedDatetime;

    public BaseTeam() {}

    public BaseTeam(String sid, String teamName, String info, Date createdDatetime, String cover, String department, String staffId, Date updatedDatetime) {
        this.sid = sid;
        this.teamName = teamName;
        this.info = info;
        this.createdDatetime = createdDatetime;
        this.cover = cover;
        this.department = department;
        this.staffId = staffId;
        this.updatedDatetime = updatedDatetime;
    }

    /********** get/set ***********/
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public Date getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(Date updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", teamName=").append(teamName);
        sb.append(", info=").append(info);
        sb.append(", createdDatetime=").append(createdDatetime);
        sb.append(", cover=").append(cover);
        sb.append(", department=").append(department);
        sb.append(", staffId=").append(staffId);
        sb.append(", updatedDatetime=").append(updatedDatetime);
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
        BaseTeam other = (BaseTeam) that;
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