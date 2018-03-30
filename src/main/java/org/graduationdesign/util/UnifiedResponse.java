package org.graduationdesign.util;

import lombok.Data;
import org.graduationdesign.enums.ResultCodeEnum;

import java.io.Serializable;

@Data
public class UnifiedResponse{
    private int status=-1;
    private String message;
    private Object data;

    public UnifiedResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public UnifiedResponse(Exception e){
        this.status=-1;
        this.data=e.getMessage();
    }

    public UnifiedResponse(Object data){
        this.status=0;
        this.data=data;
    }

    public UnifiedResponse(ResultCodeEnum resultCodeEnum){
        this.status=resultCodeEnum.getCode();
        this.message=resultCodeEnum.getContent();
    }

    public UnifiedResponse(Integer status,String Content){
        this.status=status;
        this.message=Content;
    }
}
