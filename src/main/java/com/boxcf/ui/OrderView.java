package com.boxcf.ui;

import com.box.utils.Formats;
import com.boxcf.components.ButtonRound;
import com.boxcf.components.Combobox;
import com.boxcf.components.PanelItem;
import com.boxcf.components.ScrollBar;
import com.boxcf.components.material.BoxItem;
import com.boxcf.components.material.BoxStatus;
import com.boxcf.components.material.Category;
import com.boxcf.components.material.ComboItem;
import com.boxcf.events.StoreEvents;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import com.boxcf.events.interfaces.EventItem;
import com.boxcf.components.material.ProductItem;
import com.boxcf.models.ModelItem;
import com.boxcf.components.material.PanelBill;
import com.boxcf.components.material.Panigation;
import com.boxcf.constands.BoxState;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.ComboDao;
import com.boxcf.dao.DanhMucDao;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.dao.LoaiSPDao;
import com.boxcf.dao.PhieuDatBoxDao;
import com.boxcf.dao.SanPhamDao;
import com.boxcf.models.Box;
import com.boxcf.models.Combo;
import com.boxcf.models.DanhMuc;
import com.boxcf.models.KhuyenMai;
import com.boxcf.models.LoaiBox;
import com.boxcf.models.LoaiSP;
import com.boxcf.models.SanPham;
import com.boxcf.store.Store;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderView extends javax.swing.JFrame {

    private EventItem event;
    private boolean selected;
    private PanelBill panelBill;
    private ModelItem itemSelected;
    private BoxStatus boxStatus = new BoxStatus();
    public static String mode = "";

    public OrderView() {
        initComponents();

        // tạo panel chứa bill
        panelBill = new PanelBill();

        // tạo style cho components
        initStyle();

        // init
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonRound6 = new com.boxcf.components.ButtonRound();
        ContainBill = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFinalTotal = new javax.swing.JLabel();
        cboDiscount = new com.boxcf.components.Combobox();
        panelButton = new javax.swing.JPanel();
        buttonRound1 = new com.boxcf.components.ButtonRound();
        btnBox = new com.boxcf.components.ButtonRound();
        buttonRound4 = new com.boxcf.components.ButtonRound();
        btnDoUong = new com.boxcf.components.ButtonRound();
        windowButton1 = new com.boxcf.components.WindowButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelCategory = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        panelItem = new com.boxcf.components.PanelItem();
        panelPanigation = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tạm tính");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 80, -1));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(16, 108, 130));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0 VND");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, 240, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/Trash.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 747, 37, 38));

        buttonRound6.setBackground(new java.awt.Color(50, 130, 179));
        buttonRound6.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound6.setText("THANH TOÁN");
        buttonRound6.setFocusable(false);
        buttonRound6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonRound6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound6ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 747, 312, 38));

        ContainBill.setBackground(new java.awt.Color(255, 255, 255));
        ContainBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(ContainBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 62, 425, 540));

        jLabel5.setFont(new java.awt.Font("UTM Aptima", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("HÓA ĐƠN TẠM TÍNH");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 190, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tổng tiền");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 709, 66, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 709, 66, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Khuyến mãi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 90, -1));

        lblFinalTotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblFinalTotal.setForeground(new java.awt.Color(16, 108, 130));
        lblFinalTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFinalTotal.setText("0 VND");
        jPanel1.add(lblFinalTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 710, 280, -1));

        cboDiscount.setForeground(new java.awt.Color(16, 108, 130));
        cboDiscount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cboDiscount.setFocusable(false);
        cboDiscount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cboDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiscountActionPerformed(evt);
            }
        });
        jPanel1.add(cboDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 650, 320, 40));

        panelButton.setBackground(new java.awt.Color(255, 255, 255));

        buttonRound1.setBackground(new java.awt.Color(77, 119, 254));
        buttonRound1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound1.setText("ĐỒ ĂN");
        buttonRound1.setFocusPainted(false);
        buttonRound1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        btnBox.setBackground(new java.awt.Color(18, 165, 188));
        btnBox.setForeground(new java.awt.Color(255, 255, 255));
        btnBox.setText("BOX");
        btnBox.setFocusPainted(false);
        btnBox.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoxActionPerformed(evt);
            }
        });

        buttonRound4.setBackground(new java.awt.Color(255, 150, 0));
        buttonRound4.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound4.setText("COMBO");
        buttonRound4.setFocusPainted(false);
        buttonRound4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        btnDoUong.setBackground(new java.awt.Color(56, 187, 156));
        btnDoUong.setForeground(new java.awt.Color(255, 255, 255));
        btnDoUong.setText("ĐỒ UỐNG");
        btnDoUong.setFocusPainted(false);
        btnDoUong.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoUongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 487, Short.MAX_VALUE)
                .addComponent(windowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addComponent(windowButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(241, 248, 248));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Loại");

        panelCategory.setBackground(new java.awt.Color(255, 255, 255));
        panelCategory.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(panelCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scroll.setBorder(null);
        scroll.setViewportView(panelItem);

        panelPanigation.setBackground(new java.awt.Color(255, 255, 255));
        panelPanigation.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
            .addComponent(panelPanigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelPanigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        handleClearBill();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void buttonRound6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound6ActionPerformed
        openBillView();
    }//GEN-LAST:event_buttonRound6ActionPerformed

    private void btnBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoxActionPerformed
        Panigation.current = 1;
    }//GEN-LAST:event_btnBoxActionPerformed

    private void btnDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoUongActionPerformed
        Panigation.current = 1;
    }//GEN-LAST:event_btnDoUongActionPerformed

    private void cboDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiscountActionPerformed
        handleFinalTotal();
    }//GEN-LAST:event_cboDiscountActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Store.categoryName = Store.drink;
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContainBill;
    private com.boxcf.components.ButtonRound btnBox;
    private com.boxcf.components.ButtonRound btnDoUong;
    private com.boxcf.components.ButtonRound buttonRound1;
    private com.boxcf.components.ButtonRound buttonRound4;
    private com.boxcf.components.ButtonRound buttonRound6;
    private com.boxcf.components.Combobox cboDiscount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFinalTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCategory;
    private com.boxcf.components.PanelItem panelItem;
    private javax.swing.JPanel panelPanigation;
    private javax.swing.JScrollPane scroll;
    private com.boxcf.components.WindowButton windowButton1;
    // End of variables declaration//GEN-END:variables

    public void initStyle() {

        // set style for scollbar
        scroll.setVerticalScrollBar(new ScrollBar());

        // set layout cho contaiBill
        ContainBill.setLayout(new FlowLayout());

        // set size panel chứa bill
        panelBill.setSize(ContainBill.getWidth(), ContainBill.getHeight());

        // add panel chứa bill
        ContainBill.add(panelBill);
    }

    private void init() {

        windowButton1.initEvent(this);

        // gán biến
        Store.globelPanelBill = panelBill;
        Store.orderView = this;

        // dữ liệu ban đầu của loại
//        initCategory(true, LoaiSPDao.getInstant().selectAll(), btnDoUong.getText());
        initCategory(true, LoaiSPDao.getInstant().selectByDM(DanhMucDao.getInstant().selectByNameDm(btnDoUong.getText())), btnDoUong.getText());

        // add sự kiện cho nút danh muc
        addEventCategory();
    }

    private void initProductData() {

        // đưa sang class khác xử lí
        StoreEvents.product(this);

        for (SanPham sp : SanPhamDao.getInstant().selectAll()) {

            this.addProductData(new ModelItem(sp.getMaSP(), sp.getHinhAnh(), sp.getGia(), sp.getTenSP(), 0));
        }

    }

    public void initProductData(List<SanPham> list) {

        panelItem.removeAll();
        // đưa sang class khác xử lí
        StoreEvents.product(this);

        for (SanPham sp : list) {
            this.addProductData(new ModelItem(sp.getMaSP(), sp.getHinhAnh(), sp.getGia(), sp.getTenSP(), 1));
        }
        panelBill.activeProductOnBill(panelItem);

    }

    public void initBoxData(List<Box> list) {
        panelItem.removeAll();

        this.openBoxStatus();

        StoreEvents.product(this);

        for (Box box : list) {
            //get ra ma box con gio
            String state = PhieuDatBoxDao.getInstant().getTrangThai(box.getMaBox());
            this.addBoxData(new ModelItem(box.getMaBox(), box.getTenBox(), BoxState.valueOf(state), LoaiBoxDao.getInstance().selectById(box.getMaLoaiBox())));
        }
        panelBill.activeBoxOnBill(panelItem);

    }

    private void initCategory(boolean categoryAll, List<LoaiSP> list, String name) {

        panelCategory.removeAll();

        if (categoryAll) {
            // loai tat ca

            panelCategory.add(Store.categoryAll(panelCategory, name, true));

            //--------------------ha code--------------------------------
            mode = "product";
            Panigation.current = 1;
            initProductData(SanPhamDao.getInstant().panigation(1));
            addPanigation();
        }

        for (LoaiSP lsp : list) {
            Category ctgr = new Category();
            StoreEvents.categoryActive(ctgr, panelCategory, name);
            ctgr.setActive(false);
            ctgr.addData(lsp);
            panelCategory.add(ctgr);
        }
        panelCategory.repaint();
        panelCategory.revalidate();

    }

    private void initCategoryCombo(boolean categoryAll, List<LoaiBox> list, String name) {

        panelCategory.removeAll();

        if (categoryAll) {
            panelCategory.add(Store.categoryAll(panelCategory, name, true));
            mode = "Combo";
            Panigation.current = 1;
            initComboData(ComboDao.getInstant().panigation(1));
            addPanigation();
        }

        for (LoaiBox lsp : list) {
            Category ctgr = new Category();
            StoreEvents.categoryActive(ctgr, panelCategory, name);
            ctgr.setActive(false);
            ctgr.addData(lsp);
            panelCategory.add(ctgr);
        }

        panelCategory.repaint();
        panelCategory.revalidate();

    }

    public void initCategoryBox(boolean categoryAll, List<LoaiBox> list, String name) {

        panelCategory.removeAll();

        if (categoryAll) {
            // loai tat ca
            panelCategory.add(Store.categoryAll(panelCategory, name, true));
//            initBoxData(BoxDao.getInstant().selectAll());

            //---------ha code------------------
            mode = "box";
            initBoxData(BoxDao.getInstance().panigation(Panigation.current));
            addPanigation();
        }

        for (LoaiBox lsp : list) {
            Category ctgr = new Category();
            StoreEvents.categoryActive(ctgr, panelCategory, name);
            ctgr.setActive(false);
            ctgr.addData(lsp);
            panelCategory.add(ctgr);
        }
        panelCategory.repaint();
        panelCategory.revalidate();

    }

    // add item vào panelItem
    public void addProductData(ModelItem data) {
        ProductItem item = new ProductItem();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    event.itemClick(item, data);
                }
            }
        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
        panelBill.setPanelItem(panelItem);

    }

    // add item vào panelItem
    public void addBoxData(ModelItem data) {
        BoxItem item = new BoxItem();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    event.itemClick(item, data);
                }
            }
        });

        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
        panelBill.setPanelItem(panelItem);

    }

    public void renderData(List<ModelItem> listProduct) {
        for (ModelItem item : listProduct) {
            this.addProductData(item);
        }
    }

    public void showItemBill(ModelItem data) {
        if (selected) {
            if (data.getSoLuong() <= 0) {
                panelBill.removeItem(data);
            }
            panelBill.setList(data);
        } else {
            panelBill.removeItem(data);
        }

    }

    public void setEventIncreace(java.awt.Component item, ModelItem data) {
        ProductItem i = ((ProductItem) item);

        // đưa sự kiện giảm sang class khác
        StoreEvents.decreaseProduct(i.getSoLuong(), panelBill, i, data);

        // đưa sự kiện tăng sang class khác
        StoreEvents.increaseProduct(i.getSoLuong(), panelBill, i, data);
    }

    public void setSelected(java.awt.Component item) {
        ProductItem i = ((ProductItem) item);
        if (i.isSelected()) {
            i.setSoLuong(0);
            i.setSelected(false);

        } else {
            i.setSoLuong(1);
            i.setSelected(true);
        }
        setSelected(i.isSelected());

    }

    private void addEventCategory() {

        // sự kiện các nút danh mục
        for (java.awt.Component component : panelButton.getComponents()) {
            if (component instanceof ButtonRound) {
                ButtonRound b = (ButtonRound) component;
                b.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removePanigation();
                        Panigation.current = 1;
                        addPanigation();
                        handleCategory(b.getText());
                    }

                });
            }
        }

    }

    private void handleCategory(String name) {
        panelCategory.removeAll();

        Store.categoryName = name;
        Panigation.current = 1;

        String sql = "select * from LoaiSP\n"
                + "where MaDM = ?";
        // loai box
        if (name.equalsIgnoreCase("Box")) {
            initCategoryBox(true, LoaiBoxDao.getInstance().selectAll(), name);
            return;
        }

        // combo
        if (name.equalsIgnoreCase("Combo")) {
            initCategoryCombo(true, LoaiBoxDao.getInstance().selectAll(), name);
            return;
        }

        // san pham
        for (DanhMuc danhMuc : DanhMucDao.getInstant().selectAll()) {

            // loai san pham
            if (danhMuc.getTenDM().toLowerCase().equals(name.toLowerCase())) {
                initCategory(true, LoaiSPDao.getInstant().selectBySql(sql, danhMuc.getMaDM()), name);
                return;
            }
        }

    }

    public void removeAllPanelItem() {
        panelItem.removeAll();
        panelItem.repaint();
    }

    // xử lí nút xóa tất cả
    private void handleClearBill() {
        panelBill.clearList(true);
    }

    public void handleTotal() {

        // hiển thị kiểu tiền tệ
        lblTotal.setText(Formats.toCurency(panelBill.total()));
    }

    public EventItem getEvent() {
        return event;
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public PanelItem getPanelItem() {
        return panelItem;
    }

    public void setPanelItem(PanelItem panelItem) {
        this.panelItem = panelItem;
    }

    private void openBillView() {
        if (panelBill.getComponents().length <= 0) {
            return;
        }
        HoaDonView hd = new HoaDonView((KhuyenMai) cboDiscount.getSelectedItem());
        hd.setVisible(true);
    }

    private void openBoxStatus() {
        boxStatus.setSize(getWidth(), getHeight());
        boxStatus.setVisible(true);
        panelItem.add(boxStatus);
    }

    public JPanel getPanelPanigation() {
        return panelPanigation;
    }

    public void setPanelPanigation(JPanel panelPanigation) {
        this.panelPanigation = panelPanigation;
    }

    public Combobox getCboDiscount() {
        return cboDiscount;
    }

    public void setCboDiscount(Combobox cboDiscount) {
        this.cboDiscount = cboDiscount;
    }

    public JLabel getLblFinalTotal() {
        return lblFinalTotal;
    }

    public void setLblFinalTotal(JLabel lblFinalTotal) {
        this.lblFinalTotal = lblFinalTotal;
    }

    private void handleFinalTotal() {

        KhuyenMai km = (KhuyenMai) cboDiscount.getSelectedItem();
        if (km == null) {
            lblFinalTotal.setText(Formats.toCurency(0));
            return;
        }
        long discounted = (long) (panelBill.getTotal() * (double) km.getPhanTram() / 100);
        lblFinalTotal.setText(Formats.toCurency(panelBill.getTotal() - discounted));
    }

    //-------------ha code-----------------
    public void addPanigation() {
        Panigation panigation = new Panigation();
        panelPanigation.add(panigation);
        Store.panigation = panigation;

        panelPanigation.repaint();
        panelPanigation.revalidate();

        StoreEvents.handlePanigation();
    }

    public void removePanigation() {
        panelPanigation.removeAll();
        panelPanigation.repaint();
        panelPanigation.revalidate();
    }

    public void initComboData(List<Combo> list) {
        panelItem.removeAll();

        StoreEvents.product(this);

        for (Combo cb : list) {
            this.addComboData(new ModelItem(cb.getMaCB(), cb.getGia(), cb.getTenCB(), LoaiBoxDao.getInstance().selectById(cb.getMaLoaiBox()), cb.getSoLuongDoUong(), cb.getSoLuongDoAn()));
        }
        panelBill.activeComboOnBill(panelItem);

    }

    public void addComboData(ModelItem data) {
        ComboItem item = new ComboItem();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    event.itemClick(item, data);
                }
            }
        });

        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
        panelBill.setPanelItem(panelItem);

    }

}
