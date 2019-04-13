package com.skytech.api.model;

import java.math.BigDecimal;

/**
 * Created by 1 on 2019/4/12.
 */
public class UserDataForBase {
    Integer dataId;
    BigDecimal dataActualValue;
    BigDecimal dataGoalValue;


    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
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

}
