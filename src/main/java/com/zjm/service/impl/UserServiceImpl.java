package com.zjm.service.impl;

import com.zjm.dao.ShopCarMapper;
import com.zjm.dao.UserMapper;
import com.zjm.enums.ResultEnum;
import com.zjm.exception.UserException;
import com.zjm.model.ShopCar;
import com.zjm.model.User;
import com.zjm.service.UserService;
import com.zjm.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZJM on 2017/4/9.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public User isPass(User user) throws Exception {
        String password = user.getPassword();
        user.setPassword(MD5.getMd5(password));
        List<User> userList = userMapper.selectUserByExample(user);
        if(userList.size() == 0) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public User changePassword(User user,String newPassword) throws Exception {
        if(isPass(user) == null) {
            throw new UserException(ResultEnum.PASSWORD_ERROR);
        }
        user.setPassword(MD5.getMd5(newPassword));
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public User update(User user) throws Exception {
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public boolean nickNameIsExit(String nickName) throws Exception {
        User user = new User();
        user.setNickname(nickName);
        List<User> userList = userMapper.selectUserByExample(user);
        if(userList.size() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public User addUser(User user) throws Exception{
        if(nickNameIsExit(user.getNickname())) {
            throw new UserException(ResultEnum.NICKNAME_EXIST);
        }
        user.setPassword(MD5.getMd5(user.getPassword()));
        userMapper.insert(user);
        return isPass(user);
    }

    @Override
    public List<ShopCar> showMyShopCar(int userId) throws Exception {
        return shopCarMapper.selectByUserKey(userId);
    }
}
