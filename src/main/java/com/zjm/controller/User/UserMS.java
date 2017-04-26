package com.zjm.controller.User;

import com.sun.javafx.collections.MappingChange;
import com.zjm.dao.UserMapper;
import com.zjm.enums.ResultEnum;
import com.zjm.model.*;
import com.zjm.service.UserService;
import com.zjm.util.MD5;
import com.zjm.util.MyJson;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZJM on 2017/4/8.
 */
@RestController
@RequestMapping("/user")
public class UserMS {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Result<User> login(User user, HttpSession httpSession) throws Exception{
        user = userService.isPass(user);
        if(user == null) {
            return ResultUtil.error(ResultEnum.USER_PASSWORD_ERROR);
        }
        httpSession.setAttribute("user",user);
        return ResultUtil.success(user);
    }

    @RequestMapping("regist")
    public String regist(User user) throws Exception {
        userService.addUser(user);
        return MyJson.toJson(ResultUtil.success(user));
    }

    @RequestMapping("changePassword")
    public User changePassword(User user,String newPassword) throws Exception {
        return userService.changePassword(user,newPassword);
    }

    @RequestMapping("update")
    public User update(User user) throws Exception {
        return userService.update(user);
    }
    /*
    我的购物车
     */
    @RequestMapping("myShopCar")
    public String myShopCar(int userId) throws Exception{
        return MyJson.toJson(userService.showMyShopCar(userId));
    }

    @RequestMapping("logout")
    public void logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        httpSession.invalidate();
    }

    /*
    我的地址
     */
    @RequestMapping("myAddress")
    public List<Address> myAddress(int userId) throws Exception {
        return userService.showMyAddress(userId);
    }

    //评价商品
    @RequestMapping("comment")
    public Result comment(Comment comment) throws Exception {
        userService.Comment(comment);
        return ResultUtil.success();
    }
}
