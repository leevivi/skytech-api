package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BaseTMemberExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseTMemberExample() {
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

        public Criteria andLastnameIsNull() {
            addCriterion("lastName is null");
            return (Criteria) this;
        }

        public Criteria andLastnameIsNotNull() {
            addCriterion("lastName is not null");
            return (Criteria) this;
        }

        public Criteria andLastnameEqualTo(String value) {
            addCriterion("lastName =", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotEqualTo(String value) {
            addCriterion("lastName <>", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThan(String value) {
            addCriterion("lastName >", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameGreaterThanOrEqualTo(String value) {
            addCriterion("lastName >=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThan(String value) {
            addCriterion("lastName <", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLessThanOrEqualTo(String value) {
            addCriterion("lastName <=", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameLike(String value) {
            addCriterion("lastName like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotLike(String value) {
            addCriterion("lastName not like", value, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameIn(List<String> values) {
            addCriterion("lastName in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotIn(List<String> values) {
            addCriterion("lastName not in", values, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameBetween(String value1, String value2) {
            addCriterion("lastName between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andLastnameNotBetween(String value1, String value2) {
            addCriterion("lastName not between", value1, value2, "lastname");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andCouponnumberIsNull() {
            addCriterion("couponNumber is null");
            return (Criteria) this;
        }

        public Criteria andCouponnumberIsNotNull() {
            addCriterion("couponNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCouponnumberEqualTo(Integer value) {
            addCriterion("couponNumber =", value, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberNotEqualTo(Integer value) {
            addCriterion("couponNumber <>", value, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberGreaterThan(Integer value) {
            addCriterion("couponNumber >", value, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("couponNumber >=", value, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberLessThan(Integer value) {
            addCriterion("couponNumber <", value, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberLessThanOrEqualTo(Integer value) {
            addCriterion("couponNumber <=", value, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberIn(List<Integer> values) {
            addCriterion("couponNumber in", values, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberNotIn(List<Integer> values) {
            addCriterion("couponNumber not in", values, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberBetween(Integer value1, Integer value2) {
            addCriterion("couponNumber between", value1, value2, "couponnumber");
            return (Criteria) this;
        }

        public Criteria andCouponnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("couponNumber not between", value1, value2, "couponnumber");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andDictidIsNull() {
            addCriterion("dictId is null");
            return (Criteria) this;
        }

        public Criteria andDictidIsNotNull() {
            addCriterion("dictId is not null");
            return (Criteria) this;
        }

        public Criteria andDictidEqualTo(Boolean value) {
            addCriterion("dictId =", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotEqualTo(Boolean value) {
            addCriterion("dictId <>", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThan(Boolean value) {
            addCriterion("dictId >", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("dictId >=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThan(Boolean value) {
            addCriterion("dictId <", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThanOrEqualTo(Boolean value) {
            addCriterion("dictId <=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidIn(List<Boolean> values) {
            addCriterion("dictId in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotIn(List<Boolean> values) {
            addCriterion("dictId not in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidBetween(Boolean value1, Boolean value2) {
            addCriterion("dictId between", value1, value2, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("dictId not between", value1, value2, "dictid");
            return (Criteria) this;
        }

        public Criteria andInitiationdateIsNull() {
            addCriterion("initiationDate is null");
            return (Criteria) this;
        }

        public Criteria andInitiationdateIsNotNull() {
            addCriterion("initiationDate is not null");
            return (Criteria) this;
        }

        public Criteria andInitiationdateEqualTo(Date value) {
            addCriterionForJDBCDate("initiationDate =", value, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("initiationDate <>", value, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateGreaterThan(Date value) {
            addCriterionForJDBCDate("initiationDate >", value, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("initiationDate >=", value, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateLessThan(Date value) {
            addCriterionForJDBCDate("initiationDate <", value, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("initiationDate <=", value, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateIn(List<Date> values) {
            addCriterionForJDBCDate("initiationDate in", values, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("initiationDate not in", values, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("initiationDate between", value1, value2, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andInitiationdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("initiationDate not between", value1, value2, "initiationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNull() {
            addCriterion("expirationDate is null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNotNull() {
            addCriterion("expirationDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateEqualTo(Date value) {
            addCriterionForJDBCDate("expirationDate =", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expirationDate <>", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThan(Date value) {
            addCriterionForJDBCDate("expirationDate >", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expirationDate >=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThan(Date value) {
            addCriterionForJDBCDate("expirationDate <", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expirationDate <=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIn(List<Date> values) {
            addCriterionForJDBCDate("expirationDate in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expirationDate not in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expirationDate between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expirationDate not between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andIsoverdueIsNull() {
            addCriterion("isOverdue is null");
            return (Criteria) this;
        }

        public Criteria andIsoverdueIsNotNull() {
            addCriterion("isOverdue is not null");
            return (Criteria) this;
        }

        public Criteria andIsoverdueEqualTo(Integer value) {
            addCriterion("isOverdue =", value, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueNotEqualTo(Integer value) {
            addCriterion("isOverdue <>", value, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueGreaterThan(Integer value) {
            addCriterion("isOverdue >", value, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("isOverdue >=", value, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueLessThan(Integer value) {
            addCriterion("isOverdue <", value, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueLessThanOrEqualTo(Integer value) {
            addCriterion("isOverdue <=", value, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueIn(List<Integer> values) {
            addCriterion("isOverdue in", values, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueNotIn(List<Integer> values) {
            addCriterion("isOverdue not in", values, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueBetween(Integer value1, Integer value2) {
            addCriterion("isOverdue between", value1, value2, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andIsoverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("isOverdue not between", value1, value2, "isoverdue");
            return (Criteria) this;
        }

        public Criteria andStoresidIsNull() {
            addCriterion("storesId is null");
            return (Criteria) this;
        }

        public Criteria andStoresidIsNotNull() {
            addCriterion("storesId is not null");
            return (Criteria) this;
        }

        public Criteria andStoresidEqualTo(Integer value) {
            addCriterion("storesId =", value, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidNotEqualTo(Integer value) {
            addCriterion("storesId <>", value, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidGreaterThan(Integer value) {
            addCriterion("storesId >", value, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidGreaterThanOrEqualTo(Integer value) {
            addCriterion("storesId >=", value, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidLessThan(Integer value) {
            addCriterion("storesId <", value, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidLessThanOrEqualTo(Integer value) {
            addCriterion("storesId <=", value, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidIn(List<Integer> values) {
            addCriterion("storesId in", values, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidNotIn(List<Integer> values) {
            addCriterion("storesId not in", values, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidBetween(Integer value1, Integer value2) {
            addCriterion("storesId between", value1, value2, "storesid");
            return (Criteria) this;
        }

        public Criteria andStoresidNotBetween(Integer value1, Integer value2) {
            addCriterion("storesId not between", value1, value2, "storesid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyId is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyId is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyId =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyId <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyId >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyId >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyId <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyId <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyId in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyId not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyId between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyId not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
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