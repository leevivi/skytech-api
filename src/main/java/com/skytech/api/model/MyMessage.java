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
}
