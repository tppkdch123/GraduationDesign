package org.graduationdesign.service.impl;

import org.graduationdesign.entity.MetaRoom;
import org.graduationdesign.entity.MetaRoomExample;
import org.graduationdesign.entity.RoomExample;
import org.graduationdesign.entity.RoomExtend;
import org.graduationdesign.entity.RoomExtendExample;
import org.graduationdesign.entity.RoomWithBLOBs;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.MetaRoomMapper;
import org.graduationdesign.mappers.RoomExtendMapper;
import org.graduationdesign.mappers.RoomMapper;
import org.graduationdesign.service.MetaService;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.vo.MetaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomExtendMapper roomExtendMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    MetaService metaService;

    @Autowired
    MetaRoomMapper metaRoomMapper;

    @Override
    public void addNewRoom() throws HuangShiZheException {

    }

    @Override
    public List<RoomExtend> getRoomExtendById(Long id) throws HuangShiZheException {
        RoomExtendExample roomExtendExample = new RoomExtendExample();
        RoomExtendExample.Criteria criteria = roomExtendExample.createCriteria();
        criteria.andIdEqualTo(id).andRoomIdEqualTo(id);
        List<RoomExtend> roomExtendList = roomExtendMapper.selectByExample(roomExtendExample);
        return roomExtendList;
    }

    @Override
    public RoomWithBLOBs getRoomById(Long id) throws HuangShiZheException {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andIdEqualTo(id).andIsDeleteEqualTo(false);
        List<RoomWithBLOBs> roomWithBLOBsList = roomMapper.selectByExampleWithBLOBs(roomExample);

        if (CollectionUtils.isEmpty(roomWithBLOBsList)) {
            throw new HuangShiZheException(ResultCodeEnum.ROOM_NOT_EXIT);
        }

        return roomWithBLOBsList.get(0);
    }

    @Override
    public List<MetaVO> getMetaByRoomId(Long id) throws HuangShiZheException {
        MetaRoomExample metaRoomExample = new MetaRoomExample();
        MetaRoomExample.Criteria criteria = metaRoomExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andRoomIdEqualTo(id);
        List<MetaRoom> metaRoomList = metaRoomMapper.selectByExample(metaRoomExample);

        return null;
    }

    @Override
    public List<String> getPictureUrlByRoomId(Long id) throws HuangShiZheException {
        return null;
    }

    public List<MetaVO> ConvertMeta2VO(List<MetaRoom> metaRoomList){

    }
}
