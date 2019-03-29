package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseOrgStores extends BaseModelOne<Integer>{

    private String storesname;

    private Integer companyid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date validenddate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date validstartdate;

    private String province;

    private String city;

    private String area;

    private String address;

    private String mobile;

    private Boolean status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseOrgStores() {
    }

    public BaseOrgStores(Integer id, String storesname, Integer companyid, Date validenddate, Date validstartdate, String province, String city, String area, String address, String mobile, Boolean status, Date createtime, Date updatetime) {
        this.id = id;
        this.storesname = storesname;
        this.companyid = companyid;
        this.validenddate = validenddate;
        this.validstartdate = validstartdate;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.mobile = mobile;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getStoresname() {
        return storesname;
    }

    public void setStoresname(String storesname) {
        this.storesname = storesname == null ? null : storesname.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Date getValidenddate() {
        return validenddate;
    }

    public void setValidenddate(Date validenddate) {
        this.validenddate = validenddate;
    }

    public Date getValidstartdate() {
        return validstartdate;
    }

    public void setValidstartdate(Date validstartdate) {
        this.validstartdate = validstartdate;
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