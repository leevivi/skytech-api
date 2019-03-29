package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelOne;

public class BaseTMailTo extends BaseModelOne<Integer>{
    private Integer mailid;

    private String touser;

    private Boolean status;

    public BaseTMailTo() {
    }

    public BaseTMailTo(Integer id, Integer mailid, String touser, Boolean status) {
        this.id = id;
        this.mailid = mailid;
        this.touser = touser;
        this.status = status;
    }

    public Integer getMailid() {
        return mailid;
    }

    public void setMailid(Integer mailid) {
        this.mailid = mailid;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser == null ? null : touser.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}