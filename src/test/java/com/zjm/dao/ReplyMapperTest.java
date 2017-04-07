package com.zjm.dao;

import com.zjm.model.Comment;
import com.zjm.model.Reply;
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
public class ReplyMapperTest {
    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        replyMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insert() throws Exception {
        Reply reply = new Reply();
        reply.setShopId(1);
        reply.setContent("你这么说我们会伤心的...");
        reply.setTime(new Date());
        Comment comment = new Comment();
        comment.setId(2);
        reply.setComment(comment);
        replyMapper.insert(reply);
    }

    @Test
    public void selectReplyByUserId() throws Exception {
        System.out.println(replyMapper.selectReplyByUserId(1));
    }

}