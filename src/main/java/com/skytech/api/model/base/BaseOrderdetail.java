package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseOrderdetail extends BaseModelOne<Integer>{

    private String orderno;

    private Integer coursetimeid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseOrderdetail() {
    }

    public BaseOrderdetail(Integer id, String orderno, Integer coursetimeid, Date createtime, Date updatetime) {
        this.id = id;
        this.orderno = orderno;
        this.coursetimeid = coursetimeid;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Integer getCoursetimeid() {
        return coursetimeid;
    }

    public void setCoursetimeid(Integer coursetimeid) {
        this.coursetimeid = coursetimeid;
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