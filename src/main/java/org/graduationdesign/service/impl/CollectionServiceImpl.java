package org.graduationdesign.service.impl;

import org.graduationdesign.entity.Collections;
import org.graduationdesign.entity.CollectionsExample;
import org.graduationdesign.entity.Comment;
import org.graduationdesign.entity.Room;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.CollectionsMapper;
import org.graduationdesign.service.CollectionService;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.service.UserService;
import org.graduationdesign.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionsMapper collectionsMapper;

    @Autowired
    UserService userService;


    @Autowired
    RoomService roomService;

    @Override
    public void collect(HttpServletRequest request, Long roomId) throws HuangShiZheException{
        if(!roomService.ifRoomExist(roomId)){
            throw new HuangShiZheException(ResultCodeEnum.ROOM_NOT_EXIT);
        }
        Collections collections=new Collections();
        collections.setCreateTime(new Date());
        collections.setIsDelete(false);
        collections.setUpdateTime(new Date());
        collections.setRoomId(roomId);
        collections.setUserId(userService.getCurrentUser(request).getId());
        collectionsMapper.insertSelective(collections);
    }

    @Override
    public List<RoomVO> getCollections(HttpServletRequest request) throws HuangShiZheException{
        CollectionsExample collectionsExample=new CollectionsExample();
        collectionsExample.createCriteria().andUserIdEqualTo(userService.getCurrentUser(request).getId()).andIsDeleteEqualTo(false);
        List<Long> roomIds=collectionsMapper.selectByExample(collectionsExample).stream().map(Collections::getRoomId).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(roomIds)){
            return new ArrayList<>();
        }
        return convertRoom2VO(roomService.getCollectionRoom(roomIds));
    }

    @Override
    public void cancel(HttpServletRequest request,Long roomId) throws HuangShiZheException {
        Collections collections1=new Collections();
        collections1.setIsDelete(true);
        CollectionsExample collectionsExample=new CollectionsExample();
        collectionsExample.createCriteria().andIsDeleteEqualTo(false).andUserIdEqualTo(userService.getCurrentUser(request).getId()).andRoomIdEqualTo(roomId);
        int u=collectionsMapper.updateByExampleSelective(collections1,collectionsExample);
        if(u<=0){
            throw new HuangShiZheException(ResultCodeEnum.NOT_COLLECT);
        }
    }


    private List<RoomVO> convertRoom2VO(List<Room> rooms) throws HuangShiZheException{
        List<RoomVO> roomVOList=new ArrayList<>();
        for(int i=0;i<rooms.size();i++){
            Room room=rooms.get(i);
            RoomVO roomVO=new RoomVO();
            roomVO.setId(room.getId());
            roomVO.setInfo(room.getStructure());
            roomVO.setPicUrl(roomService.getPicUrlByRoomId(room.getId()));
            roomVOList.add(roomVO);
        }
        return roomVOList;
    }
}
