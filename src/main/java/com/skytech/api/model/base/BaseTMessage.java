package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;
import io.swagger.models.auth.In;

import java.util.Date;

public class BaseTMessage extends BaseModelOne<Integer>{

    private String msgtheme;

    private Integer msgtype;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date msgtime;

    private Integer membertype;

    private String msgbody;

    private Object msgcondition;

    private String msgurl;

    private String username;

    private Integer type;

    private Integer status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTMessage() {
    }

    public BaseTMessage(Integer id, String msgtheme, Integer msgtype, Date msgtime, Integer membertype, String msgbody, Object msgcondition, String msgurl, String username, Integer type, Integer status, Date createtime, Date updatetime) {
        this.id = id;
        this.msgtheme = msgtheme;
        this.msgtype = msgtype;
        this.msgtime = msgtime;
        this.membertype = membertype;
        this.msgbody = msgbody;
        this.msgcondition = msgcondition;
        this.msgurl = msgurl;
        this.username = username;
        this.type = type;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getMsgtheme() {
        return msgtheme;
    }

    public void setMsgtheme(String msgtheme) {
        this.msgtheme = msgtheme == null ? null : msgtheme.trim();
    }

    public Integer getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    public Date getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(Date msgtime) {
        this.msgtime = msgtime;
    }

    public Integer getMembertype() {
        return membertype;
    }

    public void setMembertype(Integer membertype) {
        this.membertype = membertype;
    }

    public String getMsgbody() {
        return msgbody;
    }

    public void setMsgbody(String msgbody) {
        this.msgbody = msgbody == null ? null : msgbody.trim();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
}