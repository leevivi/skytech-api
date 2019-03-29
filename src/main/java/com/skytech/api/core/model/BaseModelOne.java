package com.skytech.api.core.model;

import java.io.Serializable;

/**
 * Created by LiWei on 2019/3/29.
 */
public class BaseModelOne <PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

}