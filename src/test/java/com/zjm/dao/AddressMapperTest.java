package com.zjm.dao;

import com.zjm.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ZJM on 2017/4/5.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressMapperTest {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void selectByUserKey() throws Exception {
        List<Address> list = addressMapper.selectByUserKey(1);
        System.out.println(list);
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
        addressMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void insert() throws Exception {
        Address address = new Address();
        address.setLocation("南岔区水解厂");
        address.setPhone("123456789");
        address.setPostnum(153110);
        address.setReceiver("小明");
        address.setUserid(1);
        addressMapper.insert(address);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}