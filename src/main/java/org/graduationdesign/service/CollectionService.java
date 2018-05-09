package org.graduationdesign.service;

import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.vo.RoomVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CollectionService {
    public void collect(HttpServletRequest request, Long roomId) throws HuangShiZheException;

    public List<RoomVO> getCollections(HttpServletRequest request) throws HuangShiZheException;

    public void cancel(HttpServletRequest request,Long roomId) throws HuangShiZheException;
}
