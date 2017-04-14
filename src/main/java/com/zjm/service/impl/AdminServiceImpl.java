package com.zjm.service.impl;

import com.zjm.dao.AdminMapper;
import com.zjm.dao.ShopMapper;
import com.zjm.enums.ResultEnum;
import com.zjm.exception.AdminException;
import com.zjm.model.Admin;
import com.zjm.model.Shop;
import com.zjm.service.AdminSerivce;
import com.zjm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJM on 2017/4/13.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminSerivce{
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Admin isPass(Admin admin) throws Exception {
        List<Admin> list = adminMapper.selectByExample(admin);
        if(list.size() == 0)
            return null;
        return list.get(0);
    }

    @Override
    public void updatePassword(Admin admin, String newPassword) throws Exception {
        if(isPass(admin) == null)
            throw new AdminException(ResultEnum.PASSWORD_ERROR);
        admin.setPassword(MD5.getMd5(newPassword));
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public List<Shop> showShop() throws Exception {
        return shopMapper.selectByExample(new Shop());
    }

    @Override
    public int passShop(int shopId) throws Exception {
        return shopMapper.passShop(shopId);
    }
}
