package com.skytech.api.model;

import com.skytech.api.model.base.BaseTEvent;

import java.util.Date;

public class TEvent extends BaseTEvent{
    int memberNums;
    //公司名称
    String comanyName;
    //门店名称
    String storesName;
    //是否已经加入活动
    Boolean joined;

    public int getMemberNums() {
        return memberNums;
    }

    public void setMemberNums(int memberNums) {
        this.memberNums = memberNums;
    }

    public String getComanyName() {
        return comanyName;
    }

    public void setComanyName(String comanyName) {
        this.comanyName = comanyName;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public Boolean getJoined() {
        return joined;
    }

    public void setJoined(Boolean joined) {
        this.joined = joined;
    }
}