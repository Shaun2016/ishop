package com.zjm.service.impl;

import com.github.pagehelper.PageInfo;
import com.zjm.model.Good;
import com.zjm.service.GoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/6.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodServiceImplTest {

    @Autowired
    private GoodService goodService;

    @Test
    public void findGoodByExample() throws Exception {
        Good good = new Good();
        good.setName("口");
        List<Good> l = goodService.findGoodByExample(good);
        System.out.println(l.size() + "_" + l);
        for (Good item:l) {
            System.out.println(item);
        }
        PageInfo pageInfo = new PageInfo(l);
        System.out.println(pageInfo);
    }

}