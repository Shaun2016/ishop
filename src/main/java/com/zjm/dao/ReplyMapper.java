package com.zjm.dao;

import com.zjm.model.Reply;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    List<Reply> selectReplyByUserId(int userId);

    List<Reply> selectNotReadReplyByUserId(int userId);
}