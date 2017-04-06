package com.zjm.dao;

import com.zjm.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        adminMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insert() throws Exception {
        Admin admin = new Admin();
        admin.setName("张家铭");
        admin.setPhone("123456");
        admin.setInductdate(new Date());
        admin.setSex(1);
        adminMapper.insert(admin);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setPhone("13603687702");
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("张家铭");
        admin.setPhone("123456");
        admin.setInductdate(new Date());
        admin.setSex(1);
        adminMapper.updateByPrimaryKey(admin);
    }

}