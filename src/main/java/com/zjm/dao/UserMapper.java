package com.zjm.dao;

import com.zjm.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(User record) throws Exception;

    int insertSelective(User record) throws Exception;

    User selectByPrimaryKey(Integer id) throws Exception;

    int updateByPrimaryKeySelective(User record) throws Exception;

    int updateByPrimaryKey(User record) throws Exception;

    List<User> selectUserByExample(User user) throws Exception;

}