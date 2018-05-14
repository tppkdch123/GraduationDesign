package org.graduationdesign.controller;

import com.sun.org.apache.regexp.internal.REProgram;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.service.CollectionService;
import org.graduationdesign.util.UnifiedResponse;
import org.graduationdesign.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/collection")
public class CollectionController extends BaseController {

    @Autowired
    CollectionService collectionService;

    @RequestMapping(value = "/collect",method = RequestMethod.GET)
    public UnifiedResponse collect(HttpServletRequest request,@Param("roomId") Long roomId) throws HuangShiZheException{
        collectionService.collect(request,roomId);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public UnifiedResponse getCollections(HttpServletRequest request) throws HuangShiZheException{
        List<RoomVO> roomVOList=collectionService.getCollections(request);
        return new UnifiedResponse(roomVOList);
    }

    @RequestMapping(value = "/cancel",method = RequestMethod.GET)
    public UnifiedResponse cancel(HttpServletRequest request,Long roomId) throws HuangShiZheException{
        collectionService.cancel(request,roomId);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value="/click",method = RequestMethod.GET)
    public UnifiedResponse click(HttpServletRequest request,Long roomId) throws HuangShiZheException{
        collectionService.click(request,roomId);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }
}
