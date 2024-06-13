/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.box.utils.Validator;
import com.boxcf.components.ButtonRound;
import com.boxcf.components.Combobox;
import com.boxcf.dao.ComboDao;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.models.Combo;
import com.boxcf.models.LoaiBox;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;

public class ComboForm extends javax.swing.JFrame implements ActionListener {
    
    public static int i = -1;
    List<Combo> list = ComboDao.getInstant().selectAll();
//    ComboView cbView = Store.CbView;

    public ComboForm() {
        initComponents();
        init();
        cboLoaiBox.addActionListener(this);
        setNextId();
    }
    
    public ComboForm(Combo Combo) {
        initComponents();
        init();
    }
    
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new com.boxcf.components.GradientPanel();
        pnlBox = new com.boxcf.components.GradientPanel();
        lblMaCombo = new javax.swing.JLabel();
        lblMaNV1 = new javax.swing.JLabel();
        lblMaNV3 = new javax.swing.JLabel();
        lblMaNV8 = new javax.swing.JLabel();
        txtMaCombo = new com.boxcf.components.TextField();
        txtTenCombo = new com.boxcf.components.TextField();
        cboLoaiBox = new com.boxcf.components.Combobox();
        btnClose = new com.boxcf.components.ButtonRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnLast = new com.boxcf.components.ButtonRound();
        btnNext = new com.boxcf.components.ButtonRound();
        btnPre = new com.boxcf.components.ButtonRound();
        btnFirst = new com.boxcf.components.ButtonRound();
        btnAdd = new com.boxcf.components.ButtonRound();
        btnRefrest = new com.boxcf.components.ButtonRound();
        btnUpdate = new com.boxcf.components.ButtonRound();
        lblMaNV2 = new javax.swing.JLabel();
        txtGiaCombo = new com.boxcf.components.TextField();
        lblMaNV4 = new javax.swing.JLabel();
        lblMaNV5 = new javax.swing.JLabel();
        txtSLDoUong = new com.boxcf.components.TextField();
        lblMaNV6 = new javax.swing.JLabel();
        txtSLDoAn = new com.boxcf.components.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientPanel1.setColor1(new java.awt.Color(102, 102, 102));
        gradientPanel1.setColor2(new java.awt.Color(102, 102, 102));
        gradientPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        pnlBox.setBackground(new java.awt.Color(102, 102, 102));
        pnlBox.setColor1(new java.awt.Color(245, 250, 255));
        pnlBox.setColor2(new java.awt.Color(245, 250, 255));
        pnlBox.setMinimumSize(new java.awt.Dimension(942, 738));
        pnlBox.setPreferredSize(new java.awt.Dimension(942, 738));
        pnlBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaCombo.setBackground(new java.awt.Color(102, 0, 204));
        lblMaCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaCombo.setForeground(new java.awt.Color(27, 51, 61));
        lblMaCombo.setText("Mã Combo");
        pnlBox.add(lblMaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 80, -1));

        lblMaNV1.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV1.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV1.setText("Tên Combo");
        pnlBox.add(lblMaNV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, -1));

        lblMaNV3.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV3.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV3.setText("Mô tả");
        pnlBox.add(lblMaNV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 50, -1));

        lblMaNV8.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV8.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV8.setText("Loại Box");
        pnlBox.add(lblMaNV8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 90, -1));

        txtMaCombo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMaCombo.setLabelText("");
        pnlBox.add(txtMaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 550, 38));

        txtTenCombo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTenCombo.setLabelText("");
        pnlBox.add(txtTenCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 550, 38));

        cboLoaiBox.setEditable(true);
        cboLoaiBox.setEnabled(false);
        cboLoaiBox.setFocusable(false);
        cboLoaiBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlBox.add(cboLoaiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 290, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlBox.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 50, 50));

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMoTa.setRows(2);
        jScrollPane1.setViewportView(txtMoTa);

        pnlBox.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 550, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 48, 84));
        jLabel1.setText("THÔNG TIN COMBO");
        pnlBox.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        btnLast.setBackground(new java.awt.Color(2, 172, 171));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.setFocusable(false);
        btnLast.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        pnlBox.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 590, 44, 40));

        btnNext.setBackground(new java.awt.Color(2, 172, 171));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.setFocusable(false);
        btnNext.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlBox.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 590, 44, 40));

        btnPre.setBackground(new java.awt.Color(2, 172, 171));
        btnPre.setForeground(new java.awt.Color(255, 255, 255));
        btnPre.setText("<<");
        btnPre.setFocusable(false);
        btnPre.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        pnlBox.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, 44, 40));

        btnFirst.setBackground(new java.awt.Color(2, 172, 171));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.setFocusable(false);
        btnFirst.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        pnlBox.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 44, 40));

        btnAdd.setBackground(new java.awt.Color(2, 172, 171));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("LƯU");
        btnAdd.setFocusable(false);
        btnAdd.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlBox.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 96, 40));

        btnRefrest.setBackground(new java.awt.Color(2, 172, 171));
        btnRefrest.setForeground(new java.awt.Color(255, 255, 255));
        btnRefrest.setText("MỚI");
        btnRefrest.setFocusable(false);
        btnRefrest.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnRefrest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrestActionPerformed(evt);
            }
        });
        pnlBox.add(btnRefrest, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 96, 40));

        btnUpdate.setBackground(new java.awt.Color(2, 172, 171));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("CẬP NHẬT");
        btnUpdate.setFocusable(false);
        btnUpdate.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlBox.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 96, 40));

        lblMaNV2.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV2.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV2.setText("Giá Combo");
        pnlBox.add(lblMaNV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 90, -1));

        txtGiaCombo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtGiaCombo.setLabelText("");
        pnlBox.add(txtGiaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 550, 38));

        lblMaNV4.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV4.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV4.setText("Số lượng đồ uống");
        pnlBox.add(lblMaNV4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        lblMaNV5.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV5.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV5.setText("Số lượng đồ uống");
        pnlBox.add(lblMaNV5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        txtSLDoUong.setText("0");
        txtSLDoUong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSLDoUong.setLabelText("");
        pnlBox.add(txtSLDoUong, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 140, 38));

        lblMaNV6.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV6.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV6.setText("Số lượng đồ ăn");
        pnlBox.add(lblMaNV6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        txtSLDoAn.setText("0");
        txtSLDoAn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSLDoAn.setLabelText("");
        pnlBox.add(txtSLDoAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 140, 38));

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(pnlBox, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(pnlBox, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.control(evt.getActionCommand());
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.control(evt.getActionCommand());
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        this.control(evt.getActionCommand());
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this.control(evt.getActionCommand());
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnRefrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrestActionPerformed
        this.clear();
        this.setNextId();
    }//GEN-LAST:event_btnRefrestActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        this.insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.exit();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.update();
        Store.CbView.fillTableCombo(ComboDao.getInstant().selectAll());
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnAdd;
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.ButtonRound btnFirst;
    private com.boxcf.components.ButtonRound btnLast;
    private com.boxcf.components.ButtonRound btnNext;
    private com.boxcf.components.ButtonRound btnPre;
    private com.boxcf.components.ButtonRound btnRefrest;
    private com.boxcf.components.ButtonRound btnUpdate;
    private com.boxcf.components.Combobox cboLoaiBox;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaCombo;
    private javax.swing.JLabel lblMaNV1;
    private javax.swing.JLabel lblMaNV2;
    private javax.swing.JLabel lblMaNV3;
    private javax.swing.JLabel lblMaNV4;
    private javax.swing.JLabel lblMaNV5;
    private javax.swing.JLabel lblMaNV6;
    private javax.swing.JLabel lblMaNV8;
    private com.boxcf.components.GradientPanel pnlBox;
    private com.boxcf.components.TextField txtGiaCombo;
    private com.boxcf.components.TextField txtMaCombo;
    private javax.swing.JTextArea txtMoTa;
    private com.boxcf.components.TextField txtSLDoAn;
    private com.boxcf.components.TextField txtSLDoUong;
    private com.boxcf.components.TextField txtTenCombo;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.prepareUI();
        this.updateStatus();
        this.fillComboBox();
    }
    
    private void prepareUI() {
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.changeTransBG(new Color(0, 0, 0, 0), txtMaCombo, txtTenCombo, txtGiaCombo, txtSLDoAn, txtSLDoUong);
        txtMaCombo.setEditable(false);
        
        btnRefrest.setVisible(false);
    }
    
    private void exit() {
        this.dispose();
    }
    
    public void fillComboBox() {
        cboLoaiBox.removeAllItems();
        List<LoaiBox> list = LoaiBoxDao.getInstance().selectAll();
        for (LoaiBox loaiBox : list) {
            cboLoaiBox.addItem(loaiBox);
        }
    }
    
    public void setForm(Combo Combo) {
        if (Combo == null) {
            return;
        }
        
        txtMaCombo.setText(Combo.getMaCB());
        txtTenCombo.setText(Combo.getTenCB());
        txtGiaCombo.setText(String.valueOf(Combo.getGia()));
        cboLoaiBox.setSelectedItem(LoaiBoxDao.getInstance().selectById(Combo.getMaLoaiBox()));
        txtSLDoUong.setText(String.valueOf(Combo.getSoLuongDoUong()));
        txtSLDoAn.setText(String.valueOf(Combo.getSoLuongDoAn()));
        txtMoTa.setText(Combo.getMoTa());
    }
    
    private Combo getForm() {
        LoaiBox loaiBox = (LoaiBox) cboLoaiBox.getSelectedItem();
        Combo Combo = new Combo();
        Combo.setMaCB(txtMaCombo.getText());
        Combo.setTenCB(txtTenCombo.getText());
        Combo.setGia(Long.parseLong(txtGiaCombo.getText()));
        Combo.setMaLoaiBox(loaiBox.getMaLoaiBox());
        Combo.setSoLuongDoUong(Integer.parseInt(txtSLDoUong.getText()));
        Combo.setSoLuongDoAn(Integer.parseInt(txtSLDoAn.getText()));
        Combo.setMoTa(txtMoTa.getText());
        return Combo;
    }
    
    public boolean validation() {
        boolean flag = true;
        String mess = "";
        
        if (Validator.isEmpty(txtTenCombo)) {
            mess += "Bạn chưa nhập tên cho Combo \n";
            flag = false;
            
        }
        
        if (Validator.isEmpty(txtGiaCombo)) {
            mess += "Bạn chưa nhập giá cho Combo \n";
            flag = false;
        } else {
            if (Validator.isDouble(txtGiaCombo.getText())) {
                double a = Double.parseDouble(txtGiaCombo.getText());
                if (!Validator.isPositiveNumber(a)) {
                    mess += "Giá không thể âm \n";
                    flag = false;
                }
            } else {
                mess += "Giá không hợp lệ \n";
                flag = false;
            }
        }
        
        if (Validator.isEmpty(txtSLDoUong)) {
            mess += "Bạn chưa nhập số lượng đồ uống \n";
            flag = false;
        } else {
            if (Validator.isInt(txtSLDoUong.getText())) {
                double b = Double.parseDouble(txtSLDoUong.getText());
                if (!Validator.isPositiveNumber(b)) {
                    mess += "Số lượng đồ uống không thể âm\n";
                    flag = false;
                    
                }
                if (Double.parseDouble(txtSLDoUong.getText()) > 6) {
                    mess += "Số lượng đồ uống tối đa là 6\n";
                    flag = false;
                }
            } else {
                mess += "Số lượng đồ uống nhập không hợp lệ \n";
                flag = false;
            }
        }
        
        if (Validator.isEmpty(txtSLDoAn)) {
            mess += "Bạn chưa nhập số lượng đồ ăn \n";
            flag = false;
        } else {
            if (Validator.isInt(txtSLDoAn.getText())) {
                double c = Double.parseDouble(txtSLDoAn.getText());
                if (!Validator.isPositiveNumber(c)) {
                    mess += "Số lượng đồ ăn không thể âm\n";
                    flag = false;
                }
                if (Double.parseDouble(txtSLDoAn.getText()) > 6) {
                    mess += "Số lượng đồ ăn tối đa là 6\n";
                    flag = false;
                }
            } else {
                mess += "Số lượng đồ ăn nhập không hợp lệ \n";
                flag = false;
            }
        }
        if (!flag) {
            MsgBox.alert(this, mess);
        }
        
        return flag;
    }
    
    private void insert() {
        if (validation()) {
            ComboDao.getInstant().insert(getForm());
            MsgBox.alert(this, "Thêm thành công!");
            clear();
            Store.CbView.fillTableCombo(ComboDao.getInstant().selectAll());
            this.dispose();
        }
    }
    
    private void clear() {
        this.setNextId();
        txtMaCombo.setText("");
        txtTenCombo.setText("");
        txtGiaCombo.setText("");
        txtSLDoUong.setText("");
        txtSLDoAn.setText("");
        txtMoTa.setText("");
        
        cboLoaiBox.setEnabled(true);
        
        i = -1;
        updateStatus();
    }
    
    private void updateStatus() {
        boolean edit = i >= 0;
        boolean first = i > 0;
        boolean last = i < list.size() - 1;
        
        btnUpdate.setEnabled(edit);
        btnUpdate.setBackground(edit ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnAdd.setEnabled(!edit);
        btnAdd.setBackground(!edit ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        
        btnFirst.setEnabled(edit && first);
        btnFirst.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnPre.setEnabled(edit && first);
        btnPre.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnLast.setEnabled(edit && last);
        btnLast.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnNext.setEnabled(edit && last);
        btnNext.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
    }
    
    private void control(String btn) {
        switch (btn) {
            case "|<":
                i = 0;
                break;
            case ">|":
                i = list.size() - 1;
                break;
            case "<<":
                if (i > 0) {
                    --i;
                }
                break;
            case ">>":
                if (i < list.size() - 1) {
                    ++i;
                }
                break;
            default:
                throw new AssertionError();
        }
        this.setForm(list.get(i));
        this.updateStatus();
    }
    
    private void update() {
        if (MsgBox.confirm(this, "Bạn có chắc muốn cập nhật dữ liệu này?")) {
            if (validation()) {
                Combo combo = getForm();
                ComboDao.getInstant().update(combo);
                MsgBox.alert(this, "Cập nhật thành công!");
                Store.CbView.fillTableCombo(ComboDao.getInstant().selectAll());
                clear();
                this.dispose();
            }
        }
    }
    
    private void setNextId() {
        String maxId;
        
        try {
            maxId = ComboDao.getInstant().getMaxId();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        
        LoaiBox loaiBox = (LoaiBox) cboLoaiBox.getSelectedItem();
        txtMaCombo.setText(getNextId(maxId, loaiBox.getMaLoaiBox()));
    }
    
    public String getNextId(String maxId, String maLoaiBox) {
        if (maxId.length() < 4) {
            return " ";
        }
        String first = maxId.substring(0, 2);
        String middle = maxId.substring(2, 5);
        Integer number = Integer.parseInt(middle);
        Integer log = number / 10;
        
        if (log == 0) {
            maxId = first + "00" + ++number + maLoaiBox;
        } else if (log > 10) {
            maxId = first + ++number + maLoaiBox;
        } else if (log > 0) {
            maxId = first + "0" + ++number + maLoaiBox;
        }
        
        return maxId;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setNextId();
    }
    
    public Combobox getCboLoaiBox() {
        return cboLoaiBox;
    }
    
    public void setCboLoaiBox(Combobox cboLoaiBox) {
        this.cboLoaiBox = cboLoaiBox;
    }
    
    public ButtonRound getBtnCapNhatSP() {
        return btnRefrest;
    }
    
    public void setBtnCapNhatSP(ButtonRound btnCapNhatSP) {
        this.btnRefrest = btnCapNhatSP;
    }
    
}
