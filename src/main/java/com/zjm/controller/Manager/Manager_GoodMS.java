package com.zjm.controller.Manager;

import com.zjm.dao.SizeMapper;
import com.zjm.model.Good;
import com.zjm.model.Result;
import com.zjm.model.Shop;
import com.zjm.model.Size;
import com.zjm.service.*;
import com.zjm.util.Data;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ZJM on 2017/4/13.
 */
@Controller
public class Manager_GoodMS {

    @Autowired
    private GoodService goodService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private Data data;

    @Autowired
    private CatogaryService catogaryService;

    /*
    页面跳转的函数
     */
    @RequestMapping("/")
    public String auto() {
        return "shop/login";
    }

    @RequestMapping("/toList")
    public String toList(HttpSession session) {
        return "shop/good";
    }

    @RequestMapping("/toDetail")
    public String toDetail(int id, Map<String,Object> map) throws Exception{
        map.put("good",goodService.showGoodDetail(id));
        map.put("tab",sizeService.selectByGood(id));
        return "shop/goodDetail";
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(int id) throws Exception{
        Good good = goodService.showGood(id);
        ModelAndView mv = new ModelAndView("shop/editGood");
        String expirationDate = good.getExpirationdate();
        mv.addObject("good",good);
        return mv;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(ModelAndView mv,String msg,String last) {
        mv.setViewName("shop/addGood");
        if(msg == null) msg = "";
        if(last == null) last = "";
        mv.addObject("msg",msg);
        mv.addObject("last",last);
        return mv;
    }

    /*
    操作
     */
    @RequestMapping("/login")
    public ModelAndView login(Shop shop, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        String url = "forward:./";
        shop = shopService.isPass(shop);
        if(shop != null) {
            session.setAttribute("shop",shop);
            storageService.init(shop.getId());
            url = "redirect:./toList";
        } else {
            mv.addObject("sign","用户名或密码错误！");
        }
        mv.setViewName(url);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/showList")
    public Data showList(HttpSession session) throws Exception {
        Shop shop = (Shop)session.getAttribute("shop");
        if(shop != null) {
            data.setData(goodService.showAll(shop.getId()));
        }
        return data;

    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam("file")MultipartFile file, Good good,String product, HttpSession session, ModelAndView mv) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        good.setProductdate(dateFormat.parse(product));
        Shop shop = (Shop)session.getAttribute("shop");
        if(!file.isEmpty())
            good.setPic(getShopIdAsUrl(shop) + file.getOriginalFilename());
        good = updateHandler(good);
        if(good.getPic() != null)
            storageService.store(file);
        goodService.update(good);
        mv.setViewName("redirect:./toList");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("file")MultipartFile file, Good good,String product,String time,HttpSession session,ModelAndView mv,MultipartFile[] tab,String tabName[],float[] tabPrice,int[] tabNum) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(!product.equals(""))
            good.setProductdate(dateFormat.parse(product));
        good.setExpirationdate(good.getExpirationdate() + time);
        mv.addObject("last",good.getName());
        mv.setViewName("redirect:./toAdd");
        Shop shop = (Shop)session.getAttribute("shop");
        good.setShopId(shop.getId());
        if(!file.isEmpty()) {
            good.setPic(getShopIdAsUrl(shop) + file.getOriginalFilename());
            storageService.store(file);
        }
        goodService.add(good);
        System.out.println(good);
        for(int i=0;i<tab.length;i++) {
            Size size = new Size();
            if(!tab[i].isEmpty()) {
                size.setImg(getShopIdAsUrl(shop) + tab[i].getOriginalFilename());
                storageService.store(tab[i]);
            }
            size.setName(tabName[i]);
            size.setNum(tabNum[i]);
            size.setPrice(tabPrice[i]);
            size.setGoodId(good.getId());
            sizeService.insert(size);
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Result delete(int id) throws Exception {
        goodService.delete(id);
        return ResultUtil.success();
    }

    private Good updateHandler(Good good) throws Exception{
        Good temp = goodService.showGood(good.getId());
        if(temp.getName() == good.getName()) good.setName(null);
        if(temp.getProductdate() == good.getProductdate()) good.setProductdate(null);
        if(temp.getPrice() == good.getPrice()) good.setPrice(null);
        if(temp.getBigCatogary().getId() == good.getBigCatogaryId()) good.setBigCatogary(null);
        if(temp.getPic() == good.getPic()) good.setPic(null);
        if(temp.getSmallCatogary().getId() == good.getSmallCatogaryId()) good.setSmallCatogary(null);
        if(temp.getDeliveryFee() == good.getDeliveryFee()) good.setDeliveryFee(-1);
        return good;
    }

    private String getShopIdAsUrl(Shop shop) {
        return "s" + shop.getId() + "/";
    }
}
