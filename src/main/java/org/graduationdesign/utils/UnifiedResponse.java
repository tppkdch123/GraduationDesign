package org.graduationdesign.utils;

public class UnifiedResponse {
    private int status;
    private String message;
    private Object data;
    public UnifiedResponse(){

    }

    public UnifiedResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
