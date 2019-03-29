package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTMemberHistory extends BaseModelOne<Integer>{

    private Integer memberid;

    private String lastname;

    private String contact;

    private String appuser;

    private Boolean sex;

    private Integer age;

    private Boolean dictid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date initiationdate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date expirationdate;

    private Integer storesid;

    private Integer companyid;

    private Integer userid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTMemberHistory() {
    }

    public BaseTMemberHistory(Integer id, Integer memberid, String lastname, String contact, String appuser, Boolean sex, Integer age, Boolean dictid, Date initiationdate, Date expirationdate, Integer storesid, Integer companyid, Integer userid, Date createtime, Date updatetime) {
        this.id = id;
        this.memberid = memberid;
        this.lastname = lastname;
        this.contact = contact;
        this.appuser = appuser;
        this.sex = sex;
        this.age = age;
        this.dictid = dictid;
        this.initiationdate = initiationdate;
        this.expirationdate = expirationdate;
        this.storesid = storesid;
        this.companyid = companyid;
        this.userid = userid;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
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

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser == null ? null : appuser.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getDictid() {
        return dictid;
    }

    public void setDictid(Boolean dictid) {
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

    public Integer getStoresid() {
        return storesid;
    }

    public void setStoresid(Integer storesid) {
        this.storesid = storesid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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