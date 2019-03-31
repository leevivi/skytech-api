package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTEvent extends BaseModelOne<Integer>{

    private String eventName;

    private String eventInfo;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    private String eventPic;

    private String detailUrl;

    private String color;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    private String eventUpper;

    private String bak1;

    private String bak2;

    private String bak3;

    private String bak4;

    private String bak5;

    public BaseTEvent() {
    }

    public BaseTEvent(Integer id, String eventName, String eventInfo, Date startDate, Date endDate, String eventPic, String detailUrl, String color, Date createdTime, Date updatedTime, String eventUpper, String bak1, String bak2, String bak3, String bak4, String bak5) {
        this.id = id;
        this.eventName = eventName;
        this.eventInfo = eventInfo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventPic = eventPic;
        this.detailUrl = detailUrl;
        this.color = color;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.eventUpper = eventUpper;
        this.bak1 = bak1;
        this.bak2 = bak2;
        this.bak3 = bak3;
        this.bak4 = bak4;
        this.bak5 = bak5;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo == null ? null : eventInfo.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEventPic() {
        return eventPic;
    }

    public void setEventPic(String eventPic) {
        this.eventPic = eventPic == null ? null : eventPic.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getEventUpper() {
        return eventUpper;
    }

    public void setEventUpper(String eventUpper) {
        this.eventUpper = eventUpper == null ? null : eventUpper.trim();
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
    }

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4 == null ? null : bak4.trim();
    }

    public String getBak5() {
        return bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5 == null ? null : bak5.trim();
    }
}