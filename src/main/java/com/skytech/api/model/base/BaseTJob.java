package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

import java.util.Date;

public class BaseTJob extends BaseModelOne<Integer>{

    private String jobname;

    private String description;

    private String cron;

    private String springbeanname;

    private String methodname;

    private Boolean issysjob;

    private Boolean status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    public BaseTJob() {
    }

    public BaseTJob(Integer id, String jobname, String description, String cron, String springbeanname, String methodname, Boolean issysjob, Boolean status, Date createtime, Date updatetime) {
        this.id = id;
        this.jobname = jobname;
        this.description = description;
        this.cron = cron;
        this.springbeanname = springbeanname;
        this.methodname = methodname;
        this.issysjob = issysjob;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public String getSpringbeanname() {
        return springbeanname;
    }

    public void setSpringbeanname(String springbeanname) {
        this.springbeanname = springbeanname == null ? null : springbeanname.trim();
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname == null ? null : methodname.trim();
    }

    public Boolean getIssysjob() {
        return issysjob;
    }

    public void setIssysjob(Boolean issysjob) {
        this.issysjob = issysjob;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}