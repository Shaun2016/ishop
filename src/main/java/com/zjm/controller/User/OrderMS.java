package com.zjm.controller.User;

import com.zjm.model.Order;
import com.zjm.model.Result;
import com.zjm.model.Transaction;
import com.zjm.model.User;
import com.zjm.service.OrderService;
import com.zjm.util.MyJson;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by ZJM on 2017/4/11.
 */
@RestController
@RequestMapping("/order")
public class OrderMS {
    @Autowired
    private OrderService orderService;

    @RequestMapping("myorders")
    public String myOrders(Order order) throws Exception {
        return MyJson.toJson(orderService.showMyOrder(order));
    }

    @RequestMapping("detail")
    public String detail(String orderId) throws Exception {
        return MyJson.toJson(orderService.showOrderDetail(orderId));
    }

    @RequestMapping("createOrder")
    public Result createOrder(Order order, HttpSession session) throws Exception {
        Transaction transaction = orderService.turnGoodToOrder(order);
        session.setAttribute("transaction",transaction);
        System.out.println("..............."+transaction);
        return ResultUtil.success(transaction);
    }

    @RequestMapping("pay")
    public Result pay(User user, HttpSession session ) throws Exception {
        Transaction transaction = (Transaction) session.getAttribute("transaction");
        return orderService.checkPay(transaction,user);
    }


}
