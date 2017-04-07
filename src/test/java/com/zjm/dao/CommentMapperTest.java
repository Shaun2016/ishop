package com.zjm.dao;

import com.zjm.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/7.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        Comment comment = new Comment();
        comment.setTime(new Date());
        comment.setUser(userMapper.selectByPrimaryKey(2));
        comment.setGood(goodMapper.selectByPrimaryKey(3));
        comment.setContent("真的挺不错的，好评100年");
        comment.setStar(5);
        commentMapper.insert(comment);
    }

    @Test
    public void selectByGoodKey() throws Exception {
        System.out.println(commentMapper.selectByGoodKey(3));
    }

}