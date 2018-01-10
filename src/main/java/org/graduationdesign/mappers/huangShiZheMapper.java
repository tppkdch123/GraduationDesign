package org.graduationdesign.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.entity.huangShiZhe;
import org.graduationdesign.entity.huangShiZheExample;

public interface huangShiZheMapper {
    int countByExample(huangShiZheExample example);

    int deleteByExample(huangShiZheExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(huangShiZhe record);

    int insertSelective(huangShiZhe record);

    List<huangShiZhe> selectByExample(huangShiZheExample example);

    huangShiZhe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") huangShiZhe record, @Param("example") huangShiZheExample example);

    int updateByExample(@Param("record") huangShiZhe record, @Param("example") huangShiZheExample example);

    int updateByPrimaryKeySelective(huangShiZhe record);

    int updateByPrimaryKey(huangShiZhe record);
}