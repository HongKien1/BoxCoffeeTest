package com.boxcf.events;

import com.boxcf.components.PanelItem;
import com.boxcf.components.Spiner;
import com.boxcf.components.material.BoxItem;
import com.boxcf.components.material.Category;
import com.boxcf.components.material.ComboItem;
import com.boxcf.components.material.ItemBill;
import com.boxcf.components.material.PanelBill;
import com.boxcf.components.material.Panigation;
import com.boxcf.components.material.ProductItem;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.ComboDao;
import com.boxcf.dao.SanPhamDao;
import com.boxcf.events.interfaces.EventIncrease;
import com.boxcf.models.SanPham;
import com.boxcf.ui.OrderView;
import java.awt.Component;
import com.boxcf.events.interfaces.EventItem;
import com.boxcf.models.ModelItem;
import com.boxcf.store.Store;
import com.boxcf.ui.DatBoxView;
import com.boxcf.ui.DatComBo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class StoreEvents {

    // xử lí sự kiện khi click vào sản phẩm
    public static void product(OrderView order) {
        order.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                if (com instanceof ProductItem) {
                    order.setEventIncreace(com, item);
                    order.setSelected(com);
                    order.showItemBill(item);
                    order.repaint();
                }

                if (com instanceof BoxItem) {
                    BoxItem box = (BoxItem) com;
                    new DatBoxView(item).setVisible(true);
                    order.repaint();
                }

                // Duc them
                if (com instanceof ComboItem) {
                    ComboItem combo = (ComboItem) com;
                    new DatComBo(item).setVisible(true);
                    order.repaint();
                }

            }
        });
    }

    // xử lí sự kiện giảm số lượng của sản phẩm
    public static void decreaseProduct(Spiner spiner, PanelBill panelBill, ProductItem i, ModelItem data) {
        spiner.setEvenDecrease(new EventIncrease() {
            @Override
            public void itemClick(java.awt.Component com, int quantity) {
                // trừ 1 vì khi tăng lên số lượng bị châm hơn 1 số
                panelBill.setQuantity(i.getData(), quantity - 1);

                if (quantity <= 1) {
                    panelBill.removeItem(data);
                }
            }

        });
    }

    // xử lí sự kiện tăng số lượng của sản phẩm
    public static void increaseProduct(Spiner spiner, PanelBill panelBill, ProductItem i, ModelItem data) {
        spiner.setEvenIncrease(new EventIncrease() {
            @Override
            public void itemClick(java.awt.Component com, int quantity) {
                // cộng 1 vì khi tăng lên số lượng bị châm hơn 1 số
                panelBill.setQuantity(i.getData(), quantity + 1);

            }

        });
    }

    // xử lí sự kiện tắt bill
    public static void closeBillProduct(ItemBill item, PanelBill panelBill, PanelItem panelItem) {
        item.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                panelBill.removeItem(item);
                for (Component component : panelItem.getComponents()) {
                    if (component instanceof ProductItem) {
                        ProductItem i = (ProductItem) component;
                        if (i.getData().getMaItem() == item.getMaItem()) {
                            i.clearSelected();
                            i.repaint();
                            i.revalidate();
                            return;
                        }
                    }

                    if (component instanceof ComboItem) {
                        ComboItem i = (ComboItem) component;

                        if (i.getData().getMaItem().equals(item.getMaItem())) {
                            i.setSelected(false);
                            panelBill.clearList(true);

                            return;
                        }
                    }

                    if (component instanceof BoxItem) {
                        BoxItem i = (BoxItem) component;
                        if (i.getData().getMaItem() == item.getMaItem()) {
                            i.clearSelected();
                            i.revalidate();
                            return;
                        }
                    }

                }
            }
        });
    }

    // xử lý sự kiện active loại sản phẩm
    public static void categoryActive(Category ctgr, JPanel panelCategory, String name) {

        OrderView order = Store.orderView;
        PanelItem panelItem = order.getPanelItem();
        PanelBill panelBill = Store.globelPanelBill;
        String sqlProduct = "select * from SanPham\n"
                + "where MaLoai = ?";

        String sqlBox = "select * from box\n"
                + "where MaLoaiBox = ?";

        ctgr.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // xóa hết các active trước đó
                for (Component component : panelCategory.getComponents()) {
                    Category c = (Category) component;
                    if (c != null) {
                        c.setActive(false);
                    }
                }

                // toggle active :))
                ctgr.toggleActive();

                // xóa các sản phẩm trước khi add vào mới không bị trùng sản phẩm
                panelItem.removeAll();

                // xu li phan loai box theo ma loai box
                if (name.equals("BOX") && ctgr.getDataBox() != null) {

                    if (ctgr.getDataBox().getMaLoaiBox().equalsIgnoreCase(Store.idAllCategory)) {
                        order.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
                        loadPanigation(order);
                        return;
                    }

                    order.removePanigation();
                    order.initBoxData(BoxDao.getInstance().selectBySql(sqlBox, ctgr.getDataBox().getMaLoaiBox()));
                    return;
                }

                // xu li chia loai combo voi ma loai box
                if (name.equals("COMBO") && ctgr.getDataBox() != null) {

                    if (ctgr.getDataBox().getMaLoaiBox().equalsIgnoreCase(Store.idAllCategory)) {
                        order.initComboData(ComboDao.getInstant().panigation(Panigation.current));
                        loadPanigation(order);
                        return;
                    }

                    order.removePanigation();
                    order.initComboData(ComboDao.getInstant().selectByLoaiBox(ctgr.getDataBox().getMaLoaiBox()));
                    return;

                }

                // xu li phan loai theo san pham
                if (ctgr.getDataProduct() != null) {
                    if (ctgr.getDataProduct().getMaLoai().equalsIgnoreCase(Store.idAllCategory)) {
                        Panigation.current = 1;
                        order.initProductData(SanPhamDao.getInstant().panigation(Panigation.current));
                        loadPanigation(order);
                        return;
                    }

                    List<SanPham> list = SanPhamDao.getInstant().selectBySql(sqlProduct, ctgr.getDataProduct().getMaLoai());

                    order.removePanigation();

                    if (list.isEmpty()) {
                        order.removeAllPanelItem();
                        return;
                    }
                    order.initProductData(list);
                }
            }

        });
    }

    public static void loadPanigation(OrderView order) {
        order.addPanigation();
        Panigation panigation = Store.panigation;
        panigation.setPage();
    }

    public static void handlePanigation() {
        OrderView order = Store.orderView;
        Component[] cpns = Store.panigation.getComponents();
        Panigation panigation = Store.panigation;

        for (Component cpn : cpns) {
            if (cpn instanceof JButton) {
                JButton btn = (JButton) cpn;

                cpn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        switch (btn.getActionCommand()) {
                            case "|<":
                                Panigation.current = 1;
                                break;
                            case "<<":
                                if (Panigation.current > 1) {
                                    --Panigation.current;
                                }
                                break;
                            case ">>":
                                if (Panigation.current < Panigation.total) {
                                    ++Panigation.current;
                                }
                                break;
                            case ">|":
                                Panigation.current = Panigation.total;
                                break;
                            default:
                                throw new AssertionError();
                        }

                        Panigation.setPage();

                        if (order.mode.equals("product")) {
                            order.initProductData(SanPhamDao.getInstant().panigation(Panigation.current));
                        } else if (order.mode.equals("Combo")) {
                            order.initComboData(ComboDao.getInstant().panigation(Panigation.current));
                        } else {
                            order.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
                        }

                    }
                });
            }
        }
    }
}
