package org.graduationdesign.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"失败"),
    SUCCESS_SEND(1, "验证码已经成功发送"),
    ALREADY_REGISTER(2, "邮箱已经注册"),
    ERROR_MAIL(3, "邮件发送大失败"),
    ALREADY_SEND(4, "已发送，2分钟后可再次发送"),
    TIME_OUT(5, "验证码已过期"),
    CODE_ERROR(6, "验证码不正确"),
    REGISTER_SUCESS(7, "注册成功"),
    UNKOWN_ERROR(8, "发生未知错误"),
    USER_ALREADY_EXIT(9,"用户已存在"),
    USER_NOT_EXIT(10,"用户不存在"),
    PARAMETERS_ERROR(11,"参数错误"),
    TOKEN_INVAILD(12,"登录信息过期"),

    ;
    private Integer code;
    private String content;
    ResultCodeEnum(Integer Code,String Content){
        this.code=Code;
        this.content=Content;
    }
    public ResultCodeEnum findResultCodeEnumByCode(Integer code){
        for(ResultCodeEnum resultCodeEnum:ResultCodeEnum.values()){
            if(resultCodeEnum.getCode().equals(code)){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
