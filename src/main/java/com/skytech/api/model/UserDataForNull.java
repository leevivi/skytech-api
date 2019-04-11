package com.skytech.api.model;

import java.math.BigDecimal;

/**
 * Created by 1 on 2019/4/10.
 */
public class UserDataForNull {
    //数据id
    Integer dataId;
    //数据序号
    Integer dataSortNum;
    //数据名称
    String dataName;
    //数据实际值
    BigDecimal dataActualValue;
    //数据目标值
    BigDecimal dataGoalValue;
    //数据单位
    String dataUnit;
    //是否达标
    Boolean upToStandard;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
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

    public BigDecimal getDataActualValue() {
        return dataActualValue;
    }

    public void setDataActualValue(BigDecimal dataActualValue) {
        this.dataActualValue = dataActualValue;
    }

    public BigDecimal getDataGoalValue() {
        return dataGoalValue;
    }

    public void setDataGoalValue(BigDecimal dataGoalValue) {
        this.dataGoalValue = dataGoalValue;
    }

    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit;
    }

    public Boolean getUpToStandard() {
        return upToStandard;
    }

    public void setUpToStandard(Boolean upToStandard) {
        this.upToStandard = upToStandard;
    }
}
