package org.graduationdesign.entity;

import java.io.Serializable;

public class DatePrice extends DatePriceKey implements Serializable {
    private Float price;

    private static final long serialVersionUID = 1L;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}