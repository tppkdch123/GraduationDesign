package org.graduationdesign.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.graduationdesign.entity.City;
import org.graduationdesign.entity.CityExample;
import org.graduationdesign.entity.Room;
import org.graduationdesign.entity.RoomExample;
import org.graduationdesign.entity.RoomWithBLOBs;
import org.graduationdesign.mappers.CityMapper;
import org.graduationdesign.mappers.RoomMapper;
import org.graduationdesign.util.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;


@RestController
public class testController {

    @Autowired
    DataSource dataSource;

    @Autowired
    CityMapper cityMapper;

    @Autowired
    RoomMapper roomMapper;

    @ResponseBody
    @RequestMapping("/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    @ResponseBody
    @RequestMapping("/config-test")
    public String testConfig() {
        return ((DruidDataSource) dataSource).getUrl();
    }

    @RequestMapping("/data-test")
    @ResponseBody
    public String testDataBase() {
        return null;
    }

    @RequestMapping(value="/city/{provinceId}",produces = {"application/json;charset=utf-8"},method = RequestMethod.GET)
    @ResponseBody
    public UnifiedResponse printCity(@PathVariable Integer provinceId){
        CityExample cityExample=new CityExample();
        CityExample.Criteria criteria=cityExample.createCriteria();
        criteria.andProvinceIdEqualTo(provinceId);
        List<City> cities=cityMapper.selectByExample(cityExample);
        return new UnifiedResponse(0,"",cities);
    }
    @RequestMapping(value="/room/{roomId}")
    public UnifiedResponse getRoomById(@PathVariable Long roomId){
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andIdEqualTo(roomId);
       List<RoomWithBLOBs> roomWithBLOBs = roomMapper.selectByExampleWithBLOBs(roomExample);
       return new UnifiedResponse(roomWithBLOBs.get(0));
    }
}
