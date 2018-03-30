package org.graduationdesign.controller;

import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.util.UnifiedResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    @ExceptionHandler(Throwable.class)
    public UnifiedResponse HandleAllException(Throwable e) {
        e.printStackTrace();
        return new UnifiedResponse(ResultCodeEnum.ERROR.getCode(), e.getMessage());
    }
}
