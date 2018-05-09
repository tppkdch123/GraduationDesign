package org.graduationdesign.service;

import com.github.pagehelper.PageInfo;
import org.graduationdesign.entity.Orders;
import org.graduationdesign.exception.HuangShiZheException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

public interface OrderService {
    PageInfo<Orders> getOrdersByUser(HttpServletRequest httpServletRequest, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException;

    PageInfo<Orders> getOrdersByUserId(@NotNull(message = "userId不能为空") Long userId, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException;

    PageInfo<Orders> getOrdersByProviderId(@NotNull(message = "prividerId不能为空") Long providerId, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException;

    void generateOrder(@NotNull(message = "参数不能为空") Orders order, HttpServletRequest request, Long couponId) throws HuangShiZheException;

    PageInfo<Orders> getOrdersByRoomId(@NotNull(message = "roomId不能为空") Long roomId, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException;
}
