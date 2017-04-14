package com.zjm.service;

import com.zjm.model.Follow_User;
import com.zjm.model.Shop;

import java.util.List;

/**
 * Created by ZJM on 2017/4/9.
 */
public interface ShopService {
    public List<Shop> findShop(String input) throws Exception;

    public Shop showShop(int id) throws Exception;

    public void followShop(Follow_User follow_user) throws Exception;

    public void cancelFollowShop(Follow_User follow_user) throws Exception;

    public List<Shop> showMyFollow(int userId) throws Exception;
    /*
    商家登录
     */
    public Shop isPass(Shop shop) throws Exception;

    public Shop update(Shop shop) throws Exception;
}
