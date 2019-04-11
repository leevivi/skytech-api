package com.skytech.api.model;

import java.util.List;

/**
 * Created by LiWei on 2019/4/5.
 */
public class MyVouchers {
    //健身券id
    Integer clubId;
    //健身会所名称
    String clubName;
    //健身券
    List<Vouchers> vouchersList;

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public List<Vouchers> getVouchersList() {
        return vouchersList;
    }

    public void setVouchersList(List<Vouchers> vouchersList) {
        this.vouchersList = vouchersList;
    }
}
