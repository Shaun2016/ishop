package com.zjm.dao;

import com.zjm.model.SmallCatogary;

public interface SmallCatogaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmallCatogary record);

    int insertSelective(SmallCatogary record);

    SmallCatogary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmallCatogary record);

    int updateByPrimaryKey(SmallCatogary record);
}