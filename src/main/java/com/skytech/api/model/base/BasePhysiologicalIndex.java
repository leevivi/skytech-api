package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BasePhysiologicalIndex extends BaseModelOne<Integer>{

    private String dataName;

    private String tagName;

    private Integer sortNum;

    private String dataUnit;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    public BasePhysiologicalIndex() {
    }

    public BasePhysiologicalIndex(Integer id, String dataName, String tagName, Integer sortNum, String dataUnit, Date createdTime) {
        this.id = id;
        this.dataName = dataName;
        this.tagName = tagName;
        this.sortNum = sortNum;
        this.dataUnit = dataUnit;
        this.createdTime = createdTime;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getDataUnit() {
        return dataUnit;
    }

    public void setDataUnit(String dataUnit) {
        this.dataUnit = dataUnit == null ? null : dataUnit.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}