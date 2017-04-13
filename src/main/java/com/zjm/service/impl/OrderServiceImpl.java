package com.zjm.service.impl;

import com.zjm.dao.OrderMapper;
import com.zjm.model.Order;
import com.zjm.model.OrderTime;
import com.zjm.model.Order_Good;
import com.zjm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZJM on 2017/4/11.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> showMyOrder(OrderTime order) throws Exception {
        return orderMapper.selectOrderByExample(order);
    }

    @Override
    public Order showOrderDetail(String orderId) throws Exception {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    @Transactional
    public void turnGoodToORder(Order order) throws Exception {
        List<Order_Good> list = order.getOrder_goodList();
        float total = 0;
        orderMapper.insert(order);
        for(Order_Good item : list) {
            item.setOrderId(order.getId());
            orderMapper.insertOrderGood(item);
        }
    }
}
