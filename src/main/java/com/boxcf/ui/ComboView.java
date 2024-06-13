package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.boxcf.components.ScrollBar;
import com.boxcf.dao.ComboDao;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.models.Combo;
import com.boxcf.models.LoaiBox;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ComboView extends javax.swing.JPanel implements ActionListener {

    private DefaultTableModel tblModel;
    private List<Combo> listCombo = ComboDao.getInstant().selectAll();
    ComboDao cbDAO = new ComboDao();

    public ComboView() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnDel = new com.boxcf.components.ButtonRound();
        btnAdd = new com.boxcf.components.ButtonRound();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        scrollbar = new javax.swing.JScrollPane();
        tblCombo = new javax.swing.JTable();
        cboLoaiBox = new com.boxcf.components.Combobox();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("QUẢN LÝ COMBO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDel.setBackground(new java.awt.Color(2, 172, 171));
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("XÓA");
        btnDel.setFocusable(false);
        btnDel.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, 96, 40));

        btnAdd.setBackground(new java.awt.Color(2, 172, 171));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM COMBO");
        btnAdd.setFocusable(false);
        btnAdd.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 470, 120, 40));

        txtSearch.setBackground(new java.awt.Color(0, 153, 153));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(51, 51, 51));
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 600, 32));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setText("Loại box");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 80, 30));

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV.setText("Combo");
        jPanel1.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 86, -1));

        tblCombo.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        tblCombo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Combo", "Tên Combo", "Giá", "Loại box", "Số lượng đồ uống", "Số lượng dồ ăn", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCombo.setGridColor(new java.awt.Color(204, 204, 204));
        tblCombo.setRowHeight(30);
        tblCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComboMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblComboMousePressed(evt);
            }
        });
        scrollbar.setViewportView(tblCombo);
        if (tblCombo.getColumnModel().getColumnCount() > 0) {
            tblCombo.getColumnModel().getColumn(0).setResizable(false);
            tblCombo.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblCombo.getColumnModel().getColumn(2).setMinWidth(200);
        }

        jPanel1.add(scrollbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 940, 260));

        cboLoaiBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả" }));
        cboLoaiBox.setFocusable(false);
        cboLoaiBox.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        cboLoaiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiBoxActionPerformed(evt);
            }
        });
        jPanel1.add(cboLoaiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiBoxActionPerformed
//                this.filter();
    }//GEN-LAST:event_cboLoaiBoxActionPerformed

    private void tblComboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComboMousePressed
        if (evt.getClickCount() == 2) {
            if (!Auth.accept(this)) {
                return;
            }
            this.showInfo(getCombo());
        }
    }//GEN-LAST:event_tblComboMousePressed

    private void tblComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComboMouseClicked

    }//GEN-LAST:event_tblComboMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        this.seach();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!Auth.accept(this)) {
            return;
        }

        ComboForm.i = -1;
        this.openComboInfo();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.delete();
    }//GEN-LAST:event_btnDelActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnAdd;
    private com.boxcf.components.ButtonRound btnDel;
    private com.boxcf.components.Combobox cboLoaiBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JScrollPane scrollbar;
    private javax.swing.JTable tblCombo;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.prepareUI();
        Store.CbView = this;
        this.fillComboBox();
        this.fillTableCombo(ComboDao.getInstant().selectAll());
        cboLoaiBox.setSelectedIndex(0);
        cboLoaiBox.addActionListener(this);

        UI.accept(btnAdd, btnDel);
    }

    private void prepareUI() {
        UI.changeTransBG(new Color(0, 0, 0, 0), txtSearch);
        scrollbar.setVerticalScrollBar(new ScrollBar());
        Store.CbView = this;
    }

    private void openComboInfo() {
        ComboForm form = new ComboForm();
        form.getCboLoaiBox().setEnabled(true);
        form.getBtnCapNhatSP().setVisible(true);
        form.setVisible(true);
    }

    public void fillComboBox() {
        cboLoaiBox.removeAllItems();
        cboLoaiBox.addItem("Tất cả");

        List<LoaiBox> list = LoaiBoxDao.getInstance().selectAll();
        for (LoaiBox loaiBox : list) {
            cboLoaiBox.addItem(loaiBox);
        }
    }

    public void fillTableCombo(List<Combo> list) {
        tblModel = (DefaultTableModel) tblCombo.getModel();
        tblModel.setRowCount(0);

        int i = 1;
        for (Combo cb : list) {
            Object[] row = {i, cb.getMaCB(), cb.getTenCB(), cb.getGia(), cb.getMaLoaiBox(), cb.getSoLuongDoUong(), cb.getSoLuongDoAn(), cb.getMoTa()};
            tblModel.addRow(row);
            ++i;
        }
    }

    private void showInfo(Object obj) {
        Combo Combo = (Combo) obj;
        ComboForm form = new ComboForm(Combo);
        form.setVisible(true);
        form.setForm(Combo);

    }

    private void delete() {
        int[] indexs = tblCombo.getSelectedRows();

        if (MsgBox.confirm(this, "Bạn có chắc muốn xóa dữ liệu này?")) {
            for (int index : indexs) {
                try {
                    ComboDao.getInstant().delete(tblCombo.getValueAt(index, 1).toString());
                } catch (Exception e) {
                    MsgBox.alert(this, "Không thể xoá Combo !");
                    return;
                }
            }
            MsgBox.alert(this, "Xóa thành công!");
            fillTableCombo(ComboDao.getInstant().selectAll());
        }
    }

    private Combo getCombo() {
        ComboForm.i = tblCombo.getSelectedRow();
        String id = tblCombo.getValueAt(ComboForm.i, 1).toString();
        return ComboDao.getInstant().selectById(id);
    }

    private void filter() {
        if (cboLoaiBox.getSelectedIndex() == 0) {
            fillTableCombo(ComboDao.getInstant().selectAll());
        } else {
            LoaiBox loaiBox = (LoaiBox) cboLoaiBox.getSelectedItem();
            fillTableCombo(ComboDao.getInstant().selectByLoaiBox(loaiBox.getMaLoaiBox()));
        }
    }

    private void seach() {
        String keyword = txtSearch.getText();

        if (keyword.isEmpty()) {
            fillTableCombo(ComboDao.getInstant().selectAll());
        } else {
            fillTableCombo(ComboDao.getInstant().selectByKeyWord(keyword));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.filter();
    }

}
