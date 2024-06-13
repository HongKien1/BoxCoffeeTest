package com.boxcf.ui;

import com.box.utils.Formats;
import com.box.utils.MsgBox;
import com.box.utils.Validator;
import com.box.utils.XDate;
import com.boxcf.components.ScrollBar;
import com.boxcf.components.material.Panigation;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.HoaDonDao;
import com.boxcf.dao.NhanVienDao;
import com.boxcf.dao.PhieuDatBoxDao;
import com.boxcf.models.HoaDon;
import com.boxcf.models.PhieuDatBox;
import com.boxcf.models.Time;
import com.boxcf.store.Store;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class HoaDonNhanBox extends javax.swing.JFrame {

    private DefaultTableModel model;
    private PhieuDatBox data;
    private long total = 0;
    private long finalTotal = 0;
    private int maHd;
    private int quantity = 0;

    public HoaDonNhanBox(PhieuDatBox data) {
        initComponents();
        this.data = data;
        clsoeButton1.initEvent(this);
        init();
    }

    public HoaDonNhanBox() {
        initComponents();
        clsoeButton1.initEvent(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel2 = new com.boxcf.components.GradientPanel();
        gradientPanel1 = new com.boxcf.components.GradientPanel();
        clsoeButton1 = new com.boxcf.components.ClsoeButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTimeNow = new javax.swing.JLabel();
        lblRedundant = new javax.swing.JLabel();
        lblNameStaff = new javax.swing.JLabel();
        txtMoney = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        lblTotalMoney = new javax.swing.JLabel();
        lblNameCutomer = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        buttonRound2 = new com.boxcf.components.ButtonRound();
        btnCreateBill = new com.boxcf.components.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientPanel2.setColor1(new java.awt.Color(102, 102, 102));
        gradientPanel2.setColor2(new java.awt.Color(102, 102, 102));

        gradientPanel1.setColor1(new java.awt.Color(255, 255, 255));
        gradientPanel1.setFocusCycleRoot(true);

        clsoeButton1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("UTM BryantLG", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("HÓA ĐƠN THANH TOÁN");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Trả Trước");

        lblDiscount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscount.setText("1.000.000");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Mã HD:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Tiền phải thanh toán");

        lblId.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblId.setText("1");

        lblTotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("1.001.000.000");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Khách hàng:");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Tiền khách trả");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Ngày:");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Tiền thừa");

        lblTimeNow.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTimeNow.setText("2023/01/01 15:00:00");

        lblRedundant.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblRedundant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRedundant.setText("0 VND");

        lblNameStaff.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNameStaff.setText("Nguyễn Thị Lam Hà");

        txtMoney.setBackground(new java.awt.Color(2, 154, 216));
        txtMoney.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMoney.setForeground(new java.awt.Color(51, 51, 51));
        txtMoney.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(150, 150, 150)));
        txtMoney.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nhân viên:");

        tblHoaDon.setFont(new java.awt.Font("UTM BryantLG", 1, 12)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "1", "1", "1000", null, "1000"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên box", "GIờ", "Đơn giá", "Tiền cọc", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblHoaDon.setGridColor(new java.awt.Color(204, 204, 204));
        tblHoaDon.setRowHeight(24);
        scroll.setViewportView(tblHoaDon);

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Tổng thành tiền");

        lblTotalMoney.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTotalMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalMoney.setText("1.000.000.000");

        lblNameCutomer.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        lblNameCutomer.setText("Phạm Nhứt Khang");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tổng số lượng:");

        lblQuantity.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuantity.setText("1 box");

        buttonRound2.setBackground(new java.awt.Color(109, 191, 184));
        buttonRound2.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound2.setText("HỦY ĐẶT");
        buttonRound2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });

        btnCreateBill.setBackground(new java.awt.Color(109, 191, 184));
        btnCreateBill.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateBill.setText("IN HÓA ĐƠN");
        btnCreateBill.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnCreateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(clsoeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(lblTimeNow, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lblNameCutomer, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDiscount))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalMoney))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll)
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRedundant, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1))
                    .addComponent(clsoeButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblId))
                .addGap(7, 7, 7)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblTimeNow))
                .addGap(7, 7, 7)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblNameStaff))
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblNameCutomer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTotalMoney))
                .addGap(7, 7, 7)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblDiscount))
                .addGap(7, 7, 7)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblTotal))
                .addGap(6, 6, 6)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblRedundant))
                .addGap(26, 26, 26)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreateBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        txtMoney.setBackground(new Color(0, 0, 0, 0));

        javax.swing.GroupLayout gradientPanel2Layout = new javax.swing.GroupLayout(gradientPanel2);
        gradientPanel2.setLayout(gradientPanel2Layout);
        gradientPanel2Layout.setHorizontalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        gradientPanel2Layout.setVerticalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBillActionPerformed
        handlePrintBill();
    }//GEN-LAST:event_btnCreateBillActionPerformed

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        cancelBox();
    }//GEN-LAST:event_buttonRound2ActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonNhanBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonNhanBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonNhanBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonNhanBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonNhanBox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnCreateBill;
    private com.boxcf.components.ButtonRound buttonRound2;
    private com.boxcf.components.ClsoeButton clsoeButton1;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private com.boxcf.components.GradientPanel gradientPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNameCutomer;
    private javax.swing.JLabel lblNameStaff;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblRedundant;
    private javax.swing.JLabel lblTimeNow;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalMoney;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMoney;
    // End of variables declaration//GEN-END:variables

    private void init() {
        prepareUI();
        model = (DefaultTableModel) tblHoaDon.getModel();
        renderDataTable();
        showInfo();
        setState();
    }

    private void prepareUI() {
        scroll.setVerticalScrollBar(new ScrollBar());
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }

    private void renderDataTable() {
        model.setRowCount(0);
        int i = 1;
        Object[] row = new Object[]{i, BoxDao.getInstance().selectById(data.getMaBox()), data.getSoGio(), Formats.toCurency(data.getThanhTien()), Formats.toCurency(data.getTraTruoc()), Formats.toCurency(data.getThanhTien() - data.getTraTruoc())};
        model.addRow(row);
    }

    private void showInfo() {
        HoaDon hd = HoaDonDao.getInstant().selectById(data.getMaHD());
        lblId.setText(data.getMaHD() + "");
        lblTimeNow.setText(XDate.toString(hd.getNgayTao(), "dd/mm/yyyy HH:mm:ss"));
        lblNameStaff.setText(NhanVienDao.getInstant().selectById(hd.getMaNV()).getTenNV());
        lblNameCutomer.setText(data.getTenKH());

        lblTotalMoney.setText(Formats.toCurency(data.getThanhTien()));
        lblDiscount.setText(Formats.toCurency(data.getTraTruoc()));

        finalTotal = data.getThanhTien() - data.getTraTruoc();
        lblTotal.setText(Formats.toCurency(finalTotal));

        txtMoney.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    long money = Long.parseLong(txtMoney.getText());
                    lblRedundant.setText(Formats.toCurency(money - finalTotal));
                } catch (NumberFormatException ex) {
                    lblRedundant.setText(Formats.toCurency(0));
                }
            }

        });
    }

    private void updateBill() {
        PhieuDatBoxDao dpd = PhieuDatBoxDao.getInstant();
        dpd.receiveBox(data);
    }

    private boolean validator() {
        boolean flag = true;
        String mess = "";
        try {

            if (finalTotal == 0) {
                return true;
            }

            long money = Long.parseLong(txtMoney.getText());

            if (Validator.isEmpty(txtMoney)) {
                mess = "Chưa có tiền khách trả  ";
                flag = false;
            }

            if (money - finalTotal < 0) {
                mess = "Tiền không đủ  ";
                flag = false;
            }

        } catch (Exception e) {
            mess = "Tiền không hợp lệ  ";
            flag = false;
        }

        if (!mess.equals("")) {
            MsgBox.alert(this, mess);
        }

        return flag;
    }

    private void handlePrintBill() {
        if (!validator()) {
            return;
        }

        this.dispose();
        updateBill();
        Store.orderView.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
        Store.bStatus.fillState();
        Store.dbView.dispose();
        Store.dbView = null;

    }

    private void setState() {

        if (XDate.now().after(data.getGioBD())) {
            btnCreateBill.setEnabled(true);
            btnCreateBill.setBackground(Color.decode("#6DBFB8"));
            btnCreateBill.setText("IN HÓA ĐƠN");

        } else {
            btnCreateBill.setEnabled(false);
            btnCreateBill.setBackground(Color.decode("#e6ddce"));
            Time t = XDate.toTime(XDate.toString(data.getGioBD(), "MM/dd/yyyy HH:mm:ss"));
            btnCreateBill.setText("Còn " + t.getHour() + " giờ " + t.getMinute() + " phút");

        }

    }

    private void cancelBox() {
        PhieuDatBoxDao pdbd = PhieuDatBoxDao.getInstant();

        boolean check = MsgBox.confirm(this, "Bạn muốn hủy ?");

        if (!check) {
            return;
        }

        pdbd.cancelBox(data);
        MsgBox.alert(this, "Hủy thành công !");
        //fill lai box
        Store.orderView.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
        Store.dbView.dispose();
        this.dispose();
    }

}
