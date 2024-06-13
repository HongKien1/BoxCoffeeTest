package com.boxcf.components;

import com.boxcf.components.material.BoxItem;
import com.boxcf.components.material.ComboItem;
import com.boxcf.components.material.ItemBill;
import com.boxcf.components.material.ProductItem;
import com.boxcf.constands.BoxState;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;

public class PanelItem extends JPanel {

    public PanelItem() {
        setBackground(Color.WHITE);
        setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
    }

    public void clearActive(boolean all) {
        for (Component component : this.getComponents()) {
            if (component instanceof ProductItem) {
                ProductItem product = (ProductItem) component;

                if (product != null) {
                    product.setSelected(false);
                    product.getSoLuong().setSoLuong(0);
                    product.repaint();
                }
            }
            
            if (component instanceof ComboItem) {
                ComboItem combo = (ComboItem) component;

                if (combo != null) {
                    combo.setSelected(false);
                }
            }
            
            if (all) {
                if (component instanceof BoxItem) {
                    BoxItem box = (BoxItem) component;
                    for (ItemBill itemBill : Store.globelPanelBill.getList()) {
                        if (box.getData().getTrangThai() != BoxState.active) {
                            box.clearSelected();
                        }

                    }

                }
            }
        }
    }

    public com.boxcf.models.ModelItem setTimer() {
        com.boxcf.models.ModelItem boxData = null;
        for (Component com : this.getComponents()) {
            if (com instanceof BoxItem) {
                BoxItem b = (BoxItem) com;
                if (b.getData().getGioKT() != null && b.getData().getTrangThai() == BoxState.waiting) {
                    b.timer();
                    boxData = b.getData();

                }
            }
        }
        return boxData;
    }
}
