package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCourseCoupon extends BaseModelOne<Integer>{

    private Integer courseid;

    private Integer couponid;

    private Integer couponnum;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTCourseCoupon() {
    }

    public BaseTCourseCoupon(Integer id, Integer courseid, Integer couponid, Integer couponnum, Date createtime, Date updatetime) {
        this.id = id;
        this.courseid = courseid;
        this.couponid = couponid;
        this.couponnum = couponnum;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public Integer getCouponnum() {
        return couponnum;
    }

    public void setCouponnum(Integer couponnum) {
        this.couponnum = couponnum;
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