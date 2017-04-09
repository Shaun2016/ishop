package com.zjm.controller;

import com.zjm.model.FeedBack;
import com.zjm.model.Follow_User;
import com.zjm.model.Shop;
import com.zjm.service.ShopService;
import com.zjm.util.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ZJM on 2017/4/9.
 */
@RestController
@RequestMapping("/shop")
public class ShopMS {
    @Autowired
    private ShopService shopService;

    @RequestMapping("find")
    public List<Shop> find(String input) throws Exception{
        return shopService.findShop(input);
    }

    @RequestMapping("show")
    public Shop show(int id) throws Exception {
        return shopService.showShop(id);
    }

    @RequestMapping("follow")
    public void follow(Follow_User follow_user) throws Exception {
        shopService.followShop(follow_user);
    }

    @RequestMapping("cancelFollow")
    public void cancelFollow(Follow_User follow_user) throws Exception {
        shopService.cancelFollowShop(follow_user);
    }

    /*
    我关注的店铺
     */
    @RequestMapping("myFollow")
    public String myFollow(int userId) throws Exception {
        return MyJson.toJson(shopService.showMyFollow(userId));
    }
}
