package com.zjm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjm.dao.Collection_UserMapper;
import com.zjm.dao.GoodMapper;
import com.zjm.dao.ShopCarMapper;
import com.zjm.model.Collection_User;
import com.zjm.model.Good;
import com.zjm.model.ShopCar;
import com.zjm.model.User;
import com.zjm.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ZJM on 2017/4/6.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private Collection_UserMapper collection_userMapper;

    @Autowired
    private ShopCarMapper shopCarMapper;

    public List<Good> findGoodByExample(Good good) {
        PageHelper.startPage(1,4);
        return goodMapper.selectByExample(good);
    }

    @Override
    public Good showGoodDetail(int id) throws Exception {
        return goodMapper.selectByPrimaryKey(id);
    }

    @Override
    public void collect(Collection_User collection_user) throws Exception {
        collection_userMapper.insert(collection_user);
    }

    /*
    取消收藏某商品：需要商品的 id 和 用户的 id
     */
    @Override
    public void removeCollect(Collection_User collection_user) throws Exception {
        collection_userMapper.delete(collection_user);
    }

    @Override
    public List<Good> showMyCollection(int userId) throws Exception {
        return collection_userMapper.selectCollectionByUser(userId);
    }

    @Override
    public void addGoodToShopCar(ShopCar shopCar) throws Exception {
        shopCar.setTime(new Date());
        shopCarMapper.insert(shopCar);
    }

}
