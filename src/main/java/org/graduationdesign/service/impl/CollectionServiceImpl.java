package org.graduationdesign.service.impl;

import com.github.pagehelper.PageInfo;
import org.graduationdesign.entity.City;
import org.graduationdesign.entity.Collections;
import org.graduationdesign.entity.CollectionsExample;
import org.graduationdesign.entity.Province;
import org.graduationdesign.entity.Room;
import org.graduationdesign.entity.User;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.CollectionsMapper;
import org.graduationdesign.service.CollectionService;
import org.graduationdesign.service.LocationService;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.service.UserService;
import org.graduationdesign.vo.RoomVO;
import org.graduationdesign.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @Autowired
    LocationService locationService;

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
    public PageInfo<RoomVO> getCollections(HttpServletRequest request) throws HuangShiZheException{
        CollectionsExample collectionsExample=new CollectionsExample();
        collectionsExample.createCriteria().andUserIdEqualTo(userService.getCurrentUser(request).getId()).andIsDeleteEqualTo(false);
        List<Long> roomIds=collectionsMapper.selectByExample(collectionsExample).stream().map(Collections::getRoomId).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(roomIds)){
            return new PageInfo<>();
        }
        return new PageInfo<>(convertRoom2VO(roomService.getCollectionRoom(roomIds)));
    }

    @Override
    public void cancel(HttpServletRequest request,Long roomId) throws HuangShiZheException {
        CollectionsExample collectionsExample=new CollectionsExample();
        collectionsExample.createCriteria().andUserIdEqualTo(userService.getCurrentUser(request).getId()).andRoomIdEqualTo(roomId);
        List<Collections> collectionsList=collectionsMapper.selectByExample(collectionsExample);
        for(int i=0;i<collectionsList.size();i++){
            collectionsList.get(i).setIsDelete(collectionsList.get(i).getIsDelete()?false:true);
            collectionsMapper.updateByPrimaryKey(collectionsList.get(i));
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void click(HttpServletRequest request, Long roomId) throws HuangShiZheException {
        CollectionsExample collectionsExample=new CollectionsExample();
        collectionsExample.createCriteria().andRoomIdEqualTo(roomId).andUserIdEqualTo(userService.getCurrentUser(request).getId());
        List<Collections> collectionsList=collectionsMapper.selectByExample(collectionsExample);
        if(CollectionUtils.isEmpty(collectionsList)){
            collect(request,roomId);
        }
        else{
            for(int i=0;i<collectionsList.size();i++){
                collectionsList.get(i).setIsDelete(collectionsList.get(i).getIsDelete()?false:true);
                collectionsMapper.updateByPrimaryKey(collectionsList.get(i));
            }
        }
    }


    private List<RoomVO> convertRoom2VO(List<Room> rooms) throws HuangShiZheException{
        List<RoomVO> roomVOList=new ArrayList<>();
        for(int i=0;i<rooms.size();i++){
            Room room=rooms.get(i);
            RoomVO roomVO=new RoomVO();
            roomVO.setId(room.getId());
            roomVO.setInfo(room.getStructure()+"|"+room.getHostMessage()+"|最多可住"+room.getMaxCapacity()+"人|"+room.getBlock()+"|"+room.getBedCount());
            roomVO.setPicUrl(roomService.getPicUrlByRoomId(room.getId()));
            roomVO.setPrice(room.getDefaultPrice());
            roomVO.setTitle(room.getTitle());
            City city=locationService.getCityById(room.getCityId());
            Province province=locationService.getProvinceById(room.getProvinceId());
            roomVO.setProvince(province.getProvinceName());
            roomVO.setCity(city.getName());
            roomVO.setRoomArea(room.getUsableArea());
            UserVO user=userService.getUserInfoById(room.getProviderId());
            roomVO.setProviderName(user.getName());
            roomVO.setProviderUrl(user.getUserAvatarUrl());
            roomVOList.add(roomVO);
        }
        return roomVOList;
    }

}
