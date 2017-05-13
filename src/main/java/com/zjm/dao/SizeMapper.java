package com.zjm.dao;

import com.zjm.model.Size;

import java.util.List;

public interface SizeMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Size record) throws Exception;

    int insertSelective(Size record) throws Exception;

    Size selectByPrimaryKey(Integer id) throws Exception;

    List<Size> selectByGoodId(Integer goodId) throws Exception;

    int updateByPrimaryKeySelective(Size record) throws Exception;

    int updateByPrimaryKey(Size record);
}