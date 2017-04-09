package com.zjm.dao;

import com.zjm.model.Follow_User;
import com.zjm.model.Shop;
import com.zjm.model.User;

import java.util.List;

public interface Follow_UserMapper {
    /*
    用户取消关注
     */
    int delete(Follow_User follow_user);

    /*
    用户关注店铺
     */
    int insert(Follow_User record);

    /*
    用户查询已关注的店铺
     */
    List<Shop> selectByUserId(Integer userId);

    /*
    店铺查询本店粉丝
     */
    List<User> selectByShopId(Integer shopId);

}