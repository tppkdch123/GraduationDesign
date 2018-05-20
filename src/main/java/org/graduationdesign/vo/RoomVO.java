package org.graduationdesign.vo;

import lombok.Data;

@Data
public class RoomVO {
    private Long id;

    private String picUrl;

    private String info;

    private String title;

    private Integer price;

    private String providerUrl;

    private Integer roomArea;

    private String providerName;

    private String city;

    private String province;
}
