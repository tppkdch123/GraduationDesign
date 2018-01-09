package org.graduationdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class testController {

    @ResponseBody
    @RequestMapping("hello-world")
    public String helloWorld(){
        return "hello world";
    }
}
