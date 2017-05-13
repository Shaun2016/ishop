package com.zjm.dao;

import com.zjm.model.Size;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/5/13.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SizeMapperTest {
    @Test
    public void selectByGoodId() throws Exception {
        System.out.println(sizeMapper.selectByGoodId(11));
    }

    @Autowired
    private SizeMapper sizeMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        sizeMapper.deleteByPrimaryKey(4);
    }

    @Test
    public void insert() throws Exception {
        Size size = new Size();
        size.setName("红色");
        size.setGoodId(11);
        size.setImg("123123123123");
        sizeMapper.insert(size);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(sizeMapper.selectByPrimaryKey(5));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Size size = new Size();
        size.setId(5);
        size.setImg("22222222");
        sizeMapper.updateByPrimaryKeySelective(size);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}