package com.zjm.model;

public class Follow_User {

    private Shop shop;

    private User user;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Follow_User{" +
                "shop=" + shop +
                ", user=" + user +
                '}';
    }
}