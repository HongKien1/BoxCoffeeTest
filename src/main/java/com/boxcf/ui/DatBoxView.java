package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.Formats;
import com.box.utils.MsgBox;
import com.box.utils.Validator;
import com.boxcf.store.Store;
import com.box.utils.XDate;
import com.boxcf.components.ScrollBar;
import com.boxcf.components.material.ItemBill;
import com.boxcf.components.material.PanelBill;
import com.boxcf.components.material.Panigation;
import com.boxcf.constands.BoxState;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.HoaDonDao;
import com.boxcf.dao.PhieuDatBoxDao;
import com.boxcf.models.HoaDon;
import com.boxcf.models.ModelCboFitTime;
import com.boxcf.models.ModelItem;
import com.boxcf.models.PhieuDatBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class DatBoxView extends javax.swing.JFrame {

    private ModelItem box;
    private int time;
    private OrderView orderView = Store.orderView;
    private PanelBill panelBill = Store.globelPanelBill;
    PhieuDatBox pdb = null;

    public static boolean isBooked;

    public DatBoxView() {
        initComponents();
        init();
    }

    public DatBoxView(ModelItem box) throws HeadlessException {
        this.box = box;
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new com.boxcf.components.GradientPanel();
        gradientPanel2 = new com.boxcf.components.GradientPanel();
        scroll = new javax.swing.JScrollPane();
        tblDatTruoc = new javax.swing.JTable();
        pnlDatBox = new com.boxcf.components.GradientPanel();
        jLabel8 = new javax.swing.JLabel();
        lblGioBd = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKhachHang = new com.boxcf.components.TextField();
        txtTraTruoc = new com.boxcf.components.TextField();
        btnDatBox = new com.boxcf.components.ButtonRound();
        cboSoGio = new com.boxcf.components.Combobox();
        cboMinus = new com.boxcf.components.Combobox();
        checkBoxCustom1 = new com.boxcf.components.CheckBoxCustom();
        lblTitleDeposits = new javax.swing.JLabel();
        lblGioKT = new javax.swing.JLabel();
        btnHuyBox = new com.boxcf.components.ButtonRound();
        txtLoaiBox = new com.boxcf.components.TextField();
        jLabel10 = new javax.swing.JLabel();
        txtTenBox = new com.boxcf.components.TextField();
        btnDatTruoc = new com.boxcf.components.ButtonRound();
        cboHour = new com.boxcf.components.Combobox();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnClose = new com.boxcf.components.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 250, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        gradientPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(241, 241, 241)));
        gradientPanel1.setColor1(new java.awt.Color(102, 102, 102));
        gradientPanel1.setColor2(new java.awt.Color(102, 102, 102));

        gradientPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(241, 241, 241)));
        gradientPanel2.setColor1(new java.awt.Color(255, 255, 255));
        gradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDatTruoc.setFont(new java.awt.Font("UTM BryantLG", 1, 12)); // NOI18N
        tblDatTruoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Box", "Người đặt", "Giờ đặt", "Giờ trả", "Số giờ", "Trả trước"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatTruoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDatTruoc.setGridColor(new java.awt.Color(204, 204, 204));
        tblDatTruoc.setRowHeight(30);
        tblDatTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDatTruocMousePressed(evt);
            }
        });
        scroll.setViewportView(tblDatTruoc);

        gradientPanel2.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 770, 150));

        pnlDatBox.setColor1(new java.awt.Color(240, 240, 240));
        pnlDatBox.setColor2(new java.awt.Color(240, 240, 240));
        pnlDatBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Giờ trả:");
        pnlDatBox.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 269, 54, 30));

        lblGioBd.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblGioBd.setText("11:00:00");
        pnlDatBox.add(lblGioBd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 110, 50));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Khách hàng:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pnlDatBox.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 90, 33));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Giờ đặt:");
        pnlDatBox.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 54, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Số giờ:");
        pnlDatBox.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 50, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Box");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pnlDatBox.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 30));

        txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtKhachHang.setLabelText("");
        txtKhachHang.setOpaque(false);
        pnlDatBox.add(txtKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 23, 480, 40));

        txtTraTruoc.setEditable(false);
        txtTraTruoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTraTruoc.setLabelText("");
        txtTraTruoc.setOpaque(false);
        pnlDatBox.add(txtTraTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 160, 33));

        btnDatBox.setBackground(new java.awt.Color(109, 191, 184));
        btnDatBox.setForeground(new java.awt.Color(255, 255, 255));
        btnDatBox.setText("ĐẶT BOX");
        btnDatBox.setFocusable(false);
        btnDatBox.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDatBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatBoxActionPerformed(evt);
            }
        });
        pnlDatBox.add(btnDatBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 120, 50));

        cboSoGio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        cboSoGio.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cboSoGio.setLabeText("");
        cboSoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSoGioActionPerformed(evt);
            }
        });
        pnlDatBox.add(cboSoGio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 90, 35));

        cboMinus.setForeground(new java.awt.Color(51, 51, 51));
        cboMinus.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        cboMinus.setLabeText("");
        cboMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMinusActionPerformed(evt);
            }
        });
        pnlDatBox.add(cboMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 80, 40));

        checkBoxCustom1.setText("Đặt trước");
        checkBoxCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCustom1ActionPerformed(evt);
            }
        });
        pnlDatBox.add(checkBoxCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 30));

        lblTitleDeposits.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTitleDeposits.setText("Trả trước");
        lblTitleDeposits.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pnlDatBox.add(lblTitleDeposits, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 150, 30));

        lblGioKT.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblGioKT.setText("12:00:00");
        pnlDatBox.add(lblGioKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 150, 50));

        btnHuyBox.setBackground(new java.awt.Color(109, 191, 184));
        btnHuyBox.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyBox.setText("TRẨ BOX");
        btnHuyBox.setFocusable(false);
        btnHuyBox.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnHuyBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoxActionPerformed(evt);
            }
        });
        pnlDatBox.add(btnHuyBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 120, 50));

        txtLoaiBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLoaiBox.setLabelText("");
        txtLoaiBox.setOpaque(false);
        pnlDatBox.add(txtLoaiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 83, 180, 40));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText("Loại:");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pnlDatBox.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 30));

        txtTenBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenBox.setLabelText("");
        txtTenBox.setOpaque(false);
        pnlDatBox.add(txtTenBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 83, 180, 40));

        btnDatTruoc.setBackground(new java.awt.Color(109, 191, 184));
        btnDatTruoc.setForeground(new java.awt.Color(255, 255, 255));
        btnDatTruoc.setText("ĐẶT TRƯỚC");
        btnDatTruoc.setFocusable(false);
        btnDatTruoc.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDatTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatTruocActionPerformed(evt);
            }
        });
        pnlDatBox.add(btnDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 120, 50));

        cboHour.setForeground(new java.awt.Color(51, 51, 51));
        cboHour.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        cboHour.setLabeText("");
        cboHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHourActionPerformed(evt);
            }
        });
        pnlDatBox.add(cboHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 80, 40));

        jLabel6.setFont(new java.awt.Font("UTM Aptima", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(":");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlDatBox.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 40, 40));

        gradientPanel2.add(pnlDatBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 690, 380));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 82, 110));
        jLabel1.setText("ĐẶT BOX");
        gradientPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("LỊCH ĐẶT TRƯỚC");
        gradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 130, 40));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        gradientPanel2.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 50, 50));

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboSoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSoGioActionPerformed
        handleTime();
    }//GEN-LAST:event_cboSoGioActionPerformed

    private void btnDatBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatBoxActionPerformed
        handleDatBox();
    }//GEN-LAST:event_btnDatBoxActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Store.dbView = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnHuyBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoxActionPerformed
        this.cancelBox();
    }//GEN-LAST:event_btnHuyBoxActionPerformed

    private void checkBoxCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCustom1ActionPerformed
        toggleState();
    }//GEN-LAST:event_checkBoxCustom1ActionPerformed

    private void cboMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMinusActionPerformed
        setGioBD();
    }//GEN-LAST:event_cboMinusActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.exit();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDatTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatTruocActionPerformed
        handeDatTruoc();
    }//GEN-LAST:event_btnDatTruocActionPerformed

    private void tblDatTruocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatTruocMousePressed
        handleShow(evt);
    }//GEN-LAST:event_tblDatTruocMousePressed

    private void cboHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHourActionPerformed
        renderMinus();
        setGioBD();
    }//GEN-LAST:event_cboHourActionPerformed

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
            java.util.logging.Logger.getLogger(DatBoxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatBoxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatBoxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatBoxView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatBoxView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.ButtonRound btnDatBox;
    private com.boxcf.components.ButtonRound btnDatTruoc;
    private com.boxcf.components.ButtonRound btnHuyBox;
    private com.boxcf.components.Combobox cboHour;
    private com.boxcf.components.Combobox cboMinus;
    private com.boxcf.components.Combobox cboSoGio;
    private com.boxcf.components.CheckBoxCustom checkBoxCustom1;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private com.boxcf.components.GradientPanel gradientPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblGioBd;
    private javax.swing.JLabel lblGioKT;
    private javax.swing.JLabel lblTitleDeposits;
    private com.boxcf.components.GradientPanel pnlDatBox;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblDatTruoc;
    private com.boxcf.components.TextField txtKhachHang;
    private com.boxcf.components.TextField txtLoaiBox;
    private com.boxcf.components.TextField txtTenBox;
    private com.boxcf.components.TextField txtTraTruoc;
    // End of variables declaration//GEN-END:variables

    private void init() {
        Store.dbView = this;
        prepareUI();
        setBox();
        setMode();
        fillTable();
        handleTime();
        renderHour();
        renderMinus();

    }

    private void prepareUI() {
        this.setLocationRelativeTo(null);
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        scroll.setVerticalScrollBar(new ScrollBar());
    }

    private void setBox() {
        txtTenBox.setText(box.getTen());
        txtLoaiBox.setText(box.getLoaiBox().getTenLoaiBox());
        lblGioBd.setText(XDate.toString(new Date(), "HH:mm:ss"));

//        box.setGioBD(new Date());
    }

    private ModelItem getBoxBooked() {
        return new ModelItem(box.getMaItem(), box.getTen(), XDate.getHour(lblGioBd.getText()), XDate.getHour(lblGioKT.getText()), box.getLoaiBox(), time <= 0 ? 1 : time, box.getLoaiBox().getGiaLoai(), box.getTenKH());
    }

    // xử lí hiển thị bill item
    private void handleDatBox() {
        ModelItem data = getBoxBooked();

        if (data.getGioKT() == null) {
            return;
        }

        List<PhieuDatBox> list = PhieuDatBoxDao.getInstant().getBookedListProc(this.box.getMaItem().toString());

        if (!list.isEmpty()) {
            PhieuDatBox pd = list.get(0);

            Date gBd = XDate.getHour(lblGioBd.getText());
            Date gKt = XDate.getHour(lblGioKT.getText());

            if (gBd.after(pd.getGioBD()) || gKt.before(pd.getGioKT())) {
                MsgBox.alert(this, "Thời gian đã đc đặt trước !");
                isBooked = true;
                setState(isBooked);
                return;
            }
        }

        for (Component component : panelBill.getComponents()) {
            ItemBill itemBill = (ItemBill) component;
            if (itemBill.getData().getMaItem() == data.getMaItem()) {
                itemBill.setData(data);
                orderView.handleTotal();
                this.dispose();
                return;
            }

        }

        panelBill.setList(data);
        panelBill.repaint();
        this.dispose();

    }

    // xử lí viêc khi tồn tại một billitem trùng với box thì sẽ lấy thông tin trên bill đó xuống
    private void handleResetData() {
        // so luong la gio do :))
        for (Component component : panelBill.getComponents()) {
            ItemBill itemBill = (ItemBill) component;
            if (itemBill.getData().getMaItem() == this.box.getMaItem()) {
                this.cboSoGio.setSelectedItem(itemBill.getData().getSoLuong() + "");
                return;
            }

        }
    }

    private void cancelBox() {
        if (this.box.getTrangThai() == BoxState.active) {
            if (!MsgBox.confirm(this, "Bạn có muốn trả box ?")) {
                return;
            }
            PhieuDatBox pdb = PhieuDatBoxDao.getInstant().getUsing(this.box.getMaItem().toString());

            PhieuDatBoxDao.getInstant().cancelBoxWhenActive(pdb);

            MsgBox.alert(this, "Trả thành công !");
            //fill lai box
            Store.orderView.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
            this.dispose();
            return;
        }

    }

    //dat truoc
    private void setState(boolean isBooked) {
        cboHour.setEnabled(isBooked);
        cboMinus.setEnabled(isBooked);
        lblGioBd.setText(XDate.toString(XDate.now(), "HH:mm:ss"));
        btnDatBox.setEnabled(!isBooked);
        btnDatBox.setBackground(!isBooked ? Color.decode("#6DBFB8") : Color.decode("#e6ddce"));

        if (this.box.getTrangThai() == BoxState.active) {
            btnHuyBox.setEnabled(true);
            btnHuyBox.setBackground(Color.decode("#6DBFB8"));
        } else {

            btnHuyBox.setEnabled(false);
            btnHuyBox.setBackground(Color.decode("#e6ddce"));
        }

        if (isBooked) {
            setGioBD();
        }

        handleTime();

    }

    private void setGioKT(Date gioBD, int soGio) {
        Date gioKT = new Date(XDate.addHours(gioBD, soGio).getTime());

        lblGioKT.setText(XDate.toString(gioKT, "HH:mm:ss"));
        time = soGio;
    }

    private void setGioBD() {

        //neu la dat truoc --> set gioBD theo combo box
        if (!isBooked) {
            return;
        }

        if (cboMinus.getSelectedItem() == null || cboHour.getSelectedItem() == null) {
            return;
        }

        int hour = Integer.parseInt(cboHour.getSelectedItem().toString());
        int minus = Integer.parseInt(cboMinus.getSelectedItem().toString());
        Date fitTime = XDate.convertHourAndMinusToDate(hour, minus);

        ModelCboFitTime model = new ModelCboFitTime(fitTime, XDate.fitHourWithTime(fitTime));

        Date gioBD = new Date(model.getTime().getTime());

        lblGioBd.setText(XDate.toString(gioBD, "HH:mm:ss"));

        setGioKT(new Date(gioBD.getTime()), Integer.parseInt(cboSoGio.getSelectedItem().toString()));

    }

    List<PhieuDatBox> listBox;

    private void handeDatTruoc() {
        if (!validator()) {
            return;
        }
        ModelItem data = getForm();

        //kiem tra giobd gio kt co hop le
        Date gioBD = XDate.getHour(lblGioBd.getText());
        Date gioKT = XDate.getHour(lblGioKT.getText());

        data.setGioBD(gioBD);
        data.setGioKT(gioKT);

        createBill(data);
        fillTable();
        MsgBox.alert(this, "Đặt trước thành công!");
        orderView.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
        clean();
    }

    private void createBill(ModelItem data) {
        //tao hoa don
        data.setTrangThai(BoxState.booked);
        HoaDon hd = new HoaDon(XDate.now(), data.getTenKH(), Auth.user.getMaNV(), "", deposits(), null);
        int maHd = HoaDonDao.getInstant().inserts(hd);

        //Tao phieu dat box
        PhieuDatBoxDao.getInstant().inserBooktProc(maHd, data, data.getTenKH());
    }

    private void fillTable() {
        DefaultTableModel tblModel = (DefaultTableModel) tblDatTruoc.getModel();
        tblModel.setRowCount(0);
        listBox = PhieuDatBoxDao.getInstant().getBookedListProc(box.getMaItem().toString());

        int i = 1;
        for (PhieuDatBox item : listBox) {
            Object[] row = {i, BoxDao.getInstance().selectById(item.getMaBox()).getTenBox(), item.getTenKH(), XDate.toString(item.getGioBD(), "HH:mm:ss"), XDate.toString(item.getGioKT(), "HH:mm:ss"), item.getSoGio(), Formats.toCurency(item.getTraTruoc())};
            tblModel.addRow(row);
            ++i;
        }
    }

    private void exit() {
        this.dispose();
    }

    private void setMode() {
        if (PhieuDatBoxDao.getInstant().isActive(box.getMaItem().toString()) != null) {
            isBooked = true;
            setState(isBooked);
            checkBoxCustom1.setSelected(true);
            checkBoxCustom1.setEnabled(false);
        } else {
            isBooked = false;
            setState(isBooked);
            checkBoxCustom1.setEnabled(true);

        }
    }

    private ModelItem getForm() {
        ModelItem data = getBoxBooked();
        data.setTenKH(txtKhachHang.getText());
        data.setTraTruoc((int) deposits());
        data.setGhiChu("Chưa thanh toán");

        return data;
    }

    private boolean validator() {
        List<PhieuDatBox> list = PhieuDatBoxDao.getInstant().getBookedListProc(this.box.getMaItem().toString());
        boolean flag = true;
        String mess = "";

        int hour = Integer.parseInt(cboHour.getSelectedItem().toString());
        int minus = Integer.parseInt(cboMinus.getSelectedItem().toString());

        //gio bd
        Date curentTime = XDate.getHour(hour + ":" + minus + ":00");
        Date timeEnd = XDate.getHour(lblGioKT.getText());

        for (int i = 0; i < list.size(); i++) {

            if (curentTime.before(XDate.now())) {
                mess += "Thời gian không phù hợp 1 ! \n";
                flag = false;
                break;
            }

            if (XDate.beforeTimeClose(timeEnd)) {
                mess += "Thời gian không phù hợp. Đã quá giờ mỡ cửa ! \n";
                flag = false;
                break;
            }

            if (curentTime.equals(list.get(i).getGioBD()) && timeEnd.equals(list.get(i).getGioKT())) {
                mess += "Thời gian đã được đặt trước 2 ! \n";
                flag = false;
                break;
            }

            if (curentTime.after(list.get(i).getGioBD()) && curentTime.before(list.get(i).getGioKT())) {
                mess += "Thời gian đã được đặt trước 3 ! \n";
                flag = false;
                break;
            }

            if (curentTime.after(list.get(list.size() - 1).getGioKT()) || curentTime.equals(list.get(list.size() - 1).getGioKT())) {
                break;
            }

            if (i >= list.size() - 1) {
                break;
            }

            PhieuDatBox nextPd = list.get(i + 1);

            if (nextPd == null) {
                break;
            }

            if (nextPd.getGioBD().getTime() - list.get(i).getGioKT().getTime() >= 3600000) {

                System.out.println("in: " + i);

                if (timeEnd.after(nextPd.getGioBD())) {
                    mess += "Thời gian đã được đặt trước 4 ! \n";
                    flag = false;
                    break;
                }

                if (curentTime.after(nextPd.getGioBD())) {
                    if (nextPd.getGioBD().getTime() - curentTime.getTime() < 3600000) {
                        mess += "Thời gian đã được đặt trước 5 !  \n";
                        flag = false;
                        break;
                    }

                    if (timeEnd.after(nextPd.getGioBD())) {
                        mess += "Thời gian đã được đặt trước 6 !  \n";
                        flag = false;
                        break;
                    }
                }

            } else {
                if (curentTime.after(list.get(i).getGioKT()) && curentTime.before(nextPd.getGioBD())) {
                    mess += "Thời gian đã được đặt trước !!!!!  \n";
                    flag = false;
                    break;
                }
            }
        }

        if (Validator.isEmpty(txtKhachHang)) {
            mess += "Bạn chưa có tên khách hàng ! \n";
            flag = false;
        }

        if (!flag) {
            MsgBox.alert(this, mess);
        }
        return flag;
    }

    private void handleShow(MouseEvent evt) {
        if (evt.getClickCount() != 2) {
            return;
        }
        int index = tblDatTruoc.getSelectedRow();

        String nameCutomer = (String) tblDatTruoc.getValueAt(index, 2);
        String timeStart = (String) tblDatTruoc.getValueAt(index, 3);
        String timeEnd = (String) tblDatTruoc.getValueAt(index, 4);
        int timeCount = (int) tblDatTruoc.getValueAt(index, 5);

        for (PhieuDatBox pd : listBox) {
            if (pd.getTenKH().equals(nameCutomer)
                    && pd.getSoGio() == timeCount
                    && XDate.toString(pd.getGioBD(), "HH:mm:ss").equalsIgnoreCase(timeStart)
                    && XDate.toString(pd.getGioKT(), "HH:mm:ss").equalsIgnoreCase(timeEnd)) {
                pdb = pd;
                new HoaDonNhanBox(pdb).setVisible(true);
                break;
            }
        }

    }

    private void renderHour() {
        int hour = 0;

        hour = Integer.parseInt(XDate.toString(XDate.now(), "HH"));

        if (this.box.getTrangThai() == BoxState.active) {
            hour = Integer.parseInt(XDate.toString(this.box.getGioKT(), "HH"));
        }

        for (int i = hour; i <= 22; i++) {
            if (i < 10) {
                cboHour.addItem("0" + i);
            } else {
                cboHour.addItem(i);
            }
        }
    }

    private void renderMinus() {
        int hour = Integer.parseInt(XDate.toString(XDate.now(), "HH"));
        int minus = Integer.parseInt(XDate.toString(XDate.now(), "mm"));

        if (cboHour.getSelectedItem() == null) {
            return;
        }

        int hourCbo = Integer.parseInt(cboHour.getSelectedItem().toString());

        if (hour != Integer.parseInt(cboHour.getSelectedItem().toString())) {
            minus = 0;
        }

        if (this.box.getTrangThai() == BoxState.active) {
            minus = Integer.parseInt(XDate.toString(this.box.getGioKT(), "mm"));

        }

        if (hourCbo == 22) {
            cboMinus.removeAllItems();
            cboMinus.addItem("00");
            return;
        }

        cboMinus.removeAllItems();
        for (int i = minus; i <= 55; i++) {
            if (i % 5 == 0) {
                if (i < 10) {
                    cboMinus.addItem("0" + i);
                } else {
                    cboMinus.addItem(i);
                }
            }
        }
    }

    private void handleTime() {
        if (cboSoGio.getSelectedItem() == null) {
            return;
        }

        int soGio = Integer.parseInt(cboSoGio.getSelectedItem().toString());
        Date ngayBD = XDate.getHour(lblGioBd.getText());
        setGioKT(ngayBD, soGio);
        handleDeposits();
    }

    private void handleDeposits() {
        String mess = "";
        int soGio = Integer.parseInt(cboSoGio.getSelectedItem().toString());

        if (!isBooked) {
            return;
        }

        if (soGio <= 2) {
            mess = "Trả trước ( 100% )";
            txtTraTruoc.setText(Formats.toCurency(this.box.getLoaiBox().getGiaLoai() * soGio));
        } else {
            mess = "Trả trước ( 60% )";
            txtTraTruoc.setText(Formats.toCurency(this.box.getLoaiBox().getGiaLoai() * soGio * 0.6));
        }

        lblTitleDeposits.setText(mess);
    }

    public long deposits() {
        int soGio = Integer.parseInt(cboSoGio.getSelectedItem().toString());
        if (soGio <= 2) {
            return this.box.getLoaiBox().getGiaLoai() * soGio;
        } else {
            return (long) (this.box.getLoaiBox().getGiaLoai() * soGio * 0.6);
        }
    }

    private void toggleState() {
        isBooked = !isBooked;
        setState(isBooked);
        handleTime();
    }

    private void clean() {
        txtKhachHang.setText("");

    }
}
