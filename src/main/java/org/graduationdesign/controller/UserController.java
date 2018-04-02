package org.graduationdesign.controller;

import org.graduationdesign.entity.User;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.service.UserService;
import org.graduationdesign.util.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/sendLoginEmail", method = RequestMethod.GET)
    public UnifiedResponse sendLoginEmail(@RequestParam("email") String email) throws HuangShiZheException {
        userService.sendLoginVerification(email);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public UnifiedResponse login(@RequestParam("email") String email, @RequestParam("verificationCode") String verification, HttpServletResponse response) throws HuangShiZheException {
        userService.login(email, verification, response);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "/hello-user", method = RequestMethod.GET)
    public UnifiedResponse hello(HttpServletRequest request) throws HuangShiZheException {
        return new UnifiedResponse(userService.getCurrentUser(request));
    }

    @RequestMapping(value = "/loginByPassword", method = RequestMethod.GET)
    public UnifiedResponse login(HttpServletResponse response, @RequestParam("email") String email, @RequestParam("password") String password) throws HuangShiZheException {
        userService.login(response, email, password);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
    public UnifiedResponse updateInfo(@RequestBody User user) throws HuangShiZheException {
        userService.updateInformation(user);
        return new UnifiedResponse(ResultCodeEnum.SUCCESS);
    }

}
