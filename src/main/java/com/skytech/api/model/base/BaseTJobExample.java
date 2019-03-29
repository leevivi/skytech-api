package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseTJobExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseTJobExample() {
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

        public Criteria andJobnameIsNull() {
            addCriterion("jobName is null");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNotNull() {
            addCriterion("jobName is not null");
            return (Criteria) this;
        }

        public Criteria andJobnameEqualTo(String value) {
            addCriterion("jobName =", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotEqualTo(String value) {
            addCriterion("jobName <>", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThan(String value) {
            addCriterion("jobName >", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThanOrEqualTo(String value) {
            addCriterion("jobName >=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThan(String value) {
            addCriterion("jobName <", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThanOrEqualTo(String value) {
            addCriterion("jobName <=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLike(String value) {
            addCriterion("jobName like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotLike(String value) {
            addCriterion("jobName not like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameIn(List<String> values) {
            addCriterion("jobName in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotIn(List<String> values) {
            addCriterion("jobName not in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameBetween(String value1, String value2) {
            addCriterion("jobName between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotBetween(String value1, String value2) {
            addCriterion("jobName not between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCronIsNull() {
            addCriterion("cron is null");
            return (Criteria) this;
        }

        public Criteria andCronIsNotNull() {
            addCriterion("cron is not null");
            return (Criteria) this;
        }

        public Criteria andCronEqualTo(String value) {
            addCriterion("cron =", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotEqualTo(String value) {
            addCriterion("cron <>", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThan(String value) {
            addCriterion("cron >", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThanOrEqualTo(String value) {
            addCriterion("cron >=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThan(String value) {
            addCriterion("cron <", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThanOrEqualTo(String value) {
            addCriterion("cron <=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLike(String value) {
            addCriterion("cron like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotLike(String value) {
            addCriterion("cron not like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronIn(List<String> values) {
            addCriterion("cron in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotIn(List<String> values) {
            addCriterion("cron not in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronBetween(String value1, String value2) {
            addCriterion("cron between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotBetween(String value1, String value2) {
            addCriterion("cron not between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameIsNull() {
            addCriterion("springBeanName is null");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameIsNotNull() {
            addCriterion("springBeanName is not null");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameEqualTo(String value) {
            addCriterion("springBeanName =", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameNotEqualTo(String value) {
            addCriterion("springBeanName <>", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameGreaterThan(String value) {
            addCriterion("springBeanName >", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameGreaterThanOrEqualTo(String value) {
            addCriterion("springBeanName >=", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameLessThan(String value) {
            addCriterion("springBeanName <", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameLessThanOrEqualTo(String value) {
            addCriterion("springBeanName <=", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameLike(String value) {
            addCriterion("springBeanName like", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameNotLike(String value) {
            addCriterion("springBeanName not like", value, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameIn(List<String> values) {
            addCriterion("springBeanName in", values, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameNotIn(List<String> values) {
            addCriterion("springBeanName not in", values, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameBetween(String value1, String value2) {
            addCriterion("springBeanName between", value1, value2, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andSpringbeannameNotBetween(String value1, String value2) {
            addCriterion("springBeanName not between", value1, value2, "springbeanname");
            return (Criteria) this;
        }

        public Criteria andMethodnameIsNull() {
            addCriterion("methodName is null");
            return (Criteria) this;
        }

        public Criteria andMethodnameIsNotNull() {
            addCriterion("methodName is not null");
            return (Criteria) this;
        }

        public Criteria andMethodnameEqualTo(String value) {
            addCriterion("methodName =", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotEqualTo(String value) {
            addCriterion("methodName <>", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameGreaterThan(String value) {
            addCriterion("methodName >", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameGreaterThanOrEqualTo(String value) {
            addCriterion("methodName >=", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLessThan(String value) {
            addCriterion("methodName <", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLessThanOrEqualTo(String value) {
            addCriterion("methodName <=", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameLike(String value) {
            addCriterion("methodName like", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotLike(String value) {
            addCriterion("methodName not like", value, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameIn(List<String> values) {
            addCriterion("methodName in", values, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotIn(List<String> values) {
            addCriterion("methodName not in", values, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameBetween(String value1, String value2) {
            addCriterion("methodName between", value1, value2, "methodname");
            return (Criteria) this;
        }

        public Criteria andMethodnameNotBetween(String value1, String value2) {
            addCriterion("methodName not between", value1, value2, "methodname");
            return (Criteria) this;
        }

        public Criteria andIssysjobIsNull() {
            addCriterion("isSysJob is null");
            return (Criteria) this;
        }

        public Criteria andIssysjobIsNotNull() {
            addCriterion("isSysJob is not null");
            return (Criteria) this;
        }

        public Criteria andIssysjobEqualTo(Boolean value) {
            addCriterion("isSysJob =", value, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobNotEqualTo(Boolean value) {
            addCriterion("isSysJob <>", value, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobGreaterThan(Boolean value) {
            addCriterion("isSysJob >", value, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isSysJob >=", value, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobLessThan(Boolean value) {
            addCriterion("isSysJob <", value, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobLessThanOrEqualTo(Boolean value) {
            addCriterion("isSysJob <=", value, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobIn(List<Boolean> values) {
            addCriterion("isSysJob in", values, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobNotIn(List<Boolean> values) {
            addCriterion("isSysJob not in", values, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobBetween(Boolean value1, Boolean value2) {
            addCriterion("isSysJob between", value1, value2, "issysjob");
            return (Criteria) this;
        }

        public Criteria andIssysjobNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isSysJob not between", value1, value2, "issysjob");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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