package com.zjm.controller.User;

import com.github.pagehelper.PageHelper;
import com.zjm.model.*;
import com.zjm.service.GoodService;
import com.zjm.util.MyJson;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJM on 2017/4/9.
 */
@RestController
@RequestMapping("/good")
public class GoodMS {

    @Value("${pageNum}")
    private int pageNum;

    @Value("${commentPageNum}")
    private int commentPageNum;

    @Autowired
    private GoodService goodService;

    @RequestMapping("find")
    public String find(Good good,int page) throws Exception {
        PageHelper.startPage(page,pageNum,false);
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

    @RequestMapping("isComment")
    public Result isComment(Collection_User collection_user) throws Exception {
        boolean isCollected = goodService.isCollected(collection_user);
        return ResultUtil.success(isCollected);
    }

    @RequestMapping("showComment")
    public String showComment(int goodId,int page) throws Exception {
        PageHelper.startPage(page,commentPageNum,false);
        return MyJson.toJson(goodService.selectCommentByGood(goodId));
    }
}
