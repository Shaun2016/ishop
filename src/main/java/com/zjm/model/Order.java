package com.zjm.model;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;

    private Address address;

    private User user;

    private Date time;

    private Integer state;

    private List<Order_Good> order_goodList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Order_Good> getOrder_goodList() {
        return order_goodList;
    }

    public void setOrder_goodList(List<Order_Good> order_goodList) {
        this.order_goodList = order_goodList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address=" + address +
                ", user=" + user +
                ", time=" + time +
                ", state=" + state +
                ", order_goodList=" + order_goodList +
                '}';
    }
}