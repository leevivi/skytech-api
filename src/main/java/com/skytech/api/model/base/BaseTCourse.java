package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCourse extends BaseModelOne<Integer>{

    private String title;

    private Integer dictid;

    private Integer userid;

    private Integer iscoupon;

    private Integer upper;

    private String coverurl;

    private String coursebody;

    private String month;

    private Integer companyid;

    private Integer storesid;

    private Integer status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTCourse() {
    }

    public BaseTCourse(Integer id, String title, Integer dictid, Integer userid, Integer iscoupon, Integer upper, String coverurl, String coursebody, String month, Integer companyid, Integer storesid, Integer status, Date createtime, Date updatetime) {
        this.id = id;
        this.title = title;
        this.dictid = dictid;
        this.userid = userid;
        this.iscoupon = iscoupon;
        this.upper = upper;
        this.coverurl = coverurl;
        this.coursebody = coursebody;
        this.month = month;
        this.companyid = companyid;
        this.storesid = storesid;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getDictid() {
        return dictid;
    }

    public void setDictid(Integer dictid) {
        this.dictid = dictid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getIscoupon() {
        return iscoupon;
    }

    public void setIscoupon(Integer iscoupon) {
        this.iscoupon = iscoupon;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl == null ? null : coverurl.trim();
    }

    public String getCoursebody() {
        return coursebody;
    }

    public void setCoursebody(String coursebody) {
        this.coursebody = coursebody == null ? null : coursebody.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
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