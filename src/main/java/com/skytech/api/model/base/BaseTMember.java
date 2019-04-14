package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTMember extends BaseModelOne<Integer>{

    private String lastname;

    private String contact;

    private Integer couponnumber;

    private String appuser;

    private Byte sex;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private Integer age;

    private Boolean dictid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date initiationdate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date expirationdate;

    private Integer isoverdue;

    private Integer storesid;

    private Integer companyid;

    private Integer userid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTMember() {
    }

    public BaseTMember(Integer id, String lastname, String contact, Integer couponnumber, String appuser, Byte sex, Date birthday, Integer age, Boolean dictid, Date initiationdate, Date expirationdate, Integer isoverdue, Integer storesid, Integer companyid, Integer userid, Date createtime, Date updatetime) {
        this.id = id;
        this.lastname = lastname;
        this.contact = contact;
        this.couponnumber = couponnumber;
        this.appuser = appuser;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.dictid = dictid;
        this.initiationdate = initiationdate;
        this.expirationdate = expirationdate;
        this.isoverdue = isoverdue;
        this.storesid = storesid;
        this.companyid = companyid;
        this.userid = userid;
        this.createtime = createtime;
        this.updatetime = updatetime;
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

    public Integer getCouponnumber() {
        return couponnumber;
    }

    public void setCouponnumber(Integer couponnumber) {
        this.couponnumber = couponnumber;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser == null ? null : appuser.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Integer getIsoverdue() {
        return isoverdue;
    }

    public void setIsoverdue(Integer isoverdue) {
        this.isoverdue = isoverdue;
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