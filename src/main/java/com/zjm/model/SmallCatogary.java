package com.zjm.model;

public class SmallCatogary {

    private Integer id;

    private String name;

    private BigCatogary bigCatogary;

    public BigCatogary getBigCatogary() {
        return bigCatogary;
    }

    public void setBigCatogary(BigCatogary bigCatogary) {
        this.bigCatogary = bigCatogary;
    }

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

    @Override
    public String toString() {
        return "SmallCatogary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bigCatogary=" + bigCatogary +
                '}';
    }
}