package org.graduationdesign.service;

import com.github.pagehelper.PageInfo;
import org.graduationdesign.entity.Room;
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

    PageInfo<Room> getRoomByCity(@NotNull(message = "cityId不能为空") Integer cityId, @NotNull Integer pageNum, @NotNull Integer size) throws HuangShiZheException;

    Boolean ifRoomExist(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException;

    Room getRoom(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException;

    List<Room> getCollectionRoom(@NotNull List<Long> roomIds) throws HuangShiZheException;

    String getPicUrlByRoomId(@NotNull Long roomId) throws HuangShiZheException;
}
