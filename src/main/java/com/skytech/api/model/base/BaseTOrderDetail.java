package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTOrderDetail extends BaseModelOne<Integer>{

    private String orderno;

    private Integer amount;

    private Integer status;

    private Integer coursetimeid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTOrderDetail() {
    }

    public BaseTOrderDetail(Integer id, String orderno, Integer amount, Integer status, Integer coursetimeid, Date createtime, Date updatetime) {
        this.id = id;
        this.orderno = orderno;
        this.amount = amount;
        this.status = status;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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