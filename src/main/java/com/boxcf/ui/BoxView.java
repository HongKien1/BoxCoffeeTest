package com.boxcf.ui;
import javax.swing.table.TableRowSorter;
import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.boxcf.components.ScrollBar;
import com.boxcf.dao.BoxDao;
import com.boxcf.dao.LoaiBoxDao;
import com.boxcf.models.Box;
import com.boxcf.models.LoaiBox;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class BoxView extends javax.swing.JPanel implements ActionListener {

    private DefaultTableModel tblModel;
    private List<Box> listBox = BoxDao.getInstance().selectAll();
    private List<LoaiBox> listLoai = LoaiBoxDao.getInstance().selectAll();
    public static Box box;

    public BoxView() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnDel = new com.boxcf.components.ButtonRound();
        btnAdd = new com.boxcf.components.ButtonRound();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        scrollbar = new javax.swing.JScrollPane();
        tblBox = new javax.swing.JTable();
        cboLoaiBox = new com.boxcf.components.Combobox();
        jPanel2 = new javax.swing.JPanel();
        lblMaNV1 = new javax.swing.JLabel();
        txtSearchLoai = new javax.swing.JTextField();
        btnXoaLoaiBox = new com.boxcf.components.ButtonRound();
        btnAdd1 = new com.boxcf.components.ButtonRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiBox = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("QUẢN LÝ BOX");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
        btnAdd.setText("THÊM BOX");
        btnAdd.setFocusable(false);
        btnAdd.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 96, 40));

        txtSearch.setBackground(new java.awt.Color(0, 153, 153));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(51, 51, 51));
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtSearch.setOpaque(false);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 600, 32));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setText("Loại box");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 80, 30));

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV.setText("Box");
        jPanel1.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 86, -1));

        tblBox.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        tblBox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Box", "Tên Box ", "Giá", "Loại box", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblBox.setGridColor(new java.awt.Color(204, 204, 204));
        tblBox.setRowHeight(30);
        tblBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBoxMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBoxMousePressed(evt);
            }
        });
        scrollbar.setViewportView(tblBox);
        if (tblBox.getColumnModel().getColumnCount() > 0) {
            tblBox.getColumnModel().getColumn(0).setResizable(false);
            tblBox.getColumnModel().getColumn(0).setPreferredWidth(20);
        }
        tblBox.setRowSorter(new TableRowSorter(tblBox.getModel()));

        jPanel1.add(scrollbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 930, 260));

        cboLoaiBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả" }));
        cboLoaiBox.setFocusable(false);
        cboLoaiBox.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        cboLoaiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiBoxActionPerformed(evt);
            }
        });
        jPanel1.add(cboLoaiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 220, -1));

        jTabbedPane1.addTab("BOX", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblMaNV1.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV1.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV1.setText("Loại box");

        txtSearchLoai.setBackground(new java.awt.Color(0, 153, 153));
        txtSearchLoai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearchLoai.setForeground(new java.awt.Color(51, 51, 51));
        txtSearchLoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtSearchLoai.setOpaque(false);
        txtSearchLoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchLoaiKeyReleased(evt);
            }
        });

        btnXoaLoaiBox.setBackground(new java.awt.Color(2, 172, 171));
        btnXoaLoaiBox.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaLoaiBox.setText("XÓA");
        btnXoaLoaiBox.setFocusable(false);
        btnXoaLoaiBox.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnXoaLoaiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoaiBoxActionPerformed(evt);
            }
        });

        btnAdd1.setBackground(new java.awt.Color(2, 172, 171));
        btnAdd1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd1.setText("THÊM");
        btnAdd1.setFocusable(false);
        btnAdd1.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        tblLoaiBox.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        tblLoaiBox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã loại box", "Tên loại box", "Giá", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblLoaiBox.setGridColor(new java.awt.Color(204, 204, 204));
        tblLoaiBox.setRowHeight(30);
        tblLoaiBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblLoaiBoxMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiBox);
        if (tblLoaiBox.getColumnModel().getColumnCount() > 0) {
            tblLoaiBox.getColumnModel().getColumn(0).setResizable(false);
            tblLoaiBox.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnXoaLoaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNV1))
                    .addComponent(txtSearchLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaLoaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LOẠI BOX", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jTabbedPane1))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.delete();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        BoxForm.i = -1;
        this.openBoxInfo();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnXoaLoaiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiBoxActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.deleteLoai();
    }//GEN-LAST:event_btnXoaLoaiBoxActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        LoaiBoxForm.i = -1;
        this.openLoaiBoxForm();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void tblBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBoxMouseClicked

    }//GEN-LAST:event_tblBoxMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        this.seach();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cboLoaiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiBoxActionPerformed
