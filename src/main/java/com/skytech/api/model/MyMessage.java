package com.skytech.api.model;

import java.util.Date;

/**
 * Created by LiWei on 2019/4/8.
 */
public class MyMessage {
    //消息标题
    String messageTitle;
    //消息时间
    Date messageTime;
    //消息内容
    String messageBody;
    //消息链接
    String messageUrl;

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyMessage myMessage = (MyMessage) o;

        if (messageTitle != null ? !messageTitle.equals(myMessage.messageTitle) : myMessage.messageTitle != null)
            return false;
        if (messageTime != null ? !messageTime.equals(myMessage.messageTime) : myMessage.messageTime != null)
            return false;
        if (messageBody != null ? !messageBody.equals(myMessage.messageBody) : myMessage.messageBody != null)
            return false;
        return messageUrl != null ? messageUrl.equals(myMessage.messageUrl) : myMessage.messageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = messageTitle != null ? messageTitle.hashCode() : 0;
        result = 31 * result + (messageTime != null ? messageTime.hashCode() : 0);
        result = 31 * result + (messageBody != null ? messageBody.hashCode() : 0);
        result = 31 * result + (messageUrl != null ? messageUrl.hashCode() : 0);
        return result;
    }
}
