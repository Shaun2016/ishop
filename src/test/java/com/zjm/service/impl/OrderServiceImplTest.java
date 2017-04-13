package com.zjm.service.impl;

import com.zjm.dao.AddressMapper;
import com.zjm.dao.GoodMapper;
import com.zjm.dao.UserMapper;
import com.zjm.model.Good;
import com.zjm.model.Order;
import com.zjm.model.Order_Good;
import com.zjm.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/12.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void showMyOrder() throws Exception {

    }

    @Test
    public void showOrderDetail() throws Exception {

    }

    @Test
    public void turnGoodToORder() throws Exception {
        Order order = new Order();
        order.setAddress(addressMapper.selectByPrimaryKey(1));
        order.setState(0);
        order.setTime(new Date());
        order.setTotal(12.5f);
        order.setUser(userMapper.selectByPrimaryKey(1));
        Good good = new Good();
        good.setName("可");
        List<Good> list = goodMapper.selectByExample(good);
        List<Order_Good> l = new ArrayList<Order_Good>();
        for(Good i : list) {
            Order_Good order_good = new Order_Good();
            order_good.setNum(1);
            order_good.setGoodId(i.getId());
            l.add(order_good);
        }
        order.setOrder_goodList(l);
        orderService.turnGoodToORder(order);
    }

}