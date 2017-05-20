package com.zjm.dao;

import com.zjm.model.Order;
import com.zjm.model.OrderTime;
import com.zjm.model.Order_Good;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String id) throws Exception;

    int insert(Order record) throws Exception;

    Order selectByPrimaryKey(String id) throws Exception;

    int insertOrderGood(Order_Good order_good) throws Exception;

    List<Order> selectOrderByExample(Order order) throws Exception;

    int updateState(Order order) throws Exception;
}