package com.skytech.api.model.base;

public class BaseTNoticeReadKey {
    private Integer noticeid;

    private Integer userid;

    public BaseTNoticeReadKey() {
    }

    public BaseTNoticeReadKey(Integer noticeid, Integer userid) {
        this.noticeid = noticeid;
        this.userid = userid;
    }

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}