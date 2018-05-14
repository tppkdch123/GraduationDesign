package org.graduationdesign.enums;

import lombok.Getter;

@Getter
public enum TimeEnum {
    TOKEN_TIEMOUT(1,"redis里token过期时间",60*60*24),
    COOKIE_TIMEOUT(2,"sso cookie过期时间",60*60*24)

    ;
    private Integer code;
    private String desc;
    private Integer value;

     TimeEnum(Integer code, String desc, Integer seconds) {
        this.code = code;
        this.desc = desc;
        this.value= seconds;
    }
}
