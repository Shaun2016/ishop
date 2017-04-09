package com.zjm.dao;

import com.zjm.model.Collection_User;
import com.zjm.model.Good;

import java.util.List;

public interface Collection_UserMapper {
    int insert(Collection_User record);

    List<Good> selectCollectionByUser(int id);

    int delete(Collection_User collection_user);
}