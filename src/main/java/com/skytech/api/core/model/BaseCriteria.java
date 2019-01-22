package com.skytech.api.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 剑神卓凌昭
 * @date 2018/01/03 13:37
 */
public abstract class BaseCriteria {
    protected List<com.skytech.api.core.model.Criterion> criteria;

    protected BaseCriteria() {
        super();
        criteria = new ArrayList<com.skytech.api.core.model.Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<com.skytech.api.core.model.Criterion> getAllCriteria() {
        return criteria;
    }

    public List<com.skytech.api.core.model.Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new com.skytech.api.core.model.Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property
                    + " cannot be null");
        }
        criteria.add(new com.skytech.api.core.model.Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2,
                                String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property
                    + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }
}