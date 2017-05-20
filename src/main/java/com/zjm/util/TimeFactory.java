package com.zjm.util;

import java.util.Date;

/**
 * Created by ZJM on 2017/5/20.
 */
public class TimeFactory {

    public static boolean validateTimeStamp(Date TimeStamp) throws Exception {
        Date date = new Date();
        if((date.getTime() - TimeStamp.getTime()) / 60000 > 5)
            return false;
        return true;
    }

}
