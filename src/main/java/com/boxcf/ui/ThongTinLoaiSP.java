/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.UI;
import com.boxcf.dao.DanhMucDao;
import com.boxcf.dao.LoaiSPDao;
import com.boxcf.models.DanhMuc;
import com.boxcf.models.LoaiSP;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ThongTinLoaiSP extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinLoaiSP
     */
    LoaiSPDao lspDAO = new LoaiSPDao();
    DanhMucDao dmDAO = new DanhMucDao();

    Color cNormal = new Color(2, 172, 171);
    SanPhamView spview = Store.spView;

    List<LoaiSP> list;

    int index = 0;
    String ID = null;

    /**
     * Creates new form ThongTinLoaiSP
     */
    public ThongTinLoaiSP(String ID) {
        this.ID = ID;
        initComponents();
        init();
    }

    void init() {
        prepareUI();
        setLocationRelativeTo(null);
        fillComboBox();
        getViTri();
        editw();
    }

    private void prepareUI() {
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        UI.changeTransBG(new Color(0, 0, 0, 0), txtMaLoaiSP, txtTenLSP);

    }

    void fillComboBox() {
        for (DanhMuc dm : dmDAO.selectAll()) {
            txtMaDM.addItem(dm.getTenDM());
        }
    }

    void getViTri() {
        list = lspDAO.selectAll();
        if (ID == null) {
            return;
        }

        for (LoaiSP lsp : list) {
            if (lsp.getMaLoai().equals(ID)) {
                index = list.indexOf(lsp);
                break;
            }
        }
    }

    void setStatus() {
        boolean edit = this.index >= 0;
        boolean first = this.index > 0;
        boolean last = this.index < list.size() - 1;
        txtMaLoaiSP.setEditable(!edit);
        btnCapNhat.setEnabled(edit);
        btnCapNhat.setBackground(edit ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnThem.setEnabled(!edit);
        btnThem.setBackground(!edit ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnFirst.setEnabled(edit && first);
        btnFirst.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnPre.setEnabled(edit && first);
        btnPre.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnLast.setEnabled(edit && last);
        btnLast.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnNext.setEnabled(edit && last);
        btnNext.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
    }

    void editw() {
        try {
            if (ID == null) {
                clear();
                return;
            }
            LoaiSP lsp = list.get(index);
            setModel(lsp);
            setStatus();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void setModel(LoaiSP lsp) {

        DanhMuc dm = dmDAO.selectById(lsp.getMaDM());

        txtMaLoaiSP.setText("" + lsp.getMaLoai());
        txtTenLSP.setText("" + lsp.getTenLoai());

        txtMaDM.setSelectedItem(dm.getTenDM());

    }

    LoaiSP getModel() {
        LoaiSP lsp = new LoaiSP();
        DanhMuc dm = dmDAO.selectByName((String) txtMaDM.getSelectedItem());
        lsp.setMaLoai(txtMaLoaiSP.getText());
        lsp.setTenLoai(txtTenLSP.getText());
        lsp.setMaDM(dm.getMaDM());
        return lsp;
    }

    void insert() {

        if (!validateForm()) {
            return;
        }
        if (!checkTrungID()) {
            JOptionPane.showMessageDialog(this, "Mã loại sản phẩm đã tồn tại!");
            return;
        }

        try {
            lspDAO.insert(getModel());
            spview.fillToTableLoaiSP();
            spview.fillCBBLoaiSP();
            clear();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void update() {
        if (!validateForm()) {
            return;
        }
        if(!confirmUpdate()) return;
        try {
            lspDAO.update(getModel());
            spview.fillToTableLoaiSP();
            spview.fillCBBLoaiSP();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void first() {
        index = 0;
        editw();
    }

    void prev() {
        index--;
        editw();
    }

    void next() {
        index++;
        editw();
    }

    void last() {
        index = list.size() - 1;
        editw();
    }

    void clear() {
        txtMaLoaiSP.setText("");
        txtTenLSP.setText("");
        txtMaDM.setSelectedIndex(0);
        index = -1;
        setStatus();
    }

    boolean validateForm() {
        StringBuilder sb = new StringBuilder();
        sb.append(txtMaLoaiSP.getText().isEmpty() ? "Mã loại sản phẩm không thể trống!" : "");
        sb.append(txtTenLSP.getText().isEmpty() ? "\nTên loại sản phẩm không thể trống!" : "");
        sb.append(txtMaLoaiSP.getText().length() > 7 ? "\nMã loai sản phẩm không thể lớn hon 7 kí tự!" : "");


        if (txtMaLoaiSP.getText().length() > 10) {
            JOptionPane.showMessageDialog(this, "Mã loại không quá 10 kí tự !");
            return false;
        }

   
        return true;
    }
    
    boolean confirmUpdate(){
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn câp nhật dữ liệu này ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return false;
        }
        return true;
    }

    boolean checkTrungID() {
        String maLoaiSP = txtMaLoaiSP.getText();
        for (LoaiSP lsp : list) {
            if (maLoaiSP.equals(lsp.getMaLoai())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel3 = new com.boxcf.components.GradientPanel();
        gradientPanel4 = new com.boxcf.components.GradientPanel();
        btnClose = new com.boxcf.components.ButtonRound();
        jLabel1 = new javax.swing.JLabel();
        lblMaNV8 = new javax.swing.JLabel();
        txtMaDM = new com.boxcf.components.Combobox();
        lblMaNV = new javax.swing.JLabel();
        txtMaLoaiSP = new com.boxcf.components.TextField();
        lblMaNV2 = new javax.swing.JLabel();
        txtTenLSP = new com.boxcf.components.TextField();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new com.boxcf.components.ButtonRound();
        btnCapNhat = new com.boxcf.components.ButtonRound();
        btnReset = new com.boxcf.components.ButtonRound();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new com.boxcf.components.ButtonRound();
        btnPre = new com.boxcf.components.ButtonRound();
        btnNext = new com.boxcf.components.ButtonRound();
        btnLast = new com.boxcf.components.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradientPanel3.setColor1(new java.awt.Color(102, 102, 102));
        gradientPanel3.setColor2(new java.awt.Color(102, 102, 102));
        gradientPanel3.setPreferredSize(new java.awt.Dimension(800, 400));

        gradientPanel4.setColor1(new java.awt.Color(245, 250, 255));
        gradientPanel4.setColor2(new java.awt.Color(245, 250, 255));
        gradientPanel4.setPreferredSize(new java.awt.Dimension(800, 408));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 48, 84));
        jLabel1.setText("THÔNG TIN LOẠI SẢN PHẨM");

        lblMaNV8.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV8.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV8.setText("Danh mục");

        txtMaDM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV.setText("Mã loại sản phẩm");

        txtMaLoaiSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaLoaiSP.setLabelText("");

        lblMaNV2.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV2.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV2.setText("Tên loại sản phẩm");

        txtTenLSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenLSP.setLabelText("");

        btnThem.setBackground(new java.awt.Color(2, 172, 171));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.setFocusable(false);
        btnThem.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(2, 172, 171));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.setFocusable(false);
        btnCapNhat.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(2, 172, 171));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("LÀM MỚI");
        btnReset.setFocusable(false);
        btnReset.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gradientPanel4Layout = new javax.swing.GroupLayout(gradientPanel4);
        gradientPanel4.setLayout(gradientPanel4Layout);
        gradientPanel4Layout.setHorizontalGroup(
            gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel4Layout.createSequentialGroup()
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradientPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(gradientPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMaNV8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLoaiSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenLSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        gradientPanel4Layout.setVerticalGroup(
            gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addComponent(lblMaNV8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblMaNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblMaNV2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout gradientPanel3Layout = new javax.swing.GroupLayout(gradientPanel3);
        gradientPanel3.setLayout(gradientPanel3Layout);
        gradientPanel3Layout.setHorizontalGroup(
            gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(gradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        gradientPanel3Layout.setVerticalGroup(
            gradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(gradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        getContentPane().add(gradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -1, 830, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

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
            java.util.logging.Logger.getLogger(ThongTinLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinLoaiSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinLoaiSP(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnCapNhat;
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.ButtonRound btnFirst;
    private com.boxcf.components.ButtonRound btnLast;
    private com.boxcf.components.ButtonRound btnNext;
    private com.boxcf.components.ButtonRound btnPre;
    private com.boxcf.components.ButtonRound btnReset;
    private com.boxcf.components.ButtonRound btnThem;
    private com.boxcf.components.GradientPanel gradientPanel3;
    private com.boxcf.components.GradientPanel gradientPanel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaNV2;
    private javax.swing.JLabel lblMaNV8;
    private com.boxcf.components.Combobox txtMaDM;
    private com.boxcf.components.TextField txtMaLoaiSP;
    private com.boxcf.components.TextField txtTenLSP;
    // End of variables declaration//GEN-END:variables
}
