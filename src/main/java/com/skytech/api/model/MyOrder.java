package com.skytech.api.model;


import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 2019/4/9.
 */
public class MyOrder {
    //订单号
    String orderNum;
    //下单日期
    Date orderDate;
    //门店名称
    String orderStoresName;
    //课程名称
    String orderCourseName;
    //课程图片
    String orderCourseUrl;
    //课程时间
    List<SelectCourseTime> orderCourseTime;
    //授课老师
    String orderCourserTeacher;
    //用券量
    String orderCourseCouponNum;
    //订单状态
    String orderStatus;
    Integer orderStatusForInt;
    //课程所有时段
    List<String> allCourseTime;

    public Integer getOrderStatusForInt() {
        return orderStatusForInt;
    }

    public void setOrderStatusForInt(Integer orderStatusForInt) {
        this.orderStatusForInt = orderStatusForInt;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getOrderCourseUrl() {
        return orderCourseUrl;
    }

    public void setOrderCourseUrl(String orderCourseUrl) {
        this.orderCourseUrl = orderCourseUrl;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStoresName() {
        return orderStoresName;
    }

    public void setOrderStoresName(String orderStoresName) {
        this.orderStoresName = orderStoresName;
    }

    public String getOrderCourseName() {
        return orderCourseName;
    }

    public void setOrderCourseName(String orderCourseName) {
        this.orderCourseName = orderCourseName;
    }

    public List<SelectCourseTime> getOrderCourseTime() {
        return orderCourseTime;
    }

    public void setOrderCourseTime(List<SelectCourseTime> orderCourseTime) {
        this.orderCourseTime = orderCourseTime;
    }

    public String getOrderCourserTeacher() {
        return orderCourserTeacher;
    }

    public void setOrderCourserTeacher(String orderCourserTeacher) {
        this.orderCourserTeacher = orderCourserTeacher;
    }

    public String getOrderCourseCouponNum() {
        return orderCourseCouponNum;
    }

    public void setOrderCourseCouponNum(String orderCourseCouponNum) {
        this.orderCourseCouponNum = orderCourseCouponNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<String> getAllCourseTime() {
        return allCourseTime;
    }

    public void setAllCourseTime(List<String> allCourseTime) {
        this.allCourseTime = allCourseTime;
    }
}

