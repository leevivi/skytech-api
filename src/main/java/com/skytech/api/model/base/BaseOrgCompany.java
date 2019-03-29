package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseOrgCompany extends BaseModelOne<Integer>{

    private String companyname;

    private String province;

    private String city;

    private String area;

    private String address;

    private String mobile;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date validstartdate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date validenddate;

    private Boolean status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseOrgCompany() {
    }

    public BaseOrgCompany(Integer id, String companyname, String province, String city, String area, String address, String mobile, Date validstartdate, Date validenddate, Boolean status, Date createtime, Date updatetime) {
        this.id = id;
        this.companyname = companyname;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.mobile = mobile;
        this.validstartdate = validstartdate;
        this.validenddate = validenddate;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getValidstartdate() {
        return validstartdate;
    }

    public void setValidstartdate(Date validstartdate) {
        this.validstartdate = validstartdate;
    }

    public Date getValidenddate() {
        return validenddate;
    }

    public void setValidenddate(Date validenddate) {
        this.validenddate = validenddate;
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