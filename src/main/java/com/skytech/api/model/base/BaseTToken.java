package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModel;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTToken extends BaseModelOne<String> {
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date expiretime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    private String val;

    public BaseTToken() {
    }

    public BaseTToken(String id, Date expiretime, Date createtime, Date updatetime, String val) {
        this.id = id;
        this.expiretime = expiretime;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.val = val;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
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

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }
}