package com.zjm.dao;

import com.zjm.model.ShopCar;

import java.util.List;

public interface ShopCarMapper {
    int insert(ShopCar record) throws Exception;

    int delete(int id) throws Exception;

    List<ShopCar> selectByUserKey(int id) throws Exception;

    int select(ShopCar shopCar) throws Exception;

    int deleteIds(int[] id) throws Exception;

    int update(ShopCar shopCar);
}