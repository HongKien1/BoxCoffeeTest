/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.box.utils.Validator;
import com.box.utils.XDate;
import com.boxcf.components.ScrollBar;
import com.boxcf.dao.KhuyenMaiDao;
import com.boxcf.models.KhuyenMai;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class KhuyenMaiView extends javax.swing.JPanel {
    
    private KhuyenMaiDao dKm = KhuyenMaiDao.getInstant();
    
    public KhuyenMaiView() {
        initComponents();
        init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtFind = new javax.swing.JTextField();
        lblMaNV = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblDiscount = new javax.swing.JTable();
        buttonRound1 = new com.boxcf.components.ButtonRound();
        btnAdd = new com.boxcf.components.ButtonRound();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("QUẢN LÝ KHUYẾN MÃI");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 30, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 90, 976, 10));

        txtFind.setBackground(new java.awt.Color(0, 153, 153));
        txtFind.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFind.setForeground(new java.awt.Color(51, 51, 51));
        txtFind.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtFind.setOpaque(false);
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });
        add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 520, 32));

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV.setText("Khuyến mãi");
        add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 86, -1));

        tblDiscount.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        tblDiscount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KM", "Tên KM", "Ngay BD", "NgayKT", "Số Lượt", "Phần Trăm Giảm", "Điều kiện giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiscount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDiscount.setGridColor(new java.awt.Color(204, 204, 204));
        tblDiscount.setRowHeight(30);
        tblDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDiscountMousePressed(evt);
            }
        });
        scroll.setViewportView(tblDiscount);

        add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 304, 985, 382));

        buttonRound1.setBackground(new java.awt.Color(2, 172, 171));
        buttonRound1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound1.setText("XÓA");
        buttonRound1.setFocusable(false);
        buttonRound1.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });
        add(buttonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 216, 96, 40));

        btnAdd.setBackground(new java.awt.Color(2, 172, 171));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("THÊM");
        btnAdd.setFocusable(false);
        btnAdd.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 216, 96, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/Trash.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, -1, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        handleDelete();
    }//GEN-LAST:event_buttonRound1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.openInsertDiscount();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        fillTable();
    }//GEN-LAST:event_txtFindKeyReleased

    private void tblDiscountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiscountMousePressed
        if (!Auth.accept(this)) {
            return;
        }
        handleOpenUpdate(evt);
    }//GEN-LAST:event_tblDiscountMousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        handleOpenTrash();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnAdd;
    private com.boxcf.components.ButtonRound buttonRound1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblDiscount;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.prepareUI();
        scroll.setVerticalScrollBar(new ScrollBar());
        fillTable();
        
        UI.accept(btnAdd, buttonRound1);
    }
    
    private void prepareUI() {
        UI.changeTransBG(new Color(0, 0, 0, 0), txtFind);
    }
    
    private void openInsertDiscount() {
        ThongTinKM themKM = new ThongTinKM();
        themKM.setVisible(true);
    }
    
    private void openUpdateDiscount(KhuyenMai km) {
        ThongTinKM themKM = new ThongTinKM();
        themKM.setVisible(true);
        themKM.setModel(km);
        tblDiscount.clearSelection();
    }
    
    public void fillTable() {
        if (Validator.isEmpty(txtFind)) {
            renderDataTable(dKm.selectAll());
            return;
        }
        
        renderDataTable(dKm.selectByKeyword(txtFind.getText()));
    }
    
    private void renderDataTable(List<KhuyenMai> list) {
        DefaultTableModel model = (DefaultTableModel) tblDiscount.getModel();
        model.setRowCount(0);
        int i = 1;
        for (KhuyenMai km : list) {
            Object row[] = {i, km.getMaKM(),
                km.getTenKM(),
                XDate.toString(km.getNgayBD(), Store.partten),
                XDate.toString(km.getNgayKT(), Store.partten),
                km.getSoLuot(),
                km.getPhanTram() + "%",
                km.getDieuKienGiam()};
            
            model.addRow(row);
            i++;
        }
    }
    
    private void handleDelete() {
        int[] list = tblDiscount.getSelectedRows();
        
        if (list.length <= 0) {
            return;
        }
        
        boolean check = MsgBox.confirm(Store.globelMain, "Điều này sẽ làm mất đi " + list.length + " khuyến mãi của cửa hàng  ");
        
        if (!check) {
            tblDiscount.clearSelection();
            return;
        }
        
        for (int selectedRow : list) {
            String id = (String) tblDiscount.getValueAt(selectedRow, 1);
            dKm.delete(id);
        }
        fillTable();
        tblDiscount.clearSelection();
    }
    
    private void handleOpenUpdate(MouseEvent evt) {
        int index = tblDiscount.rowAtPoint(evt.getPoint());
        String id = (String) tblDiscount.getValueAt(index, 1);
        KhuyenMai km = dKm.selectById(id);
        
        if (km == null) {
            MsgBox.alert(Store.globelMain, "Có lỗi khi thao tác  ");
            return;
        }
        
        if (evt.getClickCount() == 2) {
            openUpdateDiscount(km);
        }
    }
    
    private void handleOpenTrash() {
        ThungRac trashView = new ThungRac() {
            @Override
            public void renderDataTable() {
                DefaultTableModel model = (DefaultTableModel) this.getTbl().getModel();
                model.setRowCount(0);
                int i = 1;
                for (KhuyenMai km : dKm.selectTrash()) {
                    Object row[] = {i, km.getMaKM(),
                        km.getTenKM(),
                        XDate.toString(km.getNgayBD(), "dd/mm/yyyy"),
                        XDate.toString(km.getNgayKT(), "dd/mm/yyyy"),
                        km.getSoLuot(),
                        km.getPhanTram() + "%",
                        km.getDieuKienGiam()};
                    
                    model.addRow(row);
                    i++;
                }
            }
            
            @Override
            public void initHeader() {
                DefaultTableModel model = (DefaultTableModel) this.getTbl().getModel();
                String[] cols = cols = new String[]{"STT",
                    "Mã Khuyến Mãi",
                    "Tên Khuyến Mãi",
                    "Ngày Bắt Đầu",
                    "Ngày Kết Thúc",
                    "Số Lượng",
                    "Phần Trâm Giảm",
                    "Điều Kiện Giảm"};
                
                model.setColumnIdentifiers(cols);
            }
            
            @Override
            public void initTitle() {
                this.getTitles().setText("Khuyến Mãi Đã Xóa");
            }
        };
        trashView.setVisible(true);
    }
}
