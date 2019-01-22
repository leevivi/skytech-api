package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseCriteria;
import com.skytech.api.core.model.BaseModelExample;
import java.math.*;
import java.util.*;

public class BaseTeamMembersExample extends BaseModelExample {

protected List<Criteria> oredCriteria;

    public BaseTeamMembersExample() {
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

        public Criteria andTeamSidIsNull() {
            addCriterion("team_sid is null");
            return (Criteria) this;
        }

        public Criteria andTeamSidIsNotNull() {
            addCriterion("team_sid is not null");
            return (Criteria) this;
        }

        public Criteria andTeamSidEqualTo(String value) {
            addCriterion("team_sid =", value, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidNotEqualTo(String value) {
            addCriterion("team_sid <>", value, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidGreaterThan(String value) {
            addCriterion("team_sid >", value, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidGreaterThanOrEqualTo(String value) {
            addCriterion("team_sid >=", value, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidLessThan(String value) {
            addCriterion("team_sid <", value, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidLessThanOrEqualTo(String value) {
            addCriterion("team_sid <=", value, "teamSid");
            return (Criteria) this;
        }


        public Criteria andTeamSidLike(String value) {
            addCriterion("team_sid like", value, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidNotLike(String value) {
            addCriterion("team_sid not like", value, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidIn(List<String> values) {
            addCriterion("team_sid in", values, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidNotIn(List<String> values) {
            addCriterion("team_sid not in", values, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidBetween(String value1, String value2) {
            addCriterion("team_sid between", value1, value2, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamSidNotBetween(String value1, String value2) {
            addCriterion("team_sid not between", value1, value2, "teamSid");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }


        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
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

        public Criteria andJoinedDatetimeIsNull() {
            addCriterion("joined_datetime is null");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeIsNotNull() {
            addCriterion("joined_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeEqualTo(Date value) {
            addCriterion("joined_datetime =", value, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeNotEqualTo(Date value) {
            addCriterion("joined_datetime <>", value, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeGreaterThan(Date value) {
            addCriterion("joined_datetime >", value, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("joined_datetime >=", value, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeLessThan(Date value) {
            addCriterion("joined_datetime <", value, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("joined_datetime <=", value, "joinedDatetime");
            return (Criteria) this;
        }


        public Criteria andJoinedDatetimeIn(List<Date> values) {
            addCriterion("joined_datetime in", values, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeNotIn(List<Date> values) {
            addCriterion("joined_datetime not in", values, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeBetween(Date value1, Date value2) {
            addCriterion("joined_datetime between", value1, value2, "joinedDatetime");
            return (Criteria) this;
        }

        public Criteria andJoinedDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("joined_datetime not between", value1, value2, "joinedDatetime");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}