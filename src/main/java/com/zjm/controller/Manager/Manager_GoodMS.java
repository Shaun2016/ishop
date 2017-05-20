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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping("/")
    public String auto() {
        return "shop/login";
    }

    @RequestMapping("/tologin")
    public String toLogin() {
        return "shop/login";
    }

    @RequestMapping("/toList")
    public String toList(HttpSession session) {
        return "shop/good";
    }

    @RequestMapping("/toDetail")
    public String toDetail(int id, Map<String,Good> map) throws Exception{
        map.put("good",goodService.showGoodDetail(id));
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
        Shop shop = (Shop) session.getAttribute("shop");
        if(!file.isEmpty())
            good.setPic("/img/s" + shop.getId() + "/" + file.getOriginalFilename());
        good = updateHandler(good);
        String picUrl = filePath+shop.getName() + "/";
        String msg = "成功";
        if(good.getPic() != null && !file.isEmpty()) {
            msg = uploadPic(picUrl,file,msg);
        }
        goodService.update(good);
        mv.setViewName("redirect:./toList");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("file")MultipartFile file, Good good,String product,String time,HttpSession session,ModelAndView mv) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        good.setProductdate(dateFormat.parse(product));
        good.setExpirationdate(good.getExpirationdate() + time);
        Shop shop = (Shop) session.getAttribute("shop");
        String picUrl = filePath+"s"+shop.getId() + "/";
        String msg = "成功";
        if(!file.isEmpty()){
            msg = uploadPic(picUrl,file,msg);
            mv.addObject("msg",msg);
            mv.addObject("last",good.getName());
            mv.setViewName("redirect:./toAdd");
        }else{
            mv.addObject("msg","上传失败，因为文件是空的.");
            mv.setViewName("redirect:./toAdd");
        }
        good.setShopId(shop.getId());
        good.setPic("/img/s" + shop.getId() + "/" + file.getOriginalFilename());
        System.out.println(good);
        goodService.add(good);
        return mv;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Result delete(int id) throws Exception {
        goodService.delete(id);
        return ResultUtil.success();
    }

    public Good updateHandler(Good good) throws Exception{
        Good temp = goodService.showGood(good.getId());
        if(temp.getName() == good.getName()) good.setName(null);
        if(temp.getProductdate() == good.getProductdate()) good.setProductdate(null);
        if(temp.getPrice() == good.getPrice()) good.setPrice(null);
        if(temp.getBigCatogary().getId() == good.getBigCatogaryId()) good.setBigCatogary(null);
        if(temp.getSmallCatogary().getId() == good.getSmallCatogaryId()) good.setSmallCatogary(null);
        if(temp.getPic() == good.getPic()) good.setPic(null);
        if(temp.getDeliveryFee() == good.getDeliveryFee()) good.setDeliveryFee(-1);
        return good;
    }

    public String uploadPic(String picUrl,MultipartFile file,String msg) {
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
            msg = "上传失败——图片为空" + e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            msg = "图片上传失败" + e.getMessage();
        }
        return msg;
    }

}
