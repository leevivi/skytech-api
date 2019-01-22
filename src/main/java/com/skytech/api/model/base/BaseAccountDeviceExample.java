package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseCriteria;
import com.skytech.api.core.model.BaseModelExample;
import java.math.*;
import java.util.*;

public class BaseAccountDeviceExample extends BaseModelExample {

protected List<Criteria> oredCriteria;

    public BaseAccountDeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Override
    public void clear() {
        super.clear();
        oredCriteria.clear();
    }

    protected abstract static class GeneratedCriteria extends BaseCriteria {
        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }


        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andAccountSidIsNull() {
            addCriterion("account_sid is null");
            return (Criteria) this;
        }

        public Criteria andAccountSidIsNotNull() {
            addCriterion("account_sid is not null");
            return (Criteria) this;
        }

        public Criteria andAccountSidEqualTo(String value) {
            addCriterion("account_sid =", value, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidNotEqualTo(String value) {
            addCriterion("account_sid <>", value, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidGreaterThan(String value) {
            addCriterion("account_sid >", value, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidGreaterThanOrEqualTo(String value) {
            addCriterion("account_sid >=", value, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidLessThan(String value) {
            addCriterion("account_sid <", value, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidLessThanOrEqualTo(String value) {
            addCriterion("account_sid <=", value, "accountSid");
            return (Criteria) this;
        }


        public Criteria andAccountSidLike(String value) {
            addCriterion("account_sid like", value, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidNotLike(String value) {
            addCriterion("account_sid not like", value, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidIn(List<String> values) {
            addCriterion("account_sid in", values, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidNotIn(List<String> values) {
            addCriterion("account_sid not in", values, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidBetween(String value1, String value2) {
            addCriterion("account_sid between", value1, value2, "accountSid");
            return (Criteria) this;
        }

        public Criteria andAccountSidNotBetween(String value1, String value2) {
            addCriterion("account_sid not between", value1, value2, "accountSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidIsNull() {
            addCriterion("device_sid is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSidIsNotNull() {
            addCriterion("device_sid is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSidEqualTo(String value) {
            addCriterion("device_sid =", value, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidNotEqualTo(String value) {
            addCriterion("device_sid <>", value, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidGreaterThan(String value) {
            addCriterion("device_sid >", value, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidGreaterThanOrEqualTo(String value) {
            addCriterion("device_sid >=", value, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidLessThan(String value) {
            addCriterion("device_sid <", value, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidLessThanOrEqualTo(String value) {
            addCriterion("device_sid <=", value, "deviceSid");
            return (Criteria) this;
        }


        public Criteria andDeviceSidLike(String value) {
            addCriterion("device_sid like", value, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidNotLike(String value) {
            addCriterion("device_sid not like", value, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidIn(List<String> values) {
            addCriterion("device_sid in", values, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidNotIn(List<String> values) {
            addCriterion("device_sid not in", values, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidBetween(String value1, String value2) {
            addCriterion("device_sid between", value1, value2, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andDeviceSidNotBetween(String value1, String value2) {
            addCriterion("device_sid not between", value1, value2, "deviceSid");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIsNull() {
            addCriterion("created_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIsNotNull() {
            addCriterion("created_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeEqualTo(Date value) {
            addCriterion("created_datetime =", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotEqualTo(Date value) {
            addCriterion("created_datetime <>", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeGreaterThan(Date value) {
            addCriterion("created_datetime >", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_datetime >=", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeLessThan(Date value) {
            addCriterion("created_datetime <", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("created_datetime <=", value, "createdDatetime");
            return (Criteria) this;
        }


        public Criteria andCreatedDatetimeIn(List<Date> values) {
            addCriterion("created_datetime in", values, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotIn(List<Date> values) {
            addCriterion("created_datetime not in", values, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeBetween(Date value1, Date value2) {
            addCriterion("created_datetime between", value1, value2, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("created_datetime not between", value1, value2, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(Byte value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(Byte value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(Byte value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(Byte value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }


        public Criteria andDeviceStatusIn(List<Byte> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<Byte> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(Byte value1, Byte value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}