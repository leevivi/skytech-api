package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BaseTRenewExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseTRenewExample() {
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

        public Criteria andPactcodeIsNull() {
            addCriterion("pactCode is null");
            return (Criteria) this;
        }

        public Criteria andPactcodeIsNotNull() {
            addCriterion("pactCode is not null");
            return (Criteria) this;
        }

        public Criteria andPactcodeEqualTo(String value) {
            addCriterion("pactCode =", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeNotEqualTo(String value) {
            addCriterion("pactCode <>", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeGreaterThan(String value) {
            addCriterion("pactCode >", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeGreaterThanOrEqualTo(String value) {
            addCriterion("pactCode >=", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeLessThan(String value) {
            addCriterion("pactCode <", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeLessThanOrEqualTo(String value) {
            addCriterion("pactCode <=", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeLike(String value) {
            addCriterion("pactCode like", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeNotLike(String value) {
            addCriterion("pactCode not like", value, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeIn(List<String> values) {
            addCriterion("pactCode in", values, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeNotIn(List<String> values) {
            addCriterion("pactCode not in", values, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeBetween(String value1, String value2) {
            addCriterion("pactCode between", value1, value2, "pactcode");
            return (Criteria) this;
        }

        public Criteria andPactcodeNotBetween(String value1, String value2) {
            addCriterion("pactCode not between", value1, value2, "pactcode");
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

        public Criteria andCoachidIsNull() {
            addCriterion("coachId is null");
            return (Criteria) this;
        }

        public Criteria andCoachidIsNotNull() {
            addCriterion("coachId is not null");
            return (Criteria) this;
        }

        public Criteria andCoachidEqualTo(Integer value) {
            addCriterion("coachId =", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotEqualTo(Integer value) {
            addCriterion("coachId <>", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThan(Integer value) {
            addCriterion("coachId >", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coachId >=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThan(Integer value) {
            addCriterion("coachId <", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThanOrEqualTo(Integer value) {
            addCriterion("coachId <=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidIn(List<Integer> values) {
            addCriterion("coachId in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotIn(List<Integer> values) {
            addCriterion("coachId not in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidBetween(Integer value1, Integer value2) {
            addCriterion("coachId between", value1, value2, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotBetween(Integer value1, Integer value2) {
            addCriterion("coachId not between", value1, value2, "coachid");
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

        public Criteria andDictidEqualTo(Integer value) {
            addCriterion("dictId =", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotEqualTo(Integer value) {
            addCriterion("dictId <>", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThan(Integer value) {
            addCriterion("dictId >", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dictId >=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThan(Integer value) {
            addCriterion("dictId <", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThanOrEqualTo(Integer value) {
            addCriterion("dictId <=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidIn(List<Integer> values) {
            addCriterion("dictId in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotIn(List<Integer> values) {
            addCriterion("dictId not in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidBetween(Integer value1, Integer value2) {
            addCriterion("dictId between", value1, value2, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotBetween(Integer value1, Integer value2) {
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

        public Criteria andMemberidIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("memberId =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("memberId <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("memberId >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberId >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("memberId <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("memberId <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("memberId in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("memberId not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("memberId between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("memberId not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andRenewdateIsNull() {
            addCriterion("renewDate is null");
            return (Criteria) this;
        }

        public Criteria andRenewdateIsNotNull() {
            addCriterion("renewDate is not null");
            return (Criteria) this;
        }

        public Criteria andRenewdateEqualTo(Date value) {
            addCriterionForJDBCDate("renewDate =", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("renewDate <>", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateGreaterThan(Date value) {
            addCriterionForJDBCDate("renewDate >", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("renewDate >=", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateLessThan(Date value) {
            addCriterionForJDBCDate("renewDate <", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("renewDate <=", value, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateIn(List<Date> values) {
            addCriterionForJDBCDate("renewDate in", values, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("renewDate not in", values, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("renewDate between", value1, value2, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("renewDate not between", value1, value2, "renewdate");
            return (Criteria) this;
        }

        public Criteria andRenewamountIsNull() {
            addCriterion("renewAmount is null");
            return (Criteria) this;
        }

        public Criteria andRenewamountIsNotNull() {
            addCriterion("renewAmount is not null");
            return (Criteria) this;
        }

        public Criteria andRenewamountEqualTo(BigDecimal value) {
            addCriterion("renewAmount =", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountNotEqualTo(BigDecimal value) {
            addCriterion("renewAmount <>", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountGreaterThan(BigDecimal value) {
            addCriterion("renewAmount >", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("renewAmount >=", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountLessThan(BigDecimal value) {
            addCriterion("renewAmount <", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("renewAmount <=", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountIn(List<BigDecimal> values) {
            addCriterion("renewAmount in", values, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountNotIn(List<BigDecimal> values) {
            addCriterion("renewAmount not in", values, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("renewAmount between", value1, value2, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("renewAmount not between", value1, value2, "renewamount");
            return (Criteria) this;
        }

        public Criteria andUnitidIsNull() {
            addCriterion("unitId is null");
            return (Criteria) this;
        }

        public Criteria andUnitidIsNotNull() {
            addCriterion("unitId is not null");
            return (Criteria) this;
        }

        public Criteria andUnitidEqualTo(Integer value) {
            addCriterion("unitId =", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidNotEqualTo(Integer value) {
            addCriterion("unitId <>", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidGreaterThan(Integer value) {
            addCriterion("unitId >", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidGreaterThanOrEqualTo(Integer value) {
            addCriterion("unitId >=", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidLessThan(Integer value) {
            addCriterion("unitId <", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidLessThanOrEqualTo(Integer value) {
            addCriterion("unitId <=", value, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidIn(List<Integer> values) {
            addCriterion("unitId in", values, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidNotIn(List<Integer> values) {
            addCriterion("unitId not in", values, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidBetween(Integer value1, Integer value2) {
            addCriterion("unitId between", value1, value2, "unitid");
            return (Criteria) this;
        }

        public Criteria andUnitidNotBetween(Integer value1, Integer value2) {
            addCriterion("unitId not between", value1, value2, "unitid");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNull() {
            addCriterion("empId is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empId is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empId =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empId <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empId >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empId >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empId <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empId <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empId in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empId not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empId between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empId not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andCommidIsNull() {
            addCriterion("commId is null");
            return (Criteria) this;
        }

        public Criteria andCommidIsNotNull() {
            addCriterion("commId is not null");
            return (Criteria) this;
        }

        public Criteria andCommidEqualTo(Integer value) {
            addCriterion("commId =", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotEqualTo(Integer value) {
            addCriterion("commId <>", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThan(Integer value) {
            addCriterion("commId >", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThanOrEqualTo(Integer value) {
            addCriterion("commId >=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThan(Integer value) {
            addCriterion("commId <", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThanOrEqualTo(Integer value) {
            addCriterion("commId <=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidIn(List<Integer> values) {
            addCriterion("commId in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotIn(List<Integer> values) {
            addCriterion("commId not in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidBetween(Integer value1, Integer value2) {
            addCriterion("commId between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotBetween(Integer value1, Integer value2) {
            addCriterion("commId not between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andCommamountIsNull() {
            addCriterion("commAmount is null");
            return (Criteria) this;
        }

        public Criteria andCommamountIsNotNull() {
            addCriterion("commAmount is not null");
            return (Criteria) this;
        }

        public Criteria andCommamountEqualTo(BigDecimal value) {
            addCriterion("commAmount =", value, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountNotEqualTo(BigDecimal value) {
            addCriterion("commAmount <>", value, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountGreaterThan(BigDecimal value) {
            addCriterion("commAmount >", value, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commAmount >=", value, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountLessThan(BigDecimal value) {
            addCriterion("commAmount <", value, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commAmount <=", value, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountIn(List<BigDecimal> values) {
            addCriterion("commAmount in", values, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountNotIn(List<BigDecimal> values) {
            addCriterion("commAmount not in", values, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commAmount between", value1, value2, "commamount");
            return (Criteria) this;
        }

        public Criteria andCommamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commAmount not between", value1, value2, "commamount");
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