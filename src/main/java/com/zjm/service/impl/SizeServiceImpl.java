package com.zjm.service.impl;

import com.zjm.dao.SizeMapper;
import com.zjm.model.Size;
import com.zjm.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJM on 2017/5/13.
 */
@Service("sizeService")
public class SizeServiceImpl implements SizeService{

    @Autowired
    private SizeMapper sizeMapper;

    @Override
    public List<Size> selectByGood(int goodId) throws Exception {
        return sizeMapper.selectByGoodId(goodId);
    }

    @Override
    public int insert(Size size) throws Exception {
        return sizeMapper.insert(size);
    }

    @Override
    public int delete(int id) throws Exception {
        return sizeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateSizeBySelective(Size size) throws Exception {
        return sizeMapper.updateByPrimaryKeySelective(size);
    }
}
