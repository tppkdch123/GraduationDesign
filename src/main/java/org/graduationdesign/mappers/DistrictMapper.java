package org.graduationdesign.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.entity.District;
import org.graduationdesign.entity.DistrictExample;

public interface DistrictMapper {
    int countByExample(DistrictExample example);

    int deleteByExample(DistrictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByExample(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}