package com.skytech.api.model;

import java.util.Date;

/**
 * Created by 1 on 2019/4/10.
 */
public class SelectCourseTime {
    //课程时段id
    Integer courserTimeId;
    //课程时间
    Date courseDate;
    //课程时段
    String courseTime;
    //教室名称
    String className;

    public Integer getCourserTimeId() {
        return courserTimeId;
    }

    public void setCourserTimeId(Integer courserTimeId) {
        this.courserTimeId = courserTimeId;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
