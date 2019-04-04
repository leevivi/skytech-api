package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCouponLog extends BaseModelOne<Integer>{

    private String batchno;

    private String sendusername;

    private Boolean type;

    private String validityperiod;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date senddate;

    private Integer memberid;

    private Integer number;

    private Integer companyid;

    private Integer storesid;

    private Integer couponid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTCouponLog() {
    }

    public BaseTCouponLog(Integer id, String batchno, String sendusername, Boolean type, String validityperiod, Date senddate, Integer memberid, Integer number, Integer companyid, Integer storesid, Integer couponid, Date createtime, Date updatetime) {
        this.id = id;
        this.batchno = batchno;
        this.sendusername = sendusername;
        this.type = type;
        this.validityperiod = validityperiod;
        this.senddate = senddate;
        this.memberid = memberid;
        this.number = number;
        this.companyid = companyid;
        this.storesid = storesid;
        this.couponid = couponid;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getSendusername() {
        return sendusername;
    }

    public void setSendusername(String sendusername) {
        this.sendusername = sendusername == null ? null : sendusername.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getValidityperiod() {
        return validityperiod;
    }

    public void setValidityperiod(String validityperiod) {
        this.validityperiod = validityperiod == null ? null : validityperiod.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
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