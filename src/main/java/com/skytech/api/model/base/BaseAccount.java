package com.skytech.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.skytech.api.core.model.BaseModel;

import java.util.Date;

public class BaseAccount extends BaseModel<String>{

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String avarta;

    private Byte gender;

    private Integer age;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private Integer height;

    private Integer weight;

    private Double whr;

    private Integer stepTarget;

    private Integer sleepTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date registerDatetime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatedDatetime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lockintime;

    public BaseAccount() {
    }

    public BaseAccount(String sid, String firstName, String lastName, String email, String password, String avarta, Byte gender, Integer age, Date birthday, Integer height, Integer weight, Double whr, Integer stepTarget, Integer sleepTime, Date registerDatetime, Date updatedDatetime, Date lockintime) {
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.avarta = avarta;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.whr = whr;
        this.stepTarget = stepTarget;
        this.sleepTime = sleepTime;
        this.registerDatetime = registerDatetime;
        this.updatedDatetime = updatedDatetime;
        this.lockintime = lockintime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvarta() {
        return avarta;
    }

    public void setAvarta(String avarta) {
        this.avarta = avarta == null ? null : avarta.trim();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Double getWhr() {
        return whr;
    }

    public void setWhr(Double whr) {
        this.whr = whr;
    }

    public Integer getStepTarget() {
        return stepTarget;
    }

    public void setStepTarget(Integer stepTarget) {
        this.stepTarget = stepTarget;
    }

    public Integer getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        this.sleepTime = sleepTime;
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
}