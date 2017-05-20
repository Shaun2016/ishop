package com.zjm.model;

import java.util.List;

/**
 * Created by ZJM on 2017/5/8.
 */
public class CollectionList {
    List<Collection_User> list;

    public List<Collection_User> getList() {
        return list;
    }

    public void setList(List<Collection_User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CollectionList{" +
                "list=" + list +
                '}';
    }
}
