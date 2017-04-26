package com.zjm.controller.User;

import com.zjm.dao.Collection_UserMapper;
import com.zjm.model.Collection_User;
import com.zjm.model.Good;
import com.zjm.model.Result;
import com.zjm.model.ShopCar;
import com.zjm.service.GoodService;
import com.zjm.util.MyJson;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ZJM on 2017/4/9.
 */
@RestController
@RequestMapping("/good")
public class GoodMS {
    @Autowired
    private GoodService goodService;

    @RequestMapping("find")
    public String find(Good good) throws Exception {
        return MyJson.toJson(goodService.findGoodByExample(good));
    }

    @RequestMapping("show")
    public String show(int id) throws Exception {
        return MyJson.toJson(goodService.showGoodDetail(id));
    }

    @RequestMapping("isCollected")
    public Result isCollected(Collection_User collection_user) throws Exception {
        return ResultUtil.success(goodService.isCollected(collection_user));
    }
    @RequestMapping("collect")
    public Result collect(Collection_User collection_user) throws Exception {
        goodService.collect(collection_user);
        return ResultUtil.success();
    }

    @RequestMapping("removeCollect")
    public Result removeCollect(Collection_User collection_user) throws Exception {
        goodService.removeCollect(collection_user);
        return ResultUtil.success();
    }

    /*
    我收藏的商品
     */
    @RequestMapping("myCollect")
    public String myCollect(int userId) throws Exception {
        return MyJson.toJson(goodService.showMyCollection(userId));
    }

    @RequestMapping("addShopCar")
    public Result addShopCar(ShopCar shopCar) throws Exception {
        goodService.addGoodToShopCar(shopCar);
        return ResultUtil.success();
    }

    @RequestMapping("checkCart")
    public Result checkCart(ShopCar shopCar) throws Exception {
        if(goodService.checkShopCar(shopCar)) {
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }
}
