package com.zjm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjm.dao.Collection_UserMapper;
import com.zjm.dao.CommentMapper;
import com.zjm.dao.GoodMapper;
import com.zjm.dao.ShopCarMapper;
import com.zjm.model.*;
import com.zjm.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ZJM on 2017/4/6.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private Collection_UserMapper collection_userMapper;

    @Autowired
    private CommentMapper commentMapper;

    public List<Good> findGoodByExample(Good good) {
        return goodMapper.selectByExample(good);
    }

    @Override
    public Good showGoodDetail(int id) throws Exception {
        return goodMapper.selectByPrimaryKey(id);
    }

    @Override
    public void collect(Collection_User collection_user) throws Exception {
        collection_userMapper.insert(collection_user);
    }

    /*
    取消收藏某商品：需要商品的 id 和 用户的 id
     */
    @Override
    public void removeCollect(Collection_User collection_user) throws Exception {
        collection_userMapper.delete(collection_user);
    }

    @Override
    public List<Good> showMyCollection(int userId) throws Exception {
        return collection_userMapper.selectCollectionByUser(userId);
    }

    @Override
    public boolean isCollected(Collection_User collection_user) throws Exception {
        if(collection_userMapper.isCollected(collection_user) == 0)
            return false;
        return true;
    }

    //商家部分：

    @Override
    public void add(Good good) throws Exception {
        goodMapper.insert(good);
    }

    @Override
    public void delete(int id) throws Exception {
        goodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Good update(Good good) throws Exception {
        goodMapper.updateByPrimaryKeySelective(good);
        return good;
    }

    @Override
    public Good showGood(int id) throws Exception {
        return goodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Good> showAll(int shopId) throws Exception {
        return goodMapper.selectAllGoodByShopId(shopId);
    }

    @Override
    public List<Comment> selectCommentByGood(int id) throws Exception {
        return commentMapper.selectByGoodKey(id);
    }

    @Override
    public float total(int[] ids) throws Exception {
        return goodMapper.selectPriceAndDelFee(ids);
    }

}
