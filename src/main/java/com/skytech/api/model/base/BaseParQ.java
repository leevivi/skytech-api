package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseParQ extends BaseModelOne<Integer>{

    private Integer heartCondition;

    private Integer angina;

    private Integer highBloodPressure;

    private Integer asthma;

    private Integer diabetes;

    private Integer backProblems;

    private Integer sciatica;

    private Integer jointProblems;

    private Integer smoker;

    private Integer pregnancy;

    private Integer hernia;

    private Integer recentSurgery;

    private Integer fatLoss;

    private Integer building;

    private Integer toning;

    private Integer other;

    private String specificFocusAreas;

    private Integer memberId;

    private String appuser;

    private String accountSid;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    public BaseParQ() {
    }

    public BaseParQ(Integer id,Integer heartCondition, Integer angina, Integer highBloodPressure, Integer asthma, Integer diabetes, Integer backProblems, Integer sciatica, Integer jointProblems, Integer smoker, Integer pregnancy, Integer hernia, Integer recentSurgery, Integer fatLoss, Integer building, Integer toning, Integer other, String specificFocusAreas, Integer memberId, String appuser, String accountSid, Date createdTime, Date updatedTime) {
        this.id = id;
        this.heartCondition = heartCondition;
        this.angina = angina;
        this.highBloodPressure = highBloodPressure;
        this.asthma = asthma;
        this.diabetes = diabetes;
        this.backProblems = backProblems;
        this.sciatica = sciatica;
        this.jointProblems = jointProblems;
        this.smoker = smoker;
        this.pregnancy = pregnancy;
        this.hernia = hernia;
        this.recentSurgery = recentSurgery;
        this.fatLoss = fatLoss;
        this.building = building;
        this.toning = toning;
        this.other = other;
        this.specificFocusAreas = specificFocusAreas;
        this.memberId = memberId;
        this.appuser = appuser;
        this.accountSid = accountSid;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public Integer getHeartCondition() {
        return heartCondition;
    }

    public void setHeartCondition(Integer heartCondition) {
        this.heartCondition = heartCondition;
    }

    public Integer getAngina() {
        return angina;
    }

    public void setAngina(Integer angina) {
        this.angina = angina;
    }

    public Integer getHighBloodPressure() {
        return highBloodPressure;
    }

    public void setHighBloodPressure(Integer highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public Integer getAsthma() {
        return asthma;
    }

    public void setAsthma(Integer asthma) {
        this.asthma = asthma;
    }

    public Integer getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Integer diabetes) {
        this.diabetes = diabetes;
    }

    public Integer getBackProblems() {
        return backProblems;
    }

    public void setBackProblems(Integer backProblems) {
        this.backProblems = backProblems;
    }

    public Integer getSciatica() {
        return sciatica;
    }

    public void setSciatica(Integer sciatica) {
        this.sciatica = sciatica;
    }

    public Integer getJointProblems() {
        return jointProblems;
    }

    public void setJointProblems(Integer jointProblems) {
        this.jointProblems = jointProblems;
    }

    public Integer getSmoker() {
        return smoker;
    }

    public void setSmoker(Integer smoker) {
        this.smoker = smoker;
    }

    public Integer getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(Integer pregnancy) {
        this.pregnancy = pregnancy;
    }

    public Integer getHernia() {
        return hernia;
    }

    public void setHernia(Integer hernia) {
        this.hernia = hernia;
    }

    public Integer getRecentSurgery() {
        return recentSurgery;
    }

    public void setRecentSurgery(Integer recentSurgery) {
        this.recentSurgery = recentSurgery;
    }

    public Integer getFatLoss() {
        return fatLoss;
    }

    public void setFatLoss(Integer fatLoss) {
        this.fatLoss = fatLoss;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Integer getToning() {
        return toning;
    }

    public void setToning(Integer toning) {
        this.toning = toning;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    public String getSpecificFocusAreas() {
        return specificFocusAreas;
    }

    public void setSpecificFocusAreas(String specificFocusAreas) {
        this.specificFocusAreas = specificFocusAreas == null ? null : specificFocusAreas.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid == null ? null : accountSid.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}