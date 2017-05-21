package com.zjm.service.impl;

import com.zjm.dao.GoodMapper;
import com.zjm.dao.ShopCarMapper;
import com.zjm.exception.UserException;
import com.zjm.model.Good;
import com.zjm.model.Order;
import com.zjm.model.Order_Good;
import com.zjm.model.ShopCar;
import com.zjm.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ZJM on 2017/5/14.
 */
@Service("shopCarService")
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<ShopCar> showMyShopCar(int userId) throws Exception {
        return shopCarMapper.selectByUserKey(userId);
    }

    @Override
    public boolean addGoodToShopCar(ShopCar shopCar) throws Exception {
        if(checkShopCar(shopCar))
            return false;
        shopCarMapper.insert(shopCar);
        return true;
    }

    @Override
    public boolean checkShopCar(ShopCar shopCar) throws Exception {
        if(shopCarMapper.select(shopCar) == 0)
            return false;
        return true;
    }

    @Override
    public int removeShopCar(int id) throws Exception {
        return shopCarMapper.delete(id);
    }

    @Override
    public int changeGoodNum(ShopCar shopCar) throws Exception {
        return shopCarMapper.update(shopCar);
    }

}
