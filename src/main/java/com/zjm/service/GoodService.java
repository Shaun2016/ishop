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
}
