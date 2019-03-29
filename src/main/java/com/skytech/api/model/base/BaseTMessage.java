package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTMessage extends BaseModelOne<Integer>{

    private String msgtheme;

    private Boolean msgtype;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date msgtime;

    private Object msgcondition;

    private String msgurl;

    private String username;

    private Boolean status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    private String msgbody;

    public BaseTMessage() {
    }

    public BaseTMessage(Integer id, String msgtheme, Boolean msgtype, Date msgtime, Object msgcondition, String msgurl, String username, Boolean status, Date createtime, Date updatetime, String msgbody) {
        this.id = id;
        this.msgtheme = msgtheme;
        this.msgtype = msgtype;
        this.msgtime = msgtime;
        this.msgcondition = msgcondition;
        this.msgurl = msgurl;
        this.username = username;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.msgbody = msgbody;
    }

    public String getMsgtheme() {
        return msgtheme;
    }

    public void setMsgtheme(String msgtheme) {
        this.msgtheme = msgtheme == null ? null : msgtheme.trim();
    }

    public Boolean getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Boolean msgtype) {
        this.msgtype = msgtype;
    }

    public Date getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(Date msgtime) {
        this.msgtime = msgtime;
    }

    public Object getMsgcondition() {
        return msgcondition;
    }

    public void setMsgcondition(Object msgcondition) {
        this.msgcondition = msgcondition;
    }

    public String getMsgurl() {
        return msgurl;
    }

    public void setMsgurl(String msgurl) {
        this.msgurl = msgurl == null ? null : msgurl.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getMsgbody() {
        return msgbody;
    }

    public void setMsgbody(String msgbody) {
        this.msgbody = msgbody == null ? null : msgbody.trim();
    }
}