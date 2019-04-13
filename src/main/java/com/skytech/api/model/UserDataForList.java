package com.skytech.api.model;

import java.util.List;

/**
 * Created by 1 on 2019/4/12.
 */
public class UserDataForList {
    List<UserData> userDataList;

    public UserDataForList(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }

    public UserDataForList() {
    }

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }
}
