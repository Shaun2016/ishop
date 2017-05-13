package com.zjm.service;

import com.zjm.model.Size;

import java.util.List;

/**
 * Created by ZJM on 2017/5/13.
 */
public interface SizeService {

    public List<Size> selectByGood(int goodId) throws Exception;

    public int insert(Size size) throws Exception;

    public int delete(int id) throws Exception;

    public int updateSizeBySelective(Size size) throws Exception;

}
