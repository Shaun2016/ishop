package com.zjm.model;

import java.util.List;

public class BigCatogary {

    private Integer id;

    private String name;

    private List<SmallCatogary> smallCatogaryList;

    public List<SmallCatogary> getSmallCatogaryList() {
        return smallCatogaryList;
    }

    public void setSmallCatogaryList(List<SmallCatogary> smallCatogaryList) {
        this.smallCatogaryList = smallCatogaryList;
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
        return "BigCatogary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", smallCatogaryList=" + smallCatogaryList +
                '}';
    }
}