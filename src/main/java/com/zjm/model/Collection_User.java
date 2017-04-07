package com.zjm.model;

public class Collection_User {
    private Integer userid;

    private Good good;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "Collection_User{" +
                "userid=" + userid +
                ", good=" + good +
                '}';
    }
}