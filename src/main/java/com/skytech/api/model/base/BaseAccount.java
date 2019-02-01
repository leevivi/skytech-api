package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModel;

import java.util.Date;

/**
 * @author 剑神卓凌昭
 * @date 2018-12-01 23:22:09
 */
public class BaseAccount extends BaseModel<String> {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String avarta;

    private Byte gender;

    private Integer age;

    private Integer height;

    private Integer weight;

    private Integer stepTarget;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date registerDatetime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDatetime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lockintime;

    public BaseAccount() {
    }

    public BaseAccount(String sid, String firstName, String lastName, String email, String password, String avarta, Byte gender, Integer age, Integer height, Integer weight, Integer stepTarget, Date registerDatetime, Date updatedDatetime,Date lockintime) {
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.avarta = avarta;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.stepTarget = stepTarget;
        this.registerDatetime = registerDatetime;
        this.updatedDatetime = updatedDatetime;
        this.lockintime = lockintime;
    }

    /********** get/set ***********/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvarta() {
        return avarta;
    }

    public void setAvarta(String avarta) {
        this.avarta = avarta;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStepTarget() {
        return stepTarget;
    }

    public void setStepTarget(Integer stepTarget) {
        this.stepTarget = stepTarget;
    }

    public Date getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(Date registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public Date getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(Date updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    public Date getLockintime() {
        return lockintime;
    }

    public void setLockintime(Date lockintime) {
        this.lockintime = lockintime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", avarta=").append(avarta);
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", stepTarget=").append(stepTarget);
        sb.append(", registerDatetime=").append(registerDatetime);
        sb.append(", updatedDatetime=").append(updatedDatetime);
        sb.append(", lockintime=").append(lockintime);
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
        BaseAccount other = (BaseAccount) that;
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