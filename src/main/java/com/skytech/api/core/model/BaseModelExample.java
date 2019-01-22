package com.skytech.api.core.model;


import com.skytech.api.core.Pagination;

/**
 * @author 剑神卓凌昭
 * @date 2018/01/03 13:37
 */
public class BaseModelExample {
    protected Pagination<?> pagination;

    protected String orderByClause;

    protected boolean distinct;

    public void setPagination(Pagination<?> pagination) {
        this.pagination = pagination;
    }

    public Pagination<?> getPagination() {
        return pagination;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void clear() {
        orderByClause = null;
        distinct = false;
    }

}
