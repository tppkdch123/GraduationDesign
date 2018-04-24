package org.graduationdesign.service;

import org.graduationdesign.exception.HuangShiZheException;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Map;

public interface PriceService {
    void setDatePrice(@NotNull(message = "roomId不能为空") Long roomId, @NotNull(message = "日期不能为空") Calendar calendar, @NotNull(message = "价格不能为空") Float price) throws HuangShiZheException;

    Float getPriceByDate(@NotNull(message = "roomId不能为空") Long roomId, @NotNull(message = "日期不能为空") Calendar calendar) throws HuangShiZheException;

    Map<Integer, Float> getPriceByMonth(@NotNull(message = "roomId不能为空") Long roomId, @NotNull(message = "年不能为空") Integer year, @NotNull(message = "月不能为空") Integer month) throws HuangShiZheException;
}
