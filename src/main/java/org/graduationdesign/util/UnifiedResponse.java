package org.graduationdesign.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnifiedResponse{
    private int status;
    private String message;
    private Object data;

    public UnifiedResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public UnifiedResponse(Object data){
        this.status=0;
        this.data=data;
    }
}
