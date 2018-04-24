package org.graduationdesign.service;

import org.graduationdesign.entity.Coupon;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.vo.CouponVO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface CouponService {
    void addNewCouponService(@NotNull(message = "参数不能为空") Coupon coupon) throws HuangShiZheException;

    List<CouponVO> getSelfCoupon(HttpServletRequest request) throws HuangShiZheException;

    void getCoupon(@NotNull(message = "couponId不能为空") Long couponId, HttpServletRequest request) throws HuangShiZheException;

    void giveCoupon(@NotNull(message = "couponId不能为空") Long couponId, Long userId, Long startTime, Long endTime) throws HuangShiZheException;
}
