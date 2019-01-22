package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseCriteria;
import com.skytech.api.core.model.BaseModelExample;
import java.math.*;
import java.util.*;

public class BaseRunningRecordExample extends BaseModelExample {

protected List<Criteria> oredCriteria;

    public BaseRunningRecordExample() {
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

        public Criteria andStepsIsNull() {
            addCriterion("steps is null");
            return (Criteria) this;
        }

        public Criteria andStepsIsNotNull() {
            addCriterion("steps is not null");
            return (Criteria) this;
        }

        public Criteria andStepsEqualTo(Integer value) {
            addCriterion("steps =", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotEqualTo(Integer value) {
            addCriterion("steps <>", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsGreaterThan(Integer value) {
            addCriterion("steps >", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsGreaterThanOrEqualTo(Integer value) {
            addCriterion("steps >=", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsLessThan(Integer value) {
            addCriterion("steps <", value, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsLessThanOrEqualTo(Integer value) {
            addCriterion("steps <=", value, "steps");
            return (Criteria) this;
        }


        public Criteria andStepsIn(List<Integer> values) {
            addCriterion("steps in", values, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotIn(List<Integer> values) {
            addCriterion("steps not in", values, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsBetween(Integer value1, Integer value2) {
            addCriterion("steps between", value1, value2, "steps");
            return (Criteria) this;
        }

        public Criteria andStepsNotBetween(Integer value1, Integer value2) {
            addCriterion("steps not between", value1, value2, "steps");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }


        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andAverageBpmIsNull() {
            addCriterion("average_bpm is null");
            return (Criteria) this;
        }

        public Criteria andAverageBpmIsNotNull() {
            addCriterion("average_bpm is not null");
            return (Criteria) this;
        }

        public Criteria andAverageBpmEqualTo(BigDecimal value) {
            addCriterion("average_bpm =", value, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmNotEqualTo(BigDecimal value) {
            addCriterion("average_bpm <>", value, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmGreaterThan(BigDecimal value) {
            addCriterion("average_bpm >", value, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("average_bpm >=", value, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmLessThan(BigDecimal value) {
            addCriterion("average_bpm <", value, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("average_bpm <=", value, "averageBpm");
            return (Criteria) this;
        }


        public Criteria andAverageBpmIn(List<BigDecimal> values) {
            addCriterion("average_bpm in", values, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmNotIn(List<BigDecimal> values) {
            addCriterion("average_bpm not in", values, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_bpm between", value1, value2, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andAverageBpmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_bpm not between", value1, value2, "averageBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmIsNull() {
            addCriterion("max_bpm is null");
            return (Criteria) this;
        }

        public Criteria andMaxBpmIsNotNull() {
            addCriterion("max_bpm is not null");
            return (Criteria) this;
        }

        public Criteria andMaxBpmEqualTo(BigDecimal value) {
            addCriterion("max_bpm =", value, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmNotEqualTo(BigDecimal value) {
            addCriterion("max_bpm <>", value, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmGreaterThan(BigDecimal value) {
            addCriterion("max_bpm >", value, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_bpm >=", value, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmLessThan(BigDecimal value) {
            addCriterion("max_bpm <", value, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_bpm <=", value, "maxBpm");
            return (Criteria) this;
        }


        public Criteria andMaxBpmIn(List<BigDecimal> values) {
            addCriterion("max_bpm in", values, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmNotIn(List<BigDecimal> values) {
            addCriterion("max_bpm not in", values, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_bpm between", value1, value2, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andMaxBpmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_bpm not between", value1, value2, "maxBpm");
            return (Criteria) this;
        }

        public Criteria andCalIsNull() {
            addCriterion("cal is null");
            return (Criteria) this;
        }

        public Criteria andCalIsNotNull() {
            addCriterion("cal is not null");
            return (Criteria) this;
        }

        public Criteria andCalEqualTo(Integer value) {
            addCriterion("cal =", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalNotEqualTo(Integer value) {
            addCriterion("cal <>", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalGreaterThan(Integer value) {
            addCriterion("cal >", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalGreaterThanOrEqualTo(Integer value) {
            addCriterion("cal >=", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalLessThan(Integer value) {
            addCriterion("cal <", value, "cal");
            return (Criteria) this;
        }

        public Criteria andCalLessThanOrEqualTo(Integer value) {
            addCriterion("cal <=", value, "cal");
            return (Criteria) this;
        }


        public Criteria andCalIn(List<Integer> values) {
            addCriterion("cal in", values, "cal");
            return (Criteria) this;
        }

        public Criteria andCalNotIn(List<Integer> values) {
            addCriterion("cal not in", values, "cal");
            return (Criteria) this;
        }

        public Criteria andCalBetween(Integer value1, Integer value2) {
            addCriterion("cal between", value1, value2, "cal");
            return (Criteria) this;
        }

        public Criteria andCalNotBetween(Integer value1, Integer value2) {
            addCriterion("cal not between", value1, value2, "cal");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }


        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
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

        public Criteria andRunningTypeIsNull() {
            addCriterion("running_type is null");
            return (Criteria) this;
        }

        public Criteria andRunningTypeIsNotNull() {
            addCriterion("running_type is not null");
            return (Criteria) this;
        }

        public Criteria andRunningTypeEqualTo(String value) {
            addCriterion("running_type =", value, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeNotEqualTo(String value) {
            addCriterion("running_type <>", value, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeGreaterThan(String value) {
            addCriterion("running_type >", value, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeGreaterThanOrEqualTo(String value) {
            addCriterion("running_type >=", value, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeLessThan(String value) {
            addCriterion("running_type <", value, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeLessThanOrEqualTo(String value) {
            addCriterion("running_type <=", value, "runningType");
            return (Criteria) this;
        }


        public Criteria andRunningTypeLike(String value) {
            addCriterion("running_type like", value, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeNotLike(String value) {
            addCriterion("running_type not like", value, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeIn(List<String> values) {
            addCriterion("running_type in", values, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeNotIn(List<String> values) {
            addCriterion("running_type not in", values, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeBetween(String value1, String value2) {
            addCriterion("running_type between", value1, value2, "runningType");
            return (Criteria) this;
        }

        public Criteria andRunningTypeNotBetween(String value1, String value2) {
            addCriterion("running_type not between", value1, value2, "runningType");
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

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }


        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}