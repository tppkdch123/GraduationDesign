package org.graduationdesign.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.graduationdesign.entity.City;
import org.graduationdesign.entity.CityExample;
import org.graduationdesign.entity.RoomExample;
import org.graduationdesign.entity.RoomWithBLOBs;
import org.graduationdesign.mappers.CityMapper;
import org.graduationdesign.mappers.RoomMapper;
import org.graduationdesign.util.EmailUtil;
import org.graduationdesign.util.UnifiedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;


@RestController
public class testController {

    @Autowired
    DataSource dataSource;

    @Autowired
    CityMapper cityMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    JedisPool jedisPool;

    @Autowired
    EmailUtil emailUtil;

    private static Logger LOGGER= LoggerFactory.getLogger(testController.class);

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

    @RequestMapping(value = "/city/{provinceId}", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    @ResponseBody
    public UnifiedResponse printCity(@PathVariable Integer provinceId) {
        CityExample cityExample = new CityExample();
        CityExample.Criteria criteria = cityExample.createCriteria();
        criteria.andProvinceIdEqualTo(provinceId);
        List<City> cities = cityMapper.selectByExample(cityExample);
        return new UnifiedResponse(0, "", cities);
    }

    @RequestMapping(value = "/room/{roomId}")
    public UnifiedResponse getRoomById(@PathVariable Long roomId) {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andIdEqualTo(roomId);
        List<RoomWithBLOBs> roomWithBLOBs = roomMapper.selectByExampleWithBLOBs(roomExample);
        return new UnifiedResponse(roomWithBLOBs.get(0));
    }

    @RequestMapping(value = "/redis")
    public String testRedis(){
        return jedisPool.getResource().get("yellow");
    }



    @RequestMapping(value="/cookie")
    public UnifiedResponse getCookies(HttpServletRequest request){
        return new UnifiedResponse(request.getCookies());
    }

    @RequestMapping(value="/eat")
    public void setCookies(HttpServletResponse response){
        String uuid=UUID.randomUUID().toString();
        System.out.println(uuid);
        response.addCookie(new Cookie("huangshizhetianxiadiyi",uuid));
    }

    @RequestMapping(value="/testLog")
    public void testLog(){
        LOGGER.info("记录日志测试");
    }
}
