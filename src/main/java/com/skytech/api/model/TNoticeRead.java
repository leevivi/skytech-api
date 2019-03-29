package com.skytech.api.model;

import java.util.Date;

public class TNoticeRead extends TNoticeReadKey {
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}