package org.graduationdesign.entity;

import java.io.Serializable;
import java.util.Date;

public class DatePriceKey implements Serializable {
    private Long roomId;

    private Date date;

    private static final long serialVersionUID = 1L;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}