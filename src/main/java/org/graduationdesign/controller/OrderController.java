package org.graduationdesign.controller;

import com.github.pagehelper.PageInfo;
import org.graduationdesign.entity.Orders;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.service.OrderService;
import org.graduationdesign.util.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends BaseController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/watch",method = RequestMethod.GET)
    public UnifiedResponse getOrders(HttpServletRequest request, @RequestParam Integer pageNum, @RequestParam Integer size) throws HuangShiZheException {
        PageInfo<Orders> ordersPageInfo = orderService.getOrdersByUser(request, pageNum, size);
        return new UnifiedResponse(ordersPageInfo);
    }

    @RequestMapping(value="/room-orders",method = RequestMethod.GET)
    public UnifiedResponse getOrderByRoomId(Long roomId,Integer pageNum,Integer size) throws HuangShiZheException{
        PageInfo<Orders> ordersPageInfo=orderService.getOrdersByRoomId(roomId, pageNum, size);
        return new UnifiedResponse(ordersPageInfo);
    }
}
