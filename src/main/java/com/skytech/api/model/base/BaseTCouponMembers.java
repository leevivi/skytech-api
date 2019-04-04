package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCouponMembers extends BaseModelOne<Integer>{

    private Integer couponid;

    private String validityperiod;

    private Integer memberid;

    private String orderno;

    private Integer status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date usedate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTCouponMembers() {
    }

    public BaseTCouponMembers(Integer id, Integer couponid, String validityperiod, Integer memberid, String orderno, Integer status, Date usedate, Date createtime, Date updatetime) {
        this.id = id;
        this.couponid = couponid;
        this.validityperiod = validityperiod;
        this.memberid = memberid;
        this.orderno = orderno;
        this.status = status;
        this.usedate = usedate;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public String getValidityperiod() {
        return validityperiod;
    }

    public void setValidityperiod(String validityperiod) {
        this.validityperiod = validityperiod == null ? null : validityperiod.trim();
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUsedate() {
        return usedate;
    }

    public void setUsedate(Date usedate) {
        this.usedate = usedate;
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