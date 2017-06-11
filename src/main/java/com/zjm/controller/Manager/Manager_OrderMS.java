package com.zjm.controller.Manager;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.zjm.model.Order;
import com.zjm.model.Result;
import com.zjm.model.Shop;
import com.zjm.service.OrderService;
import com.zjm.util.MyJson;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZJM on 2017/6/11.
 */
@Controller
@RequestMapping("/s")
public class Manager_OrderMS {

    @Autowired
    private OrderService orderService;

    /*
    转发到页面
     */
    @GetMapping("toOrderList/{state}")
    public String toOrderList(@PathVariable("state") int state) {
        switch (state) {
            case 0:
                return "shop/orderList";
            case 1:
                return "shop/orderList1";
            case 2:
                return "shop/orderList2";
            case 3:
                return "shop/orderList3";
            default:
                return "shop/orderList";
        }
    }

    /*
    显示本店铺的所有订单
     */
    @ResponseBody
    @GetMapping("myOrders")
    public String myOrders(HttpSession session,Order order) throws Exception {
        Shop shop = (Shop)session.getAttribute("shop");
        order.setShopId(shop.getId());
        return MyJson.toJson(orderService.showOrderByShop(order));
    }

    /*
    更改订单状态：模拟
     */
    @GetMapping("changeState")
    public Result changeState(Order order) throws Exception {
        orderService.updateOrderState(order);
        return ResultUtil.success();
    }
}
