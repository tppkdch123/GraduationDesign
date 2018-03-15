package org.graduationdesign.entity;

import java.io.Serializable;

public class RoomWithBLOBs extends Room implements Serializable {
    private String introduction;

    private String description;

    private static final long serialVersionUID = 1L;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}