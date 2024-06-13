/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import com.box.utils.MsgBox;
import com.box.utils.XDate;
import com.boxcf.components.material.BoxItem;
import com.boxcf.components.material.Panigation;
import com.boxcf.constands.BoxState;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.PhieuDatBoxDao;
import java.util.TimerTask;
import com.boxcf.store.Store;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Timer {

    BoxItem box;
    ModelItem data;

    public Timer() {
    }

    public Timer(BoxItem box, ModelItem data) {
        this.box = box;
        this.data = data;
    }

    public BoxItem getBox() {
        return box;
    }

    public void setBox(BoxItem box) {
        this.box = box;
    }

    public ModelItem getData() {
        return data;
    }

    public void setData(ModelItem data) {
        this.data = data;
    }

    public synchronized void setTime() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    box.setSelected(BoxState.active);

                    Time t = XDate.toTime(XDate.toString(data.getGioKT(), "MM/dd/yyyy HH:mm:ss"));

                    if (XDate.now().after(box.getData().getGioKT())) {
                        PhieuDatBoxDao.getInstant().updateProc(box.getData(), BoxState.empty.toString(), box.getData().getGioKT());
                        MsgBox.alert(Store.orderView, box.getData().getTen() + " đã hết thời gian !");
                        box.clearSelected();
                        timer.cancel();
                        return;
                    }

                    box.setRemainderTime(t);
                } catch (Exception e) {
                    timer.cancel();
                }
            }
        };

        try {
            timer.scheduleAtFixedRate(task, 0, 1000);
        } catch (Exception e) {
            timer.cancel();
            setTime();
        }
    }

    public synchronized void setTime2(PhieuDatBox nextBooked) {
        java.util.Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();
                long limit = 1 * 60 * 1000;
                long maxHour = limit + nextBooked.getGioBD().getTime();

                if (currentTime >= maxHour) {

                    ModelItem item = new ModelItem();
                    item.setGioKT(nextBooked.getGioKT());
                    item.setMaItem(nextBooked.getMaBox());

                    PhieuDatBoxDao.getInstant().updateProc(item, "used", new Date(currentTime));
                    Store.orderView.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
                    MsgBox.alert(Store.orderView, BoxDao.getInstance().selectById(nextBooked.getMaBox()).getTenBox() + " đã quá giờ nhận box!");
                }

            }
        };
        timer.scheduleAtFixedRate(task, 0, 2000);
    }

    @Override
    public String toString() {
        return "Timer{" + "box=" + box + ", data=" + data + '}';
    }
}
