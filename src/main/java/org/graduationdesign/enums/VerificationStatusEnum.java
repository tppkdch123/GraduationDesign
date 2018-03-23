package org.graduationdesign.enums;

public enum VerificationStatusEnum {
    SUCCESS_SEND(1,"验证码已经成功发送"),
    ALREADY_REGISTER(2,"邮箱已经注册"),
    ERROR(3,"邮件发送大失败")
    ;
    Integer code;
    String message;
    VerificationStatusEnum(Integer integer,String message){
        this.code=integer;
        this.message=message;
    }
}
