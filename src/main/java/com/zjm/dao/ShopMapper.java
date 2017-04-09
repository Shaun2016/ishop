package com.zjm.dao;

import com.zjm.model.Shop;

import java.util.List;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer id);
    /*
    查询条件限制于 店铺名称 和 店铺标签 ，店铺简介
     */
    List<Shop> selectByKeyWord(String input);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    int decreateFansNum(int id);

    int increateFansNum(int id);

    int passShop(int id);
}