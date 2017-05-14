package com.zjm.service;

import com.zjm.model.*;

import java.util.List;

/**
 * Created by ZJM on 2017/4/6.
 */
public interface UserService {
    public User isPass(User user) throws Exception;

    public User showUserDetail(User user) throws Exception;

    public User changePassword(User user,String newPassword) throws Exception;

    public User update(User user) throws Exception;

    public boolean nickNameIsExit(String nickName) throws Exception;

    public boolean phoneIsExist(String phone) throws Exception;

    public User addUser(User user) throws Exception;

    public List<Address> showMyAddress(int userId) throws Exception;

    public List<Good> showMyCollection(int userId) throws Exception;

    public void removeCollection(List<Collection_User> collection_user) throws Exception;
    /*
    问题反馈
     */
    public void Comment(Comment comment) throws Exception;
    /*
    是否已评论
     */
    public boolean isComment(Comment comment) throws Exception;
}
