package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.box.utils.XDate;
import com.boxcf.dao.NhanVienDao;
import com.boxcf.models.KhuyenMai;
import com.boxcf.models.NhanVien;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class NhanVienView extends javax.swing.JPanel {

    private List<NhanVien> nhanvien;
    private DefaultTableModel model;
    NhanVienDao nvDAO = new NhanVienDao();

    public NhanVienView() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTimNV = new javax.swing.JTextField();
        lblMaNV = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnDel = new com.boxcf.components.ButtonRound();
        btnAdd = new com.boxcf.components.ButtonRound();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTimNV.setBackground(new java.awt.Color(0, 153, 153));
        txtTimNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTimNV.setForeground(new java.awt.Color(51, 51, 51));
        txtTimNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtTimNV.setOpaque(false);
        txtTimNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimNVKeyReleased(evt);
            }
        });
        add(txtTimNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 520, 32));

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV.setText("Nhân viên");
        add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 86, -1));

        tblNhanVien.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Tên nhân viên", "SDT", "Ngày Sinh", "Ngày vào làm", "Chức Vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblNhanVien.setGridColor(new java.awt.Color(204, 204, 204));
        tblNhanVien.setRowHeight(30);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 304, 985, 382));

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
        add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 216, 96, 40));

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

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 22, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 985, 10));

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

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        handleDelete();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.openThemNV();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtTimNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimNVKeyReleased
        fillDataTable();
    }//GEN-LAST:event_txtTimNVKeyReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        handleOpenTrash();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tblNhanVienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseReleased
        if (!Auth.accept(this)) {
            return;
        }
        handleOpenEdit(evt);
    }//GEN-LAST:event_tblNhanVienMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnAdd;
    private com.boxcf.components.ButtonRound btnDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtTimNV;
    // End of variables declaration//GEN-END:variables

    private void init() {
        Store.nvView = this;
        this.prepareUI();
        fillDataTable();
        UI.accept(btnAdd, btnDel);
    }

    private void prepareUI() {
        UI.changeTransBG(new Color(0, 0, 0, 0), txtTimNV);
    }

    private void openThemNV() {
        ThongTinNV themNV = new ThongTinNV();
        themNV.setVisible(true);
    }

    boolean getClick(JTable table) {
        if (table.getSelectedRow() == -1) {
            return false;
        }
        return true;
    }

    public void render(List<NhanVien> list) {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (NhanVien nv : list) {
                Object[] row = {i,
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.getSDT(),
                    XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"),
                    XDate.toString(nv.getNgayVaoLam(), "dd/MM/yyyy"),
                    nv.getVaiTro()};
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    public void fillDataTable() {
        String keyword = txtTimNV.getText();
        render(nvDAO.selectByKeyword(keyword));
    }

    private void handleOpenTrash() {
        ThungRac trnv = new ThungRac() {
            @Override
            public void renderDataTable() {
                DefaultTableModel model = (DefaultTableModel) this.getTbl().getModel();
                model.setRowCount(0);
                int i = 1;
                for (NhanVien nv : NhanVienDao.getInstant().selectTrash()) {
                    Object row[] = {i, nv.getMaNV(),
                        nv.getTenNV(),
                        nv.getSDT(),
                        XDate.toString(nv.getNgaySinh(), "dd/mm/yyyy"),
                        XDate.toString(nv.getNgayVaoLam(), "dd/mm/yyyy"),
                        nv.getVaiTro()};

                    model.addRow(row);
                    i++;
                }
            }

            @Override
            public void initHeader() {
                DefaultTableModel model = (DefaultTableModel) this.getTbl().getModel();
                String[] cols = cols = new String[]{"STT",
                    "Mã Nhân Viên",
                    "Tên",
                    "SĐT",
                    "Ngày Sinh",
                    "Ngày Vào Làm",
                    "Chức Vụ"};

                model.setColumnIdentifiers(cols);
            }

            @Override
            public void initTitle() {
                this.getTitles().setText("Nhân Viên Không Còn Làm Việc");
            }
        };

        trnv.setVisible(true);

    }

    private void handleOpenEdit(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            ThongTinNV tnNv = new ThongTinNV();
            String id = tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 1).toString().toLowerCase();
            NhanVien nv = NhanVienDao.getInstant().selectById(id);

            if (nv != null) {
                tnNv.setModel(nv);
                tnNv.setVisible(true);
                tnNv.enableRole();
            }
        }
    }

    private void handleDelete() {
        int[] list = tblNhanVien.getSelectedRows();

        if (list.length <= 0) {
            return;
        }

        boolean check = MsgBox.confirm(Store.globelMain, "Điều này sẽ làm mất đi " + list.length + " nhân viên của cửa hàng đó  ");

        if (!check) {
            tblNhanVien.clearSelection();
            return;
        }

        for (int selectedRow : list) {
            String id = (String) tblNhanVien.getValueAt(selectedRow, 1);
            if (id.endsWith(Auth.user.getMaNV())) {
                MsgBox.alert(this, "Không thể xóa tài khoản đang đăng nhập !");
                return;
            }
            NhanVienDao.getInstant().delete(id);

        }
        fillDataTable();
        tblNhanVien.clearSelection();
    }

}
