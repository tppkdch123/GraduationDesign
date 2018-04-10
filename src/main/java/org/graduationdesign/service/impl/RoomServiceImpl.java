package org.graduationdesign.service.impl;

import com.google.common.collect.Lists;
import org.graduationdesign.entity.Meta;
import org.graduationdesign.entity.MetaRoom;
import org.graduationdesign.entity.MetaRoomExample;
import org.graduationdesign.entity.Provider;
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
import org.graduationdesign.service.MetaService;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.service.UserService;
import org.graduationdesign.vo.MetaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @Autowired
    UserService userService;

    @Override
    public void addNewRoom(RoomWithBLOBs roomWithBLOBs, HttpServletRequest httpServletRequest) throws HuangShiZheException {
        roomWithBLOBs.setUpdateTime(new Date());
        roomWithBLOBs.setCreateTime(new Date());
        User user = userService.getCurrentUser(httpServletRequest);
        Provider provider=userService.getProviderByUserId(user.getId());
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
}
