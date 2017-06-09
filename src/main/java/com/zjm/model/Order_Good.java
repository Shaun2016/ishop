package com.zjm.model;

public class Order_Good {

    private int id;

    private String orderId;

    private int goodId;

    private int tabId;

    private Good good;

    private Size size;

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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
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
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", goodId=" + goodId +
                ", tabId=" + tabId +
                ", good=" + good +
                ", size=" + size +
                ", num=" + num +
                '}';
    }
}