package com.skytech.api.model;

/**
 * Created by 1 on 2019/4/10.
 */
public class Mine {
    String accountSid;
    String accountName;
    String accountAvatar;
    String position;

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountAvatar() {
        return accountAvatar;
    }

    public void setAccountAvatar(String accountAvatar) {
        this.accountAvatar = accountAvatar;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
