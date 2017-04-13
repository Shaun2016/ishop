package com.zjm.model;

public class Order_Good {

    private int id;

    private String orderId;

    private int goodId;

    private Good good;

    private Integer num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Order_Good{" +
                "orderId='" + orderId + '\'' +
                ", goodId=" + goodId +
                ", good=" + good +
                ", num=" + num +
                '}';
    }
}