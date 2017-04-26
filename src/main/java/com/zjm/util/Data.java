package com.zjm.util;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZJM on 2017/4/22.
 */
@Component
public class Data {
    private List<?> data;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

}
