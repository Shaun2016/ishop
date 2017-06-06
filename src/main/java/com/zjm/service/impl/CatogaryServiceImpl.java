package com.zjm.service.impl;

import com.zjm.dao.BigCatogaryMapper;
import com.zjm.dao.SmallCatogaryMapper;
import com.zjm.model.BigCatogary;
import com.zjm.model.SmallCatogary;
import com.zjm.service.CatogaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJM on 2017/6/5.
 */
@Service("catogaryService")
public class CatogaryServiceImpl implements CatogaryService{

    @Autowired
    private BigCatogaryMapper bigCatogaryMapper;

    @Autowired
    private SmallCatogaryMapper smallCatogaryMapper;

    @Override
    public int addBigCatogary(BigCatogary bigCatogary) {
        return bigCatogaryMapper.insert(bigCatogary);
    }

    @Override
    public int removeBigCatogary(int id) {
        return bigCatogaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int renameBigCatogary(BigCatogary bigCatogary) {
        return bigCatogaryMapper.updateByPrimaryKeySelective(bigCatogary);
    }

    @Override
    public List<BigCatogary> showCatogaryByShop(int shopId) {
        return bigCatogaryMapper.selectByShopId(shopId);
    }

    @Override
    public int addSmallCatogary(SmallCatogary smallCatogary) {
        return smallCatogaryMapper.insert(smallCatogary);
    }

    @Override
    public int removeSmallCatogary(int id) {
        return smallCatogaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int renameSmallCatogary(SmallCatogary smallCatogary) {
        return 0;
    }
}
