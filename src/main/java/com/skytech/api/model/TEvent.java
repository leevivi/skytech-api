package com.skytech.api.model;

import com.skytech.api.model.base.BaseTEvent;

import java.util.Date;

public class TEvent extends BaseTEvent{
    private int memberNums;

    private int days;

    public int getMemberNums() {
        return memberNums;
    }

    public void setMemberNums(int memberNums) {
        this.memberNums = memberNums;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}