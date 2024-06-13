package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.Formats;
import com.box.utils.MsgBox;
import com.box.utils.Validator;
import com.box.utils.XDate;
import com.boxcf.components.ScrollBar;
import com.boxcf.components.material.ItemBill;
import com.boxcf.components.material.Panigation;
import com.boxcf.constands.BoxState;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.ComboCTDao;
import com.boxcf.dao.HoaDonChiTietDao;
import com.boxcf.dao.HoaDonDao;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.dao.PhieuDatBoxDao;
import com.boxcf.models.ComboCT;
import com.boxcf.models.HoaDon;
import com.boxcf.models.HoaDonCT;
import com.boxcf.models.KhuyenMai;
import com.boxcf.models.ModelItem;
import com.boxcf.store.Store;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

public class HoaDonView extends javax.swing.JFrame {

    private DefaultTableModel model;
    private long total = 0;
    private long finalTotal = 0;
    private KhuyenMai km;
    private int maHd;
    private int quantity = 0;

    public HoaDonView() {
        initComponents();
        clsoeButton1.initEvent(this);
        initShowHistory();
    }

    public HoaDonView(KhuyenMai km) {
        this.km = km;
        initComponents();
        clsoeButton1.initEvent(this);
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel2 = new com.boxcf.components.GradientPanel();
        gradientPanel1 = new com.boxcf.components.GradientPanel();
        clsoeButton1 = new com.boxcf.components.ClsoeButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        buttonRound1 = new com.boxcf.components.ButtonRound();
        lblDiscount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
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
        jLabel5 = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();

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
        jLabel12.setText("Khuyến mãi");

        buttonRound1.setBackground(new java.awt.Color(109, 191, 184));
        buttonRound1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound1.setText("IN HÓA ĐƠN");
        buttonRound1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

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
        lblRedundant.setText("0 vnd");

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
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRedundant, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(77, 77, 77)
                        .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(71, 71, 71)
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
                .addGap(23, 23, 23)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        handlePrintBill();
    }//GEN-LAST:event_buttonRound1ActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound buttonRound1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblId;
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
    }

    private void initShowHistory() {
        prepareUI();
        model = (DefaultTableModel) tblHoaDon.getModel();
    }

    public void setKm(KhuyenMai km) {
        this.km = km;
    }

    private void prepareUI() {
        scroll.setVerticalScrollBar(new ScrollBar());
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }

    private void renderDataTable() {
        model.setRowCount(0);
        int i = 1;
        for (Component com : Store.globelPanelBill.getComponents()) {
            if (com instanceof ItemBill) {
                ItemBill item = (ItemBill) com;
                ModelItem data = item.getData();

                total += data.getSoLuong() * data.getGia();
                Object[] row = new Object[]{i, data.getTen(), data.getGia(), data.getSoLuong(), data.getSoLuong() * data.getGia()};
                model.addRow(row);

                i++;
            }
        }
    }

    private void showInfo() {
        double discount = 0;
        int nextId = HoaDonDao.getInstant().getNextId();

        lblId.setText(nextId + "");
        lblTimeNow.setText(XDate.toString(XDate.now(), "dd/mm/yyyy HH:mm:ss"));
        lblQuantity.setText(Store.globelPanelBill.getQuantityBill() + "");
        lblNameStaff.setText(Auth.user.getTenNV());

        lblTotalMoney.setText(Formats.toCurency(total));
        if (km != null) {
            discount = (this.total * ((float) km.getPhanTram() / 100));

        }
        lblDiscount.setText("- " + Formats.toCurency(discount));
        this.finalTotal = (long) (this.total - discount);
        lblTotal.setText(Formats.toCurency(this.finalTotal).trim());
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

    private void createBill() {
        //tao hoa don
        HoaDon hd = new HoaDon(XDate.now(), "", Auth.user.getMaNV(), "", finalTotal, km == null ? null : km.getMaKM());
        maHd = HoaDonDao.getInstant().inserts(hd);

        //tao hoa don chi tiet
        for (ItemBill item : Store.globelPanelBill.getList()) {
            ModelItem data = item.getData();

            data.setTrangThai(BoxState.active);
            item.setData(data);

            if (item.getData().getMaCB() != null) {
                String maSP = data.getLoaiBox() == null ? data.getMaItem().toString() : null;
                String maBox = data.getLoaiBox() != null ? data.getMaItem().toString() : null;

                if (maSP != null) {
                    ComboCT cbct = new ComboCT(maHd, data.getMaCB(), maSP, maBox, data.getSoLuong());
                    ComboCTDao.getInstant().insert(cbct);
                    //Tao hoa don chi tiet
                    HoaDonCT hdct = new HoaDonCT(maHd, data.getMaItem().toString(), data.getSoLuong(), "", (long) (data.getGia()));
                    HoaDonChiTietDao.getInstant().insert(hdct);
                }

                if (maBox != null && data.getLoaiBox() != null && !data.getMaItem().equals(data.getMaCB())) {
                    ComboCT cbct = new ComboCT(maHd, data.getMaCB(), maSP, maBox, data.getSoLuong());
                    ComboCTDao.getInstant().insert(cbct);

                    // set cua loai box ve 0 khi chen vi khi tinh tien chi tinh tien combo
                    ModelItem newData = data;
                    newData.getLoaiBox().setGiaLoai(0);

                    PhieuDatBoxDao.getInstant().insertProc(maHd, newData, "");
                }

            } else if (data.getLoaiBox() != null) {
                //Tao phieu dat box
                PhieuDatBoxDao.getInstant().insertProc(maHd, item.getData(), "");

            } else {
                //Tao hoa don chi tiet
                HoaDonCT hdct = new HoaDonCT(maHd, data.getMaItem().toString(), data.getSoLuong(), "", (long) (data.getGia()));
                HoaDonChiTietDao.getInstant().insert(hdct);
            }

        }
        MsgBox.alert(Store.orderView, "Thanh toán thành công !");

    }

    private boolean validator() {
        boolean flag = true;
        String mess = "";
        try {
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
        createBill();
        Store.globelPanelBill.clearList(false);
        Store.orderView.initBoxData(BoxDao.getInstance().panigation(Panigation.current));
        Store.bStatus.fillState();
    }

}
