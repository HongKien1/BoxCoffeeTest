/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.boxcf.components.TextField;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.models.LoaiBox;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.swing.JFrame;

public class LoaiBoxForm extends javax.swing.JFrame {

    String maBox;
    public static int i = -1;
    List<LoaiBox> list = LoaiBoxDao.getInstance().selectAll();

    public LoaiBoxForm() {
        initComponents();
        init();
    }

    public LoaiBoxForm(LoaiBox loaiBox) {
        initComponents();
        init();
    }

    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new com.boxcf.components.GradientPanel();
        pnlBox = new com.boxcf.components.GradientPanel();
        lblMaNV = new javax.swing.JLabel();
        lblMaNV1 = new javax.swing.JLabel();
        lblMaNV3 = new javax.swing.JLabel();
        lblMaNV8 = new javax.swing.JLabel();
        txtMaLoai = new com.boxcf.components.TextField();
        txtGia = new com.boxcf.components.TextField();
        btnClose = new com.boxcf.components.ButtonRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnLast = new com.boxcf.components.ButtonRound();
        btnNext = new com.boxcf.components.ButtonRound();
        btnPre = new com.boxcf.components.ButtonRound();
        btnFirst = new com.boxcf.components.ButtonRound();
        btnAdd = new com.boxcf.components.ButtonRound();
        btnCapNhatSP = new com.boxcf.components.ButtonRound();
        btnUpdate = new com.boxcf.components.ButtonRound();
        txtTenLoai = new com.boxcf.components.TextField();

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

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV.setText("Tên loại");
        pnlBox.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 70, -1));

        lblMaNV1.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV1.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV1.setText("Giá (VNĐ / giờ)");
        pnlBox.add(lblMaNV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 120, -1));

        lblMaNV3.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV3.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV3.setText("Mô tả");
        pnlBox.add(lblMaNV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 50, -1));

        lblMaNV8.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV8.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV8.setText(" Mã loại");
        pnlBox.add(lblMaNV8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 90, -1));

        txtMaLoai.setEnabled(false);
        txtMaLoai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMaLoai.setLabelText("");
        txtMaLoai.setOpaque(false);
        pnlBox.add(txtMaLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 550, 38));

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtGia.setLabelText("");
        txtGia.setOpaque(false);
        pnlBox.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 550, 38));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlBox.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 50, 50));

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMoTa.setRows(2);
        jScrollPane1.setViewportView(txtMoTa);

        pnlBox.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 550, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 48, 84));
        jLabel1.setText("THÔNG TIN LOẠI BOX");
        pnlBox.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        btnLast.setBackground(new java.awt.Color(2, 172, 171));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        pnlBox.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, 44, 40));

        btnNext.setBackground(new java.awt.Color(2, 172, 171));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlBox.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, 44, 40));

        btnPre.setBackground(new java.awt.Color(2, 172, 171));
        btnPre.setForeground(new java.awt.Color(255, 255, 255));
        btnPre.setText("<<");
        btnPre.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        pnlBox.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, 44, 40));

        btnFirst.setBackground(new java.awt.Color(2, 172, 171));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        pnlBox.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 44, 40));

        btnAdd.setBackground(new java.awt.Color(2, 172, 171));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("LƯU");
        btnAdd.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlBox.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 96, 40));

        btnCapNhatSP.setBackground(new java.awt.Color(2, 172, 171));
        btnCapNhatSP.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatSP.setText("MỚI");
        btnCapNhatSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnCapNhatSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSPActionPerformed(evt);
            }
        });
        pnlBox.add(btnCapNhatSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 96, 40));

        btnUpdate.setBackground(new java.awt.Color(2, 172, 171));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("CẬP NHẬT");
        btnUpdate.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlBox.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 96, 40));

        txtTenLoai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTenLoai.setLabelText("");
        txtTenLoai.setOpaque(false);
        pnlBox.add(txtTenLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 550, 38));

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(pnlBox, javax.swing.GroupLayout.PREFERRED_SIZE, 761, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(pnlBox, javax.swing.GroupLayout.PREFERRED_SIZE, 618, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCapNhatSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSPActionPerformed
        this.clear();
    }//GEN-LAST:event_btnCapNhatSPActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        this.insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.exit();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.update();
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnAdd;
    private com.boxcf.components.ButtonRound btnCapNhatSP;
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.ButtonRound btnFirst;
    private com.boxcf.components.ButtonRound btnLast;
    private com.boxcf.components.ButtonRound btnNext;
    private com.boxcf.components.ButtonRound btnPre;
    private com.boxcf.components.ButtonRound btnUpdate;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaNV1;
    private javax.swing.JLabel lblMaNV3;
    private javax.swing.JLabel lblMaNV8;
    private com.boxcf.components.GradientPanel pnlBox;
    private com.boxcf.components.TextField txtGia;
    private com.boxcf.components.TextField txtMaLoai;
    private javax.swing.JTextArea txtMoTa;
    private com.boxcf.components.TextField txtTenLoai;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.prepareUI();
        this.updateStatus();
    }

    private void prepareUI() {
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.changeTransBG(new Color(0, 0, 0, 0), txtMaLoai, txtTenLoai, txtGia);
    }

    private void exit() {
        this.dispose();
    }

    public void setForm(LoaiBox loaiBox) {
        txtMaLoai.setText(loaiBox.getMaLoaiBox());
        txtTenLoai.setText(loaiBox.getTenLoaiBox());
        txtGia.setText(loaiBox.getGiaLoai() + "");
        txtMoTa.setText(loaiBox.getMoTa());
    }

    private LoaiBox getForm() {
        LoaiBox loaiBox = new LoaiBox();

        loaiBox.setMaLoaiBox(txtMaLoai.getText());
        loaiBox.setTenLoaiBox(txtTenLoai.getText());
        loaiBox.setGiaLoai(Long.parseLong(txtGia.getText()));
        loaiBox.setMoTa(txtMoTa.getText());

        return loaiBox;
    }

    public boolean validation() {
        String maLoai = txtMaLoai.getText();
        String tenLoai = txtTenLoai.getText();
        String giaLoai = txtGia.getText();
        String message = "Bạn chưa nhập ";
        boolean valid = true;

        if (maLoai.isEmpty()) {
            message += "Mã loại, ";
            valid = false;
        } else {
            if (maLoai.length() > 10) {
                MsgBox.alert(this, "Mã loại phải ít hơn 10 ký tự");
                return false;
            }
        }

        if (tenLoai.isEmpty()) {
            message += "Tên loại, ";
            valid = false;
        }

        if (giaLoai.isEmpty()) {
            message += "Giá, ";
            valid = false;
        } else {
            try {
                if (Long.parseLong(giaLoai) <= 0) {
                    MsgBox.alert(this, "Giá phải > 0");
                    return false;
                }
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "Giá không đúng định dạng!");
                return false;
            }
        }

        if (!valid) {
            MsgBox.alert(this, message);
        }

        return valid;
    }

    private void insert() {
        if (validation()) {
            if (LoaiBoxDao.getInstance().selectById(txtMaLoai.getText()) != null) {
                MsgBox.alert(this, "Mã đã tồn tại, vui lòng kiểm tra lại!");
                return;
            }

            LoaiBoxDao.getInstance().insert(getForm());
            MsgBox.alert(this, "Thêm thành công!");
            Store.boxView.fillTableLoaiBox(LoaiBoxDao.getInstance().selectAll());
            clear();
        }
    }

    private void clear() {
        LoaiBox loaiBox = new LoaiBox();
        setForm(loaiBox);

        i = -1;
        updateStatus();
        txtMaLoai.setEnabled(true);
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
        if (validation()) {
            if (MsgBox.confirm(this, "Bạn có chắc muốn cập nhật dữ liệu này?")) {
            LoaiBox loaiBox = getForm();
            LoaiBoxDao.getInstance().update(loaiBox);
            MsgBox.alert(this, "Cập nhật thành công!");
            Store.boxView.fillTableLoaiBox(LoaiBoxDao.getInstance().selectAll());
            clear();
            this.dispose();
            }
        }
    }
//
//    public String getNextId(String maxId, String maLoaiBox) {
//        String first = maxId.substring(0, 1);
//        String middle = maxId.substring(1, 4);
//        Integer number = Integer.parseInt(middle);
//        Integer log = number / 10;
//
//        if (log == 0) {
//            maxId = first + "00" + ++number + maLoaiBox;
//        } else if (log > 10) {
//            maxId = first + ++number + maLoaiBox;
//        } else if (log > 0) {
//            maxId = first + "0" + ++number + maLoaiBox;
//        }
//
//        return maxId;
//    }
//
//    private void setNextId() {
//        String maxId;
//
//        try {
//            maxId = BoxDao.getInstance().getMaxId();
//            System.out.println(maxId);
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//
//        LoaiBoxForm loaiBox = (LoaiBoxForm)cboLoaiBox.getSelectedItem();
//        txtMaLoai.setText(getNextId(maxId, loaiBox.getMaLoaiBox()));
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        this.setNextId();
//    }

    public TextField getTxtMaLoai() {
        return txtMaLoai;
    }

    public void setTxtMaLoai(TextField txtMaLoai) {
        this.txtMaLoai = txtMaLoai;
    }
}
