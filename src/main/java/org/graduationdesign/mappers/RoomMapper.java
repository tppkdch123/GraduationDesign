package org.graduationdesign.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.entity.Room;
import org.graduationdesign.entity.RoomExample;
import org.graduationdesign.entity.RoomWithBLOBs;

public interface RoomMapper {
    int countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomWithBLOBs record);

    int insertSelective(RoomWithBLOBs record);

    List<RoomWithBLOBs> selectByExampleWithBLOBs(RoomExample example);

    List<Room> selectByExample(RoomExample example);

    RoomWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoomWithBLOBs record, @Param("example") RoomExample example);

    int updateByExampleWithBLOBs(@Param("record") RoomWithBLOBs record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(RoomWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RoomWithBLOBs record);

    int updateByPrimaryKey(Room record);
}