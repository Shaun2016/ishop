package com.zjm.dao;

import com.zjm.model.ShopCar;

import java.util.List;

public interface ShopCarMapper {
    int insert(ShopCar record);

    int delete(int id);

    List<ShopCar> selectByUserKey(int id);

    int select(ShopCar shopCar);
}