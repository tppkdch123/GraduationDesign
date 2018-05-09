package org.graduationdesign.service;

import org.checkerframework.checker.nullness.compatqual.NullableType;
import org.graduationdesign.entity.Comment;
import org.graduationdesign.exception.HuangShiZheException;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CommentService {
    public void sendComments(@NotNull(message="orderId不能为空") Long orderId,@NotNull(message = "content不能为空") String content,@NotNull(message = "分数不能为空") Integer score) throws HuangShiZheException;

    public List<Comment> getComments(@NotNull(message="房源Id不能为空") Long roomId) throws HuangShiZheException;
}
