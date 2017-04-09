package com.zjm.service.impl;

import com.zjm.dao.Follow_UserMapper;
import com.zjm.dao.ShopMapper;
import com.zjm.model.Follow_User;
import com.zjm.model.Shop;
import com.zjm.model.User;
import com.zjm.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZJM on 2017/4/9.
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private Follow_UserMapper follow_userMapper;

    @Override
    public List<Shop> findShop(String input) throws Exception {
        return shopMapper.selectByKeyWord(input);
    }

    @Override
    public Shop showShop(int id) throws Exception {
        return shopMapper.selectByPrimaryKey(id);
    }

    @Override
    public void followShop(Follow_User follow_user) throws Exception {
        follow_userMapper.insert(follow_user);
    }

    @Override
    public void cancelFollowShop(Follow_User follow_user) throws Exception {
        follow_userMapper.delete(follow_user);
    }

    /*
    显示我关注的店铺
     */
    @Override
    public List<Shop> showMyFollow(int userId) throws Exception {
        return follow_userMapper.selectByUserId(userId);
    }


}
