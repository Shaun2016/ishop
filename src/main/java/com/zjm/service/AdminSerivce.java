package com.zjm.service;

import com.zjm.model.Admin;
import com.zjm.model.FeedBack;
import com.zjm.model.Shop;

import java.util.List;

/**
 * Created by ZJM on 2017/4/13.
 */
 public interface AdminSerivce {
     Admin isPass(Admin admin) throws Exception;

     Admin changePassword(Admin admin,String newPassword) throws Exception;

     void updatePassword(Admin admin,String newPassword) throws Exception;

     List<Shop> showShop() throws Exception;

     int passShop(int shopId) throws Exception;

     List<FeedBack> showFeedBack(FeedBack feedBack) throws Exception;
}
