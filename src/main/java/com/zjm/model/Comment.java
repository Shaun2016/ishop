package com.zjm.model;

import javax.validation.constraints.Max;
import java.util.Date;

public class Comment {
    private Integer id;

    private User user;

    private Good good;

    private Reply reply;

    private String content;

    private Date time;

    @Max(5)
    private Integer star;

    private int idRead;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
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

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public int getIdRead() {
        return idRead;
    }

    public void setIdRead(int idRead) {
        this.idRead = idRead;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", good=" + good +
                ", reply=" + reply +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", star=" + star +
                ", idRead=" + idRead +
                '}';
    }
}