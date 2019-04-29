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

    @Override
    public String toString() {
        return "MemberInfo{" +
                "memberId=" + memberId +
                ", companyId=" + companyId +
                ", storesId=" + storesId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberInfo that = (MemberInfo) o;

        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (companyId != null ? !companyId.equals(that.companyId) : that.companyId != null) return false;
        return storesId != null ? storesId.equals(that.storesId) : that.storesId == null;
    }

    @Override
    public int hashCode() {
        int result = memberId != null ? memberId.hashCode() : 0;
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (storesId != null ? storesId.hashCode() : 0);
        return result;
    }
}
