package org.graduationdesign.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.entity.Province;
import org.graduationdesign.entity.ProvinceExample;

public interface ProvinceMapper {
    int countByExample(ProvinceExample example);

    int deleteByExample(ProvinceExample example);

    int deleteByPrimaryKey(Integer provinceCode);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(Integer provinceCode);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}