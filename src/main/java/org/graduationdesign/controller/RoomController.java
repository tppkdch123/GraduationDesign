package org.graduationdesign.controller;

import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.util.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/room")
public class RoomController {
    @Autowired
    RoomService roomService;


    @RequestMapping("/test/{roomId}")
    public UnifiedResponse testRoomExtend(@PathVariable("roomId") Long roomId) throws HuangShiZheException{
      return new UnifiedResponse(roomService.getRoomExtendById(roomId));
    }

}
