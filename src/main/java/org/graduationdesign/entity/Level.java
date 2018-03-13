package org.graduationdesign.entity;

import java.io.Serializable;

public class Level implements Serializable {
    private Integer id;

    private String levelName;

    private Integer levelNeedScore;

    private Byte levelType;

    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Integer getLevelNeedScore() {
        return levelNeedScore;
    }

    public void setLevelNeedScore(Integer levelNeedScore) {
        this.levelNeedScore = levelNeedScore;
    }

    public Byte getLevelType() {
        return levelType;
    }

    public void setLevelType(Byte levelType) {
        this.levelType = levelType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}