package com.zjm.model;

public class Collection_User {
    private Integer userId;

    private Good good;

    private int goodId;

    private int collectClassifyId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    @Override
    public String toString() {
        return "Collection_User{" +
                "userId=" + userId +
                ", goodId=" + goodId +
                '}';
    }
}