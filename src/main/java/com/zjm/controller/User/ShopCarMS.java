package com.zjm.controller.User;

import com.zjm.model.Order;
import com.zjm.model.Result;
import com.zjm.model.ShopCar;
import com.zjm.service.ShopCarService;
import com.zjm.util.MyJson;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJM on 2017/5/14.
 */
@RestController
@RequestMapping("shopCar")
public class ShopCarMS {
    @Autowired
    private ShopCarService shopCarService;

    /*
    添加购物车
     */
    @RequestMapping("addCart")
    public Result addCart(ShopCar shopCar) throws Exception {
        shopCarService.addGoodToShopCar(shopCar);
        return ResultUtil.success();
    }

    /*
    我的购物车
     */
    @RequestMapping("myCart")
    public String myCart(int userId) throws Exception{
        return MyJson.toJson(shopCarService.showMyShopCar(userId));
    }

    /*
    移除购物车
     */
    @RequestMapping("remove")
    public Result remove(int []id) throws Exception {
        int n = shopCarService.removeShopCar(id);
        return ResultUtil.success(n);
    }
    /*
    更改购物车中商品数量
     */
    @RequestMapping("changeNum")
    public Result changeNum(ShopCar shopCar) throws Exception {
        int n = shopCarService.changeGoodNum(shopCar);
        return ResultUtil.success(n);
    }

}
