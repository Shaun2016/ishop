package com.zjm.dao;

import com.zjm.model.Collection_User;

import java.util.List;

public interface Collection_UserMapper {
    int insert(Collection_User record);

    List<Collection_User> selectCollectionByUser(int id);

    int delete(int id);
}