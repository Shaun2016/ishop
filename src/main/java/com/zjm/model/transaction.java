package com.zjm.model;

import java.util.Date;
import java.util.List;

/**
 * Created by ZJM on 2017/5/20.
 */
public class Transaction {

    private String id;

    private List<Order> orderList;

    private float total;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", orderList=" + orderList +
                ", total=" + total +
                ", date=" + date +
                '}';
    }
}
