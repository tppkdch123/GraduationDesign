package org.graduationdesign.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;



@Controller
public class testController {

    @Autowired
    DataSource dataSource;

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
}
