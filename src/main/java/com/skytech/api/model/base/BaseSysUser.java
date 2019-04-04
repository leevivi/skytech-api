package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseSysUser extends BaseModelOne<Integer>{

    private String username;

    private String password;

    private Integer companyid;

    private Integer storesid;

    private String nickname;

    private String headimgurl;

    private String phone;

    private String empcode;

    private Boolean type;

    private Boolean ismaster;

    private Boolean iscompany;

    private String email;
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

    private Boolean sex;

    private Boolean status;

    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseSysUser() {
    }

    public BaseSysUser(Integer id, String username, String password, Integer companyid, Integer storesid, String nickname, String headimgurl, String phone, String empcode, Boolean type, Boolean ismaster, Boolean iscompany, String email, Date birthday, Boolean sex, Boolean status, Date createtime, Date updatetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.companyid = companyid;
        this.storesid = storesid;
        this.nickname = nickname;
        this.headimgurl = headimgurl;
        this.phone = phone;
        this.empcode = empcode;
        this.type = type;
        this.ismaster = ismaster;
        this.iscompany = iscompany;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode == null ? null : empcode.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getIsmaster() {
        return ismaster;
    }

    public void setIsmaster(Boolean ismaster) {
        this.ismaster = ismaster;
    }

    public Boolean getIscompany() {
        return iscompany;
    }

    public void setIscompany(Boolean iscompany) {
        this.iscompany = iscompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
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