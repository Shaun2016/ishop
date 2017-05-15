package com.zjm.dao;

import com.google.gson.Gson;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.zjm.model.ShopCar;
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
public class ShopCarMapperTest {

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void insert() throws Exception {
        ShopCar shopcar = new ShopCar();
        shopcar.setUser(userMapper.selectByPrimaryKey(1));
        shopcar.setGood(goodMapper.selectByPrimaryKey(2));
        shopcar.setNum(18);
        shopCarMapper.insert(shopcar);
    }

    @Test
    public void delete() throws Exception {
        shopCarMapper.delete(2);
    }

    @Test
    public void selectByUserKey() throws Exception {
        Gson gson = new Gson();
        System.out.println(gson.toJson(shopCarMapper.selectByUserKey(1)));
    }

    @Test
    public void update() throws Exception {
        ShopCar shopCar = new ShopCar();
        shopCar.setId(25);
        shopCar.setNum(2);
        shopCarMapper.update(shopCar);
    }
}