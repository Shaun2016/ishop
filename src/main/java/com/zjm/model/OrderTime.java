package com.zjm.model;

import java.util.Date;

/**
 * Created by ZJM on 2017/4/6.
 */
public class OrderTime extends Order{
    private Date start;

    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
