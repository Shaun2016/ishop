package com.zjm.model;

import java.util.Date;

public class Admin {
    private Integer id;

    private String name;

    private Integer sex;

    private String phone;

    private String password;

    private Date inductdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getInductdate() {
        return inductdate;
    }

    public void setInductdate(Date inductdate) {
        this.inductdate = inductdate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", inductdate=" + inductdate +
                '}';
    }
}