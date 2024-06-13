/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.box.utils.XImage;
import com.boxcf.components.ButtonRound;
import com.boxcf.components.Combobox;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.models.Box;
import com.boxcf.models.LoaiBox;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class BoxForm extends javax.swing.JFrame implements ActionListener {

    String maBox;
    public static int i = -1;
    List<Box> list = BoxDao.getInstance().selectAll();

    public BoxForm() {
        initComponents();
        init();
    }

    public BoxForm(Box box) {
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
        txtMaBox = new com.boxcf.components.TextField();
        txtTenBox = new com.boxcf.components.TextField();
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
        btnRefresh = new com.boxcf.components.ButtonRound();
        btnUpdate = new com.boxcf.components.ButtonRound();
        lblHinhAnh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
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
        lblMaNV.setText("Mã Box");
        pnlBox.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 70, -1));

        lblMaNV1.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV1.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV1.setText("Tên Box");
        pnlBox.add(lblMaNV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 70, -1));

        lblMaNV3.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV3.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV3.setText("Mô tả");
        pnlBox.add(lblMaNV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 50, -1));

        lblMaNV8.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV8.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV8.setText("Loại Box");
        pnlBox.add(lblMaNV8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 90, -1));

        txtMaBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMaBox.setLabelText("");
        txtMaBox.setOpaque(false);
        pnlBox.add(txtMaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 550, 38));

        txtTenBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTenBox.setLabelText("");
        txtTenBox.setOpaque(false);
        pnlBox.add(txtTenBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 550, 38));

        cboLoaiBox.setEnabled(false);
        cboLoaiBox.setFocusable(false);
        cboLoaiBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlBox.add(cboLoaiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 290, -1));

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

        pnlBox.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 550, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 48, 84));
        jLabel1.setText("THÔNG TIN BOX");
        pnlBox.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

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

        btnRefresh.setBackground(new java.awt.Color(2, 172, 171));
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("MỚI");
        btnRefresh.setFocusable(false);
        btnRefresh.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        pnlBox.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 96, 40));

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

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });
        pnlBox.add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 190, 180));

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

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        this.clear();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.insert();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.exit();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.update();
        Store.boxView.fillTableBox(BoxDao.getInstance().selectAll());
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        chooseImage();
    }//GEN-LAST:event_lblHinhAnhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnAdd;
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.ButtonRound btnFirst;
    private com.boxcf.components.ButtonRound btnLast;
    private com.boxcf.components.ButtonRound btnNext;
    private com.boxcf.components.ButtonRound btnPre;
    private com.boxcf.components.ButtonRound btnRefresh;
    private com.boxcf.components.ButtonRound btnUpdate;
    private com.boxcf.components.Combobox cboLoaiBox;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaNV1;
    private javax.swing.JLabel lblMaNV3;
    private javax.swing.JLabel lblMaNV8;
    private com.boxcf.components.GradientPanel pnlBox;
    private com.boxcf.components.TextField txtMaBox;
    private javax.swing.JTextArea txtMoTa;
    private com.boxcf.components.TextField txtTenBox;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.prepareUI();
        this.fillComboBox();
        this.updateStatus();
        UI.accept(btnAdd, btnRefresh, btnUpdate);
    }

    private void prepareUI() {
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.changeTransBG(new Color(0, 0, 0, 0), txtMaBox, txtTenBox);
        cboLoaiBox.addActionListener(this);
        txtMaBox.setEditable(false);
//        btnRefresh.setVisible(false);
    }

    private void exit() {
        this.dispose();
    }

    public void fillComboBox() {
        DefaultComboBoxModel cbo = (DefaultComboBoxModel) cboLoaiBox.getModel();
        cbo.removeAllElements();

        List<LoaiBox> list = LoaiBoxDao.getInstance().selectAll();
        for (LoaiBox loaiBox : list) {
            cbo.addElement(loaiBox);
        }
    }

    public void setForm(Box box) {
        cboLoaiBox.setSelectedItem(LoaiBoxDao.getInstance().selectById(box.getMaLoaiBox()));
        txtMaBox.setText(box.getMaBox());
        txtTenBox.setText(box.getTenBox());
        txtMoTa.setText(box.getMoTa());

        String url = box.getHinhAnh();
        if (url != null) {
            lblHinhAnh.setToolTipText(url);
            ImageIcon icon = XImage.read(url);
            Image img = XImage.resize(icon.getImage(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
            icon = new ImageIcon(img);
            lblHinhAnh.setIcon(icon);
        } else {
            lblHinhAnh.setIcon(null);
        }
    }

    private Box getForm() {
        Box box = new Box();
        LoaiBox loaiBox = (LoaiBox) cboLoaiBox.getSelectedItem();
        box.setMaBox(txtMaBox.getText());
        box.setMaLoaiBox(loaiBox.getMaLoaiBox());
        box.setTenBox(txtTenBox.getText());
        box.setHinhAnh(lblHinhAnh.getToolTipText());
        box.setMoTa(txtMoTa.getText());

        return box;
    }

    public boolean validation() {
        String tenBox = txtTenBox.getText();
        if (tenBox.isEmpty()) {
            MsgBox.alert(this, "Bạn chưa nhập tên box!");
            return false;
        }

        if (lblHinhAnh.getToolTipText() == null || lblHinhAnh.getToolTipText().equals("")) {
            MsgBox.alert(this, "Bạn chưa chọn ảnh cho Box!");
            return false;
        }

        return true;
    }

    private void insert() {
        if (validation()) {
            BoxDao.getInstance().insert(getForm());
            MsgBox.alert(this, "Thêm thành công!");
            clear();
            Store.boxView.fillTableBox(BoxDao.getInstance().selectAll());
            this.dispose();
        }
    }

    private void clear() {
        this.setNextId();

        txtTenBox.setText("");
        txtMoTa.setText("");
        lblHinhAnh.setToolTipText("");
        lblHinhAnh.setIcon(null);

        i = -1;
        cboLoaiBox.setEnabled(true);
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
        UI.accept(btnAdd, btnRefresh, btnUpdate);

    }

    private void chooseImage() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            Image img = XImage.resize(icon.getImage(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
            icon = new ImageIcon(img);
            lblHinhAnh.setIcon(icon);
            lblHinhAnh.setToolTipText(file.getName());
        }
    }

    private void update() {
        if (validation()) {
            if (MsgBox.confirm(this, "Bạn có chắc muốn cập nhật dữ liệu này?")) {
                Box box = getForm();
                BoxDao.getInstance().update(box);
                MsgBox.alert(this, "Cập nhật thành công!");
                clear();
                this.dispose();
            }
        }
    }

    public String getNextId(String maxId, String maLoaiBox) {
        if (maxId.length() < 4) {
            return " ";
        }
        String first = maxId.substring(0, 1);
        String middle = maxId.substring(1, 4);
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

    private void setNextId() {
        String maxId;

        try {
            maxId = BoxDao.getInstance().getMaxId();
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        LoaiBox loaiBox = (LoaiBox) cboLoaiBox.getSelectedItem();
        txtMaBox.setText(getNextId(maxId, loaiBox.getMaLoaiBox()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setNextId();
    }

    public ButtonRound getBtnCapNhatSP() {
        return btnRefresh;
    }

    public void setBtnCapNhatSP(ButtonRound btnCapNhatSP) {
        this.btnRefresh = btnCapNhatSP;
    }

    public Combobox getCboLoaiBox() {
        return cboLoaiBox;
    }

    public void setCboLoaiBox(Combobox cboLoaiBox) {
        this.cboLoaiBox = cboLoaiBox;
    }

}
