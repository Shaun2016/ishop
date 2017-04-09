package com.zjm.dao;

import com.zjm.model.User;
import com.zjm.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/5.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        userMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setPhone("13636662259");
        user.setSex(0);
        user.setEmail("7788521@qq.com");
        user.setNickname("毛硕");
        user.setPassword(MD5.getMd5("123456"));
        user.setRegdate(new Date());
        userMapper.insert(user);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        User user = new User();
        user.setId(1);
        user.setNickname("shaunHaHaHa");
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

    @Test
    public void selectUserByExample() throws Exception {
        User user = new User();
        user.setNickname("张家铭");
        user.setPassword(MD5.getMd5("123456"));
        System.out.println(userMapper.selectUserByExample(user));
    }
}