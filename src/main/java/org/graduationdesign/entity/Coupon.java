package org.graduationdesign.entity;

import java.io.Serializable;

public class Coupon implements Serializable {
    private Long id;

    private Float reduceAmount;

    private Float needAmount;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(Float reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Float getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(Float needAmount) {
        this.needAmount = needAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}