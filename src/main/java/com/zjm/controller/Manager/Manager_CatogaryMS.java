package com.zjm.controller.Manager;

import com.zjm.model.BigCatogary;
import com.zjm.model.Shop;
import com.zjm.service.CatogaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZJM on 2017/6/5.
 */
@Controller
@RequestMapping("catogary")
public class Manager_CatogaryMS {

    @Autowired
    private CatogaryService catogaryService;

    @GetMapping("/")
    public String showCatogary(HttpSession session,Model model) {
        Shop shop = (Shop)session.getAttribute("shop");
        int shopId = shop.getId();
        List<BigCatogary> list = catogaryService.showCatogaryByShop(shopId);
        model.addAttribute("catogary",list);
        return "shop/catogary";
    }

    @ResponseBody
    @GetMapping("/getCatogary")
    public List<BigCatogary> getCatogary(HttpSession session) {
        Shop shop = (Shop)session.getAttribute("shop");
        int shopId = shop.getId();
        List<BigCatogary> list = catogaryService.showCatogaryByShop(shopId);
        return list;
    }
}
