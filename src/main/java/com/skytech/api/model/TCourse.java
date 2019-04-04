package com.skytech.api.model;

import com.skytech.api.model.base.BaseTCourse;

import java.util.Date;

public class TCourse extends BaseTCourse{
    //授课老师
    String teacherName;
    //课程参加人数
    int joinedNum;
    //健身券数量
    int couponNum;
    //门店名称
    String storesName;
    //公司名称
    String companyName;
    //是否已加入该课程
    Boolean joined;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getJoined() {
        return joined;
    }

    public void setJoined(Boolean joined) {
        this.joined = joined;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public int getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(int couponNum) {
        this.couponNum = couponNum;
    }

    public int getJoinedNum() {
        return joinedNum;
    }

    public void setJoinedNum(int joinedNum) {
        this.joinedNum = joinedNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}