package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModel;
import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;
import java.util.Date;

/**
*
* @author 剑神卓凌昭
* @date   2019-01-06 20:38:17
*/
public class BaseRunningRecord extends BaseModel<String>{

    private String accountSid;

    private String accountName;

    private Integer steps;

    private Integer duration;

    private BigDecimal averageBpm;

    private BigDecimal maxBpm;

    private Integer cal;

    private Integer distance;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startDatetime;

   @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdDatetime;

    private String runningType;

    private String deviceSid;

    private Integer frequency;

    private String heartRate;

    public BaseRunningRecord() {}

    public BaseRunningRecord(String sid, String accountSid, String accountName, Integer steps, Integer duration, BigDecimal averageBpm, BigDecimal maxBpm, Integer cal, Integer distance, Date startDatetime, Date createdDatetime, String runningType, String deviceSid, Integer frequency,String heartRate) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.accountName = accountName;
        this.steps = steps;
        this.duration = duration;
        this.averageBpm = averageBpm;
        this.maxBpm = maxBpm;
        this.cal = cal;
        this.distance = distance;
        this.startDatetime = startDatetime;
        this.createdDatetime = createdDatetime;
        this.runningType = runningType;
        this.deviceSid = deviceSid;
        this.frequency = frequency;
        this.heartRate = heartRate;
    }

    /********** get/set ***********/
    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public BigDecimal getAverageBpm() {
        return averageBpm;
    }

    public void setAverageBpm(BigDecimal averageBpm) {
        this.averageBpm = averageBpm;
    }
    public BigDecimal getMaxBpm() {
        return maxBpm;
    }

    public void setMaxBpm(BigDecimal maxBpm) {
        this.maxBpm = maxBpm;
    }
    public Integer getCal() {
        return cal;
    }

    public void setCal(Integer cal) {
        this.cal = cal;
    }
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }
    public String getRunningType() {
        return runningType;
    }

    public void setRunningType(String runningType) {
        this.runningType = runningType;
    }
    public String getDeviceSid() {
        return deviceSid;
    }

    public void setDeviceSid(String deviceSid) {
        this.deviceSid = deviceSid;
    }
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", accountSid=").append(accountSid);
        sb.append(", accountName=").append(accountName);
        sb.append(", steps=").append(steps);
        sb.append(", duration=").append(duration);
        sb.append(", averageBpm=").append(averageBpm);
        sb.append(", maxBpm=").append(maxBpm);
        sb.append(", cal=").append(cal);
        sb.append(", distance=").append(distance);
        sb.append(", startDatetime=").append(startDatetime);
        sb.append(", createdDatetime=").append(createdDatetime);
        sb.append(", runningType=").append(runningType);
        sb.append(", deviceSid=").append(deviceSid);
        sb.append(", frequency=").append(frequency);
        sb.append(", heartRate=").append(heartRate);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BaseRunningRecord other = (BaseRunningRecord) that;
        return (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        return result;
    }
}