package com.zjm.dao;

import com.zjm.model.FeedBack;

import java.util.List;

public interface FeedBackMapper {

    int insert(FeedBack record) throws Exception;

    List<FeedBack> selectByExample(FeedBack feedBack) throws Exception;

    FeedBack selectByPrimaryKey(Integer id) throws Exception;

    int turnReadState();
}