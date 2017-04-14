package com.zjm.dao;

import com.zjm.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Admin record) throws Exception;

    int insertSelective(Admin record) throws Exception;

    List<Admin> selectByExample(Admin admin) throws Exception;

    Admin selectByPrimaryKey(Integer id) throws Exception;

    int updateByPrimaryKeySelective(Admin record) throws Exception;

    int updateByPrimaryKey(Admin record) throws Exception;
}