package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseUserDataExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseUserDataExample() {
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

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdIsNull() {
            addCriterion("userdata_id is null");
            return (Criteria) this;
        }

        public Criteria andUserdataIdIsNotNull() {
            addCriterion("userdata_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserdataIdEqualTo(Integer value) {
            addCriterion("userdata_id =", value, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdNotEqualTo(Integer value) {
            addCriterion("userdata_id <>", value, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdGreaterThan(Integer value) {
            addCriterion("userdata_id >", value, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userdata_id >=", value, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdLessThan(Integer value) {
            addCriterion("userdata_id <", value, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdLessThanOrEqualTo(Integer value) {
            addCriterion("userdata_id <=", value, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdIn(List<Integer> values) {
            addCriterion("userdata_id in", values, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdNotIn(List<Integer> values) {
            addCriterion("userdata_id not in", values, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdBetween(Integer value1, Integer value2) {
            addCriterion("userdata_id between", value1, value2, "userdataId");
            return (Criteria) this;
        }

        public Criteria andUserdataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userdata_id not between", value1, value2, "userdataId");
            return (Criteria) this;
        }

        public Criteria andDataActualIsNull() {
            addCriterion("data_actual is null");
            return (Criteria) this;
        }

        public Criteria andDataActualIsNotNull() {
            addCriterion("data_actual is not null");
            return (Criteria) this;
        }

        public Criteria andDataActualEqualTo(BigDecimal value) {
            addCriterion("data_actual =", value, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualNotEqualTo(BigDecimal value) {
            addCriterion("data_actual <>", value, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualGreaterThan(BigDecimal value) {
            addCriterion("data_actual >", value, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("data_actual >=", value, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualLessThan(BigDecimal value) {
            addCriterion("data_actual <", value, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualLessThanOrEqualTo(BigDecimal value) {
            addCriterion("data_actual <=", value, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualIn(List<BigDecimal> values) {
            addCriterion("data_actual in", values, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualNotIn(List<BigDecimal> values) {
            addCriterion("data_actual not in", values, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("data_actual between", value1, value2, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataActualNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("data_actual not between", value1, value2, "dataActual");
            return (Criteria) this;
        }

        public Criteria andDataGoalIsNull() {
            addCriterion("data_goal is null");
            return (Criteria) this;
        }

        public Criteria andDataGoalIsNotNull() {
            addCriterion("data_goal is not null");
            return (Criteria) this;
        }

        public Criteria andDataGoalEqualTo(BigDecimal value) {
            addCriterion("data_goal =", value, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalNotEqualTo(BigDecimal value) {
            addCriterion("data_goal <>", value, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalGreaterThan(BigDecimal value) {
            addCriterion("data_goal >", value, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("data_goal >=", value, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalLessThan(BigDecimal value) {
            addCriterion("data_goal <", value, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("data_goal <=", value, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalIn(List<BigDecimal> values) {
            addCriterion("data_goal in", values, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalNotIn(List<BigDecimal> values) {
            addCriterion("data_goal not in", values, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("data_goal between", value1, value2, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andDataGoalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("data_goal not between", value1, value2, "dataGoal");
            return (Criteria) this;
        }

        public Criteria andAppuserIsNull() {
            addCriterion("appUser is null");
            return (Criteria) this;
        }

        public Criteria andAppuserIsNotNull() {
            addCriterion("appUser is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserEqualTo(String value) {
            addCriterion("appUser =", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotEqualTo(String value) {
            addCriterion("appUser <>", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserGreaterThan(String value) {
            addCriterion("appUser >", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserGreaterThanOrEqualTo(String value) {
            addCriterion("appUser >=", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLessThan(String value) {
            addCriterion("appUser <", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLessThanOrEqualTo(String value) {
            addCriterion("appUser <=", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLike(String value) {
            addCriterion("appUser like", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotLike(String value) {
            addCriterion("appUser not like", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserIn(List<String> values) {
            addCriterion("appUser in", values, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotIn(List<String> values) {
            addCriterion("appUser not in", values, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserBetween(String value1, String value2) {
            addCriterion("appUser between", value1, value2, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotBetween(String value1, String value2) {
            addCriterion("appUser not between", value1, value2, "appuser");
            return (Criteria) this;
        }

        public Criteria andUpToStandardIsNull() {
            addCriterion("up_to_standard is null");
            return (Criteria) this;
        }

        public Criteria andUpToStandardIsNotNull() {
            addCriterion("up_to_standard is not null");
            return (Criteria) this;
        }

        public Criteria andUpToStandardEqualTo(Integer value) {
            addCriterion("up_to_standard =", value, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardNotEqualTo(Integer value) {
            addCriterion("up_to_standard <>", value, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardGreaterThan(Integer value) {
            addCriterion("up_to_standard >", value, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardGreaterThanOrEqualTo(Integer value) {
            addCriterion("up_to_standard >=", value, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardLessThan(Integer value) {
            addCriterion("up_to_standard <", value, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardLessThanOrEqualTo(Integer value) {
            addCriterion("up_to_standard <=", value, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardIn(List<Integer> values) {
            addCriterion("up_to_standard in", values, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardNotIn(List<Integer> values) {
            addCriterion("up_to_standard not in", values, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardBetween(Integer value1, Integer value2) {
            addCriterion("up_to_standard between", value1, value2, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andUpToStandardNotBetween(Integer value1, Integer value2) {
            addCriterion("up_to_standard not between", value1, value2, "upToStandard");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}