package com.zjm.controller.Manager;

import com.zjm.model.Shop;
import com.zjm.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJM on 2017/4/13.
 */
@RestController
@RequestMapping("/manager/seller")
public class Manager_SellerMS {
    @Autowired
    private ShopService shopService;

    @RequestMapping("show")
    public Shop show(int id) throws Exception{
        return shopService.showShop(id);
    }

    @RequestMapping("update")
    public Shop update(Shop shop) throws Exception {
        return shopService.update(shop);
    }

}
