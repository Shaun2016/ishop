package com.zjm.dao;

import com.zjm.model.ShopCar;

public interface ShopCarMapper {
    int insert(ShopCar record);

    int insertSelective(ShopCar record);
}