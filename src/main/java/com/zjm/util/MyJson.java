package com.zjm.util;

import com.google.gson.Gson;

/**
 * Created by ZJM on 2017/4/9.
 */
public class MyJson {

    private static Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
}
