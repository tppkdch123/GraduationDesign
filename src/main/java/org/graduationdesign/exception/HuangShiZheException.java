package org.graduationdesign.exception;

import org.graduationdesign.enums.ResultCodeEnum;

public class HuangShiZheException extends Exception {

    private Integer code = -1;

    public HuangShiZheException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getContent());
        this.code = resultCodeEnum.getCode();
    }

    public HuangShiZheException(ResultCodeEnum resultCodeEnum, String message) {
        super(message);
        this.code = resultCodeEnum.getCode();
    }

    public HuangShiZheException(ResultCodeEnum resultCodeEnum,Exception e){
        super(e.getMessage());
        this.code=resultCodeEnum.getCode();
    }

}
