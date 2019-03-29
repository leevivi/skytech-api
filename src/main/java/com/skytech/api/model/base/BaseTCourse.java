package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCourse extends BaseModelOne<Integer>{

    private String title;

    private Integer dictid;

    private Integer userid;

    private Boolean iscoupon;

    private Integer upper;

    private String coverurl;
    @JSONField(format="yyyy-MM")
    private Date month;

    private Integer companyid;

    private Integer storesid;

    private Boolean status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    private String coursebody;

    public BaseTCourse() {
    }

    public BaseTCourse(Integer id, String title, Integer dictid, Integer userid, Boolean iscoupon, Integer upper, String coverurl, Date month, Integer companyid, Integer storesid, Boolean status, Date createtime, Date updatetime, String coursebody) {
        this.id = id;
        this.title = title;
        this.dictid = dictid;
        this.userid = userid;
        this.iscoupon = iscoupon;
        this.upper = upper;
        this.coverurl = coverurl;
        this.month = month;
        this.companyid = companyid;
        this.storesid = storesid;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.coursebody = coursebody;
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

    public Boolean getIscoupon() {
        return iscoupon;
    }

    public void setIscoupon(Boolean iscoupon) {
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

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
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

    public String getCoursebody() {
        return coursebody;
    }

    public void setCoursebody(String coursebody) {
        this.coursebody = coursebody == null ? null : coursebody.trim();
    }
}