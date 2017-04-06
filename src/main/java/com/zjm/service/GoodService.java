package com.zjm.service;

import com.zjm.model.Good;

import java.util.List;

/**
 * Created by ZJM on 2017/4/6.
 */
public interface GoodService {
    public List<Good> findGoodByExample(Good good);
}
