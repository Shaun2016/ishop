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

}