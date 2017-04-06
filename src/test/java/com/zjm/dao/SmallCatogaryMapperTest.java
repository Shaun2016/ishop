package com.zjm.dao;

import com.zjm.model.BigCatogary;
import com.zjm.model.SmallCatogary;
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
public class SmallCatogaryMapperTest {

    @Autowired
    private SmallCatogaryMapper smallCatogaryMapper;

    @Autowired
    private BigCatogaryMapper bigCatogaryMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        smallCatogaryMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insert() throws Exception {
        BigCatogary bigCatogary = new BigCatogary();
        bigCatogary.setId(1);
        SmallCatogary smallCatogary = new SmallCatogary();
        smallCatogary.setName("苹果");
        smallCatogary.setBigCatogary(bigCatogary);
        smallCatogaryMapper.insert(smallCatogary);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        SmallCatogary smallCatogary = smallCatogaryMapper.selectByPrimaryKey(1);
        System.out.println(smallCatogary);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        SmallCatogary smallCatogary = new SmallCatogary();
        BigCatogary bigCatogary = bigCatogaryMapper.selectByPrimaryKey(1);
        smallCatogary.setBigCatogary(bigCatogary);
        smallCatogary.setName("西瓜");
        smallCatogary.setId(1);
        smallCatogaryMapper.updateByPrimaryKeySelective(smallCatogary);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}