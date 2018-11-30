package com.skytech.api.model;

import com.skytech.api.model.base.BaseEvent;

public class Event extends BaseEvent {

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