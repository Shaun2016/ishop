package com.zjm.dao;

import com.zjm.model.Collection_User;
import com.zjm.model.Good;

import java.util.List;

public interface Collection_UserMapper {
    int insert(Collection_User record) throws Exception;

    List<Good> selectCollectionByUser(int id) throws Exception;

    int delete(Collection_User collection_user) throws Exception;

    Collection_User isCollected(Collection_User collection_user) throws Exception;
}