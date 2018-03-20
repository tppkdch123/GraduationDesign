package org.graduationdesign.entity;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreIsNull() {
            addCriterion("descript_score is null");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreIsNotNull() {
            addCriterion("descript_score is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreEqualTo(Integer value) {
            addCriterion("descript_score =", value, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreNotEqualTo(Integer value) {
            addCriterion("descript_score <>", value, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreGreaterThan(Integer value) {
            addCriterion("descript_score >", value, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("descript_score >=", value, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreLessThan(Integer value) {
            addCriterion("descript_score <", value, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreLessThanOrEqualTo(Integer value) {
            addCriterion("descript_score <=", value, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreIn(List<Integer> values) {
            addCriterion("descript_score in", values, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreNotIn(List<Integer> values) {
            addCriterion("descript_score not in", values, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreBetween(Integer value1, Integer value2) {
            addCriterion("descript_score between", value1, value2, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andDescriptScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("descript_score not between", value1, value2, "descriptScore");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIsNull() {
            addCriterion("is_anonymous is null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIsNotNull() {
            addCriterion("is_anonymous is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousEqualTo(Boolean value) {
            addCriterion("is_anonymous =", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotEqualTo(Boolean value) {
            addCriterion("is_anonymous <>", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousGreaterThan(Boolean value) {
            addCriterion("is_anonymous >", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_anonymous >=", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousLessThan(Boolean value) {
            addCriterion("is_anonymous <", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousLessThanOrEqualTo(Boolean value) {
            addCriterion("is_anonymous <=", value, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousIn(List<Boolean> values) {
            addCriterion("is_anonymous in", values, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotIn(List<Boolean> values) {
            addCriterion("is_anonymous not in", values, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousBetween(Boolean value1, Boolean value2) {
            addCriterion("is_anonymous between", value1, value2, "isAnonymous");
            return (Criteria) this;
        }

        public Criteria andIsAnonymousNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_anonymous not between", value1, value2, "isAnonymous");
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

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andChatScoreIsNull() {
            addCriterion("chat_score is null");
            return (Criteria) this;
        }

        public Criteria andChatScoreIsNotNull() {
            addCriterion("chat_score is not null");
            return (Criteria) this;
        }

        public Criteria andChatScoreEqualTo(Integer value) {
            addCriterion("chat_score =", value, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreNotEqualTo(Integer value) {
            addCriterion("chat_score <>", value, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreGreaterThan(Integer value) {
            addCriterion("chat_score >", value, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_score >=", value, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreLessThan(Integer value) {
            addCriterion("chat_score <", value, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreLessThanOrEqualTo(Integer value) {
            addCriterion("chat_score <=", value, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreIn(List<Integer> values) {
            addCriterion("chat_score in", values, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreNotIn(List<Integer> values) {
            addCriterion("chat_score not in", values, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreBetween(Integer value1, Integer value2) {
            addCriterion("chat_score between", value1, value2, "chatScore");
            return (Criteria) this;
        }

        public Criteria andChatScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_score not between", value1, value2, "chatScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreIsNull() {
            addCriterion("hyginene_score is null");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreIsNotNull() {
            addCriterion("hyginene_score is not null");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreEqualTo(Integer value) {
            addCriterion("hyginene_score =", value, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreNotEqualTo(Integer value) {
            addCriterion("hyginene_score <>", value, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreGreaterThan(Integer value) {
            addCriterion("hyginene_score >", value, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("hyginene_score >=", value, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreLessThan(Integer value) {
            addCriterion("hyginene_score <", value, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreLessThanOrEqualTo(Integer value) {
            addCriterion("hyginene_score <=", value, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreIn(List<Integer> values) {
            addCriterion("hyginene_score in", values, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreNotIn(List<Integer> values) {
            addCriterion("hyginene_score not in", values, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreBetween(Integer value1, Integer value2) {
            addCriterion("hyginene_score between", value1, value2, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andHygineneScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("hyginene_score not between", value1, value2, "hygineneScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreIsNull() {
            addCriterion("location_score is null");
            return (Criteria) this;
        }

        public Criteria andLocationScoreIsNotNull() {
            addCriterion("location_score is not null");
            return (Criteria) this;
        }

        public Criteria andLocationScoreEqualTo(Integer value) {
            addCriterion("location_score =", value, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreNotEqualTo(Integer value) {
            addCriterion("location_score <>", value, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreGreaterThan(Integer value) {
            addCriterion("location_score >", value, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_score >=", value, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreLessThan(Integer value) {
            addCriterion("location_score <", value, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreLessThanOrEqualTo(Integer value) {
            addCriterion("location_score <=", value, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreIn(List<Integer> values) {
            addCriterion("location_score in", values, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreNotIn(List<Integer> values) {
            addCriterion("location_score not in", values, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreBetween(Integer value1, Integer value2) {
            addCriterion("location_score between", value1, value2, "locationScore");
            return (Criteria) this;
        }

        public Criteria andLocationScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("location_score not between", value1, value2, "locationScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreIsNull() {
            addCriterion("cost_score is null");
            return (Criteria) this;
        }

        public Criteria andCostScoreIsNotNull() {
            addCriterion("cost_score is not null");
            return (Criteria) this;
        }

        public Criteria andCostScoreEqualTo(Integer value) {
            addCriterion("cost_score =", value, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreNotEqualTo(Integer value) {
            addCriterion("cost_score <>", value, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreGreaterThan(Integer value) {
            addCriterion("cost_score >", value, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost_score >=", value, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreLessThan(Integer value) {
            addCriterion("cost_score <", value, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreLessThanOrEqualTo(Integer value) {
            addCriterion("cost_score <=", value, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreIn(List<Integer> values) {
            addCriterion("cost_score in", values, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreNotIn(List<Integer> values) {
            addCriterion("cost_score not in", values, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreBetween(Integer value1, Integer value2) {
            addCriterion("cost_score between", value1, value2, "costScore");
            return (Criteria) this;
        }

        public Criteria andCostScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("cost_score not between", value1, value2, "costScore");
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