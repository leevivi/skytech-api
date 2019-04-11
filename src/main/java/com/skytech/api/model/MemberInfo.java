package com.skytech.api.model;

/**
 * Created by LiWei on 2019/4/6.
 */
public class MemberInfo {
    //会员id
    Integer memberId;
    //会员所属健身公司id
    Integer companyId;
    //会员所属健身门店id
    Integer storesId;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }
}
