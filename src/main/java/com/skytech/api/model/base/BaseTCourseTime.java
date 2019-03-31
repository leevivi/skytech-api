package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCourseTime extends BaseModelOne<Integer>{

    private Integer courseid;

    private Integer weekid;

    private String startcoursetime;

    private String endcoursetime;

    private Integer classid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTCourseTime() {
    }

    public BaseTCourseTime(Integer id, Integer courseid, Integer weekid, String startcoursetime, String endcoursetime, Integer classid, Date createtime, Date updatetime) {
        this.id = id;
        this.courseid = courseid;
        this.weekid = weekid;
        this.startcoursetime = startcoursetime;
        this.endcoursetime = endcoursetime;
        this.classid = classid;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getWeekid() {
        return weekid;
    }

    public void setWeekid(Integer weekid) {
        this.weekid = weekid;
    }

    public String getStartcoursetime() {
        return startcoursetime;
    }

    public void setStartcoursetime(String startcoursetime) {
        this.startcoursetime = startcoursetime == null ? null : startcoursetime.trim();
    }

    public String getEndcoursetime() {
        return endcoursetime;
    }

    public void setEndcoursetime(String endcoursetime) {
        this.endcoursetime = endcoursetime == null ? null : endcoursetime.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
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