package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTOrder extends BaseModelOne<Integer>{

    private String orderno;

    private Integer courseid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date ordertime;

    private Integer quantity;

    private Integer amount;

    private Integer memberid;

    private Integer companyid;

    private Integer storesid;

    private Integer status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date completedate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTOrder() {
    }

    public BaseTOrder(Integer id, String orderno, Integer courseid, Date ordertime, Integer quantity, Integer amount, Integer memberid, Integer companyid, Integer storesid, Integer status, Date completedate, Date createtime, Date updatetime) {
        this.id = id;
        this.orderno = orderno;
        this.courseid = courseid;
        this.ordertime = ordertime;
        this.quantity = quantity;
        this.amount = amount;
        this.memberid = memberid;
        this.companyid = companyid;
        this.storesid = storesid;
        this.status = status;
        this.completedate = completedate;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCompletedate() {
        return completedate;
    }

    public void setCompletedate(Date completedate) {
        this.completedate = completedate;
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