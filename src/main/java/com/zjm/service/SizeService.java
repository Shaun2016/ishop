package com.zjm.service;

import com.zjm.model.Size;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJM on 2017/5/13.
 */
@Service("sizeService")
public interface SizeService {

     List<Size> selectByGood(int goodId) throws Exception;

     int insert(Size size) throws Exception;

     int delete(int id) throws Exception;

     int updateSizeBySelective(Size size) throws Exception;

}
