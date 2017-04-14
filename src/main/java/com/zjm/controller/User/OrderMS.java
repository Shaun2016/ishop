package com.zjm.controller.User;

import com.zjm.model.Order;
import com.zjm.model.OrderTime;
import com.zjm.service.OrderService;
import com.zjm.util.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJM on 2017/4/11.
 */
@RestController
@RequestMapping("/order")
public class OrderMS {
    @Autowired
    private OrderService orderService;

    @RequestMapping("myorders")
    public String myOrders(OrderTime order) throws Exception{
        return MyJson.toJson(orderService.showMyOrder(order));
    }

    @RequestMapping("detail")
    public String detail(String orderId) throws Exception{
        return MyJson.toJson(orderService.showOrderDetail(orderId));
    }

    @RequestMapping("buy")
    public void buy(Order order) throws Exception{
        orderService.turnGoodToORder(order);
    }
}
