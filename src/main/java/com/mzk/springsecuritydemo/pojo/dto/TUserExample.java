package com.mzk.springsecuritydemo.pojo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author miaozhenkai
 * @version 2021-07-12  18:14
 */
public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredIsNull() {
            addCriterion("accountNonExpired is null");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredIsNotNull() {
            addCriterion("accountNonExpired is not null");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredEqualTo(Boolean value) {
            addCriterion("accountNonExpired =", value, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredNotEqualTo(Boolean value) {
            addCriterion("accountNonExpired <>", value, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredGreaterThan(Boolean value) {
            addCriterion("accountNonExpired >", value, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("accountNonExpired >=", value, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredLessThan(Boolean value) {
            addCriterion("accountNonExpired <", value, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("accountNonExpired <=", value, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredIn(List<Boolean> values) {
            addCriterion("accountNonExpired in", values, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredNotIn(List<Boolean> values) {
            addCriterion("accountNonExpired not in", values, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("accountNonExpired between", value1, value2, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonexpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("accountNonExpired not between", value1, value2, "accountnonexpired");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedIsNull() {
            addCriterion("accountNonLocked is null");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedIsNotNull() {
            addCriterion("accountNonLocked is not null");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedEqualTo(Boolean value) {
            addCriterion("accountNonLocked =", value, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedNotEqualTo(Boolean value) {
            addCriterion("accountNonLocked <>", value, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedGreaterThan(Boolean value) {
            addCriterion("accountNonLocked >", value, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("accountNonLocked >=", value, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedLessThan(Boolean value) {
            addCriterion("accountNonLocked <", value, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedLessThanOrEqualTo(Boolean value) {
            addCriterion("accountNonLocked <=", value, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedIn(List<Boolean> values) {
            addCriterion("accountNonLocked in", values, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedNotIn(List<Boolean> values) {
            addCriterion("accountNonLocked not in", values, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedBetween(Boolean value1, Boolean value2) {
            addCriterion("accountNonLocked between", value1, value2, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andAccountnonlockedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("accountNonLocked not between", value1, value2, "accountnonlocked");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredIsNull() {
            addCriterion("credentialsNonExpired is null");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredIsNotNull() {
            addCriterion("credentialsNonExpired is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredEqualTo(Boolean value) {
            addCriterion("credentialsNonExpired =", value, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredNotEqualTo(Boolean value) {
            addCriterion("credentialsNonExpired <>", value, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredGreaterThan(Boolean value) {
            addCriterion("credentialsNonExpired >", value, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("credentialsNonExpired >=", value, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredLessThan(Boolean value) {
            addCriterion("credentialsNonExpired <", value, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("credentialsNonExpired <=", value, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredIn(List<Boolean> values) {
            addCriterion("credentialsNonExpired in", values, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredNotIn(List<Boolean> values) {
            addCriterion("credentialsNonExpired not in", values, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("credentialsNonExpired between", value1, value2, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsnonexpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("credentialsNonExpired not between", value1, value2, "credentialsnonexpired");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
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