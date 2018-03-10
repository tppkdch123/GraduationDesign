package org.graduationdesign.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(Long value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(Long value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(Long value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(Long value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(Long value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<Long> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<Long> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(Long value1, Long value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(Long value1, Long value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIsNull() {
            addCriterion("default_price is null");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIsNotNull() {
            addCriterion("default_price is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceEqualTo(Float value) {
            addCriterion("default_price =", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotEqualTo(Float value) {
            addCriterion("default_price <>", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceGreaterThan(Float value) {
            addCriterion("default_price >", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("default_price >=", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceLessThan(Float value) {
            addCriterion("default_price <", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceLessThanOrEqualTo(Float value) {
            addCriterion("default_price <=", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIn(List<Float> values) {
            addCriterion("default_price in", values, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotIn(List<Float> values) {
            addCriterion("default_price not in", values, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceBetween(Float value1, Float value2) {
            addCriterion("default_price between", value1, value2, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotBetween(Float value1, Float value2) {
            addCriterion("default_price not between", value1, value2, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityIsNull() {
            addCriterion("max_capacity is null");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityIsNotNull() {
            addCriterion("max_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityEqualTo(Integer value) {
            addCriterion("max_capacity =", value, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityNotEqualTo(Integer value) {
            addCriterion("max_capacity <>", value, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityGreaterThan(Integer value) {
            addCriterion("max_capacity >", value, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_capacity >=", value, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityLessThan(Integer value) {
            addCriterion("max_capacity <", value, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("max_capacity <=", value, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityIn(List<Integer> values) {
            addCriterion("max_capacity in", values, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityNotIn(List<Integer> values) {
            addCriterion("max_capacity not in", values, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityBetween(Integer value1, Integer value2) {
            addCriterion("max_capacity between", value1, value2, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andMaxCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("max_capacity not between", value1, value2, "maxCapacity");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andUsableAreaIsNull() {
            addCriterion("usable_area is null");
            return (Criteria) this;
        }

        public Criteria andUsableAreaIsNotNull() {
            addCriterion("usable_area is not null");
            return (Criteria) this;
        }

        public Criteria andUsableAreaEqualTo(Integer value) {
            addCriterion("usable_area =", value, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaNotEqualTo(Integer value) {
            addCriterion("usable_area <>", value, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaGreaterThan(Integer value) {
            addCriterion("usable_area >", value, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("usable_area >=", value, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaLessThan(Integer value) {
            addCriterion("usable_area <", value, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaLessThanOrEqualTo(Integer value) {
            addCriterion("usable_area <=", value, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaIn(List<Integer> values) {
            addCriterion("usable_area in", values, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaNotIn(List<Integer> values) {
            addCriterion("usable_area not in", values, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaBetween(Integer value1, Integer value2) {
            addCriterion("usable_area between", value1, value2, "usableArea");
            return (Criteria) this;
        }

        public Criteria andUsableAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("usable_area not between", value1, value2, "usableArea");
            return (Criteria) this;
        }

        public Criteria andStructureIsNull() {
            addCriterion("structure is null");
            return (Criteria) this;
        }

        public Criteria andStructureIsNotNull() {
            addCriterion("structure is not null");
            return (Criteria) this;
        }

        public Criteria andStructureEqualTo(String value) {
            addCriterion("structure =", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotEqualTo(String value) {
            addCriterion("structure <>", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureGreaterThan(String value) {
            addCriterion("structure >", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureGreaterThanOrEqualTo(String value) {
            addCriterion("structure >=", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureLessThan(String value) {
            addCriterion("structure <", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureLessThanOrEqualTo(String value) {
            addCriterion("structure <=", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureLike(String value) {
            addCriterion("structure like", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotLike(String value) {
            addCriterion("structure not like", value, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureIn(List<String> values) {
            addCriterion("structure in", values, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotIn(List<String> values) {
            addCriterion("structure not in", values, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureBetween(String value1, String value2) {
            addCriterion("structure between", value1, value2, "structure");
            return (Criteria) this;
        }

        public Criteria andStructureNotBetween(String value1, String value2) {
            addCriterion("structure not between", value1, value2, "structure");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAroundInfoIsNull() {
            addCriterion("around_info is null");
            return (Criteria) this;
        }

        public Criteria andAroundInfoIsNotNull() {
            addCriterion("around_info is not null");
            return (Criteria) this;
        }

        public Criteria andAroundInfoEqualTo(String value) {
            addCriterion("around_info =", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoNotEqualTo(String value) {
            addCriterion("around_info <>", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoGreaterThan(String value) {
            addCriterion("around_info >", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoGreaterThanOrEqualTo(String value) {
            addCriterion("around_info >=", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoLessThan(String value) {
            addCriterion("around_info <", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoLessThanOrEqualTo(String value) {
            addCriterion("around_info <=", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoLike(String value) {
            addCriterion("around_info like", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoNotLike(String value) {
            addCriterion("around_info not like", value, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoIn(List<String> values) {
            addCriterion("around_info in", values, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoNotIn(List<String> values) {
            addCriterion("around_info not in", values, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoBetween(String value1, String value2) {
            addCriterion("around_info between", value1, value2, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andAroundInfoNotBetween(String value1, String value2) {
            addCriterion("around_info not between", value1, value2, "aroundInfo");
            return (Criteria) this;
        }

        public Criteria andRealCheckIsNull() {
            addCriterion("real_check is null");
            return (Criteria) this;
        }

        public Criteria andRealCheckIsNotNull() {
            addCriterion("real_check is not null");
            return (Criteria) this;
        }

        public Criteria andRealCheckEqualTo(Byte value) {
            addCriterion("real_check =", value, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckNotEqualTo(Byte value) {
            addCriterion("real_check <>", value, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckGreaterThan(Byte value) {
            addCriterion("real_check >", value, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckGreaterThanOrEqualTo(Byte value) {
            addCriterion("real_check >=", value, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckLessThan(Byte value) {
            addCriterion("real_check <", value, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckLessThanOrEqualTo(Byte value) {
            addCriterion("real_check <=", value, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckIn(List<Byte> values) {
            addCriterion("real_check in", values, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckNotIn(List<Byte> values) {
            addCriterion("real_check not in", values, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckBetween(Byte value1, Byte value2) {
            addCriterion("real_check between", value1, value2, "realCheck");
            return (Criteria) this;
        }

        public Criteria andRealCheckNotBetween(Byte value1, Byte value2) {
            addCriterion("real_check not between", value1, value2, "realCheck");
            return (Criteria) this;
        }

        public Criteria andBedCountIsNull() {
            addCriterion("bed_count is null");
            return (Criteria) this;
        }

        public Criteria andBedCountIsNotNull() {
            addCriterion("bed_count is not null");
            return (Criteria) this;
        }

        public Criteria andBedCountEqualTo(Integer value) {
            addCriterion("bed_count =", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountNotEqualTo(Integer value) {
            addCriterion("bed_count <>", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountGreaterThan(Integer value) {
            addCriterion("bed_count >", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bed_count >=", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountLessThan(Integer value) {
            addCriterion("bed_count <", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountLessThanOrEqualTo(Integer value) {
            addCriterion("bed_count <=", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountIn(List<Integer> values) {
            addCriterion("bed_count in", values, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountNotIn(List<Integer> values) {
            addCriterion("bed_count not in", values, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountBetween(Integer value1, Integer value2) {
            addCriterion("bed_count between", value1, value2, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("bed_count not between", value1, value2, "bedCount");
            return (Criteria) this;
        }

        public Criteria andCommentNumberIsNull() {
            addCriterion("comment_number is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumberIsNotNull() {
            addCriterion("comment_number is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumberEqualTo(Integer value) {
            addCriterion("comment_number =", value, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberNotEqualTo(Integer value) {
            addCriterion("comment_number <>", value, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberGreaterThan(Integer value) {
            addCriterion("comment_number >", value, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_number >=", value, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberLessThan(Integer value) {
            addCriterion("comment_number <", value, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberLessThanOrEqualTo(Integer value) {
            addCriterion("comment_number <=", value, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberIn(List<Integer> values) {
            addCriterion("comment_number in", values, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberNotIn(List<Integer> values) {
            addCriterion("comment_number not in", values, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberBetween(Integer value1, Integer value2) {
            addCriterion("comment_number between", value1, value2, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andCommentNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_number not between", value1, value2, "commentNumber");
            return (Criteria) this;
        }

        public Criteria andHostMessageIsNull() {
            addCriterion("host_message is null");
            return (Criteria) this;
        }

        public Criteria andHostMessageIsNotNull() {
            addCriterion("host_message is not null");
            return (Criteria) this;
        }

        public Criteria andHostMessageEqualTo(String value) {
            addCriterion("host_message =", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageNotEqualTo(String value) {
            addCriterion("host_message <>", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageGreaterThan(String value) {
            addCriterion("host_message >", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageGreaterThanOrEqualTo(String value) {
            addCriterion("host_message >=", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageLessThan(String value) {
            addCriterion("host_message <", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageLessThanOrEqualTo(String value) {
            addCriterion("host_message <=", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageLike(String value) {
            addCriterion("host_message like", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageNotLike(String value) {
            addCriterion("host_message not like", value, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageIn(List<String> values) {
            addCriterion("host_message in", values, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageNotIn(List<String> values) {
            addCriterion("host_message not in", values, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageBetween(String value1, String value2) {
            addCriterion("host_message between", value1, value2, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andHostMessageNotBetween(String value1, String value2) {
            addCriterion("host_message not between", value1, value2, "hostMessage");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Long value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Long value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Long value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Long value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Long value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Long value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Long> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Long> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Long value1, Long value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Long value1, Long value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Long value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Long value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Long value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Long value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Long value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Long value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Long> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Long> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Long value1, Long value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Long value1, Long value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andStreetIsNull() {
            addCriterion("street is null");
            return (Criteria) this;
        }

        public Criteria andStreetIsNotNull() {
            addCriterion("street is not null");
            return (Criteria) this;
        }

        public Criteria andStreetEqualTo(String value) {
            addCriterion("street =", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotEqualTo(String value) {
            addCriterion("street <>", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThan(String value) {
            addCriterion("street >", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThanOrEqualTo(String value) {
            addCriterion("street >=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThan(String value) {
            addCriterion("street <", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThanOrEqualTo(String value) {
            addCriterion("street <=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLike(String value) {
            addCriterion("street like", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotLike(String value) {
            addCriterion("street not like", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetIn(List<String> values) {
            addCriterion("street in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotIn(List<String> values) {
            addCriterion("street not in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetBetween(String value1, String value2) {
            addCriterion("street between", value1, value2, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotBetween(String value1, String value2) {
            addCriterion("street not between", value1, value2, "street");
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

        public Criteria andIsOnsaleIsNull() {
            addCriterion("is_onsale is null");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleIsNotNull() {
            addCriterion("is_onsale is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleEqualTo(Byte value) {
            addCriterion("is_onsale =", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleNotEqualTo(Byte value) {
            addCriterion("is_onsale <>", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleGreaterThan(Byte value) {
            addCriterion("is_onsale >", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_onsale >=", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleLessThan(Byte value) {
            addCriterion("is_onsale <", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleLessThanOrEqualTo(Byte value) {
            addCriterion("is_onsale <=", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleIn(List<Byte> values) {
            addCriterion("is_onsale in", values, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleNotIn(List<Byte> values) {
            addCriterion("is_onsale not in", values, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleBetween(Byte value1, Byte value2) {
            addCriterion("is_onsale between", value1, value2, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleNotBetween(Byte value1, Byte value2) {
            addCriterion("is_onsale not between", value1, value2, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Long value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Long value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Long value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Long value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Long value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Long value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Long> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Long> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Long value1, Long value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Long value1, Long value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andBlockIsNull() {
            addCriterion("block is null");
            return (Criteria) this;
        }

        public Criteria andBlockIsNotNull() {
            addCriterion("block is not null");
            return (Criteria) this;
        }

        public Criteria andBlockEqualTo(String value) {
            addCriterion("block =", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotEqualTo(String value) {
            addCriterion("block <>", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockGreaterThan(String value) {
            addCriterion("block >", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockGreaterThanOrEqualTo(String value) {
            addCriterion("block >=", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockLessThan(String value) {
            addCriterion("block <", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockLessThanOrEqualTo(String value) {
            addCriterion("block <=", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockLike(String value) {
            addCriterion("block like", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotLike(String value) {
            addCriterion("block not like", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockIn(List<String> values) {
            addCriterion("block in", values, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotIn(List<String> values) {
            addCriterion("block not in", values, "block");
            return (Criteria) this;
        }

        public Criteria andBlockBetween(String value1, String value2) {
            addCriterion("block between", value1, value2, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotBetween(String value1, String value2) {
            addCriterion("block not between", value1, value2, "block");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Long> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Long> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysIsNull() {
            addCriterion("move_up_cancel_days is null");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysIsNotNull() {
            addCriterion("move_up_cancel_days is not null");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysEqualTo(Integer value) {
            addCriterion("move_up_cancel_days =", value, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysNotEqualTo(Integer value) {
            addCriterion("move_up_cancel_days <>", value, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysGreaterThan(Integer value) {
            addCriterion("move_up_cancel_days >", value, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("move_up_cancel_days >=", value, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysLessThan(Integer value) {
            addCriterion("move_up_cancel_days <", value, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysLessThanOrEqualTo(Integer value) {
            addCriterion("move_up_cancel_days <=", value, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysIn(List<Integer> values) {
            addCriterion("move_up_cancel_days in", values, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysNotIn(List<Integer> values) {
            addCriterion("move_up_cancel_days not in", values, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysBetween(Integer value1, Integer value2) {
            addCriterion("move_up_cancel_days between", value1, value2, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andMoveUpCancelDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("move_up_cancel_days not between", value1, value2, "moveUpCancelDays");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeIsNull() {
            addCriterion("earliest_check_in_time is null");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeIsNotNull() {
            addCriterion("earliest_check_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeEqualTo(String value) {
            addCriterion("earliest_check_in_time =", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeNotEqualTo(String value) {
            addCriterion("earliest_check_in_time <>", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeGreaterThan(String value) {
            addCriterion("earliest_check_in_time >", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeGreaterThanOrEqualTo(String value) {
            addCriterion("earliest_check_in_time >=", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeLessThan(String value) {
            addCriterion("earliest_check_in_time <", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeLessThanOrEqualTo(String value) {
            addCriterion("earliest_check_in_time <=", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeLike(String value) {
            addCriterion("earliest_check_in_time like", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeNotLike(String value) {
            addCriterion("earliest_check_in_time not like", value, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeIn(List<String> values) {
            addCriterion("earliest_check_in_time in", values, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeNotIn(List<String> values) {
            addCriterion("earliest_check_in_time not in", values, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeBetween(String value1, String value2) {
            addCriterion("earliest_check_in_time between", value1, value2, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andEarliestCheckInTimeNotBetween(String value1, String value2) {
            addCriterion("earliest_check_in_time not between", value1, value2, "earliestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeIsNull() {
            addCriterion("lastest_check_in_time is null");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeIsNotNull() {
            addCriterion("lastest_check_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeEqualTo(String value) {
            addCriterion("lastest_check_in_time =", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeNotEqualTo(String value) {
            addCriterion("lastest_check_in_time <>", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeGreaterThan(String value) {
            addCriterion("lastest_check_in_time >", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeGreaterThanOrEqualTo(String value) {
            addCriterion("lastest_check_in_time >=", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeLessThan(String value) {
            addCriterion("lastest_check_in_time <", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeLessThanOrEqualTo(String value) {
            addCriterion("lastest_check_in_time <=", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeLike(String value) {
            addCriterion("lastest_check_in_time like", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeNotLike(String value) {
            addCriterion("lastest_check_in_time not like", value, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeIn(List<String> values) {
            addCriterion("lastest_check_in_time in", values, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeNotIn(List<String> values) {
            addCriterion("lastest_check_in_time not in", values, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeBetween(String value1, String value2) {
            addCriterion("lastest_check_in_time between", value1, value2, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckInTimeNotBetween(String value1, String value2) {
            addCriterion("lastest_check_in_time not between", value1, value2, "lastestCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeIsNull() {
            addCriterion("lastest_check_out_time is null");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeIsNotNull() {
            addCriterion("lastest_check_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeEqualTo(String value) {
            addCriterion("lastest_check_out_time =", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeNotEqualTo(String value) {
            addCriterion("lastest_check_out_time <>", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeGreaterThan(String value) {
            addCriterion("lastest_check_out_time >", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("lastest_check_out_time >=", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeLessThan(String value) {
            addCriterion("lastest_check_out_time <", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeLessThanOrEqualTo(String value) {
            addCriterion("lastest_check_out_time <=", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeLike(String value) {
            addCriterion("lastest_check_out_time like", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeNotLike(String value) {
            addCriterion("lastest_check_out_time not like", value, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeIn(List<String> values) {
            addCriterion("lastest_check_out_time in", values, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeNotIn(List<String> values) {
            addCriterion("lastest_check_out_time not in", values, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeBetween(String value1, String value2) {
            addCriterion("lastest_check_out_time between", value1, value2, "lastestCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andLastestCheckOutTimeNotBetween(String value1, String value2) {
            addCriterion("lastest_check_out_time not between", value1, value2, "lastestCheckOutTime");
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