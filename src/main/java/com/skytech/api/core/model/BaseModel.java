package com.skytech.api.core.model;

import java.io.Serializable;

/**
 *
 * @author 剑神卓凌昭
 * @date 2018/01/03 13:37
 */
public class BaseModel<PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected PK sid;

    public PK getSid() {
        return sid;
    }

    public void setSid(PK sid) {
        this.sid = sid;
    }

}
