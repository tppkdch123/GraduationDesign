package org.graduationdesign.service.impl;

import org.graduationdesign.entity.DatePrice;
import org.graduationdesign.entity.DatePriceExample;
import org.graduationdesign.entity.DatePriceKey;
import org.graduationdesign.entity.Room;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.DatePriceMapper;
import org.graduationdesign.service.PriceService;
import org.graduationdesign.service.RoomService;
import org.graduationdesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class PriceServiceImpl implements PriceService {

    @Autowired
    DatePriceMapper datePriceMapper;

    @Autowired
    UserService userService;

    @Autowired
    RoomService roomService;

    @Override
    public void setDatePrice(@NotNull(message = "roomId不能为空") Long roomId, @NotNull(message = "日期不能为空") Calendar calendar, @NotNull(message = "价格不能为空") Float price) throws HuangShiZheException {
        if(price<=0){
           throw new HuangShiZheException(ResultCodeEnum.PRICE_ERROR);
        }
        if(roomService.ifRoomExist(roomId)) {
            DatePrice datePrice = new DatePrice();
            datePrice.setPrice(price);
            datePrice.setDate(calendar.getTime());
            datePrice.setRoomId(roomId);
            datePriceMapper.insertSelective(datePrice);
        }
        else{
            throw new HuangShiZheException(ResultCodeEnum.ROOM_NOT_EXIT);
        }
    }

    @Override
    public Float getPriceByDate(@NotNull(message = "roomId不能为空") Long roomId, @NotNull(message = "日期不能为空") Calendar calendar) throws HuangShiZheException {
        DatePriceKey datePriceKey=new DatePriceKey();
        datePriceKey.setRoomId(roomId);
        datePriceKey.setDate(calendar.getTime());
        DatePriceExample datePriceExample=new DatePriceExample();
        datePriceExample.createCriteria().andDateEqualTo(datePriceKey.getDate()).andRoomIdEqualTo(roomId);
        List<DatePrice> datePrices=datePriceMapper.selectByExample(datePriceExample);
        if(CollectionUtils.isEmpty(datePrices)) {
            Room room = roomService.getRoom(roomId);
            return room.getDefaultPrice()/100.0f;
        }
        return datePrices.get(0).getPrice();
    }

    @Override
    public Map<Integer, Float> getPriceByMonth(@NotNull(message = "roomId不能为空") Long roomId, @NotNull(message = "年不能为空") Integer year, @NotNull(message = "月不能为空") Integer month) throws HuangShiZheException {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        return null;
    }
}
