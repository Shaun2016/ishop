package com.zjm.dao;

import com.zjm.model.Order;
import com.zjm.model.OrderTime;
import com.zjm.model.Order_Good;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int insertOrderGood(Order_Good order_good);

    List<Order> findOrderByExample(OrderTime orderTime);
}