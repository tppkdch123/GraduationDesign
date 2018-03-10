package org.graduationdesign.entity;

import java.io.Serializable;

public class Province implements Serializable {
    private Integer provinceCode;

    private String provinceName;

    private static final long serialVersionUID = 1L;

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }
}