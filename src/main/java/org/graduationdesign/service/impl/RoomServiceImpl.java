package org.graduationdesign.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.graduationdesign.entity.City;
import org.graduationdesign.entity.Meta;
import org.graduationdesign.entity.MetaRoom;
import org.graduationdesign.entity.MetaRoomExample;
import org.graduationdesign.entity.Provider;
import org.graduationdesign.entity.Province;
import org.graduationdesign.entity.Room;
import org.graduationdesign.entity.RoomExample;
import org.graduationdesign.entity.RoomExtend;
import org.graduationdesign.entity.RoomExtendExample;
import org.graduationdesign.entity.RoomWithBLOBs;
import org.graduationdesign.entity.User;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.MetaRoomMapper;
import org.graduationdesign.mappers.RoomExtendMapper;
import org.graduationdesign.mappers.RoomMapper;
import org.graduationdesign.service.LocationService;
import org.graduationdesign.service.MetaService;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.service.UserService;
import org.graduationdesign.vo.MetaVO;
import org.graduationdesign.vo.RoomVO;
import org.graduationdesign.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Autowired
    RoomExtendMapper roomExtendMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    MetaService metaService;

    @Autowired
    MetaRoomMapper metaRoomMapper;

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    @Autowired
    RoomService roomService;

    @Override
    public void addNewRoom(RoomWithBLOBs roomWithBLOBs, HttpServletRequest httpServletRequest) throws HuangShiZheException {
        roomWithBLOBs.setUpdateTime(new Date());
        roomWithBLOBs.setCreateTime(new Date());
        User user = userService.getCurrentUser(httpServletRequest);
        Provider provider = userService.getProviderByUserId(user.getId());
        roomWithBLOBs.setIsDelete(false);
        roomWithBLOBs.setProviderId(provider.getId());
        roomMapper.insert(roomWithBLOBs);
    }

    @Override
    public List<RoomExtend> getRoomExtendById(Long id) throws HuangShiZheException {
        RoomExtendExample roomExtendExample = new RoomExtendExample();
        RoomExtendExample.Criteria criteria = roomExtendExample.createCriteria();
        criteria.andRoomIdEqualTo(id);
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
        return generateMetaVO(metaRoomList);
    }

    @Override
    public List<RoomExtend> getPictureUrlByRoomId(Long id) throws HuangShiZheException {
        RoomExtendExample roomExample = new RoomExtendExample();
        RoomExtendExample.Criteria criteria = roomExample.createCriteria();
        criteria.andRoomIdEqualTo(id).andTypeEqualTo(0);
        List<RoomExtend> roomExtendMapperList = roomExtendMapper.selectByExample(roomExample);
        return roomExtendMapperList;
    }

    @Override
    public PageInfo<RoomVO> getRoomByCity(@NotNull(message = "cityId不能为空") Integer cityId, @NotNull Integer pageNum, @NotNull Integer size) throws HuangShiZheException {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andCityIdEqualTo(cityId);
        PageHelper.startPage(pageNum, size);
        List<Room> roomList = roomMapper.selectByExample(roomExample);
        List<RoomVO> roomVOList=convertRoom2VO(roomList);
        return new PageInfo<>(roomVOList);
    }

    @Override
    public Boolean ifRoomExist(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andIsDeleteEqualTo(false).andIdEqualTo(id);
        List<Room> roomList = roomMapper.selectByExample(roomExample);
        if (CollectionUtils.isEmpty(roomList)) {
            return false;
        }
        return true;
    }

    @Override
    public Room getRoom(@NotNull(message = "roomId不能为空") Long id) throws HuangShiZheException {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andIsDeleteEqualTo(false).andIdEqualTo(id);
        List<Room> roomList = roomMapper.selectByExample(roomExample);
        if (CollectionUtils.isEmpty(roomList)) {
            throw new HuangShiZheException(ResultCodeEnum.ROOM_NOT_EXIT);
        }
        return roomList.get(0);
    }

    @Override
    public List<Room> getCollectionRoom(List<Long> roomIds) throws HuangShiZheException {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        criteria.andIdIn(roomIds).andIsDeleteEqualTo(false);
        return roomMapper.selectByExample(roomExample);
    }

    @Override
    public String getPicUrlByRoomId(@NotNull Long roomId) throws HuangShiZheException {
        RoomExtendExample roomExample = new RoomExtendExample();
        RoomExtendExample.Criteria criteria = roomExample.createCriteria();
        criteria.andRoomIdEqualTo(roomId).andTypeEqualTo(0);
        PageHelper.startPage(1,1);
        List<RoomExtend> roomExtendMapperList = roomExtendMapper.selectByExample(roomExample);
        if(CollectionUtils.isEmpty(roomExtendMapperList)){
            return null;
        }
        return roomExtendMapperList.get(0).getValue();
    }

    @Override
    public void changeRoomInfo(HttpServletRequest request,@NotNull RoomWithBLOBs room) throws HuangShiZheException {
        if(!ifRoomExist(room.getId())){
            throw new HuangShiZheException(ResultCodeEnum.ROOM_NOT_EXIT);
        }
        if(userService.getProviderByUserId(userService.getCurrentUser(request).getId())==null){
            throw new HuangShiZheException(ResultCodeEnum.UNKOWN_ERROR);
        }
        roomMapper.updateByPrimaryKeySelective(room);
    }

    private List<MetaVO> generateMetaVO(List<MetaRoom> metaRoomList) throws HuangShiZheException {
        List<MetaVO> metaVOList = Lists.newArrayList();
        for (MetaRoom metaRoom : metaRoomList) {
            Meta meta = metaService.getMetaById(metaRoom.getMetaId());
            MetaVO metaVO = new MetaVO();
            metaVO.setMetaValue(metaRoom.getMetaValue());
            metaVO.setId(meta.getId());
            metaVO.setType(meta.getType());
            metaVO.setValue(meta.getValue());
            metaVOList.add(metaVO);
        }
        return metaVOList;
    }
    
    public List<MetaVO> ConvertMeta2VO(List<MetaRoom> metaRoomList) {
        return null;
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
        roomVO.setProviderUrl(user.getUserAvatarUrl());
        roomVOList.add(roomVO);
    }
        return roomVOList;
}
}
