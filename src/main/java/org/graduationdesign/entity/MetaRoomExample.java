package org.graduationdesign.entity;

import java.util.ArrayList;
import java.util.List;

public class MetaRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MetaRoomExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Long value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Long value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Long value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Long value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Long> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Long> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Long value1, Long value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andMetaIdIsNull() {
            addCriterion("meta_id is null");
            return (Criteria) this;
        }

        public Criteria andMetaIdIsNotNull() {
            addCriterion("meta_id is not null");
            return (Criteria) this;
        }

        public Criteria andMetaIdEqualTo(Integer value) {
            addCriterion("meta_id =", value, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdNotEqualTo(Integer value) {
            addCriterion("meta_id <>", value, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdGreaterThan(Integer value) {
            addCriterion("meta_id >", value, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("meta_id >=", value, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdLessThan(Integer value) {
            addCriterion("meta_id <", value, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdLessThanOrEqualTo(Integer value) {
            addCriterion("meta_id <=", value, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdIn(List<Integer> values) {
            addCriterion("meta_id in", values, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdNotIn(List<Integer> values) {
            addCriterion("meta_id not in", values, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdBetween(Integer value1, Integer value2) {
            addCriterion("meta_id between", value1, value2, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("meta_id not between", value1, value2, "metaId");
            return (Criteria) this;
        }

        public Criteria andMetaValueIsNull() {
            addCriterion("meta_value is null");
            return (Criteria) this;
        }

        public Criteria andMetaValueIsNotNull() {
            addCriterion("meta_value is not null");
            return (Criteria) this;
        }

        public Criteria andMetaValueEqualTo(String value) {
            addCriterion("meta_value =", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueNotEqualTo(String value) {
            addCriterion("meta_value <>", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueGreaterThan(String value) {
            addCriterion("meta_value >", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueGreaterThanOrEqualTo(String value) {
            addCriterion("meta_value >=", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueLessThan(String value) {
            addCriterion("meta_value <", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueLessThanOrEqualTo(String value) {
            addCriterion("meta_value <=", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueLike(String value) {
            addCriterion("meta_value like", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueNotLike(String value) {
            addCriterion("meta_value not like", value, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueIn(List<String> values) {
            addCriterion("meta_value in", values, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueNotIn(List<String> values) {
            addCriterion("meta_value not in", values, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueBetween(String value1, String value2) {
            addCriterion("meta_value between", value1, value2, "metaValue");
            return (Criteria) this;
        }

        public Criteria andMetaValueNotBetween(String value1, String value2) {
            addCriterion("meta_value not between", value1, value2, "metaValue");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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