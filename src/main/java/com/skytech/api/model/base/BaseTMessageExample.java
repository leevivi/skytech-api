package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseTMessageExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseTMessageExample() {
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

        public Criteria andMsgthemeIsNull() {
            addCriterion("msgTheme is null");
            return (Criteria) this;
        }

        public Criteria andMsgthemeIsNotNull() {
            addCriterion("msgTheme is not null");
            return (Criteria) this;
        }

        public Criteria andMsgthemeEqualTo(String value) {
            addCriterion("msgTheme =", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeNotEqualTo(String value) {
            addCriterion("msgTheme <>", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeGreaterThan(String value) {
            addCriterion("msgTheme >", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeGreaterThanOrEqualTo(String value) {
            addCriterion("msgTheme >=", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeLessThan(String value) {
            addCriterion("msgTheme <", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeLessThanOrEqualTo(String value) {
            addCriterion("msgTheme <=", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeLike(String value) {
            addCriterion("msgTheme like", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeNotLike(String value) {
            addCriterion("msgTheme not like", value, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeIn(List<String> values) {
            addCriterion("msgTheme in", values, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeNotIn(List<String> values) {
            addCriterion("msgTheme not in", values, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeBetween(String value1, String value2) {
            addCriterion("msgTheme between", value1, value2, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgthemeNotBetween(String value1, String value2) {
            addCriterion("msgTheme not between", value1, value2, "msgtheme");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("msgType is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("msgType is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(Integer value) {
            addCriterion("msgType =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(Integer value) {
            addCriterion("msgType <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(Integer value) {
            addCriterion("msgType >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("msgType >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(Integer value) {
            addCriterion("msgType <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(Integer value) {
            addCriterion("msgType <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<Integer> values) {
            addCriterion("msgType in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<Integer> values) {
            addCriterion("msgType not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(Integer value1, Integer value2) {
            addCriterion("msgType between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("msgType not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIsNull() {
            addCriterion("msgTime is null");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIsNotNull() {
            addCriterion("msgTime is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtimeEqualTo(Date value) {
            addCriterion("msgTime =", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotEqualTo(Date value) {
            addCriterion("msgTime <>", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeGreaterThan(Date value) {
            addCriterion("msgTime >", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("msgTime >=", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeLessThan(Date value) {
            addCriterion("msgTime <", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeLessThanOrEqualTo(Date value) {
            addCriterion("msgTime <=", value, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeIn(List<Date> values) {
            addCriterion("msgTime in", values, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotIn(List<Date> values) {
            addCriterion("msgTime not in", values, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeBetween(Date value1, Date value2) {
            addCriterion("msgTime between", value1, value2, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMsgtimeNotBetween(Date value1, Date value2) {
            addCriterion("msgTime not between", value1, value2, "msgtime");
            return (Criteria) this;
        }

        public Criteria andMembertypeIsNull() {
            addCriterion("memberType is null");
            return (Criteria) this;
        }

        public Criteria andMembertypeIsNotNull() {
            addCriterion("memberType is not null");
            return (Criteria) this;
        }

        public Criteria andMembertypeEqualTo(Integer value) {
            addCriterion("memberType =", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotEqualTo(Integer value) {
            addCriterion("memberType <>", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeGreaterThan(Integer value) {
            addCriterion("memberType >", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberType >=", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeLessThan(Integer value) {
            addCriterion("memberType <", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeLessThanOrEqualTo(Integer value) {
            addCriterion("memberType <=", value, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeIn(List<Integer> values) {
            addCriterion("memberType in", values, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotIn(List<Integer> values) {
            addCriterion("memberType not in", values, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeBetween(Integer value1, Integer value2) {
            addCriterion("memberType between", value1, value2, "membertype");
            return (Criteria) this;
        }

        public Criteria andMembertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("memberType not between", value1, value2, "membertype");
            return (Criteria) this;
        }

        public Criteria andMsgbodyIsNull() {
            addCriterion("msgBody is null");
            return (Criteria) this;
        }

        public Criteria andMsgbodyIsNotNull() {
            addCriterion("msgBody is not null");
            return (Criteria) this;
        }

        public Criteria andMsgbodyEqualTo(String value) {
            addCriterion("msgBody =", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotEqualTo(String value) {
            addCriterion("msgBody <>", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyGreaterThan(String value) {
            addCriterion("msgBody >", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyGreaterThanOrEqualTo(String value) {
            addCriterion("msgBody >=", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyLessThan(String value) {
            addCriterion("msgBody <", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyLessThanOrEqualTo(String value) {
            addCriterion("msgBody <=", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyLike(String value) {
            addCriterion("msgBody like", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotLike(String value) {
            addCriterion("msgBody not like", value, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyIn(List<String> values) {
            addCriterion("msgBody in", values, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotIn(List<String> values) {
            addCriterion("msgBody not in", values, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyBetween(String value1, String value2) {
            addCriterion("msgBody between", value1, value2, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgbodyNotBetween(String value1, String value2) {
            addCriterion("msgBody not between", value1, value2, "msgbody");
            return (Criteria) this;
        }

        public Criteria andMsgconditionIsNull() {
            addCriterion("msgCondition is null");
            return (Criteria) this;
        }

        public Criteria andMsgconditionIsNotNull() {
            addCriterion("msgCondition is not null");
            return (Criteria) this;
        }

        public Criteria andMsgconditionEqualTo(Object value) {
            addCriterion("msgCondition =", value, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionNotEqualTo(Object value) {
            addCriterion("msgCondition <>", value, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionGreaterThan(Object value) {
            addCriterion("msgCondition >", value, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionGreaterThanOrEqualTo(Object value) {
            addCriterion("msgCondition >=", value, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionLessThan(Object value) {
            addCriterion("msgCondition <", value, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionLessThanOrEqualTo(Object value) {
            addCriterion("msgCondition <=", value, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionIn(List<Object> values) {
            addCriterion("msgCondition in", values, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionNotIn(List<Object> values) {
            addCriterion("msgCondition not in", values, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionBetween(Object value1, Object value2) {
            addCriterion("msgCondition between", value1, value2, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgconditionNotBetween(Object value1, Object value2) {
            addCriterion("msgCondition not between", value1, value2, "msgcondition");
            return (Criteria) this;
        }

        public Criteria andMsgurlIsNull() {
            addCriterion("msgUrl is null");
            return (Criteria) this;
        }

        public Criteria andMsgurlIsNotNull() {
            addCriterion("msgUrl is not null");
            return (Criteria) this;
        }

        public Criteria andMsgurlEqualTo(String value) {
            addCriterion("msgUrl =", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlNotEqualTo(String value) {
            addCriterion("msgUrl <>", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlGreaterThan(String value) {
            addCriterion("msgUrl >", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlGreaterThanOrEqualTo(String value) {
            addCriterion("msgUrl >=", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlLessThan(String value) {
            addCriterion("msgUrl <", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlLessThanOrEqualTo(String value) {
            addCriterion("msgUrl <=", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlLike(String value) {
            addCriterion("msgUrl like", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlNotLike(String value) {
            addCriterion("msgUrl not like", value, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlIn(List<String> values) {
            addCriterion("msgUrl in", values, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlNotIn(List<String> values) {
            addCriterion("msgUrl not in", values, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlBetween(String value1, String value2) {
            addCriterion("msgUrl between", value1, value2, "msgurl");
            return (Criteria) this;
        }

        public Criteria andMsgurlNotBetween(String value1, String value2) {
            addCriterion("msgUrl not between", value1, value2, "msgurl");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
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