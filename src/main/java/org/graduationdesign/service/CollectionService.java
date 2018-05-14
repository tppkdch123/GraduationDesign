package org.graduationdesign.service;

import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.vo.RoomVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CollectionService {
    void collect(HttpServletRequest request, Long roomId) throws HuangShiZheException;

    List<RoomVO> getCollections(HttpServletRequest request) throws HuangShiZheException;

    void cancel(HttpServletRequest request, Long roomId) throws HuangShiZheException;

    void click(HttpServletRequest request, Long roomId) throws HuangShiZheException;
}
