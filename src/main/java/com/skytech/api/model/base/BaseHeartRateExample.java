package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseCriteria;
import com.skytech.api.core.model.BaseModelExample;
import java.math.*;
import java.util.*;

public class BaseHeartRateExample extends BaseModelExample {

protected List<Criteria> oredCriteria;

    public BaseHeartRateExample() {
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

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }


        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("data is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("data is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("data =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("data <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("data >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("data >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("data <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("data <=", value, "data");
            return (Criteria) this;
        }


        public Criteria andDataLike(String value) {
            addCriterion("data like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("data not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("data in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("data not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("data between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("data not between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeIsNull() {
            addCriterion("start_datetime is null");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeIsNotNull() {
            addCriterion("start_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeEqualTo(Date value) {
            addCriterion("start_datetime =", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeNotEqualTo(Date value) {
            addCriterion("start_datetime <>", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeGreaterThan(Date value) {
            addCriterion("start_datetime >", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_datetime >=", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeLessThan(Date value) {
            addCriterion("start_datetime <", value, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("start_datetime <=", value, "startDatetime");
            return (Criteria) this;
        }


        public Criteria andStartDatetimeIn(List<Date> values) {
            addCriterion("start_datetime in", values, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeNotIn(List<Date> values) {
            addCriterion("start_datetime not in", values, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeBetween(Date value1, Date value2) {
            addCriterion("start_datetime between", value1, value2, "startDatetime");
            return (Criteria) this;
        }

        public Criteria andStartDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("start_datetime not between", value1, value2, "startDatetime");
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

        public Criteria andEndDatetimeIsNull() {
            addCriterion("end_datetime is null");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeIsNotNull() {
            addCriterion("end_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeEqualTo(Date value) {
            addCriterion("end_datetime =", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotEqualTo(Date value) {
            addCriterion("end_datetime <>", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeGreaterThan(Date value) {
            addCriterion("end_datetime >", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_datetime >=", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeLessThan(Date value) {
            addCriterion("end_datetime <", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("end_datetime <=", value, "endDatetime");
            return (Criteria) this;
        }


        public Criteria andEndDatetimeIn(List<Date> values) {
            addCriterion("end_datetime in", values, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotIn(List<Date> values) {
            addCriterion("end_datetime not in", values, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeBetween(Date value1, Date value2) {
            addCriterion("end_datetime between", value1, value2, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("end_datetime not between", value1, value2, "endDatetime");
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

        public Criteria andRecordDateIsNull() {
            addCriterion("record_date is null");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNotNull() {
            addCriterion("record_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDateEqualTo(Date value) {
            addCriterion("record_date =", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotEqualTo(Date value) {
            addCriterion("record_date <>", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThan(Date value) {
            addCriterion("record_date >", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanOrEqualTo(Date value) {
            addCriterion("record_date >=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThan(Date value) {
            addCriterion("record_date <", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanOrEqualTo(Date value) {
            addCriterion("record_date <=", value, "recordDate");
            return (Criteria) this;
        }


        public Criteria andRecordDateIn(List<Date> values) {
            addCriterion("record_date in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotIn(List<Date> values) {
            addCriterion("record_date not in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateBetween(Date value1, Date value2) {
            addCriterion("record_date between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotBetween(Date value1, Date value2) {
            addCriterion("record_date not between", value1, value2, "recordDate");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}