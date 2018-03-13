package org.graduationdesign.entity;

import java.io.Serializable;
import java.util.Date;

public class Room implements Serializable {
    private Long id;

    private Long providerId;

    private String title;

    private Float defaultPrice;

    private Integer maxCapacity;

    private String introduction;

    private Integer usableArea;

    private String structure;

    private Date createTime;

    private Date updateTime;

    private String aroundInfo;

    private Byte realCheck;

    private Integer bedCount;

    private Integer commentNumber;

    private String hostMessage;

    private Long latitude;

    private Long longitude;

    private String street;

    private Byte isDelete;

    private Byte isOnsale;

    private Integer cityId;

    private Integer provinceId;

    private Long districtId;

    private String block;

    private Long areaId;

    private Integer moveUpCancelDays;

    private String earliestCheckInTime;

    private String lastestCheckInTime;

    private String lastestCheckOutTime;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Float getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Integer usableArea) {
        this.usableArea = usableArea;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure == null ? null : structure.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAroundInfo() {
        return aroundInfo;
    }

    public void setAroundInfo(String aroundInfo) {
        this.aroundInfo = aroundInfo == null ? null : aroundInfo.trim();
    }

    public Byte getRealCheck() {
        return realCheck;
    }

    public void setRealCheck(Byte realCheck) {
        this.realCheck = realCheck;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getHostMessage() {
        return hostMessage;
    }

    public void setHostMessage(String hostMessage) {
        this.hostMessage = hostMessage == null ? null : hostMessage.trim();
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsOnsale() {
        return isOnsale;
    }

    public void setIsOnsale(Byte isOnsale) {
        this.isOnsale = isOnsale;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block == null ? null : block.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Integer getMoveUpCancelDays() {
        return moveUpCancelDays;
    }

    public void setMoveUpCancelDays(Integer moveUpCancelDays) {
        this.moveUpCancelDays = moveUpCancelDays;
    }

    public String getEarliestCheckInTime() {
        return earliestCheckInTime;
    }

    public void setEarliestCheckInTime(String earliestCheckInTime) {
        this.earliestCheckInTime = earliestCheckInTime == null ? null : earliestCheckInTime.trim();
    }

    public String getLastestCheckInTime() {
        return lastestCheckInTime;
    }

    public void setLastestCheckInTime(String lastestCheckInTime) {
        this.lastestCheckInTime = lastestCheckInTime == null ? null : lastestCheckInTime.trim();
    }

    public String getLastestCheckOutTime() {
        return lastestCheckOutTime;
    }

    public void setLastestCheckOutTime(String lastestCheckOutTime) {
        this.lastestCheckOutTime = lastestCheckOutTime == null ? null : lastestCheckOutTime.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}