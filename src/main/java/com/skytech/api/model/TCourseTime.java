package com.skytech.api.model;

import com.skytech.api.model.base.BaseTCourseTime;

import java.util.Date;

public class TCourseTime extends BaseTCourseTime{
    //教室
    String className;
    //是否已经加入
    Boolean joined;
    //报名人数已满
    Boolean isFull;

    public Boolean getJoined() {
        return joined;
    }

    public void setJoined(Boolean joined) {
        this.joined = joined;
    }

    public Boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(Boolean isFull) {
        this.isFull = isFull;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}