package org.graduationdesign.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable{
    private Long id;

    private String email;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String mobile;

    private Boolean sex;

    private String userAvatarUrl;

    private Boolean isDelete;

    private Boolean isActive;
}
