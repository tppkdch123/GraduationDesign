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
    PASSWORD_ERROR(13,"密码不正确"),
    EMAIL_REGEX(14,"邮箱格式不正确"),
    EMAIL_MUST_NOT_NULL(15,"邮箱不能为空"),
    NOT_PROVIDER(16,"还不是房东"),
    ALREADY_PROVIDER(17,"已经是提供者"),
    ROOM_NOT_EXIT(18,"房源不存在"),
    META_NOT_EXIT(19,"meta不存在"),
    ORDER_NOT_EXIT(20,"不存在符合条件的订单"),
    PRICE_ERROR(21,"价格不正确"),
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
