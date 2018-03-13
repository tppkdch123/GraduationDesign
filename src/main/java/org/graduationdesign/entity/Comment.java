package org.graduationdesign.entity;

import java.io.Serializable;

public class Comment implements Serializable {
    private Long id;

    private Long orderId;

    private Integer descriptScore;

    private String content;

    private Byte isAnonymous;

    private Byte isDelete;

    private Integer chatScore;

    private Integer hygineneScore;

    private Integer locationScore;

    private Integer costScore;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getDescriptScore() {
        return descriptScore;
    }

    public void setDescriptScore(Integer descriptScore) {
        this.descriptScore = descriptScore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Byte isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getChatScore() {
        return chatScore;
    }

    public void setChatScore(Integer chatScore) {
        this.chatScore = chatScore;
    }

    public Integer getHygineneScore() {
        return hygineneScore;
    }

    public void setHygineneScore(Integer hygineneScore) {
        this.hygineneScore = hygineneScore;
    }

    public Integer getLocationScore() {
        return locationScore;
    }

    public void setLocationScore(Integer locationScore) {
        this.locationScore = locationScore;
    }

    public Integer getCostScore() {
        return costScore;
    }

    public void setCostScore(Integer costScore) {
        this.costScore = costScore;
    }
}