package com.zjm.dao;

import com.zjm.model.BigCatogary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/5.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BigCatogaryMapperTest {

    @Autowired
    private BigCatogaryMapper bigCatogaryMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        bigCatogaryMapper.deleteByPrimaryKey(1);
    }

    @Test
    public void insert() throws Exception {
        BigCatogary bigCatogary = new BigCatogary();
        bigCatogary.setName("蔬菜");
        bigCatogaryMapper.insert(bigCatogary);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        BigCatogary bigCatogary = bigCatogaryMapper.selectByPrimaryKey(2);
        System.out.println(bigCatogary);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        BigCatogary bigCatogary = new BigCatogary();
        bigCatogary.setId(1);
        bigCatogary.setName("热带水果");
        bigCatogaryMapper.updateByPrimaryKeySelective(bigCatogary);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}