package org.graduationdesign.service;

import org.graduationdesign.entity.RoomExtend;
import org.graduationdesign.entity.RoomWithBLOBs;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.vo.MetaVO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface RoomService {
    void addNewRoom(@NotNull(message = "参数不能为空") RoomWithBLOBs roomWithBLOBs, HttpServletRequest request) throws HuangShiZheException;

    List<RoomExtend> getRoomExtendById(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException;

    RoomWithBLOBs getRoomById(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException;

    List<MetaVO> getMetaByRoomId(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException;

    List<RoomExtend> getPictureUrlByRoomId(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException;
}
