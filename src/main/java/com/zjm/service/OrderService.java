package com.zjm.service;

import com.zjm.model.*;

import java.util.List;

/**
 * Created by ZJM on 2017/4/11.
 */
public interface OrderService {
    List<Order> showMyOrder(Order order) throws Exception;

    Order showOrderDetail(String orderId) throws Exception;
    /*
    将商品转化为订单
     */
    Transaction turnGoodToOrder(List<Order> orderList) throws Exception;

    /*
    支付
     */
    Transaction checkPay(Transaction transaction, User user) throws Exception;
}
