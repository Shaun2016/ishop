package com.zjm.service;

import com.zjm.model.Admin;
import com.zjm.model.Shop;

import java.util.List;

/**
 * Created by ZJM on 2017/4/13.
 */
public interface AdminSerivce {
    public Admin isPass(Admin admin) throws Exception;

    public void updatePassword(Admin admin,String newPassword) throws Exception;

    public List<Shop> showShop() throws Exception;

    public int passShop(int shopId) throws Exception;
}
