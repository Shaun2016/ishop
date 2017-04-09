package com.zjm.dao;

import com.zjm.model.FeedBack;
import com.zjm.model.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/8.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FeedBackMapperTest {

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void insert() throws Exception {
        FeedBack feedBack = new FeedBack();
        feedBack.setContent("软件运行的好慢啊...");
        //feedBack.setUser(userMapper.selectByPrimaryKey(1));
        feedBack.setShop(shopMapper.selectByPrimaryKey(1));
        feedBack.setTime(new Date());
        feedBackMapper.insert(feedBack);
    }

    @Test
    public void selectByExample() throws Exception {
        FeedBack feedBack = new FeedBack();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        feedBack.setStart(dateFormat.parse("2017-4-7"));
        feedBack.setEnd(dateFormat.parse("2017-4-8"));
        feedBack.setIsRead(0);
        List<FeedBack> l = feedBackMapper.selectByExample(feedBack);
        System.out.println(l);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(feedBackMapper.selectByPrimaryKey(1));
    }

    @Test
    public void turnReadState() throws Exception {
        feedBackMapper.turnReadState();
    }
}