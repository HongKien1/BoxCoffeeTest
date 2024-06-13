package com.box.utils;

import com.boxcf.components.material.Panigation;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.DatTruocDao;
import com.boxcf.dao.KhuyenMaiDao;
import com.boxcf.dao.PhieuDatBoxDao;
import com.boxcf.models.DatTruoc;
import com.boxcf.models.KhuyenMai;
import com.boxcf.models.PhieuDatBox;
import com.boxcf.store.Store;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Cleaner {

    public static void start() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                cleanInvalidDiscount();
                cleanInvalidBook();

            }
        };

        timer.scheduleAtFixedRate(task, 0, 60 * 1000);
    }

    public static void cleanInvalidDiscount() {
        KhuyenMaiDao dKm = KhuyenMaiDao.getInstant();
        List<KhuyenMai> list = dKm.selectAll();
        String date = XDate.toString(XDate.now(), "yyyy-MM-dd");
        boolean flag = false;

        for (KhuyenMai km : list) {
            if (XDate.toDate(date, "yyyy-MM-dd").after(km.getNgayKT()) || km.getSoLuot() <= 0) {
                dKm.delete(km.getMaKM());
                flag = true;
            }
        }

        if (flag) {
            Store.kmView.fillTable();
        }

    }

    public static void cleanInvalidBook() {
        PhieuDatBoxDao d = PhieuDatBoxDao.getInstant();
        List<PhieuDatBox> list = d.selectWithBooked();
        String mess = "";
        boolean flag = false;

        for (PhieuDatBox pd : list) {
            if (XDate.now().getTime() - pd.getGioBD().getTime() >= 60000) {
                mess += "Đã hủy đặt trước của " + BoxDao.getInstance().selectById(pd.getMaBox()) + " đã đặt trước vào lúc"
                        + " " + XDate.toString(pd.getGioBD(), "HH:mm:ss") + " vì quá hạn \n";

                d.cancelBox(pd);

            }
        }

        if (mess.length() <= 0) {
            return;
        }

        if (Store.orderView != null) {
            MsgBox.alert(Store.orderView, mess);
            Store.orderView.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
        } else {
            MsgBox.alert(Store.globelMain, mess);
        }

    }

}
