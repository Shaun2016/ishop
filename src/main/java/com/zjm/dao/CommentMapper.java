package com.zjm.dao;

import com.zjm.model.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    List<Comment> selectByGoodKey(Integer id);
}