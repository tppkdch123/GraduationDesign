package org.graduationdesign.service.impl;

import org.graduationdesign.entity.Coupon;
import org.graduationdesign.entity.CouponExample;
import org.graduationdesign.entity.User;
import org.graduationdesign.entity.UserCoupon;
import org.graduationdesign.entity.UserCouponExample;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.CouponMapper;
import org.graduationdesign.mappers.UserCouponMapper;
import org.graduationdesign.service.CouponService;
import org.graduationdesign.service.UserService;
import org.graduationdesign.vo.CouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponServiceImpl implements CouponService {

    private static

    @Autowired
    UserService userService;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    UserCouponMapper userCouponMapper;

    @Override
    public void addNewCouponService(@NotNull(message = "参数不能为空") Coupon coupon) throws HuangShiZheException {

    }

    @Override
    public List<CouponVO> getSelfCoupon(HttpServletRequest request) throws HuangShiZheException {
        User user = userService.getCurrentUser(request);
        UserCouponExample userCouponExample = new UserCouponExample();
        UserCouponExample.Criteria criteria = userCouponExample.createCriteria();
        Date date = new Date();
        criteria.andUserIdEqualTo(user.getId()).andStartTimeLessThan(date).andEndTimeLessThanOrEqualTo(date);
        List<UserCoupon> userCoupons = userCouponMapper.selectByExample(userCouponExample);
        List<CouponVO> couponVOS = userCoupons.stream().map(userCoupon -> {
            return convertUserCoupon2VO(userCoupon);
        }).collect(Collectors.toList());
        return couponVOS;
    }

    @Override
    public void getCoupon(@NotNull(message = "couponId不能为空") Long couponId, HttpServletRequest request) throws HuangShiZheException {

    }

    @Override
    public void giveCoupon(@NotNull(message = "couponId不能为空") Long couponId, Long userId, Long startTime, Long endTime) throws HuangShiZheException {
        UserCouponExample userCouponExample = new UserCouponExample();
        if (!ifConponExit(couponId)) {
            throw new HuangShiZheException(ResultCodeEnum.COUPON_NOT_EXIST);
        }
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setCouponId(couponId);
        userCoupon.setCreateTime(new Date());
        userCoupon.setStartTime(new Date(startTime));
        userCoupon.setEndTime(new Date(endTime));
        userCoupon.setIsInvalid(false);
        userCoupon.setUserId(userId);
        userCouponMapper.insertSelective(userCoupon);
    }

    private Boolean ifConponExit(Long couponId) throws HuangShiZheException {
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andIdEqualTo(couponId);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        if (CollectionUtils.isEmpty(coupons)) {
            return false;
        }
        return true;
    }

    private CouponVO convertUserCoupon2VO(UserCoupon userCoupon) {
        CouponVO couponVO = new CouponVO();
        if (userCoupon == null) {
            return couponVO;
        }
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andIdEqualTo(userCoupon.getCouponId());
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        if (CollectionUtils.isEmpty(coupons)) {
            return couponVO;
        }
        Coupon coupon = coupons.get(0);
        couponVO.setDescription(coupon.getDescription());
        couponVO.setNeedAmount(coupon.getNeedAmount());
        couponVO.setReduceAmount(coupon.getReduceAmount());
        couponVO.setCouponId(userCoupon.getCouponId());
        couponVO.setId(userCoupon.getId());
        couponVO.setCreateTime(userCoupon.getCreateTime());
        couponVO.setEndTime(userCoupon.getEndTime());
        couponVO.setIsInvalid(userCoupon.getIsInvalid());
        couponVO.setStartTime(userCoupon.getStartTime());
        return couponVO;
    }
}
