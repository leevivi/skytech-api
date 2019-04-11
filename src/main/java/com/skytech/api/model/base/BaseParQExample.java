package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseParQExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseParQExample() {
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

        public Criteria andHeartConditionIsNull() {
            addCriterion("heart_condition is null");
            return (Criteria) this;
        }

        public Criteria andHeartConditionIsNotNull() {
            addCriterion("heart_condition is not null");
            return (Criteria) this;
        }

        public Criteria andHeartConditionEqualTo(Integer value) {
            addCriterion("heart_condition =", value, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionNotEqualTo(Integer value) {
            addCriterion("heart_condition <>", value, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionGreaterThan(Integer value) {
            addCriterion("heart_condition >", value, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("heart_condition >=", value, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionLessThan(Integer value) {
            addCriterion("heart_condition <", value, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionLessThanOrEqualTo(Integer value) {
            addCriterion("heart_condition <=", value, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionIn(List<Integer> values) {
            addCriterion("heart_condition in", values, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionNotIn(List<Integer> values) {
            addCriterion("heart_condition not in", values, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionBetween(Integer value1, Integer value2) {
            addCriterion("heart_condition between", value1, value2, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andHeartConditionNotBetween(Integer value1, Integer value2) {
            addCriterion("heart_condition not between", value1, value2, "heartCondition");
            return (Criteria) this;
        }

        public Criteria andAnginaIsNull() {
            addCriterion("angina is null");
            return (Criteria) this;
        }

        public Criteria andAnginaIsNotNull() {
            addCriterion("angina is not null");
            return (Criteria) this;
        }

        public Criteria andAnginaEqualTo(Integer value) {
            addCriterion("angina =", value, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaNotEqualTo(Integer value) {
            addCriterion("angina <>", value, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaGreaterThan(Integer value) {
            addCriterion("angina >", value, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaGreaterThanOrEqualTo(Integer value) {
            addCriterion("angina >=", value, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaLessThan(Integer value) {
            addCriterion("angina <", value, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaLessThanOrEqualTo(Integer value) {
            addCriterion("angina <=", value, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaIn(List<Integer> values) {
            addCriterion("angina in", values, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaNotIn(List<Integer> values) {
            addCriterion("angina not in", values, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaBetween(Integer value1, Integer value2) {
            addCriterion("angina between", value1, value2, "angina");
            return (Criteria) this;
        }

        public Criteria andAnginaNotBetween(Integer value1, Integer value2) {
            addCriterion("angina not between", value1, value2, "angina");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureIsNull() {
            addCriterion("high_blood_pressure is null");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureIsNotNull() {
            addCriterion("high_blood_pressure is not null");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureEqualTo(Integer value) {
            addCriterion("high_blood_pressure =", value, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureNotEqualTo(Integer value) {
            addCriterion("high_blood_pressure <>", value, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureGreaterThan(Integer value) {
            addCriterion("high_blood_pressure >", value, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_blood_pressure >=", value, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureLessThan(Integer value) {
            addCriterion("high_blood_pressure <", value, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureLessThanOrEqualTo(Integer value) {
            addCriterion("high_blood_pressure <=", value, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureIn(List<Integer> values) {
            addCriterion("high_blood_pressure in", values, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureNotIn(List<Integer> values) {
            addCriterion("high_blood_pressure not in", values, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureBetween(Integer value1, Integer value2) {
            addCriterion("high_blood_pressure between", value1, value2, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andHighBloodPressureNotBetween(Integer value1, Integer value2) {
            addCriterion("high_blood_pressure not between", value1, value2, "highBloodPressure");
            return (Criteria) this;
        }

        public Criteria andAsthmaIsNull() {
            addCriterion("asthma is null");
            return (Criteria) this;
        }

        public Criteria andAsthmaIsNotNull() {
            addCriterion("asthma is not null");
            return (Criteria) this;
        }

        public Criteria andAsthmaEqualTo(Integer value) {
            addCriterion("asthma =", value, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaNotEqualTo(Integer value) {
            addCriterion("asthma <>", value, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaGreaterThan(Integer value) {
            addCriterion("asthma >", value, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaGreaterThanOrEqualTo(Integer value) {
            addCriterion("asthma >=", value, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaLessThan(Integer value) {
            addCriterion("asthma <", value, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaLessThanOrEqualTo(Integer value) {
            addCriterion("asthma <=", value, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaIn(List<Integer> values) {
            addCriterion("asthma in", values, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaNotIn(List<Integer> values) {
            addCriterion("asthma not in", values, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaBetween(Integer value1, Integer value2) {
            addCriterion("asthma between", value1, value2, "asthma");
            return (Criteria) this;
        }

        public Criteria andAsthmaNotBetween(Integer value1, Integer value2) {
            addCriterion("asthma not between", value1, value2, "asthma");
            return (Criteria) this;
        }

        public Criteria andDiabetesIsNull() {
            addCriterion("diabetes is null");
            return (Criteria) this;
        }

        public Criteria andDiabetesIsNotNull() {
            addCriterion("diabetes is not null");
            return (Criteria) this;
        }

        public Criteria andDiabetesEqualTo(Integer value) {
            addCriterion("diabetes =", value, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesNotEqualTo(Integer value) {
            addCriterion("diabetes <>", value, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesGreaterThan(Integer value) {
            addCriterion("diabetes >", value, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesGreaterThanOrEqualTo(Integer value) {
            addCriterion("diabetes >=", value, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesLessThan(Integer value) {
            addCriterion("diabetes <", value, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesLessThanOrEqualTo(Integer value) {
            addCriterion("diabetes <=", value, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesIn(List<Integer> values) {
            addCriterion("diabetes in", values, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesNotIn(List<Integer> values) {
            addCriterion("diabetes not in", values, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesBetween(Integer value1, Integer value2) {
            addCriterion("diabetes between", value1, value2, "diabetes");
            return (Criteria) this;
        }

        public Criteria andDiabetesNotBetween(Integer value1, Integer value2) {
            addCriterion("diabetes not between", value1, value2, "diabetes");
            return (Criteria) this;
        }

        public Criteria andBackProblemsIsNull() {
            addCriterion("back_problems is null");
            return (Criteria) this;
        }

        public Criteria andBackProblemsIsNotNull() {
            addCriterion("back_problems is not null");
            return (Criteria) this;
        }

        public Criteria andBackProblemsEqualTo(Integer value) {
            addCriterion("back_problems =", value, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsNotEqualTo(Integer value) {
            addCriterion("back_problems <>", value, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsGreaterThan(Integer value) {
            addCriterion("back_problems >", value, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsGreaterThanOrEqualTo(Integer value) {
            addCriterion("back_problems >=", value, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsLessThan(Integer value) {
            addCriterion("back_problems <", value, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsLessThanOrEqualTo(Integer value) {
            addCriterion("back_problems <=", value, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsIn(List<Integer> values) {
            addCriterion("back_problems in", values, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsNotIn(List<Integer> values) {
            addCriterion("back_problems not in", values, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsBetween(Integer value1, Integer value2) {
            addCriterion("back_problems between", value1, value2, "backProblems");
            return (Criteria) this;
        }

        public Criteria andBackProblemsNotBetween(Integer value1, Integer value2) {
            addCriterion("back_problems not between", value1, value2, "backProblems");
            return (Criteria) this;
        }

        public Criteria andSciaticaIsNull() {
            addCriterion("sciatica is null");
            return (Criteria) this;
        }

        public Criteria andSciaticaIsNotNull() {
            addCriterion("sciatica is not null");
            return (Criteria) this;
        }

        public Criteria andSciaticaEqualTo(Integer value) {
            addCriterion("sciatica =", value, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaNotEqualTo(Integer value) {
            addCriterion("sciatica <>", value, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaGreaterThan(Integer value) {
            addCriterion("sciatica >", value, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaGreaterThanOrEqualTo(Integer value) {
            addCriterion("sciatica >=", value, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaLessThan(Integer value) {
            addCriterion("sciatica <", value, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaLessThanOrEqualTo(Integer value) {
            addCriterion("sciatica <=", value, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaIn(List<Integer> values) {
            addCriterion("sciatica in", values, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaNotIn(List<Integer> values) {
            addCriterion("sciatica not in", values, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaBetween(Integer value1, Integer value2) {
            addCriterion("sciatica between", value1, value2, "sciatica");
            return (Criteria) this;
        }

        public Criteria andSciaticaNotBetween(Integer value1, Integer value2) {
            addCriterion("sciatica not between", value1, value2, "sciatica");
            return (Criteria) this;
        }

        public Criteria andJointProblemsIsNull() {
            addCriterion("joint_problems is null");
            return (Criteria) this;
        }

        public Criteria andJointProblemsIsNotNull() {
            addCriterion("joint_problems is not null");
            return (Criteria) this;
        }

        public Criteria andJointProblemsEqualTo(Integer value) {
            addCriterion("joint_problems =", value, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsNotEqualTo(Integer value) {
            addCriterion("joint_problems <>", value, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsGreaterThan(Integer value) {
            addCriterion("joint_problems >", value, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsGreaterThanOrEqualTo(Integer value) {
            addCriterion("joint_problems >=", value, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsLessThan(Integer value) {
            addCriterion("joint_problems <", value, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsLessThanOrEqualTo(Integer value) {
            addCriterion("joint_problems <=", value, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsIn(List<Integer> values) {
            addCriterion("joint_problems in", values, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsNotIn(List<Integer> values) {
            addCriterion("joint_problems not in", values, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsBetween(Integer value1, Integer value2) {
            addCriterion("joint_problems between", value1, value2, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andJointProblemsNotBetween(Integer value1, Integer value2) {
            addCriterion("joint_problems not between", value1, value2, "jointProblems");
            return (Criteria) this;
        }

        public Criteria andSmokerIsNull() {
            addCriterion("smoker is null");
            return (Criteria) this;
        }

        public Criteria andSmokerIsNotNull() {
            addCriterion("smoker is not null");
            return (Criteria) this;
        }

        public Criteria andSmokerEqualTo(Integer value) {
            addCriterion("smoker =", value, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerNotEqualTo(Integer value) {
            addCriterion("smoker <>", value, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerGreaterThan(Integer value) {
            addCriterion("smoker >", value, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerGreaterThanOrEqualTo(Integer value) {
            addCriterion("smoker >=", value, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerLessThan(Integer value) {
            addCriterion("smoker <", value, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerLessThanOrEqualTo(Integer value) {
            addCriterion("smoker <=", value, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerIn(List<Integer> values) {
            addCriterion("smoker in", values, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerNotIn(List<Integer> values) {
            addCriterion("smoker not in", values, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerBetween(Integer value1, Integer value2) {
            addCriterion("smoker between", value1, value2, "smoker");
            return (Criteria) this;
        }

        public Criteria andSmokerNotBetween(Integer value1, Integer value2) {
            addCriterion("smoker not between", value1, value2, "smoker");
            return (Criteria) this;
        }

        public Criteria andPregnancyIsNull() {
            addCriterion("pregnancy is null");
            return (Criteria) this;
        }

        public Criteria andPregnancyIsNotNull() {
            addCriterion("pregnancy is not null");
            return (Criteria) this;
        }

        public Criteria andPregnancyEqualTo(Integer value) {
            addCriterion("pregnancy =", value, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyNotEqualTo(Integer value) {
            addCriterion("pregnancy <>", value, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyGreaterThan(Integer value) {
            addCriterion("pregnancy >", value, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyGreaterThanOrEqualTo(Integer value) {
            addCriterion("pregnancy >=", value, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyLessThan(Integer value) {
            addCriterion("pregnancy <", value, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyLessThanOrEqualTo(Integer value) {
            addCriterion("pregnancy <=", value, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyIn(List<Integer> values) {
            addCriterion("pregnancy in", values, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyNotIn(List<Integer> values) {
            addCriterion("pregnancy not in", values, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyBetween(Integer value1, Integer value2) {
            addCriterion("pregnancy between", value1, value2, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andPregnancyNotBetween(Integer value1, Integer value2) {
            addCriterion("pregnancy not between", value1, value2, "pregnancy");
            return (Criteria) this;
        }

        public Criteria andHerniaIsNull() {
            addCriterion("hernia is null");
            return (Criteria) this;
        }

        public Criteria andHerniaIsNotNull() {
            addCriterion("hernia is not null");
            return (Criteria) this;
        }

        public Criteria andHerniaEqualTo(Integer value) {
            addCriterion("hernia =", value, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaNotEqualTo(Integer value) {
            addCriterion("hernia <>", value, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaGreaterThan(Integer value) {
            addCriterion("hernia >", value, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaGreaterThanOrEqualTo(Integer value) {
            addCriterion("hernia >=", value, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaLessThan(Integer value) {
            addCriterion("hernia <", value, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaLessThanOrEqualTo(Integer value) {
            addCriterion("hernia <=", value, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaIn(List<Integer> values) {
            addCriterion("hernia in", values, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaNotIn(List<Integer> values) {
            addCriterion("hernia not in", values, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaBetween(Integer value1, Integer value2) {
            addCriterion("hernia between", value1, value2, "hernia");
            return (Criteria) this;
        }

        public Criteria andHerniaNotBetween(Integer value1, Integer value2) {
            addCriterion("hernia not between", value1, value2, "hernia");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryIsNull() {
            addCriterion("recent_surgery is null");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryIsNotNull() {
            addCriterion("recent_surgery is not null");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryEqualTo(Integer value) {
            addCriterion("recent_surgery =", value, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryNotEqualTo(Integer value) {
            addCriterion("recent_surgery <>", value, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryGreaterThan(Integer value) {
            addCriterion("recent_surgery >", value, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryGreaterThanOrEqualTo(Integer value) {
            addCriterion("recent_surgery >=", value, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryLessThan(Integer value) {
            addCriterion("recent_surgery <", value, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryLessThanOrEqualTo(Integer value) {
            addCriterion("recent_surgery <=", value, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryIn(List<Integer> values) {
            addCriterion("recent_surgery in", values, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryNotIn(List<Integer> values) {
            addCriterion("recent_surgery not in", values, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryBetween(Integer value1, Integer value2) {
            addCriterion("recent_surgery between", value1, value2, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andRecentSurgeryNotBetween(Integer value1, Integer value2) {
            addCriterion("recent_surgery not between", value1, value2, "recentSurgery");
            return (Criteria) this;
        }

        public Criteria andFatLossIsNull() {
            addCriterion("fat_loss is null");
            return (Criteria) this;
        }

        public Criteria andFatLossIsNotNull() {
            addCriterion("fat_loss is not null");
            return (Criteria) this;
        }

        public Criteria andFatLossEqualTo(Integer value) {
            addCriterion("fat_loss =", value, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossNotEqualTo(Integer value) {
            addCriterion("fat_loss <>", value, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossGreaterThan(Integer value) {
            addCriterion("fat_loss >", value, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossGreaterThanOrEqualTo(Integer value) {
            addCriterion("fat_loss >=", value, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossLessThan(Integer value) {
            addCriterion("fat_loss <", value, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossLessThanOrEqualTo(Integer value) {
            addCriterion("fat_loss <=", value, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossIn(List<Integer> values) {
            addCriterion("fat_loss in", values, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossNotIn(List<Integer> values) {
            addCriterion("fat_loss not in", values, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossBetween(Integer value1, Integer value2) {
            addCriterion("fat_loss between", value1, value2, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andFatLossNotBetween(Integer value1, Integer value2) {
            addCriterion("fat_loss not between", value1, value2, "fatLoss");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNull() {
            addCriterion("building is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNotNull() {
            addCriterion("building is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingEqualTo(Integer value) {
            addCriterion("building =", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotEqualTo(Integer value) {
            addCriterion("building <>", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThan(Integer value) {
            addCriterion("building >", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThanOrEqualTo(Integer value) {
            addCriterion("building >=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThan(Integer value) {
            addCriterion("building <", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThanOrEqualTo(Integer value) {
            addCriterion("building <=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingIn(List<Integer> values) {
            addCriterion("building in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotIn(List<Integer> values) {
            addCriterion("building not in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingBetween(Integer value1, Integer value2) {
            addCriterion("building between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotBetween(Integer value1, Integer value2) {
            addCriterion("building not between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andToningIsNull() {
            addCriterion("toning is null");
            return (Criteria) this;
        }

        public Criteria andToningIsNotNull() {
            addCriterion("toning is not null");
            return (Criteria) this;
        }

        public Criteria andToningEqualTo(Integer value) {
            addCriterion("toning =", value, "toning");
            return (Criteria) this;
        }

        public Criteria andToningNotEqualTo(Integer value) {
            addCriterion("toning <>", value, "toning");
            return (Criteria) this;
        }

        public Criteria andToningGreaterThan(Integer value) {
            addCriterion("toning >", value, "toning");
            return (Criteria) this;
        }

        public Criteria andToningGreaterThanOrEqualTo(Integer value) {
            addCriterion("toning >=", value, "toning");
            return (Criteria) this;
        }

        public Criteria andToningLessThan(Integer value) {
            addCriterion("toning <", value, "toning");
            return (Criteria) this;
        }

        public Criteria andToningLessThanOrEqualTo(Integer value) {
            addCriterion("toning <=", value, "toning");
            return (Criteria) this;
        }

        public Criteria andToningIn(List<Integer> values) {
            addCriterion("toning in", values, "toning");
            return (Criteria) this;
        }

        public Criteria andToningNotIn(List<Integer> values) {
            addCriterion("toning not in", values, "toning");
            return (Criteria) this;
        }

        public Criteria andToningBetween(Integer value1, Integer value2) {
            addCriterion("toning between", value1, value2, "toning");
            return (Criteria) this;
        }

        public Criteria andToningNotBetween(Integer value1, Integer value2) {
            addCriterion("toning not between", value1, value2, "toning");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(Integer value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(Integer value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(Integer value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(Integer value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(Integer value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(Integer value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<Integer> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<Integer> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(Integer value1, Integer value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(Integer value1, Integer value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasIsNull() {
            addCriterion("specific_focus_areas is null");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasIsNotNull() {
            addCriterion("specific_focus_areas is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasEqualTo(String value) {
            addCriterion("specific_focus_areas =", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasNotEqualTo(String value) {
            addCriterion("specific_focus_areas <>", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasGreaterThan(String value) {
            addCriterion("specific_focus_areas >", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasGreaterThanOrEqualTo(String value) {
            addCriterion("specific_focus_areas >=", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasLessThan(String value) {
            addCriterion("specific_focus_areas <", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasLessThanOrEqualTo(String value) {
            addCriterion("specific_focus_areas <=", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasLike(String value) {
            addCriterion("specific_focus_areas like", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasNotLike(String value) {
            addCriterion("specific_focus_areas not like", value, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasIn(List<String> values) {
            addCriterion("specific_focus_areas in", values, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasNotIn(List<String> values) {
            addCriterion("specific_focus_areas not in", values, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasBetween(String value1, String value2) {
            addCriterion("specific_focus_areas between", value1, value2, "specificFocusAreas");
            return (Criteria) this;
        }

        public Criteria andSpecificFocusAreasNotBetween(String value1, String value2) {
            addCriterion("specific_focus_areas not between", value1, value2, "specificFocusAreas");
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