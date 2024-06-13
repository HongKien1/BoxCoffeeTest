/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.store;

import com.boxcf.components.material.BoxStatus;
import com.boxcf.components.material.Category;
import com.boxcf.components.material.PanelBill;
import com.boxcf.components.material.Panigation;
import com.boxcf.events.StoreEvents;
import com.boxcf.models.LoaiBox;
import com.boxcf.models.LoaiSP;
import com.boxcf.ui.BoxView;
import com.boxcf.ui.ComboView;
import com.boxcf.ui.DatBoxView;
import com.boxcf.ui.DatComBo;
import com.boxcf.ui.KhuyenMaiView;
import com.boxcf.ui.Main;
import com.boxcf.ui.NhanVienView;
import com.boxcf.ui.OrderView;
import com.boxcf.ui.SanPhamView;
import com.boxcf.ui.ThongKeView;
import com.raven.chart.Chart;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class Store {

    public final static Category categoryAll(JPanel panelCategory, String name, boolean active) {
        Category ctgrAll = new Category();
        StoreEvents.categoryActive(ctgrAll, panelCategory, name);

        ctgrAll.setActive(active);
        LoaiSP lsp = new LoaiSP(Store.idAllCategory, "Tất cả", Store.idAllCategory);
        LoaiBox lb = new LoaiBox(Store.idAllCategory, "Tất cả", 0, "");
        ctgrAll.addData(lsp, lb);
        return ctgrAll;
    }

    public String getNextId(String maxId) {
//        String maxId = "PC09999";

        String first = maxId.substring(0, 2);
        String last = maxId.substring(2);
        Integer number = Integer.parseInt(last);
        Integer log = number / 10;

        if (log == 0) {
            maxId = first + "00" + ++number;
        } else if (log > 1000) {
            maxId = first + ++number;
        } else if (log > 100) {
            maxId = first + "" + ++number;
        } else if (log > 10) {
            maxId = first + "" + ++number;
        } else if (log > 0) {
            maxId = first + "0" + ++number;
        }

        return maxId;
    }

    public static String food = "ĐỒ ĂN";

    public static String drink = "ĐỒ UỐNG";

    public static String categoryName = drink;

    public static SanPhamView spView = null;

    public static KhuyenMaiView kmView = null;

    public static Main globelMain = null;

    public final static String idAllCategory = "TẤT CẢ";

    public static OrderView orderView = null;

    public static PanelBill globelPanelBill = null;

    public static String partten = "MM/dd/yyyy HH:mm:ss";

    public static String parttenHour = "HH:mm";

    public static int breaks = 0;

    public static Panigation panigation = null;

    public static DatBoxView dbView = null;

    public static BoxView boxView = null;

    public static Chart chart = null;

    public static ThongKeView tkView = null;

    public static NhanVienView nvView = null;

    public static ComboView CbView = null;

    public static DatComBo dcbView = null;

    public static BoxStatus bStatus = null;

}
