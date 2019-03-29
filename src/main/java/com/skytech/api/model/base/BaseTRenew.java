package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.math.BigDecimal;
import java.util.Date;

public class BaseTRenew extends BaseModelOne<Integer>{

    private String pactcode;

    private Integer companyid;

    private Integer storesid;

    private String lastname;

    private String contact;

    private Integer coachid;

    private Integer dictid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date initiationdate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date expirationdate;

    private Integer memberid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date renewdate;

    private BigDecimal renewamount;

    private Integer unitid;

    private Integer empid;

    private Integer commid;

    private BigDecimal commamount;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTRenew() {
    }

    public BaseTRenew(Integer id, String pactcode, Integer companyid, Integer storesid, String lastname, String contact, Integer coachid, Integer dictid, Date initiationdate, Date expirationdate, Integer memberid, Date renewdate, BigDecimal renewamount, Integer unitid, Integer empid, Integer commid, BigDecimal commamount, Date createtime, Date updatetime) {
        this.id = id;
        this.pactcode = pactcode;
        this.companyid = companyid;
        this.storesid = storesid;
        this.lastname = lastname;
        this.contact = contact;
        this.coachid = coachid;
        this.dictid = dictid;
        this.initiationdate = initiationdate;
        this.expirationdate = expirationdate;
        this.memberid = memberid;
        this.renewdate = renewdate;
        this.renewamount = renewamount;
        this.unitid = unitid;
        this.empid = empid;
        this.commid = commid;
        this.commamount = commamount;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getPactcode() {
        return pactcode;
    }

    public void setPactcode(String pactcode) {
        this.pactcode = pactcode == null ? null : pactcode.trim();
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public Integer getDictid() {
        return dictid;
    }

    public void setDictid(Integer dictid) {
        this.dictid = dictid;
    }

    public Date getInitiationdate() {
        return initiationdate;
    }

    public void setInitiationdate(Date initiationdate) {
        this.initiationdate = initiationdate;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Date getRenewdate() {
        return renewdate;
    }

    public void setRenewdate(Date renewdate) {
        this.renewdate = renewdate;
    }

    public BigDecimal getRenewamount() {
        return renewamount;
    }

    public void setRenewamount(BigDecimal renewamount) {
        this.renewamount = renewamount;
    }

    public Integer getUnitid() {
        return unitid;
    }

    public void setUnitid(Integer unitid) {
        this.unitid = unitid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getCommid() {
        return commid;
    }

    public void setCommid(Integer commid) {
        this.commid = commid;
    }

    public BigDecimal getCommamount() {
        return commamount;
    }

    public void setCommamount(BigDecimal commamount) {
        this.commamount = commamount;
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