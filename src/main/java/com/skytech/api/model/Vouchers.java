package com.skytech.api.model;

/**
 * Created by 1 on 2019/4/9.
 */
public class Vouchers {

    //健身券名称
    String vouchersName;
    //健身券有效期
    String validityTime;
    //健身券适用健身会所
    String availableClub;

    public String getVouchersName() {
        return vouchersName;
    }

    public void setVouchersName(String vouchersName) {
        this.vouchersName = vouchersName;
    }

    public String getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(String validityTime) {
        this.validityTime = validityTime;
    }

    public String getAvailableClub() {
        return availableClub;
    }

    public void setAvailableClub(String availableClub) {
        this.availableClub = availableClub;
    }
}
