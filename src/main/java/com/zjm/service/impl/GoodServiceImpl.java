package com.zjm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjm.dao.GoodMapper;
import com.zjm.model.Good;
import com.zjm.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJM on 2017/4/6.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    public List<Good> findGoodByExample(Good good) {
        PageHelper.startPage(1,4);
        return goodMapper.selectByExample(good);
    }

}
