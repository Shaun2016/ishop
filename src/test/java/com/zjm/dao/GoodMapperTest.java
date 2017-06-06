package com.zjm.dao;

import com.zjm.model.Good;
import com.zjm.model.Shop;
import com.zjm.model.ShopCar;
import com.zjm.model.SmallCatogary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/6.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodMapperTest {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Autowired
    private BigCatogaryMapper bigCatogaryMapper;

    @Autowired
    private SmallCatogaryMapper smallCatogaryMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        goodMapper.deleteByPrimaryKey(6);
    }

    @Test
    public void insert() throws Exception {
        Good good = new Good();
        good.setName("可口可乐6");
        good.setExpirationdate("12个月");
        good.setPrice(2.5f);
        good.setProductdate(new Date(2017-1-1));
        good.setSellnum(210);
        good.setWarenum(110);
        good.setShopId(1);
        good.setBigCatogaryId(1);
        good.setSmallCatogaryId(1);
        goodMapper.insert(good);
        System.out.println("........."+good);
    }

    @Test
    public void selectByExample() throws Exception {
        Good good = new Good();
        good.setName("可");
//        Shop shop = new Shop();
//        shop.setId(1);
//        good.setShop(shop);
        List<Good> list = goodMapper.selectByExample(good);
        System.out.println(list.size() + "_" + list);
    }
    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(goodMapper.selectByPrimaryKey(1));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Good good = goodMapper.selectByPrimaryKey(1);
        good.setSellnum(good.getSellnum()+1);
        goodMapper.updateByPrimaryKeySelective(good);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

    @Test
    public void checkCart() throws Exception {
        ShopCar shopCar = new ShopCar();
        shopCar.setUserId(3);
        shopCar.setGoodId(1);
        int n = shopCarMapper.select(shopCar);
        System.out.println(n);
    }

    @Test
    public void selectPriceAndDelFee() throws Exception {
        int []ids = {1,2,3};
        System.out.println(goodMapper.selectPriceAndDelFee(ids));
    }

}