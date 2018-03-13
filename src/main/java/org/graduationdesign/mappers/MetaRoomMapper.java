package org.graduationdesign.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.entity.MetaRoom;
import org.graduationdesign.entity.MetaRoomExample;

public interface MetaRoomMapper {
    int countByExample(MetaRoomExample example);

    int deleteByExample(MetaRoomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MetaRoom record);

    int insertSelective(MetaRoom record);

    List<MetaRoom> selectByExample(MetaRoomExample example);

    MetaRoom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MetaRoom record, @Param("example") MetaRoomExample example);

    int updateByExample(@Param("record") MetaRoom record, @Param("example") MetaRoomExample example);

    int updateByPrimaryKeySelective(MetaRoom record);

    int updateByPrimaryKey(MetaRoom record);
}