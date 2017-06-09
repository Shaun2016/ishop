package com.zjm.service;

import com.zjm.model.*;

import java.util.List;

/**
 * Created by ZJM on 2017/4/6.
 */
public interface UserService {
    User isPass(User user) throws Exception;

    User showUserDetail(User user) throws Exception;

    User changePassword(User user,String newPassword) throws Exception;

    User update(User user) throws Exception;

    boolean nickNameIsExit(String nickName) throws Exception;

    boolean phoneIsExist(String phone) throws Exception;

    User addUser(User user) throws Exception;

    List<Address> showMyAddress(int userId) throws Exception;

    Address showMyDefaultAddr(int userId) throws Exception;

    List<Good> showMyCollection(int userId) throws Exception;

    void removeCollection(List<Collection_User> collection_user) throws Exception;
    /*
    问题反馈
     */
    void Comment(Comment comment) throws Exception;
    /*
    是否已评论
     */
    boolean isComment(Comment comment) throws Exception;

    /*
    用户账户余额操作
     */
    float userCount(int userId) throws Exception;

    int trade(User user) throws Exception;
}
