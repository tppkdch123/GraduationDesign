package org.graduationdesign.enums;

import lombok.Getter;

@Getter
public enum EmailTemplateEnum {
    REGISTER_VERIFICATION("注册验证码", "验证码:{}"),
    LOGIN_VERIFICATION("登录验证码","验证码:{}"),
    ;
    String subject;
    String content;

    EmailTemplateEnum(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}
