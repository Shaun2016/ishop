package com.zjm.model;

import java.util.Date;

public class Reply {
    private Integer id;

    private Integer shopId;

    private Comment comment;

    private String content;

    private Date time;

    private int isRead;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", comment=" + comment +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", isRead=" + isRead +
                '}';
    }
}