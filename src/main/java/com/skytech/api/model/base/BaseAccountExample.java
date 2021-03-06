package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BaseAccountExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseAccountExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

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

        public Criteria andFirstNameIsNull() {
            addCriterion("first_name is null");
            return (Criteria) this;
        }

        public Criteria andFirstNameIsNotNull() {
            addCriterion("first_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirstNameEqualTo(String value) {
            addCriterion("first_name =", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotEqualTo(String value) {
            addCriterion("first_name <>", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameGreaterThan(String value) {
            addCriterion("first_name >", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameGreaterThanOrEqualTo(String value) {
            addCriterion("first_name >=", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLessThan(String value) {
            addCriterion("first_name <", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLessThanOrEqualTo(String value) {
            addCriterion("first_name <=", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLike(String value) {
            addCriterion("first_name like", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotLike(String value) {
            addCriterion("first_name not like", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameIn(List<String> values) {
            addCriterion("first_name in", values, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotIn(List<String> values) {
            addCriterion("first_name not in", values, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameBetween(String value1, String value2) {
            addCriterion("first_name between", value1, value2, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotBetween(String value1, String value2) {
            addCriterion("first_name not between", value1, value2, "firstName");
            return (Criteria) this;
        }

        public Criteria andLastNameIsNull() {
            addCriterion("last_name is null");
            return (Criteria) this;
        }

        public Criteria andLastNameIsNotNull() {
            addCriterion("last_name is not null");
            return (Criteria) this;
        }

        public Criteria andLastNameEqualTo(String value) {
            addCriterion("last_name =", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotEqualTo(String value) {
            addCriterion("last_name <>", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameGreaterThan(String value) {
            addCriterion("last_name >", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameGreaterThanOrEqualTo(String value) {
            addCriterion("last_name >=", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLessThan(String value) {
            addCriterion("last_name <", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLessThanOrEqualTo(String value) {
            addCriterion("last_name <=", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLike(String value) {
            addCriterion("last_name like", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotLike(String value) {
            addCriterion("last_name not like", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameIn(List<String> values) {
            addCriterion("last_name in", values, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotIn(List<String> values) {
            addCriterion("last_name not in", values, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameBetween(String value1, String value2) {
            addCriterion("last_name between", value1, value2, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotBetween(String value1, String value2) {
            addCriterion("last_name not between", value1, value2, "lastName");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAvartaIsNull() {
            addCriterion("avarta is null");
            return (Criteria) this;
        }

        public Criteria andAvartaIsNotNull() {
            addCriterion("avarta is not null");
            return (Criteria) this;
        }

        public Criteria andAvartaEqualTo(String value) {
            addCriterion("avarta =", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaNotEqualTo(String value) {
            addCriterion("avarta <>", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaGreaterThan(String value) {
            addCriterion("avarta >", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaGreaterThanOrEqualTo(String value) {
            addCriterion("avarta >=", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaLessThan(String value) {
            addCriterion("avarta <", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaLessThanOrEqualTo(String value) {
            addCriterion("avarta <=", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaLike(String value) {
            addCriterion("avarta like", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaNotLike(String value) {
            addCriterion("avarta not like", value, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaIn(List<String> values) {
            addCriterion("avarta in", values, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaNotIn(List<String> values) {
            addCriterion("avarta not in", values, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaBetween(String value1, String value2) {
            addCriterion("avarta between", value1, value2, "avarta");
            return (Criteria) this;
        }

        public Criteria andAvartaNotBetween(String value1, String value2) {
            addCriterion("avarta not between", value1, value2, "avarta");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Byte value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Byte value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Byte value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Byte value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Byte value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Byte> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Byte> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Byte value1, Byte value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWhrIsNull() {
            addCriterion("WHR is null");
            return (Criteria) this;
        }

        public Criteria andWhrIsNotNull() {
            addCriterion("WHR is not null");
            return (Criteria) this;
        }

        public Criteria andWhrEqualTo(Double value) {
            addCriterion("WHR =", value, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrNotEqualTo(Double value) {
            addCriterion("WHR <>", value, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrGreaterThan(Double value) {
            addCriterion("WHR >", value, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrGreaterThanOrEqualTo(Double value) {
            addCriterion("WHR >=", value, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrLessThan(Double value) {
            addCriterion("WHR <", value, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrLessThanOrEqualTo(Double value) {
            addCriterion("WHR <=", value, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrIn(List<Double> values) {
            addCriterion("WHR in", values, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrNotIn(List<Double> values) {
            addCriterion("WHR not in", values, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrBetween(Double value1, Double value2) {
            addCriterion("WHR between", value1, value2, "whr");
            return (Criteria) this;
        }

        public Criteria andWhrNotBetween(Double value1, Double value2) {
            addCriterion("WHR not between", value1, value2, "whr");
            return (Criteria) this;
        }

        public Criteria andStepTargetIsNull() {
            addCriterion("step_target is null");
            return (Criteria) this;
        }

        public Criteria andStepTargetIsNotNull() {
            addCriterion("step_target is not null");
            return (Criteria) this;
        }

        public Criteria andStepTargetEqualTo(Integer value) {
            addCriterion("step_target =", value, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetNotEqualTo(Integer value) {
            addCriterion("step_target <>", value, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetGreaterThan(Integer value) {
            addCriterion("step_target >", value, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_target >=", value, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetLessThan(Integer value) {
            addCriterion("step_target <", value, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetLessThanOrEqualTo(Integer value) {
            addCriterion("step_target <=", value, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetIn(List<Integer> values) {
            addCriterion("step_target in", values, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetNotIn(List<Integer> values) {
            addCriterion("step_target not in", values, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetBetween(Integer value1, Integer value2) {
            addCriterion("step_target between", value1, value2, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andStepTargetNotBetween(Integer value1, Integer value2) {
            addCriterion("step_target not between", value1, value2, "stepTarget");
            return (Criteria) this;
        }

        public Criteria andSleepTimeIsNull() {
            addCriterion("sleep_time is null");
            return (Criteria) this;
        }

        public Criteria andSleepTimeIsNotNull() {
            addCriterion("sleep_time is not null");
            return (Criteria) this;
        }

        public Criteria andSleepTimeEqualTo(Integer value) {
            addCriterion("sleep_time =", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeNotEqualTo(Integer value) {
            addCriterion("sleep_time <>", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeGreaterThan(Integer value) {
            addCriterion("sleep_time >", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sleep_time >=", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeLessThan(Integer value) {
            addCriterion("sleep_time <", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeLessThanOrEqualTo(Integer value) {
            addCriterion("sleep_time <=", value, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeIn(List<Integer> values) {
            addCriterion("sleep_time in", values, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeNotIn(List<Integer> values) {
            addCriterion("sleep_time not in", values, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeBetween(Integer value1, Integer value2) {
            addCriterion("sleep_time between", value1, value2, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andSleepTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("sleep_time not between", value1, value2, "sleepTime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIsNull() {
            addCriterion("register_datetime is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIsNotNull() {
            addCriterion("register_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeEqualTo(Date value) {
            addCriterion("register_datetime =", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotEqualTo(Date value) {
            addCriterion("register_datetime <>", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeGreaterThan(Date value) {
            addCriterion("register_datetime >", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_datetime >=", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeLessThan(Date value) {
            addCriterion("register_datetime <", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("register_datetime <=", value, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeIn(List<Date> values) {
            addCriterion("register_datetime in", values, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotIn(List<Date> values) {
            addCriterion("register_datetime not in", values, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeBetween(Date value1, Date value2) {
            addCriterion("register_datetime between", value1, value2, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andRegisterDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("register_datetime not between", value1, value2, "registerDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeIsNull() {
            addCriterion("updated_datetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeIsNotNull() {
            addCriterion("updated_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeEqualTo(Date value) {
            addCriterion("updated_datetime =", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeNotEqualTo(Date value) {
            addCriterion("updated_datetime <>", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeGreaterThan(Date value) {
            addCriterion("updated_datetime >", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_datetime >=", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeLessThan(Date value) {
            addCriterion("updated_datetime <", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_datetime <=", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeIn(List<Date> values) {
            addCriterion("updated_datetime in", values, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeNotIn(List<Date> values) {
            addCriterion("updated_datetime not in", values, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeBetween(Date value1, Date value2) {
            addCriterion("updated_datetime between", value1, value2, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_datetime not between", value1, value2, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andLockintimeIsNull() {
            addCriterion("lockintime is null");
            return (Criteria) this;
        }

        public Criteria andLockintimeIsNotNull() {
            addCriterion("lockintime is not null");
            return (Criteria) this;
        }

        public Criteria andLockintimeEqualTo(Date value) {
            addCriterion("lockintime =", value, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeNotEqualTo(Date value) {
            addCriterion("lockintime <>", value, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeGreaterThan(Date value) {
            addCriterion("lockintime >", value, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lockintime >=", value, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeLessThan(Date value) {
            addCriterion("lockintime <", value, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeLessThanOrEqualTo(Date value) {
            addCriterion("lockintime <=", value, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeIn(List<Date> values) {
            addCriterion("lockintime in", values, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeNotIn(List<Date> values) {
            addCriterion("lockintime not in", values, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeBetween(Date value1, Date value2) {
            addCriterion("lockintime between", value1, value2, "lockintime");
            return (Criteria) this;
        }

        public Criteria andLockintimeNotBetween(Date value1, Date value2) {
            addCriterion("lockintime not between", value1, value2, "lockintime");
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