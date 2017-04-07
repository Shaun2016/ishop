package com.zjm.model;

import java.util.Date;

public class ShopCar {
    private int id;

    private User user;

    private Good good;

    private Integer num;

    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", user=" + user +
                ", good=" + good +
                ", num=" + num +
                ", time=" + time +
                '}';
    }
}