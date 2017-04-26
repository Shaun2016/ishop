package com.zjm.dao;

import com.zjm.model.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    Good selectByPrimaryKeyOnlyGood(Integer id);

    List<Good> selectAllGoodByShopId(int shopId);

    List<Good> selectByExample(Good good);

    List<Good> sortByHigherPrice();

    List<Good> sortByLowerPrice();

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}