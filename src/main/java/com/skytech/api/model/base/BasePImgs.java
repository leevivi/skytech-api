package com.skytech.api.model.base;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModelOne;

public class BasePImgs extends BaseModelOne<Integer>{
    private String img;

    private String url;

    private Integer type;

    private Integer status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}