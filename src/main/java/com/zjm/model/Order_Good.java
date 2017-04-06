package com.zjm.model;

public class Order_Good {

    private String orderId;

    private int goodId;

    private String goodName;

    private Integer num;

    private float price;

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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order_Good{" +
                "orderId=" + orderId +
                ", goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}