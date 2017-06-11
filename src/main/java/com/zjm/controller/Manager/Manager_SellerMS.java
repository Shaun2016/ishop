package com.zjm.controller.Manager;

import com.zjm.model.Shop;
import com.zjm.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJM on 2017/4/13.
 */
@RequestMapping("/seller")
@Controller
public class Manager_SellerMS {
    @Autowired
    private ShopService shopService;

    /*
    转发页面
     */
    @GetMapping("toStatistics")
    public String toStatistics() {
        return "shop/statistics";
    }

    @GetMapping("toStatistics1")
    public String toStatistics1() {
        return "shop/statistics1";
    }
    /*
    显示店铺详情
     */
    @RequestMapping("show")
    public Shop show(int id) throws Exception{
        return shopService.showShop(id);
    }

    /*
    更新店铺信息
     */
    @RequestMapping("update")
    public Shop update(Shop shop) throws Exception {
        return shopService.update(shop);
    }

}
