package org.graduationdesign.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.graduationdesign.entity.DatePrice;
import org.graduationdesign.entity.DatePriceExample;
import org.graduationdesign.entity.DatePriceKey;

public interface DatePriceMapper {
    int countByExample(DatePriceExample example);

    int deleteByExample(DatePriceExample example);

    int deleteByPrimaryKey(DatePriceKey key);

    int insert(DatePrice record);

    int insertSelective(DatePrice record);

    List<DatePrice> selectByExample(DatePriceExample example);

    DatePrice selectByPrimaryKey(DatePriceKey key);

    int updateByExampleSelective(@Param("record") DatePrice record, @Param("example") DatePriceExample example);

    int updateByExample(@Param("record") DatePrice record, @Param("example") DatePriceExample example);

    int updateByPrimaryKeySelective(DatePrice record);

    int updateByPrimaryKey(DatePrice record);
}