package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCoupon extends BaseModelOne<Integer>{

    private String couponname;

    private Boolean coupontype;

    private Integer companyid;

    private Integer storesid;

    private Boolean status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTCoupon() {
    }

    public BaseTCoupon(Integer id, String couponname, Boolean coupontype, Integer companyid, Integer storesid, Boolean status, Date createtime, Date updatetime) {
        this.id = id;
        this.couponname = couponname;
        this.coupontype = coupontype;
        this.companyid = companyid;
        this.storesid = storesid;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getCouponname() {
        return couponname;
    }

    public void setCouponname(String couponname) {
        this.couponname = couponname == null ? null : couponname.trim();
    }

    public Boolean getCoupontype() {
        return coupontype;
    }

    public void setCoupontype(Boolean coupontype) {
        this.coupontype = coupontype;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getStoresid() {
        return storesid;
    }

    public void setStoresid(Integer storesid) {
        this.storesid = storesid;
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
}