//        this.filter();
    }//GEN-LAST:event_cboLoaiBoxActionPerformed

    private void tblBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBoxMousePressed
        if (evt.getClickCount() == 2) {
            this.showInfo(getBox());
        }
    }//GEN-LAST:event_tblBoxMousePressed

    private void tblLoaiBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiBoxMousePressed
        if (evt.getClickCount() == 2) {
            this.showInfo(getLoaiBox());
        }
    }//GEN-LAST:event_tblLoaiBoxMousePressed

    private void txtSearchLoaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchLoaiKeyReleased
        this.searchLoai();
    }//GEN-LAST:event_txtSearchLoaiKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnAdd;
    private com.boxcf.components.ButtonRound btnAdd1;
    private com.boxcf.components.ButtonRound btnDel;
    private com.boxcf.components.ButtonRound btnXoaLoaiBox;
    private com.boxcf.components.Combobox cboLoaiBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaNV1;
    private javax.swing.JScrollPane scrollbar;
    private javax.swing.JTable tblBox;
    private javax.swing.JTable tblLoaiBox;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchLoai;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.prepareUI();
        this.fillTableBox(listBox);
        this.fillTableLoaiBox(listLoai);
        this.fillComboBox(LoaiBoxDao.getInstance().selectAll());
        cboLoaiBox.addActionListener(this);

        UI.accept(btnAdd, btnDel, btnAdd1, btnXoaLoaiBox);
    }

    private void prepareUI() {
        UI.changeTransBG(new Color(0, 0, 0, 0), txtSearch);
        scrollbar.setVerticalScrollBar(new ScrollBar());
        Store.boxView = this;
    }

    private void openBoxInfo() {
        BoxForm form = new BoxForm();
        form.getCboLoaiBox().setEnabled(true);
        form.getBtnCapNhatSP().setVisible(true);
        form.setVisible(true);
    }

    public void fillTableBox(List<Box> list) {
        tblModel = (DefaultTableModel) tblBox.getModel();
        tblModel.setRowCount(0);

        int i = 1;
        for (Box box : list) {
            Object[] row = {i, box.getMaBox(), box.getTenBox(), LoaiBoxDao.getInstance().selectById(box.getMaLoaiBox()).getGiaLoai(), LoaiBoxDao.getInstance().selectById(box.getMaLoaiBox()).getTenLoaiBox(), box.getMoTa()};
            tblModel.addRow(row);
            ++i;
        }
    }

    public void fillComboBox(List<LoaiBox> list) {
        DefaultComboBoxModel cbo = (DefaultComboBoxModel) cboLoaiBox.getModel();

        if (list.isEmpty()) {
            MsgBox.alert(this, "Đang không có loại box nào");
            return;
        }

        for (LoaiBox loaiBox : list) {
            cboLoaiBox.addItem(loaiBox);
        }
    }

    private void showInfo(Object obj) {
        if (obj instanceof Box) {
            Box box = (Box) obj;
            BoxForm form = new BoxForm(box);
            form.setVisible(true);
            form.setForm(box);
        } else {
            LoaiBox loaiBox = (LoaiBox) obj;
            LoaiBoxForm form = new LoaiBoxForm(loaiBox);
            form.setVisible(true);
            form.setForm(loaiBox);
        }
    }

    private Box getBox() {
        BoxForm.i = tblBox.getSelectedRow();
        String id = tblBox.getValueAt(BoxForm.i, 1).toString();
        return BoxDao.getInstance().selectById(id);
    }

    private void seach() {
        String keyword = txtSearch.getText();

        if (keyword.isEmpty()) {
            fillTableBox(BoxDao.getInstance().selectAll());
        } else {
            fillTableBox(BoxDao.getInstance().selectByKeyWord(keyword));
        }
    }

    private void filter() {
        if (cboLoaiBox.getSelectedIndex() == 0) {
            fillTableBox(BoxDao.getInstance().selectAll());
        } else {
            LoaiBox loaiBox = (LoaiBox) cboLoaiBox.getSelectedItem();
            fillTableBox(BoxDao.getInstance().selectByLoaiBox(loaiBox.getMaLoaiBox()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.filter();
    }

    private void delete() {
        int[] indexs = tblBox.getSelectedRows();

        if (MsgBox.confirm(this, "Bạn có chắc muốn xóa dữ liệu này?")) {
            for (int index : indexs) {
                try {
                    BoxDao.getInstance().delete(tblBox.getValueAt(index, 1).toString());
                } catch (Exception e) {
                    MsgBox.alert(this, "Có Box đang hoạt động không thể xóa !");
                    return;
                }
            }
            MsgBox.alert(this, "Xóa thành công!");
            fillTableBox(BoxDao.getInstance().selectAll());
        }
    }

    //----------------Loai box--------------------
    public void fillTableLoaiBox(List<LoaiBox> list) {
        DefaultTableModel tbl = (DefaultTableModel) tblLoaiBox.getModel();
        tbl.setRowCount(0);

        int i = 1;
        for (LoaiBox loaiBox : list) {
            Object[] row = {i, loaiBox.getMaLoaiBox(), loaiBox.getTenLoaiBox(), loaiBox.getGiaLoai(), loaiBox.getMoTa()};
            tbl.addRow(row);
            ++i;
        }
    }

    private LoaiBox getLoaiBox() {
        LoaiBoxForm.i = tblLoaiBox.getSelectedRow();
        String maLoai = tblLoaiBox.getValueAt(LoaiBoxForm.i, 1).toString();

        return LoaiBoxDao.getInstance().selectById(maLoai);
    }

    private void openLoaiBoxForm() {
        LoaiBoxForm form = new LoaiBoxForm();
        form.getTxtMaLoai().setEnabled(true);
        form.setVisible(true);
    }

    private void deleteLoai() {
        int[] indexs = tblLoaiBox.getSelectedRows();

        if (MsgBox.confirm(this, "Bạn có chắc muốn xóa dữ liệu này?")) {
            for (int index : indexs) {
                try {
                    LoaiBoxDao.getInstance().delete(tblLoaiBox.getValueAt(index, 1).toString());

                } catch (Exception e) {
                    MsgBox.alert(this, "Không thể thể thực hiện, Loại Box đang hoạt động !");
                    return;
                }
            }
            MsgBox.alert(this, "Xóa thành công!");
            fillTableLoaiBox(LoaiBoxDao.getInstance().selectAll());
        }
    }

    private void searchLoai() {
        String keyword = txtSearchLoai.getText();

        if (keyword.isEmpty()) {
            fillTableLoaiBox(LoaiBoxDao.getInstance().selectAll());
        } else {
            fillTableLoaiBox(LoaiBoxDao.getInstance().selectByKeyWord(keyword));
        }
    }
}
