package com.zjm.dao;

import com.zjm.model.Follow_User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/7.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Follow_UserMapperTest {
    @Autowired
    private Follow_UserMapper follow_userMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void selectByUserId() throws Exception {
        System.out.println(follow_userMapper.selectByUserId(1));
    }

    @Test
    public void selectByShopId() throws Exception {
        System.out.println(follow_userMapper.selectByShopId(2));
    }

}