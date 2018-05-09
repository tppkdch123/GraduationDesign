package org.graduationdesign.service.impl;

import org.graduationdesign.entity.Comment;
import org.graduationdesign.entity.CommentExample;
import org.graduationdesign.entity.Orders;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.CommentMapper;
import org.graduationdesign.service.CommentService;
import org.graduationdesign.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    OrderService orderService;

    @Override
    public void sendComments(@NotNull(message = "orderId不能为空") Long orderId, @NotNull(message = "content不能为空") String content, @NotNull(message = "分数不能为空") Integer score) throws HuangShiZheException {
        Comment comment = new Comment();
        comment.setChatScore(score);
        comment.setContent(content);
        comment.setIsDelete(false);
        comment.setOrderId(orderId);
        comment.setCostScore(score);
        comment.setIsAnonymous(false);
        commentMapper.insertSelective(comment);
    }

    @Override
    public List<Comment> getComments(@NotNull(message = "房源Id不能为空") Long roomId) throws HuangShiZheException {
        List<Long> orderIds = orderService.getOrdersByRoomId(roomId, 1, 100).getList().stream().map(Orders::getId).collect(Collectors.toList());
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andIsDeleteEqualTo(false).andOrderIdIn(orderIds).andIsAnonymousEqualTo(false);
        return commentMapper.selectByExample(commentExample);
    }
}
