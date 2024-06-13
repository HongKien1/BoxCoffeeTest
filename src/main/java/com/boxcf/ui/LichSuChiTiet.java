/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.Formats;
import com.box.utils.XDate;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.ComboCTDao;
import com.boxcf.dao.ComboDao;
import com.boxcf.dao.HoaDonChiTietDao;
import com.boxcf.dao.KhuyenMaiDao;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.dao.PhieuDatBoxDao;
import com.boxcf.dao.SanPhamDao;
import com.boxcf.models.Box;
import com.boxcf.models.Combo;
import com.boxcf.models.HoaDonCT;
import com.boxcf.models.KhuyenMai;
import com.boxcf.models.LichSu;
import com.boxcf.models.LoaiBox;
import com.boxcf.models.PhieuDatBox;
import com.boxcf.store.Store;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class LichSuChiTiet extends javax.swing.JDialog {

    private long total = 0;
    private long finalTotal = 0;
    private int quantity = 0;
    private String cattegory;

    public LichSuChiTiet(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.clsoeButton1.initEvent(this);
    }

    public LichSuChiTiet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel6 = new javax.swing.JLabel();
        lblTimeNow = new javax.swing.JLabel();
        lblNameStaff = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        lblTotalMoney = new javax.swing.JLabel();
        lblNameCutomer = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel12.setText("Khuyến mãi");

        lblDiscount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscount.setText("1.000.000");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Mã HD:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Tổng cộng");

        lblId.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblId.setText("1");

        lblTotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("1.001.000.000");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Khách hàng:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Ngày:");

        lblTimeNow.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTimeNow.setText("2023/01/01 15:00:00");

        lblNameStaff.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNameStaff.setText("Nguyễn Thị Lam Hà");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nhân viên:");

        tblHoaDon.setFont(new java.awt.Font("UTM BryantLG", 1, 12)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "1", "1000", "1", "1000"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Sản phẩm", "Đơn giá", "Số lượng (giờ)", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        lblQuantity.setText("1 món");

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDiscount))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalMoney))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(20, 20, 20))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
                .addGap(20, 20, 20))
        );

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
            java.util.logging.Logger.getLogger(LichSuChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LichSuChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LichSuChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LichSuChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LichSuChiTiet dialog = new LichSuChiTiet(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ClsoeButton clsoeButton1;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private com.boxcf.components.GradientPanel gradientPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel lblTimeNow;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalMoney;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables

    private void renderDataTable(List<HoaDonCT> list, int mahd) {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        int i = 1;

        if (cattegory.equalsIgnoreCase("Combo")) {
            String MaCB = ComboCTDao.getInstant().getMaCombo(mahd);

            if (MaCB == null) {
                return;
            }

            Combo combo = ComboDao.getInstant().selectById(MaCB);
            total += combo.getGia();
            Object[] row = new Object[]{i, combo.getTenCB(),
                Formats.toCurency(combo.getGia()), combo.getSoluong(), Formats.toCurency(combo.getGia())};
            model.addRow(row);
            quantity += combo.getSoluong();
            i++;

        }

        for (HoaDonCT hd : list) {

            total += hd.getSoLuong() * hd.getThanhTien();
            Object[] row = new Object[]{i, SanPhamDao.getInstant().selectById(hd.getMaSP()).getTenSP(),
                Formats.toCurency(hd.getThanhTien()), hd.getSoLuong(), Formats.toCurency(hd.getSoLuong() * hd.getThanhTien())};
            model.addRow(row);
            if (!cattegory.equalsIgnoreCase("Combo")) {
                quantity += hd.getSoLuong();
            }
            i++;
        }
        for (PhieuDatBox pd : PhieuDatBoxDao.getInstant().selectByHd(mahd)) {
            Box b = BoxDao.getInstance().selectById(pd.getMaBox());
            LoaiBox lb = LoaiBoxDao.getInstance().selectById(b.getMaLoaiBox());
            int hour = pd.getSoGio();

            if (!cattegory.equalsIgnoreCase("Combo")) {
                quantity += 1;

            }
            Object[] row = new Object[]{i,
                b.getTenBox(),
                cattegory.equalsIgnoreCase("Combo") ? Formats.toCurency(0) : Formats.toCurency(lb.getGiaLoai() * hour),
                hour, Formats.toCurency(pd.getTienThucNhan())};
            model.addRow(row);
            total += pd.getTienThucNhan();
            i++;
        }

    }

    public void addInfo(LichSu hd, String category) {
        this.cattegory = category;
        double discount = 0;
        KhuyenMai km = KhuyenMaiDao.getInstant().selectByIdIgnorState(hd.getMaKM());

        renderDataTable(HoaDonChiTietDao.getInstant().selectByHd(hd.getMaHD()), hd.getMaHD());

        lblId.setText(hd.getMaHD() + "");
        lblTimeNow.setText(XDate.toString(hd.getNgayTao(), "dd/mm/yyyy HH:mm:ss"));
        lblNameStaff.setText(hd.getTenNV());
        lblNameCutomer.setText(hd.getTenKH());
        lblQuantity.setText(this.quantity + "");
        lblTotalMoney.setText(Formats.toCurency(total));

        if (km != null) {
            discount = (this.total * ((float) km.getPhanTram() / 100));

        }
        lblDiscount.setText("- " + Formats.toCurency(discount));
        this.finalTotal = (long) (this.total - discount);
        lblTotal.setText(Formats.toCurency(this.finalTotal).trim());

    }

}
