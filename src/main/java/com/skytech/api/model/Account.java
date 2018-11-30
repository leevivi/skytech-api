package com.skytech.api.model;

import com.skytech.api.model.base.BaseAccount;

public class Account extends BaseAccount {

    private int steps;

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}