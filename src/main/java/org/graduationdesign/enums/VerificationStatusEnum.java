package org.graduationdesign.enums;

public enum VerificationStatusEnum {
    SUCCESS(0,"成功"),
    SUCCESS_SEND(1, "验证码已经成功发送"),
    ALREADY_REGISTER(2, "邮箱已经注册"),
    ERROR(3, "邮件发送大失败"),
    ALREADY_SEND(4, "已发送，2分钟后可再次发送"),
    TIME_OUT(5, "验证码已过期"),
    CODE_ERROR(6, "验证码不正确"),
    REGISTER_SUCESS(7, "注册成功"),
    UNKOWN_ERROR(8, "发生未知错误");
    Integer code;
    String message;

    VerificationStatusEnum(Integer integer, String message) {
        this.code = integer;
        this.message = message;
    }
    public static VerificationStatusEnum getEnumByCode(Integer code){
        if(code==null){
            return null;
        }
        for(VerificationStatusEnum verificationStatusEnum:VerificationStatusEnum.values()){
            if(code.equals(verificationStatusEnum.code)){
                return verificationStatusEnum;
            }
        }
        return null;
    }
}
