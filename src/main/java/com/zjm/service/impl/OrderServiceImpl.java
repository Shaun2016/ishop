package com.zjm.service.impl;

import com.zjm.dao.GoodMapper;
import com.zjm.dao.OrderMapper;
import com.zjm.dao.UserMapper;
import com.zjm.enums.OrderStateEnum;
import com.zjm.enums.ResultEnum;
import com.zjm.exception.OrderException;
import com.zjm.exception.UserException;
import com.zjm.model.*;
import com.zjm.service.OrderService;
import com.zjm.util.TimeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ZJM on 2017/4/11.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Order> showMyOrder(Order order) throws Exception {
        return orderMapper.selectOrderByExample(order);
    }

    @Override
    public Order showOrderDetail(String orderId) throws Exception {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    @Transactional
    public Transaction turnGoodToOrder(List<Order> orderList) throws Exception {
        float total = 0;
        for(Order order:orderList) {
            float oneOrderTotal = 0;
            List<Order_Good> order_goodList = order.getOrder_goodList();
            System.out.println("Order..."+order);
            System.out.println("order_goodList..."+order_goodList);
            oneOrderTotal += getGoodsTotal(order_goodList);
            order.setTotal(oneOrderTotal);
            generatorOrder(order,order_goodList);
            total += oneOrderTotal;
        }
        Date date = new Date();
        Transaction transaction = new Transaction();
        transaction.setTotal(total);
        transaction.setDate(date);
        transaction.setOrderList(orderList);
        return transaction;
    }

    private void generatorOrder(Order order,List<Order_Good> list) throws Exception{
        orderMapper.insert(order);
        for(Order_Good item : list) {
            item.setOrderId(order.getId());
            orderMapper.insertOrderGood(item);
        }
    }

    private float getGoodsTotal(List<Order_Good> list) throws Exception {
        int length = list.size();
System.out.println(length);
        int[] ids = new int[length];
        for(int i=0;i<length;i++) {
System.out.println(list.get(i));
            ids[i] = list.get(i).getGoodId();
        }
        return goodMapper.selectPriceAndDelFee(ids);
    }

    @Override
    public Transaction checkPay(Transaction transaction, User user) throws Exception {
        List<User> userList = userMapper.selectUserByExample(user);
        if(userList.size() == 0) {
            throw new UserException(ResultEnum.PAY_PASSWORD_ERROR);
        }
        if(TimeFactory.validateTimeStamp(transaction.getDate())) {
            throw new OrderException(ResultEnum.DEAL_OERTIME);
        }
        if(userList.get(0).getCount() < transaction.getTotal()) {
            throw new OrderException(ResultEnum.COUNT_NOT_ENOUGH);
        }
        List<Order> orderList = transaction.getOrderList();
        for(Order order: orderList) {
            order.setState(OrderStateEnum.WAIT_DELIVERY.getCode());
            orderMapper.updateState(order);
        }
        user.setCount(transaction.getTotal());
        userMapper.updateCount(user);
        return null;
    }

}
