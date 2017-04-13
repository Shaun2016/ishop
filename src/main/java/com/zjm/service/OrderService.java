package com.zjm.service;

import com.zjm.model.Order;
import com.zjm.model.OrderTime;
import com.zjm.model.Order_Good;

import java.util.List;

/**
 * Created by ZJM on 2017/4/11.
 */
public interface OrderService {
    public List<Order> showMyOrder(OrderTime order) throws Exception;

    public Order showOrderDetail(String orderId) throws Exception;
    /*
    将商品转化为订单
     */
    public void turnGoodToORder(Order order) throws Exception;

}
