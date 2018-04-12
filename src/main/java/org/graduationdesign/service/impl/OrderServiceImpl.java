package org.graduationdesign.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.graduationdesign.entity.Orders;
import org.graduationdesign.entity.OrdersExample;
import org.graduationdesign.entity.User;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.OrdersMapper;
import org.graduationdesign.service.OrderService;
import org.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersMapper orderMapper;

    @Autowired
    UserService userService;


    @Override
    public PageInfo<Orders> getOrdersByUser(HttpServletRequest httpServletRequest, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException {
        User user = userService.getCurrentUser(httpServletRequest);
        OrdersExample orderExample = new OrdersExample();
        OrdersExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUserIdEqualTo(user.getId()).andIsDeleteEqualTo(false);
        PageHelper.startPage(pageNum,size);
        List<Orders> ordersList=orderMapper.selectByExample(orderExample);
        PageInfo<Orders> pageInfo=new PageInfo<>(ordersList);
        return pageInfo;
    }

    @Override
    public PageInfo<Orders> getOrdersByUserId(@NotNull(message = "userId不能为空") Long userId, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException {
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria=ordersExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andIsDeleteEqualTo(false);
        PageHelper.startPage(pageNum,size);
        List<Orders> ordersList=orderMapper.selectByExample(ordersExample);
        return new PageInfo<>(ordersList);
    }

    @Override
    public PageInfo<Orders> getOrdersByProviderId(@NotNull(message = "providerId不能为空") Long providerId, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void generateOrder(@NotNull(message = "参数不能为空") Orders order,HttpServletRequest request) throws HuangShiZheException {
       order.setCreateTime(new Date());
       order.setUserId(userService.getCurrentUser(request).getId());
       order.setIsDelete(false);
       OrdersExample ordersExample=new OrdersExample();
       orderMapper.insertSelective(order);
    }

    @Override
    public PageInfo<Orders> getOrdersByRoomId(@NotNull(message = "roomId不能为空") Long roomId, @NotNull() Integer pageNum, @NotNull Integer size) throws HuangShiZheException {
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria=ordersExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andRoomIdEqualTo(roomId);
        PageHelper.startPage(pageNum,size);
        List<Orders> ordersList=orderMapper.selectByExample(ordersExample);
        if(CollectionUtils.isEmpty(ordersList)){
            throw new HuangShiZheException(ResultCodeEnum.ORDER_NOT_EXIT);
        }
        return new PageInfo<>(ordersList);
    }
}