package com.zjm.controller.Manager;

import com.zjm.model.Good;
import com.zjm.model.Result;
import com.zjm.model.Shop;
import com.zjm.service.GoodService;
import com.zjm.service.ShopService;
import com.zjm.util.Data;
import com.zjm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ZJM on 2017/4/13.
 */
@RestController
@RequestMapping("/manager/good")
public class Manager_GoodMS {

    @Value("${filePath}")
    private String filePath;

    @Autowired
    private GoodService goodService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private Data data;
    /*
    页面跳转的函数
     */
    @RequestMapping("toLogin")
    public ModelAndView toLogin() {
        ModelAndView mv = new ModelAndView("shop/login");
        return mv;
    }

    @RequestMapping("toList")
    public ModelAndView toList(HttpSession session) {
        ModelAndView mv = new ModelAndView("shop/good");
        return mv;
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate() {
        ModelAndView mv = new ModelAndView("shop/updateGood");
        return mv;
    }

    @RequestMapping("toAdd")
    public ModelAndView toAdd() {
        ModelAndView mv = new ModelAndView("shop/addGood");
        return mv;
    }

    /*
    操作
     */
    @RequestMapping("login")
    public ModelAndView login(Shop shop, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        String url = "redirect:./toLogin";
        shop = shopService.isPass(shop);
        if(shop != null) {
            session.setAttribute("shop",shop);
            url = "redirect:./toList";
        } else {
            mv.addObject("sign","用户名或密码错误！");
        }
        mv.setViewName(url);
        return mv;
    }

    @RequestMapping("showList")
    public Data showList(HttpSession session) throws Exception {
        Shop shop = (Shop)session.getAttribute("shop");
        if(shop != null) {
            data.setData(goodService.showAll(shop.getId()));
        }
        return data;
    }

    @RequestMapping("edit")
    public Result edit(Good good) throws Exception {
        goodService.update(good);
        return ResultUtil.success();
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("file")MultipartFile file, Good good,String product,String time,HttpSession session) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        good.setProductdate(dateFormat.parse(product));
        good.setExpirationdate(good.getExpirationdate() + time);
        Shop shop = (Shop) session.getAttribute("shop");
        System.out.println("112233"+shop);
        ModelAndView mv = new ModelAndView();
        String picUrl = filePath+shop.getName() + "/";
        if(!file.isEmpty()){
            try {
                File pic = new File(picUrl);
                if (!pic.exists()) {
                    pic.mkdirs();
                }
                pic = new File(picUrl + file.getOriginalFilename());
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pic));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                mv.addObject("msg","上传失败,"+e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                mv.addObject("msg","上传失败,"+e.getMessage());
            } finally {
                mv.setViewName("redirect:./toAdd");
            }
            mv.addObject("msg","上传成功");
            mv.addObject("last",good.getName());
            mv.setViewName("redirect:./toAdd");
        }else{
            mv.addObject("msg","上传失败，因为文件是空的.");
            mv.setViewName("redirect:./toAdd");
        }
        good.setShopId(shop.getId());
        good.setPic(picUrl + file.getOriginalFilename());
        System.out.println(good);
        goodService.add(good);
        return mv;
    }
    @RequestMapping("delete")
    public void delete(int id) throws Exception {
        goodService.delete(id);
    }

    @RequestMapping("showOne")
    public Good showOne(int id) throws Exception{
        return goodService.showGoodDetail(id);
    }
}
