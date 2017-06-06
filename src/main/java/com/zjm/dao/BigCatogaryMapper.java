package com.zjm.dao;

import com.zjm.model.BigCatogary;

import java.util.List;

public interface BigCatogaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BigCatogary record);

    int insertSelective(BigCatogary record);

    BigCatogary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BigCatogary record);

    int updateByPrimaryKey(BigCatogary record);

    List<BigCatogary> selectByShopId(int shopId);
}