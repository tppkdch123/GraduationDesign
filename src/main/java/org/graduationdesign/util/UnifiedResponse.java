package org.graduationdesign.util;

import java.io.Serializable;

public class UnifiedResponse implements Serializable{
    private int status;
    private String message;
    private Object data;

    public UnifiedResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
