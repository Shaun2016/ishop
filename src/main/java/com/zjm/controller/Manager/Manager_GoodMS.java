package com.zjm.controller.Manager;

import com.zjm.model.Good;
import com.zjm.service.GoodService;
import com.zjm.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ZJM on 2017/4/13.
 */
@RestController
@RequestMapping("/manager/good")
public class Manager_GoodMS {
    @Autowired
    private GoodService goodService;

    @Autowired
    private ShopService shopService;

    @RequestMapping("showList")
    public List<Good> showList(Good good) throws Exception {
        return goodService.findGoodByExample(good);
    }

    @RequestMapping("add")
    public void add(Good good) throws Exception {
        goodService.add(good);
    }

    @RequestMapping("delete")
    public void delete(int id) throws Exception {
        goodService.delete(id);
    }

    @RequestMapping("showOne")
    public Good showOne(int id) throws Exception{
        return goodService.showGoodDetail(id);
    }
}
