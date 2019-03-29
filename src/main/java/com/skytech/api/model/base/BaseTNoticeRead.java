package com.skytech.api.model.base;

import com.skytech.api.model.TNoticeReadKey;

import java.util.Date;

public class BaseTNoticeRead extends TNoticeReadKey {
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}