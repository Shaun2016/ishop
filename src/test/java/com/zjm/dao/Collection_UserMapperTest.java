package com.zjm.dao;

import com.zjm.model.Collection_User;
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
public class Collection_UserMapperTest {
    @Autowired
    private Collection_UserMapper collection_userMapper;

    @Autowired
    private GoodMapper goodMapper;
    @Test
    public void insert() throws Exception {
        Collection_User collection_user = new Collection_User();
        collection_user.setUserId(3);
        collection_user.setGoodId(3);
        collection_userMapper.insert(collection_user);
    }

    @Test
    public void selectCollectionByUser() throws Exception {
        System.out.println(collection_userMapper.selectCollectionByUser(1));
    }

    @Test
    public void delete() throws Exception {
        Collection_User collection_user = new Collection_User();
        collection_user.setUserId(3);
        collection_user.setGoodId(3);
        collection_userMapper.delete(collection_user);
    }

}