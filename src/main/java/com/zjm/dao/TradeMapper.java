package com.zjm.dao;

import com.zjm.model.Trade;

public interface TradeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Trade record);

    Trade selectByPrimaryKey(String id);
}