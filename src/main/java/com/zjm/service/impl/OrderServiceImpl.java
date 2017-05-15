package com.zjm.service.impl;

import com.zjm.dao.GoodMapper;
import com.zjm.dao.OrderMapper;
import com.zjm.dao.UserMapper;
import com.zjm.enums.OrderStateEnum;
import com.zjm.enums.ResultEnum;
import com.zjm.exception.UserException;
import com.zjm.model.*;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodMapper goodMapper;

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
        /*
        计算总价
         */
        float total = 0;
        int goodNum = list.size();
        int[] ids = new int[goodNum];
        for(int i = 0;i < goodNum; i++) {
            ids[i] = list.get(i).getGoodId();
        }
        total = goodMapper.selectPriceAndDelFee(ids);
        order.setTotal(total);
        /*
        检查用户账户余额
         */
        float count = userMapper.selectCount(order.getUserId());
        /*
        比较余额是否够用
         */
        if(count < total) {
            //生成订单 状态为：待付款
            order.setState(OrderStateEnum.WAIT_PAY.getCode());
            generatorOrder(order,list);
            //提示用户余额不足
            throw new UserException(ResultEnum.COUNT_NOT_ENOUGH);
        }
        /*
        扣除交易金额
         */
        User user = new User();
        user.setId(order.getUserId());
        user.setCount(total);
        /*
        生成订单 状态为：待发货
         */
        order.setState(OrderStateEnum.WAIT_DELIVERY.getCode());
        generatorOrder(order,list);
    }

    private void generatorOrder(Order order,List<Order_Good> list) {
        orderMapper.insert(order);
        for(Order_Good item : list) {
            item.setOrderId(order.getId());
            orderMapper.insertOrderGood(item);
        }
    }
}
