package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTCourseTime extends BaseModelOne<Integer>{

    private Integer courseid;

    private Integer weekid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startcoursetime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endcoursetime;

    private Integer classid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTCourseTime() {
    }

    public BaseTCourseTime(Integer id, Integer courseid, Integer weekid, Date startcoursetime, Date endcoursetime, Integer classid, Date createtime, Date updatetime) {
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

    public Date getStartcoursetime() {
        return startcoursetime;
    }

    public void setStartcoursetime(Date startcoursetime) {
        this.startcoursetime = startcoursetime;
    }

    public Date getEndcoursetime() {
        return endcoursetime;
    }

    public void setEndcoursetime(Date endcoursetime) {
        this.endcoursetime = endcoursetime;
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