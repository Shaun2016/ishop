package com.zjm.model;

public class Address {
    private Integer id;

    private Integer userid;

    private String location;

    private String phone;

    private String receiver;

    private Integer postnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public Integer getPostnum() {
        return postnum;
    }

    public void setPostnum(Integer postnum) {
        this.postnum = postnum;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userid=" + userid +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", receiver='" + receiver + '\'' +
                ", postnum=" + postnum +
                '}';
    }
}