package com.zjm.service;

import com.zjm.model.Follow_User;
import com.zjm.model.Shop;

import java.util.List;

/**
 * Created by ZJM on 2017/4/9.
 */
 public interface ShopService {
     List<Shop> findShop(String input) throws Exception;

     Shop showShop(int id) throws Exception;

     void followShop(Follow_User follow_user) throws Exception;

     void cancelFollowShop(Follow_User follow_user) throws Exception;

     List<Shop> showMyFollow(int userId) throws Exception;
    /*
    商家登录
     */
     Shop isPass(Shop shop) throws Exception;

     Shop update(Shop shop) throws Exception;
}
