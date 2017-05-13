package com.zjm.controller.User;

import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zjm.dao.Collection_UserMapper;
import com.zjm.model.*;
import com.zjm.service.GoodService;
import com.zjm.service.UserService;
import com.zjm.util.MyJson;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZJM on 2017/4/9.
 */
@RestController
@RequestMapping("/good")
public class GoodMS {

    @Value("${goodPageNum}")
    private int goodPageNum;

    @Value("${commentPageNum}")
    private int commentPageNum;

    @Autowired
    private GoodService goodService;

    @Autowired
    private UserService userService;

    @RequestMapping("find")
    public String find(Good good,int page) throws Exception {
        PageHelper.startPage(page,goodPageNum,false);
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

    @RequestMapping("initUserInfo")
    public Result initUserInfo(Collection_User collection_user, ShopCar shopCar, Comment comment) throws Exception {
        boolean isCollected = goodService.isCollected(collection_user);
        boolean isCart = goodService.checkShopCar(shopCar);
        boolean isComment = userService.isComment(comment);
        List<Boolean> init = new ArrayList<Boolean>();
        init.add(0,isCollected);
        init.add(1,isCart);
        init.add(2,isComment);
        return ResultUtil.success(init);
    }

    @RequestMapping("showComment")
    public String showComment(int goodId,int page) throws Exception {
        PageHelper.startPage(page,commentPageNum);
        return MyJson.toJson(goodService.selectCommentByGood(goodId));
    }
}
