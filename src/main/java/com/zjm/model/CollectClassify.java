package com.zjm.model;

/**
 * Created by ZJM on 2017/5/3.
 */
public class CollectClassify {
    private int id;

    private String name;

    private User user;

    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CollectClassify{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", userId=" + userId +
                '}';
    }
}
