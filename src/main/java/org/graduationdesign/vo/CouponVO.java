package org.graduationdesign.vo;

import lombok.Data;
import org.graduationdesign.entity.UserCoupon;

import java.io.Serializable;

@Data
public class CouponVO extends UserCoupon implements Serializable {

    private Float reduceAmount;

    private Float needAmount;

    private String description;
}
