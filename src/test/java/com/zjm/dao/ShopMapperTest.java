package com.zjm.dao;

import com.zjm.model.Shop;
import com.zjm.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/5.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ShopMapperTest {

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
       // shopMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void insertSelective() throws Exception {
        Shop shop = new Shop();
        shop.setLoginname("cmcc");
        shop.setPassword(MD5.getMd5("123456"));
        shop.setFansnum(5);
        shop.setName("连你电信");
        shop.setPhone("2288228");
        shop.setInfo("CMCC一天，七天，包月");
        shop.setTab("cmcc");
        shopMapper.insertSelective(shop);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Shop shop = shopMapper.selectByPrimaryKey(1);
        System.out.println(shop);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Shop shop = new Shop();
        shop.setId(1);
        shop.setLoginname("商其娟");
        shopMapper.updateByPrimaryKeySelective(shop);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

    @Test
    public void passShop() throws Exception {
        shopMapper.passShop(2);
    }

    @Test
    public void selectByKeyWord() throws Exception {
        shopMapper.selectByKeyWord("cmcc");
    }

    @Test
    public void selectByExample() throws Exception {
        Shop shop = new Shop();
        shop.setLoginname("商其娟");
        shop.setPassword(MD5.getMd5("123456"));
        System.out.println(shopMapper.selectByExample(shop));
    }
}