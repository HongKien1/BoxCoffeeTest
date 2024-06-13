/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.XDate;
import com.boxcf.dao.KhuyenMaiDao;
import com.boxcf.models.KhuyenMai;
import com.boxcf.store.Store;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public abstract class ThungRac extends javax.swing.JFrame {

    public ThungRac() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new com.boxcf.components.GradientPanel();
        gradientPanel2 = new com.boxcf.components.GradientPanel();
        title = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnClose = new com.boxcf.components.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientPanel1.setColor1(new java.awt.Color(102, 102, 102));
        gradientPanel1.setColor2(new java.awt.Color(102, 102, 102));
        gradientPanel1.setPreferredSize(new java.awt.Dimension(800, 400));

        gradientPanel2.setColor1(new java.awt.Color(245, 250, 255));
        gradientPanel2.setColor2(new java.awt.Color(245, 250, 255));
        gradientPanel2.setPreferredSize(new java.awt.Dimension(800, 408));

        title.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        title.setForeground(new java.awt.Color(40, 48, 84));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Nhân Viên Không Còn Làm Việc");

        tbl.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl.setGridColor(new java.awt.Color(204, 204, 204));
        tbl.setRowHeight(30);
        scroll.setViewportView(tbl);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientPanel2Layout = new javax.swing.GroupLayout(gradientPanel2);
        gradientPanel2.setLayout(gradientPanel2Layout);
        gradientPanel2Layout.setHorizontalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel2Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(gradientPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        gradientPanel2Layout.setVerticalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title))
                .addContainerGap(359, Short.MAX_VALUE))
            .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel2Layout.createSequentialGroup()
                    .addContainerGap(95, Short.MAX_VALUE)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.exit();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private com.boxcf.components.GradientPanel gradientPanel2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private void init() {
        prepareUI();
        renderDataTable();
        initHeader();
        renderDataTable();
        initTitle();
    }

    private void prepareUI() {
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void exit() {
        this.dispose();
    }

//    private void renderDataTable() {
//        DefaultTableModel model = (DefaultTableModel) tblDiscount.getModel();
//        model.setRowCount(0);
//        int i = 1;
//        for (KhuyenMai km : dKm.selectTrash()) {
//            Object row[] = {i, km.getMaKM(),
//                km.getTenKM(),
//                XDate.toString(km.getNgayBD(), Store.partten),
//                XDate.toString(km.getNgayKT(), Store.partten),
//                km.getSoLuot(),
//                km.getPhanTram() + "%",
//                km.getDieuKienGiam()};
//
//            model.addRow(row);
//            i++;
//        }
//    }
    public JTable getTbl() {
        return tbl;
    }

    public void setTbl(JTable tbl) {
        this.tbl = tbl;
    }

    public JLabel getTitles() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    abstract public void renderDataTable();

    abstract public void initHeader();

    abstract public void initTitle();

}
