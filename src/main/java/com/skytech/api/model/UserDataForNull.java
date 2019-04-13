package com.skytech.api.model;

import java.math.BigDecimal;

/**
 * Created by 1 on 2019/4/10.
 */
public class UserDataForNull{
    //数据id
    Integer userdataId;
    //数据序号
    Integer dataSortNum;
    //数据名称
    String dataName;
    //数据实际值
    BigDecimal dataActual;
    //数据目标值
    BigDecimal dataGoal;
    //数据单位
    String dataUnit;
    //是否达标1达标0未达标
    Integer upToStandard;

    public Integer getUserdataId() {
        return userdataId;
    }

    public void setUserdataId(Integer userdataId) {
        this.userdataId = userdataId;
    }

    public BigDecimal getDataActual() {
        return dataActual;
    }

    public void setDataActual(BigDecimal dataActual) {
        this.dataActual = dataActual;
    }

    public BigDecimal getDataGoal() {
        return dataGoal;
    }

    public void setDataGoal(BigDecimal dataGoal) {
        this.dataGoal = dataGoal;
    }

    public Integer getDataSortNum() {
        return dataSortNum;
    }

    public void setDataSortNum(Integer dataSortNum) {
        this.dataSortNum = dataSortNum;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }


    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public Integer getUpToStandard() {
        return upToStandard;
    }

    public void setUpToStandard(Integer upToStandard) {
        this.upToStandard = upToStandard;
    }


}
