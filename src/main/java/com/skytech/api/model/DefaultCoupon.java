package com.skytech.api.model;

/**
 * Created by 1 on 2019/4/9.
 */
public class DefaultCoupon {
    //默认券数量
    Integer defaultCouponNum;
    //可用券数量
    Integer availableCoupon;

    public Integer getDefaultCouponNum() {
        return defaultCouponNum;
    }

    public void setDefaultCouponNum(Integer defaultCouponNum) {
        this.defaultCouponNum = defaultCouponNum;
    }

    public Integer getAvailableCoupon() {
        return availableCoupon;
    }

    public void setAvailableCoupon(Integer availableCoupon) {
        this.availableCoupon = availableCoupon;
    }
}
