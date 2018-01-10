package org.graduationdesign.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class huangShiZhe implements Serializable {
    private Integer id;

    private String name;

    private Boolean sex;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }
}