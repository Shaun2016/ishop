package com.zjm.service;

import com.zjm.model.BigCatogary;
import com.zjm.model.SmallCatogary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJM on 2017/6/5.
 */
public interface CatogaryService {

    int addBigCatogary(BigCatogary bigCatogary);

    int removeBigCatogary(int id);

    int renameBigCatogary(BigCatogary bigCatogary);

    List<BigCatogary> showCatogaryByShop(int shopId);

    int addSmallCatogary(SmallCatogary smallCatogary);

    int removeSmallCatogary(int id);

    int renameSmallCatogary(SmallCatogary smallCatogary);

}
