package com.zjm.service;

import com.zjm.model.Order;
import com.zjm.model.ShopCar;

import java.util.List;

/**
 * Created by ZJM on 2017/5/14.
 */
public interface ShopCarService {

    public List<ShopCar> showMyShopCar(int userId) throws Exception;

    public boolean addGoodToShopCar(ShopCar shopCar) throws Exception;

    public boolean checkShopCar(ShopCar shopCar) throws Exception;

    public int removeShopCar(int id) throws Exception;

    public int changeGoodNum(ShopCar shopCar) throws Exception;

}
