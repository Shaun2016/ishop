package com.zjm.service.impl;

import com.zjm.dao.GoodMapper;
import com.zjm.dao.OrderMapper;
import com.zjm.dao.TradeMapper;
import com.zjm.dao.UserMapper;
import com.zjm.enums.OrderStateEnum;
import com.zjm.enums.ResultEnum;
import com.zjm.exception.OrderException;
import com.zjm.exception.UserException;
import com.zjm.model.*;
import com.zjm.service.OrderService;
import com.zjm.util.ResultUtil;
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
    private TradeMapper tradeMapper;

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
    public Transaction turnGoodToOrder(Order order) throws Exception {
        System.out.println("Order..."+order);
        List<Order_Good> order_goodList = order.getOrder_goodList();
        System.out.println("order_goodList..."+order_goodList);
        order.setTime(TimeFactory.getCurrentTime());
        order.setState(OrderStateEnum.WAIT_PAY.getCode());
        generatorOrder(order,order_goodList);
        Transaction transaction = new Transaction();
        transaction.setTotal(order.getTotal());
        transaction.setOrder(order);
        return transaction;
    }

    private void generatorOrder(Order order,List<Order_Good> list) throws Exception{
        orderMapper.insert(order);
        for(Order_Good item : list) {
            item.setOrderId(order.getId());
            orderMapper.insertOrderGood(item);
        }
    }

    @Transactional
    @Override
    public Result checkPay(Transaction transaction, User user) throws Exception {
        List<User> userList = userMapper.selectUserByExample(user);
        if(userList.size() == 0) {
            throw new UserException(ResultEnum.PAY_PASSWORD_ERROR);
        }
        /*if(TimeFactory.validateTimeStamp(transaction.getDate())) {
            throw new OrderException(ResultEnum.DEAL_OERTIME);
        }*/
        if(userList.get(0).getCount() < transaction.getTotal()) {
            throw new OrderException(ResultEnum.COUNT_NOT_ENOUGH);
        }
        Order order = transaction.getOrder();
        order.setState(OrderStateEnum.WAIT_DELIVERY.getCode());
        orderMapper.updateState(order);
        user.setCount(transaction.getTotal());
        userMapper.updateCount(user);
        //插入交易流水
        Trade trade = new Trade();
        trade.setUserid(user.getId());
        trade.setOrderid(order.getId());
        trade.setTime(TimeFactory.getCurrentTime());
        trade.setShopid(transaction.getShopId());
        trade.setTotal(order.getTotal());
        tradeMapper.insert(trade);
        return ResultUtil.success(trade);
    }

    @Override
    public List<Order> showOrderByShop(Order order) throws Exception {
        return orderMapper.selectByShopId(order);
    }

    @Override
    public int updateOrderState(Order order) throws Exception {
        return orderMapper.updateState(order);
    }

}
