package com.zjm.service.impl;

import com.zjm.model.User;
import com.zjm.service.UserService;
import com.zjm.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/9.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void isPass() throws Exception {
        User user = new User();
        user.setNickname("张家铭");
        user.setPassword(MD5.getMd5("123456"));
        assertEquals(true,userService.isPass(user) == null?false:true);
    }

    @Test
    public void changePassword() throws Exception {
        User user = new User();
        user.setId(1);
        user.setPassword(MD5.getMd5("111111"));
        userService.changePassword(user,MD5.getMd5("123456"));
    }

    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(1);
        user.setNickname("shaun");
        userService.update(user);
    }

    @Test
    public void nickNameIsExit() throws Exception {
        assertEquals(true,userService.nickNameIsExit("毛硕"));
    }

}