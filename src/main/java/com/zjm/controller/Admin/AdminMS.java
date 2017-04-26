package com.zjm.controller.Admin;

import com.zjm.enums.ResultEnum;
import com.zjm.exception.AdminException;
import com.zjm.model.Admin;
import com.zjm.model.FeedBack;
import com.zjm.model.Result;
import com.zjm.model.Shop;
import com.zjm.service.AdminSerivce;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZJM on 2017/4/17.
 */
@RestController
@RequestMapping("/admin")
public class AdminMS {
    @Autowired
    private AdminSerivce adminSerivce;

    @RequestMapping("login")
    public Result login(Admin admin, HttpSession httpSession) throws Exception {
        admin = adminSerivce.isPass(admin);
        if(admin == null) {
            return ResultUtil.error(ResultEnum.USER_PASSWORD_ERROR);
        }
        httpSession.setAttribute("admin",admin);
        return ResultUtil.success(admin);
    }

    @RequestMapping("changePassword")
    public Result changePassword(Admin admin,String newPassword) throws Exception {
        return ResultUtil.success(adminSerivce.changePassword(admin,newPassword));
    }

    @RequestMapping("passShop")
    public Result passShop(int shopId) throws Exception {
        adminSerivce.passShop(shopId);
        return ResultUtil.success();
    }

    @RequestMapping("showFeedBack")
    public List<FeedBack> showFeedBack(FeedBack feedBack) throws Exception {
        return adminSerivce.showFeedBack(feedBack);
    }
}
