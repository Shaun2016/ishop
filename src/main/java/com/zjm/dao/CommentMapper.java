package com.zjm.dao;

import com.zjm.model.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    List<Comment> selectByGoodKey(Integer id);

    int turnReadStateByShop(int id);

    List<Comment> selectNotReadByShop(int id);

    List<Comment> selectByShop(int id);

    /*
    判断用户是否评论
     */
    List<Comment> selectByUser(Comment comment);
}