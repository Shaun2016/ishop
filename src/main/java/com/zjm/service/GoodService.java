package com.zjm.service;

import com.zjm.model.Collection_User;
import com.zjm.model.Good;
import com.zjm.model.ShopCar;

import java.util.List;

/**
 * Created by ZJM on 2017/4/6.
 */
public interface GoodService {

    public List<Good> findGoodByExample(Good good) throws Exception;

    public Good showGoodDetail(int id) throws Exception;

    public void collect(Collection_User collection_user) throws Exception;

    public void removeCollect(Collection_User collection_user) throws Exception;

    public List<Good> showMyCollection(int userId) throws Exception;

    public void addGoodToShopCar(ShopCar shopCar) throws Exception;

    public boolean checkShopCar(ShopCar shopCar) throws Exception;
    /*
    查看是否收藏过该商品
     */
    public boolean isCollected(Collection_User collection_user) throws Exception;
    //商家部分：

    public void add(Good good) throws Exception;

    public void delete(int id) throws Exception;

    public Good update(Good good) throws Exception;

    public Good showGood(int id) throws Exception;

    public List<Good> showAll(int shopId) throws Exception;
}
