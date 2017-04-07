package com.zjm.dao;

import com.zjm.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/5.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderMapperTest {
    @Test
    public void findOrderByDate() throws Exception {
        OrderTime orderTime = new OrderTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = "2017-4-5";
        String end = "2017-4-8";
        orderTime.setStart(dateFormat.parse(start));
        orderTime.setEnd(dateFormat.parse(end));
        List<Order> list = orderMapper.findOrderByExample(orderTime);
        System.out.println(list);
    }

    @Test
    public void findOrderByUserId() throws Exception {
        OrderTime order = new OrderTime();
        User user = new User();
        user.setId(1);
        order.setUser(user);
        List<Order> l = orderMapper.findOrderByExample(order);
        System.out.println(l.size() + "_" + l);
    }

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        Order order = new Order();
        order.setAddress(addressMapper.selectByPrimaryKey(1));
        order.setState(0);
        order.setTime(new Date());
        order.setUser(userMapper.selectByPrimaryKey(1));
        orderMapper.insert(order);
        Good good = new Good();
        good.setName("可");
        List<Good> list = goodMapper.selectByExample(good);
        int goodId;
        for(int i=0;i<list.size();i++) {
            goodId = list.get(i).getId();
            Order_Good order_good = new Order_Good();
            order_good.setGoodId(goodId);
            order_good.setNum(5);
            order_good.setOrderId(order.getId());
            orderMapper.insertOrderGood(order_good);
        }

    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(orderMapper.selectByPrimaryKey("7cf3d66e1abc11e789eeecf4bb947367"));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}