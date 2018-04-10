package org.graduationdesign.controller;

import org.graduationdesign.entity.RoomExtend;
import org.graduationdesign.entity.RoomWithBLOBs;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.service.MetaService;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.util.UnifiedResponse;
import org.graduationdesign.vo.MetaVO;
import org.python.tests.props.PropShadow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController extends BaseController{
    @Autowired
    RoomService roomService;

    @Autowired
    MetaService metaService;


    @RequestMapping(value = "/test/{roomId}", method = RequestMethod.GET)
    public UnifiedResponse testRoomExtend(@PathVariable("roomId") Long roomId) throws HuangShiZheException {
        return new UnifiedResponse(roomService.getRoomExtendById(roomId));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UnifiedResponse addRoom(@RequestBody RoomWithBLOBs roomWithBLOBs, HttpServletRequest request) throws HuangShiZheException {
        roomService.addNewRoom(roomWithBLOBs, request);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
    public UnifiedResponse getRoomById(@PathVariable Long roomId) throws HuangShiZheException {
        RoomWithBLOBs roomWithBLOBs = roomService.getRoomById(roomId);
        return new UnifiedResponse(roomWithBLOBs);
    }

    @RequestMapping(value = "/extend",method = RequestMethod.GET)
    public UnifiedResponse getRoomExtendById(@RequestParam Long id) throws HuangShiZheException{
        List<RoomExtend> roomExtendList=roomService.getRoomExtendById(id);
        return new UnifiedResponse(roomExtendList);
    }

    @RequestMapping(value = "/metas",method = RequestMethod.GET)
    public UnifiedResponse getMetaByRoomId(@RequestParam Long roomId) throws HuangShiZheException{
        List<MetaVO> metaVOList=roomService.getMetaByRoomId(roomId);
        return new UnifiedResponse(metaVOList);

    }
}
