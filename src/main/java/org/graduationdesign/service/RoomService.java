package org.graduationdesign.service;

import org.graduationdesign.entity.RoomExtend;
import org.graduationdesign.entity.RoomWithBLOBs;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.vo.MetaVO;

import java.util.List;

public interface RoomService {
    void addNewRoom() throws HuangShiZheException;

    List<RoomExtend> getRoomExtendById(Long id) throws HuangShiZheException;

    RoomWithBLOBs getRoomById(Long id) throws HuangShiZheException;

    List<MetaVO> getMetaByRoomId(Long id) throws HuangShiZheException;

    List<String> getPictureUrlByRoomId(Long id) throws HuangShiZheException;
}
