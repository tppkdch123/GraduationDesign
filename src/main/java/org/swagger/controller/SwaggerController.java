package org.swagger.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @RequestMapping(value="/api-doc",method = RequestMethod.GET)
    public void apiDoc(HttpServletRequest request, HttpServletResponse response) throws Exception{

    }
}
