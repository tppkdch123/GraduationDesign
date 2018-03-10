package org.graduationdesign.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.entity.RoomExtend;
import org.graduationdesign.entity.RoomExtendExample;

public interface RoomExtendMapper {
    int countByExample(RoomExtendExample example);

    int deleteByExample(RoomExtendExample example);

    int deleteByPrimaryKey(Long roomId);

    int insert(RoomExtend record);

    int insertSelective(RoomExtend record);

    List<RoomExtend> selectByExample(RoomExtendExample example);

    RoomExtend selectByPrimaryKey(Long roomId);

    int updateByExampleSelective(@Param("record") RoomExtend record, @Param("example") RoomExtendExample example);

    int updateByExample(@Param("record") RoomExtend record, @Param("example") RoomExtendExample example);

    int updateByPrimaryKeySelective(RoomExtend record);

    int updateByPrimaryKey(RoomExtend record);
}