/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import com.box.utils.XDate;
import com.boxcf.store.Store;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ModelCboFitTime {

    private Date time;
    private int limit;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ModelCboFitTime(Date time, int limit) {
        this.time = time;
        this.limit = limit;
    }

    @Override
    public String toString() {
        return XDate.toString(time, Store.parttenHour);
    }
}
