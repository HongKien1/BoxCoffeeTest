package com.boxcf.ui;

import com.box.utils.Formats;
import com.box.utils.JdbcHelper;
import com.box.utils.UI;
import com.boxcf.components.ScrollBar;
import com.boxcf.dao.ComboCTDao;
import com.boxcf.dao.DanhMucDao;
import com.boxcf.dao.HoaDonChiTietDao;
import com.boxcf.dao.LoaiSPDao;
import com.boxcf.dao.SanPhamDao;
import com.boxcf.models.ComboCT;
import com.boxcf.models.DanhMuc;
import com.boxcf.models.HoaDon;
import com.boxcf.models.HoaDonCT;
import com.boxcf.models.LoaiSP;
import com.boxcf.models.SanPham;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class SanPhamView extends javax.swing.JPanel {

    Formats fm = new Formats();
    SanPhamDao spDAO = new SanPhamDao();
    LoaiSPDao lspDAO = new LoaiSPDao();
    DanhMucDao dmDAO = new DanhMucDao();

    suport sp = new suport();

    public int pageNumber = 1;
    public int pageNumberLSP = 1;

    public String maSP;
    public String maLoai;
    public String maDanhMuc = null;

    public SanPhamView() {
        initComponents();
        init();
    }

    boolean getClick(JTable table) {
        if (table.getSelectedRow() == -1) {
            return false;
        }
        return true;
    }

    void setBtnDanhMuc() {
        btnNext1.setBackground(Color.decode("#e6ddce"));
        btnFirstLSP1.setBackground(Color.decode("#e6ddce"));
        btnLastLSP1.setBackground(Color.decode("#e6ddce"));
        btnPre1.setBackground(Color.decode("#e6ddce"));
    }

    private void init() {
        this.prepareUI();
        fillCBBDM();
        fillCBBLoaiSP();
        fillToTableSanPham();
        fillToTableDanhMuc();
        fillToTableLoaiSP();
        setBtnDanhMuc();
        Store.spView = this;
    }

    private void prepareUI() {
        scroll.setVerticalScrollBar(new ScrollBar());
        UI.changeTransBG(new Color(0, 0, 0, 0), txtTimSP, txtTimLoaiSP, txtTimDM);
    }
    int i = 1;

    private void renderDataTable(List<SanPham> list) {
        DefaultTableModel tbl = (DefaultTableModel) tblSanPham.getModel();
        tbl.setRowCount(0);
        int i = ((pageNumber * 8) - 8) + 1;
        for (SanPham sp : list) {
            Object row[] = {i, sp.getMaSP(), sp.getTenSP(), fm.toCurency(sp.getGia()), lspDAO.selectById(sp.getMaLoai()).getTenLoai(), sp.getMoTa()};
            tbl.addRow(row);
            i++;
        }
    }

    void fillCBBLoaiSP() {
        cboLoaiSP.removeAllItems();
        cboLoaiSP.addItem("Tất cả");
        for (LoaiSP lsp : sp.getLSPFromDM(cboDanhMuc1.getSelectedItem().toString() == "Tất cả" ? "" : cboDanhMuc1.getSelectedItem().toString())) {
            cboLoaiSP.addItem(lsp.getTenLoai());
        }
    }

    void fillCBBDM() {
        cboDanhMuc1.removeAllItems();
        cboDanhMuc2.removeAllItems();
        cboDanhMuc1.addItem("Tất cả");
        cboDanhMuc2.addItem("Tất cả");
        for (DanhMuc dm : dmDAO.selectAll()) {
            cboDanhMuc1.addItem(dm.getTenDM().toString());
            cboDanhMuc2.addItem(dm.getTenDM().toString());
        }

    }

    public void fillToTableSanPham() {
        renderDataTable(sp.panigation(pageNumber, txtTimSP.getText(), 4, cboLoaiSP.getSelectedItem().toString() == "Tất cả" ? "" : cboLoaiSP.getSelectedItem().toString(), cboDanhMuc1.getSelectedItem().toString() == "Tất cả" ? "" : cboDanhMuc1.getSelectedItem().toString(), cboSort.getSelectedItem().toString()));
//        for (SanPham sp : spDAO.selectAll()) {
//            Object row[] = {sp.getMaSP(), sp.getTenSP(), sp.getGia(), sp.getMaLoai(), sp.getMoTa()};
//            tbl.addRow(row);
//        }
        setStatusSP();
        updateDelButton();
    }

    public void timSP() {
        fillToTableSanPham();

    }

    void filterLoaiSP() {
        fillToTableSanPham();
    }

    void filterDM() {
        if (cboDanhMuc1.getItemCount() > 1) {
            fillToTableSanPham();
        }
    }

    void fillToTableLoaiSP() {
        rendeDataLSP(sp.panigationLSP(pageNumberLSP, txtTimLoaiSP.getText(), cboDanhMuc2.getSelectedItem().toString() == "Tất cả" ? "" : cboDanhMuc2.getSelectedItem().toString()));
        setStatusLSP();
        updateDelButton();
    }

    void rendeDataLSP(List<LoaiSP> list) {
        DefaultTableModel tbl = (DefaultTableModel) tblLoaiSP.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (LoaiSP lsp : list) {
            Object row[] = {i, lsp.getMaLoai(), lsp.getTenLoai(), dmDAO.selectById(lsp.getMaDM()).getTenDM()};
            tbl.addRow(row);
            i++;
        }
    }

    void fillToTableDanhMuc() {
        DefaultTableModel tbl = (DefaultTableModel) tblDanhMuc.getModel();
        tbl.setRowCount(0);
        String keyWord = txtTimDM.getText();
        int i = 1;
        for (DanhMuc dm : sp.selectAll(txtTimDM.getText())) {
            Object row[] = {i, dm.getMaDM(), dm.getTenDM()};
            tbl.addRow(row);
            i++;
        }
    }

    private void openEditTTSP() {
        SanPham sp = spDAO.selectById(maSP);
        ThongTinSP ttsp = new ThongTinSP();
        if (sp == null) {
            ttsp.clear();
            ttsp.setVisible(true);
            return;
        }

        ttsp.setModel(sp);
        ttsp.setVisible(true);

    }

    void openTTLSP() {
        new ThongTinLoaiSP(maLoai).setVisible(true);
    }

    void openTTDM() {
        new ThongTinDM(maDanhMuc).setVisible(true);
    }

    void anSP() {
        if (!getClick(tblSanPham)) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm! \n");
            return;
        }
        if (!kiemTraLienKetSP()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm " + maSP + " còn đang hoạt động!\n Không thể ẩn! \n");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn ẩn sản phẩm " + maSP + " ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }

        spDAO.delete(maSP);
        JOptionPane.showMessageDialog(this, "Ẩn thành công! \n");
        fillToTableSanPham();
    }

    void xoaDM() {
        if (!getClick(tblDanhMuc)) {
            JOptionPane.showMessageDialog(this, "Chưa chọn danh mục! \n");
            return;
        }
        if (!kiemTraLienKetDM()) {
            JOptionPane.showMessageDialog(this, "Mã danh mục " + maDanhMuc + " có liên kết dữ liệu!\n Không thể xóa! \n");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa danh mục " + maDanhMuc + " ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == 1) {
            return;
        }

        dmDAO.delete(maDanhMuc);
        JOptionPane.showMessageDialog(this, "Xóa thành công!");
        fillToTableDanhMuc();
        fillCBBDM();
    }

    void xoaLoaiSP() {
        if (!getClick(tblLoaiSP)) {
            JOptionPane.showMessageDialog(this, "Chưa chọn loại sản phẩm!");
            return;
        }
        if (!kiemTraLienKetLSP()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm " + maLoai + " có liên kết dữ liệu!\n Không thể xóa!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa loại sản phẩm " + maLoai + " ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            lspDAO.delete(maLoai);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            fillToTableLoaiSP();
            fillCBBLoaiSP();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi liên kết dữ liệu!");
        }
    }

    boolean kiemTraLienKetSP() {
        HoaDonChiTietDao hdctDAO = new HoaDonChiTietDao();
        ComboCTDao cbctDAO = new ComboCTDao();
        for (HoaDonCT hdct : hdctDAO.selectAll()) {
            if (maSP.equals(hdct.getMaSP())) {
                return false;
            }
        }

        return true;
    }

    boolean kiemTraLienKetDM() {
        for (LoaiSP lsp : lspDAO.selectAll()) {
            if (maDanhMuc.equals(lsp.getMaDM())) {
                return false;
            }
        }
        return true;
    }

    boolean kiemTraLienKetLSP() {
        for (SanPham sp : spDAO.selectAll()) {
            if (maLoai.equals(sp.getMaLoai())) {
                return false;
            }
        }
        return true;
    }

    void updateDelButton() {
        btnXoaSP.setEnabled(getClick(tblSanPham));
        btnXoaSP.setBackground(getClick(tblSanPham) ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnXoaLSP.setEnabled(getClick(tblLoaiSP));
        btnXoaLSP.setBackground(getClick(tblLoaiSP) ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnXoaDM.setEnabled(getClick(tblDanhMuc));
        btnXoaDM.setBackground(getClick(tblDanhMuc) ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
    }

//    void setStatusSP() {
//        boolean first = pageNumber > 1;
//        boolean last = pageNumber < sp.getPageNumber();
//        btnPre.setEnabled(first);
//        btnNext.setEnabled(last);
//    }
    void setStatusSP() {
        boolean edit = this.pageNumber >= 1;
        boolean first = this.pageNumber > 1;
        boolean last = this.pageNumber < sp.getPageNumber();

        btnFirst.setEnabled(edit && first);
        btnFirst.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnPre.setEnabled(edit && first);
        btnPre.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnLast.setEnabled(edit && last);
        btnLast.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnNext.setEnabled(edit && last);
        btnNext.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
    }

    void setStatusLSP() {
        boolean edit = this.pageNumberLSP >= 1;
        boolean first = this.pageNumberLSP > 1;
        boolean last = this.pageNumberLSP < sp.getPageNumberLSP();

        btnFirstLSP.setEnabled(edit && first);
        btnFirstLSP.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnPreLSP.setEnabled(edit && first);
        btnPreLSP.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnLastLSP.setEnabled(edit && last);
        btnLastLSP.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnNextLSP.setEnabled(edit && last);
        btnNextLSP.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
    }

    void load() {
        txtTimSP.setText(null);
        cboLoaiSP.setSelectedIndex(0);
        cboDanhMuc1.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnThemSP = new com.boxcf.components.ButtonRound();
        btnXoaSP = new com.boxcf.components.ButtonRound();
        lblMaNV = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        gradientPanel1 = new com.boxcf.components.GradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboDanhMuc1 = new com.boxcf.components.Combobox();
        cboLoaiSP = new com.boxcf.components.Combobox();
        scroll = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnNext = new com.boxcf.components.ButtonRound();
        btnPre = new com.boxcf.components.ButtonRound();
        cboSort = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnXoaSP1 = new com.boxcf.components.ButtonRound();
        btnFirst = new com.boxcf.components.ButtonRound();
        btnLast = new com.boxcf.components.ButtonRound();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiSP = new javax.swing.JTable();
        lblMaNV2 = new javax.swing.JLabel();
        gradientPanel2 = new com.boxcf.components.GradientPanel();
        jLabel4 = new javax.swing.JLabel();
        cboDanhMuc2 = new com.boxcf.components.Combobox();
        btnXoaLSP = new com.boxcf.components.ButtonRound();
        btnThemLSP = new com.boxcf.components.ButtonRound();
        txtTimLoaiSP = new javax.swing.JTextField();
        btnNextLSP = new com.boxcf.components.ButtonRound();
        btnPreLSP = new com.boxcf.components.ButtonRound();
        btnXoaSP2 = new com.boxcf.components.ButtonRound();
        btnFirstLSP = new com.boxcf.components.ButtonRound();
        btnLastLSP = new com.boxcf.components.ButtonRound();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        lblMaNV3 = new javax.swing.JLabel();
        txtTimDM = new javax.swing.JTextField();
        btnXoaDM = new com.boxcf.components.ButtonRound();
        btnThemDM = new com.boxcf.components.ButtonRound();
        btnNext1 = new com.boxcf.components.ButtonRound();
        btnPre1 = new com.boxcf.components.ButtonRound();
        btnLastLSP1 = new com.boxcf.components.ButtonRound();
        btnFirstLSP1 = new com.boxcf.components.ButtonRound();
        btnXoaSP4 = new com.boxcf.components.ButtonRound();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 90, 1000, 10));

        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThemSP.setBackground(new java.awt.Color(2, 172, 171));
        btnThemSP.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSP.setText("THÊM");
        btnThemSP.setFocusable(false);
        btnThemSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });
        jPanel1.add(btnThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, 96, 40));

        btnXoaSP.setBackground(new java.awt.Color(2, 172, 171));
        btnXoaSP.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSP.setText("ẨN");
        btnXoaSP.setFocusable(false);
        btnXoaSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 96, 40));

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV.setText("Sản phẩm");
        jPanel1.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 44, 86, -1));

        txtTimSP.setBackground(new java.awt.Color(255, 255, 255,0));
        txtTimSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTimSP.setForeground(new java.awt.Color(51, 51, 51));
        txtTimSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimSPActionPerformed(evt);
            }
        });
        txtTimSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimSPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimSPKeyTyped(evt);
            }
        });
        jPanel1.add(txtTimSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 32, 530, 32));

        gradientPanel1.setColor1(new java.awt.Color(240, 240, 240));
        gradientPanel1.setColor2(new java.awt.Color(240, 240, 240));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Danh mục");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Loại");

        cboDanhMuc1.setFocusable(false);
        cboDanhMuc1.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        cboDanhMuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDanhMuc1ActionPerformed(evt);
            }
        });

        cboLoaiSP.setFocusable(false);
        cboLoaiSP.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        cboLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(cboDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1.add(gradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 720, 70));

        scroll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblSanPham.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Giá", "Loại SP", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSanPham.setGridColor(new java.awt.Color(204, 204, 204));
        tblSanPham.setRowHeight(35);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanPhamMousePressed(evt);
            }
        });
        tblSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblSanPhamKeyPressed(evt);
            }
        });
        scroll.setViewportView(tblSanPham);

        jPanel1.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 980, 310));

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
        jPanel1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 70, 40));

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
        jPanel1.add(btnPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 70, 40));

        cboSort.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giá tăng", "Giá giảm" }));
        cboSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSortActionPerformed(evt);
            }
        });
        jPanel1.add(cboSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 130, 130, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/Trash.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, -1, 40));

        btnXoaSP1.setBackground(new java.awt.Color(255, 255, 255));
        btnXoaSP1.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/42b0d0b95c057d968127d88f529122f4.jpg"))); // NOI18N
        btnXoaSP1.setFocusable(false);
        btnXoaSP1.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnXoaSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSP1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 80, 40));

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
        jPanel1.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 70, 40));

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
        jPanel1.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 70, 40));

        jTabbedPane1.addTab("SẢN PHẨM", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblLoaiSP.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        tblLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã loại", "Tên loại", "Danh mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblLoaiSP.setGridColor(new java.awt.Color(204, 204, 204));
        tblLoaiSP.setRowHeight(35);
        tblLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblLoaiSPMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiSP);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 990, 310));

        lblMaNV2.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV2.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV2.setText("Loại sản phẩm");
        jPanel2.add(lblMaNV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 110, -1));

        gradientPanel2.setColor1(new java.awt.Color(240, 240, 240));
        gradientPanel2.setColor2(new java.awt.Color(240, 240, 240));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Danh mục");

        cboDanhMuc2.setFocusable(false);
        cboDanhMuc2.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        cboDanhMuc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDanhMuc2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientPanel2Layout = new javax.swing.GroupLayout(gradientPanel2);
        gradientPanel2.setLayout(gradientPanel2Layout);
        gradientPanel2Layout.setHorizontalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboDanhMuc2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        gradientPanel2Layout.setVerticalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDanhMuc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel2.add(gradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 360, 80));

        btnXoaLSP.setBackground(new java.awt.Color(2, 172, 171));
        btnXoaLSP.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaLSP.setText("XÓA");
        btnXoaLSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnXoaLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLSPActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoaLSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, 96, 40));

        btnThemLSP.setBackground(new java.awt.Color(2, 172, 171));
        btnThemLSP.setForeground(new java.awt.Color(255, 255, 255));
        btnThemLSP.setText("THÊM");
        btnThemLSP.setFocusable(false);
        btnThemLSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnThemLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLSPActionPerformed(evt);
            }
        });
        jPanel2.add(btnThemLSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, 96, 40));

        txtTimLoaiSP.setBackground(new java.awt.Color(255, 255, 255,0));
        txtTimLoaiSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTimLoaiSP.setForeground(new java.awt.Color(51, 51, 51));
        txtTimLoaiSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtTimLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimLoaiSPActionPerformed(evt);
            }
        });
        txtTimLoaiSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimLoaiSPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimLoaiSPKeyTyped(evt);
            }
        });
        jPanel2.add(txtTimLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 32, 470, 32));

        btnNextLSP.setBackground(new java.awt.Color(2, 172, 171));
        btnNextLSP.setForeground(new java.awt.Color(255, 255, 255));
        btnNextLSP.setText(">>");
        btnNextLSP.setFocusable(false);
        btnNextLSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnNextLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextLSPActionPerformed(evt);
            }
        });
        jPanel2.add(btnNextLSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 70, 40));

        btnPreLSP.setBackground(new java.awt.Color(2, 172, 171));
        btnPreLSP.setForeground(new java.awt.Color(255, 255, 255));
        btnPreLSP.setText("<<");
        btnPreLSP.setFocusable(false);
        btnPreLSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnPreLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreLSPActionPerformed(evt);
            }
        });
        jPanel2.add(btnPreLSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 70, 40));

        btnXoaSP2.setBackground(new java.awt.Color(255, 255, 255));
        btnXoaSP2.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/42b0d0b95c057d968127d88f529122f4.jpg"))); // NOI18N
        btnXoaSP2.setFocusable(false);
        btnXoaSP2.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnXoaSP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSP2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoaSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 60, 40));

        btnFirstLSP.setBackground(new java.awt.Color(2, 172, 171));
        btnFirstLSP.setForeground(new java.awt.Color(255, 255, 255));
        btnFirstLSP.setText("|<");
        btnFirstLSP.setFocusable(false);
        btnFirstLSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnFirstLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstLSPActionPerformed(evt);
            }
        });
        jPanel2.add(btnFirstLSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 70, 40));

        btnLastLSP.setBackground(new java.awt.Color(2, 172, 171));
        btnLastLSP.setForeground(new java.awt.Color(255, 255, 255));
        btnLastLSP.setText(">|");
        btnLastLSP.setFocusable(false);
        btnLastLSP.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnLastLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastLSPActionPerformed(evt);
            }
        });
        jPanel2.add(btnLastLSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 70, 40));

        jTabbedPane1.addTab("LOẠI SP", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhMuc.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã DM", "Tên DM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhMuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDanhMuc.setGridColor(new java.awt.Color(204, 204, 204));
        tblDanhMuc.setRowHeight(30);
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDanhMucMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhMuc);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 970, 370));

        lblMaNV3.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV3.setForeground(new java.awt.Color(51, 51, 51));
        lblMaNV3.setText("Danh mục");
        jPanel3.add(lblMaNV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 44, 80, -1));

        txtTimDM.setBackground(new java.awt.Color(0, 153, 153,0));
        txtTimDM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTimDM.setForeground(new java.awt.Color(51, 51, 51));
        txtTimDM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(2, 172, 171)));
        txtTimDM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimDMKeyPressed(evt);
            }
        });
        jPanel3.add(txtTimDM, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 32, 470, 32));

        btnXoaDM.setBackground(new java.awt.Color(2, 172, 171));
        btnXoaDM.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaDM.setText("XÓA");
        btnXoaDM.setFocusable(false);
        btnXoaDM.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnXoaDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDMActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoaDM, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 96, 40));

        btnThemDM.setBackground(new java.awt.Color(2, 172, 171));
        btnThemDM.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDM.setText("THÊM");
        btnThemDM.setFocusable(false);
        btnThemDM.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnThemDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDMActionPerformed(evt);
            }
        });
        jPanel3.add(btnThemDM, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 96, 40));

        btnNext1.setBackground(new java.awt.Color(2, 172, 171));
        btnNext1.setForeground(new java.awt.Color(255, 255, 255));
        btnNext1.setText(">>");
        btnNext1.setEnabled(false);
        btnNext1.setFocusable(false);
        btnNext1.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnNext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 96, 40));

        btnPre1.setBackground(new java.awt.Color(2, 172, 171));
        btnPre1.setForeground(new java.awt.Color(255, 255, 255));
        btnPre1.setText("<<");
        btnPre1.setEnabled(false);
        btnPre1.setFocusable(false);
        btnPre1.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnPre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPre1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 96, 40));

        btnLastLSP1.setBackground(new java.awt.Color(2, 172, 171));
        btnLastLSP1.setForeground(new java.awt.Color(255, 255, 255));
        btnLastLSP1.setText(">|");
        btnLastLSP1.setEnabled(false);
        btnLastLSP1.setFocusable(false);
        btnLastLSP1.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnLastLSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastLSP1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnLastLSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 96, 40));

        btnFirstLSP1.setBackground(new java.awt.Color(2, 172, 171));
        btnFirstLSP1.setForeground(new java.awt.Color(255, 255, 255));
        btnFirstLSP1.setText("|<");
        btnFirstLSP1.setEnabled(false);
        btnFirstLSP1.setFocusable(false);
        btnFirstLSP1.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnFirstLSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstLSP1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnFirstLSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 96, 40));

        btnXoaSP4.setBackground(new java.awt.Color(255, 255, 255));
        btnXoaSP4.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/42b0d0b95c057d968127d88f529122f4.jpg"))); // NOI18N
        btnXoaSP4.setText("↻");
        btnXoaSP4.setFocusable(false);
        btnXoaSP4.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        btnXoaSP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSP4ActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoaSP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 60, 40));

        jTabbedPane1.addTab("DANH MỤC SP", jPanel3);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 102, 1010, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        maSP = null;
        openEditTTSP();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // TODO add your handling code here:
        anSP();
        updateDelButton();
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnXoaDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDMActionPerformed
        xoaDM();
    }//GEN-LAST:event_btnXoaDMActionPerformed

    private void btnXoaLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLSPActionPerformed
        xoaLoaiSP();
    }//GEN-LAST:event_btnXoaLSPActionPerformed

    private void btnThemLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLSPActionPerformed
        maLoai = null;
        openTTLSP();
    }//GEN-LAST:event_btnThemLSPActionPerformed

    private void tblSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMousePressed
        updateDelButton();
        int index = tblSanPham.rowAtPoint(evt.getPoint());
        maSP = (String) tblSanPham.getValueAt(index, 1);
        if (evt.getClickCount() == 2) {
            openEditTTSP();
        }
    }//GEN-LAST:event_tblSanPhamMousePressed

    private void tblLoaiSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSPMousePressed
        // TODO add your handling code here:
        updateDelButton();
        int index = tblLoaiSP.rowAtPoint(evt.getPoint());
        maLoai = (String) tblLoaiSP.getValueAt(index, 1);
        if (evt.getClickCount() == 2) {
            openTTLSP();
        }
    }//GEN-LAST:event_tblLoaiSPMousePressed

    private void tblDanhMucMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMousePressed
        // TODO add your handling code here:
        updateDelButton();
        int index = tblDanhMuc.rowAtPoint(evt.getPoint());
        maDanhMuc = (String) tblDanhMuc.getValueAt(index, 1);
        if (evt.getClickCount() == 2) {
            openTTDM();
        }
    }//GEN-LAST:event_tblDanhMucMousePressed

    private void cboDanhMuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDanhMuc1ActionPerformed
        if (cboDanhMuc1.getItemCount() > 1) {
            fillCBBLoaiSP();
            filterDM();
        }
    }//GEN-LAST:event_cboDanhMuc1ActionPerformed

    private void cboLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSPActionPerformed
        if (cboLoaiSP.getItemCount() > 1) {
            filterDM();
        }
    }//GEN-LAST:event_cboLoaiSPActionPerformed

    private void tblSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSanPhamKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tblSanPhamKeyPressed

    private void btnThemDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDMActionPerformed
        // TODO add your handling code here:
        maDanhMuc = null;
        openTTDM();
    }//GEN-LAST:event_btnThemDMActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:    
        if (pageNumber == 1) {
            return;
        }
        pageNumber--;
        fillToTableSanPham();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:

        if (pageNumber >= sp.getPageNumber()) {
            return;
        }
        pageNumber++;
        fillToTableSanPham();
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimSPActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimSPActionPerformed

    private void txtTimSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSPKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimSPKeyTyped

    private void txtTimSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSPKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cboLoaiSP.setSelectedIndex(0);
            cboDanhMuc1.setSelectedIndex(0);
            fillToTableSanPham();
        }
    }//GEN-LAST:event_txtTimSPKeyPressed

    private void cboSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSortActionPerformed
        // TODO add your handling code here:
        fillToTableSanPham();
    }//GEN-LAST:event_cboSortActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new SanPhamAn().setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:   
    }//GEN-LAST:event_formKeyPressed

    private void btnXoaSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSP1ActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_btnXoaSP1ActionPerformed

    private void txtTimLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimLoaiSPActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimLoaiSPActionPerformed

    private void txtTimLoaiSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimLoaiSPKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cboDanhMuc2.setSelectedIndex(0);
            fillToTableLoaiSP();
        }
    }//GEN-LAST:event_txtTimLoaiSPKeyPressed

    private void txtTimLoaiSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimLoaiSPKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimLoaiSPKeyTyped

    private void txtTimDMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimDMKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fillToTableDanhMuc();
        }
    }//GEN-LAST:event_txtTimDMKeyPressed

    private void btnNextLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextLSPActionPerformed
        // TODO add your handling code here:
        if (pageNumberLSP >= sp.getPageNumberLSP()) {
            return;
        }
        pageNumberLSP++;
        fillToTableLoaiSP();
    }//GEN-LAST:event_btnNextLSPActionPerformed

    private void btnPreLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreLSPActionPerformed
        // TODO add your handling code here:
        if (pageNumberLSP <= 1) {
            return;
        }
        pageNumberLSP--;
        fillToTableLoaiSP();
    }//GEN-LAST:event_btnPreLSPActionPerformed

    private void cboDanhMuc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDanhMuc2ActionPerformed
        // TODO add your handling code here:
        if (cboDanhMuc2.getItemCount() > 1) {
            fillToTableLoaiSP();
        }
    }//GEN-LAST:event_cboDanhMuc2ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnPre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPre1ActionPerformed

    private void btnXoaSP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSP2ActionPerformed
        // TODO add your handling code here:
        cboDanhMuc2.setSelectedIndex(0);
        txtTimLoaiSP.setText(null);
        fillToTableLoaiSP();
    }//GEN-LAST:event_btnXoaSP2ActionPerformed

    private void btnFirstLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstLSPActionPerformed
        // TODO add your handling code here:
        pageNumberLSP = 1;
        fillToTableLoaiSP();
    }//GEN-LAST:event_btnFirstLSPActionPerformed

    private void btnLastLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastLSPActionPerformed
        // TODO add your handling code here:
        pageNumber = sp.getPageNumberLSP();
        fillToTableLoaiSP();
    }//GEN-LAST:event_btnLastLSPActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        pageNumber = 1;
        fillToTableSanPham();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        pageNumber = sp.getPageNumber();
        fillToTableSanPham();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnLastLSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastLSP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastLSP1ActionPerformed

    private void btnFirstLSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstLSP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstLSP1ActionPerformed

    private void btnXoaSP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSP4ActionPerformed
        // TODO add your handling code here:
        txtTimDM.setText(null);
        fillToTableDanhMuc();
    }//GEN-LAST:event_btnXoaSP4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnFirst;
    private com.boxcf.components.ButtonRound btnFirstLSP;
    private com.boxcf.components.ButtonRound btnFirstLSP1;
    private com.boxcf.components.ButtonRound btnLast;
    private com.boxcf.components.ButtonRound btnLastLSP;
    private com.boxcf.components.ButtonRound btnLastLSP1;
    private com.boxcf.components.ButtonRound btnNext;
    private com.boxcf.components.ButtonRound btnNext1;
    private com.boxcf.components.ButtonRound btnNextLSP;
    private com.boxcf.components.ButtonRound btnPre;
    private com.boxcf.components.ButtonRound btnPre1;
    private com.boxcf.components.ButtonRound btnPreLSP;
    private com.boxcf.components.ButtonRound btnThemDM;
    private com.boxcf.components.ButtonRound btnThemLSP;
    private com.boxcf.components.ButtonRound btnThemSP;
    private com.boxcf.components.ButtonRound btnXoaDM;
    private com.boxcf.components.ButtonRound btnXoaLSP;
    private com.boxcf.components.ButtonRound btnXoaSP;
    private com.boxcf.components.ButtonRound btnXoaSP1;
    private com.boxcf.components.ButtonRound btnXoaSP2;
    private com.boxcf.components.ButtonRound btnXoaSP4;
    private com.boxcf.components.Combobox cboDanhMuc1;
    private com.boxcf.components.Combobox cboDanhMuc2;
    private com.boxcf.components.Combobox cboLoaiSP;
    private javax.swing.JComboBox<String> cboSort;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private com.boxcf.components.GradientPanel gradientPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaNV2;
    private javax.swing.JLabel lblMaNV3;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTable tblLoaiSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtTimDM;
    private javax.swing.JTextField txtTimLoaiSP;
    private javax.swing.JTextField txtTimSP;
    // End of variables declaration//GEN-END:variables

}

class suport {

    public static int quantity = 1;
    public static int quantityLSP = 1;

    public List<LoaiSP> panigationLSP(int pageCurent, String keyWord, String TenDM) {
        String sql = "select top 8 lsp.* from loaisp lsp inner join danhmuc dm on lsp.MaDM=dm.MaDM where lsp.MaLoai not in \n"
                + "(select top " + (pageCurent * 8 - 8) + " lsp2.MaLoai from LoaiSP lsp2 inner join danhmuc dm2 on lsp2.MaDM=dm2.MaDM where dm2.TenDM like ? and (lsp2.MaLoai like ? or lsp2.TenLoai like ?))\n"
                + "and dm.TenDM like ? and (lsp.MaLoai like ? or lsp.TenLoai like ?);";
        quantityLSP = new LoaiSPDao().selectBySql(sql, "%" + TenDM + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + TenDM + "%", "%" + keyWord + "%", "%" + keyWord + "%").size();
        return new LoaiSPDao().selectBySql(sql, "%" + TenDM + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + TenDM + "%", "%" + keyWord + "%", "%" + keyWord + "%");
    }

    public List<SanPham> panigation(Integer pageCurrent, String keyWord, int type, String TenLoai, String TenDM, String sort) {
        String sql = "";
        sort = sort.equals("Giá tăng") ? "ASC" : "DESC";
        switch (type) {
            case 3:
                sql = "SELECT TOP 8 sp.* FROM SanPham sp inner join LoaiSP lsp on sp.MaLoai=lsp.MaLoai where MaSP NOT IN (SELECT TOP " + (pageCurrent * 8 - 8) + " MaSP FROM SanPham) and MaSP like ? and lsp.TenLoai like ?;";
                quantity = new SanPhamDao().selectBySql(sql, "%" + keyWord + "%", "%" + TenLoai + "%").size();
                return new SanPhamDao().selectBySql(sql, "%" + keyWord + "%", "%" + TenLoai + "%");
            case 4:
                sql = "SELECT TOP 8 sp.* FROM SanPham sp inner join LoaiSP lsp on sp.MaLoai=lsp.MaLoai inner join DanhMuc dm on lsp.MaDM=dm.MaDM "
                        + "where MaSP NOT IN (SELECT TOP " + (pageCurrent * 8 - 8) + " MaSP FROM SanPham sp2 join LoaiSP lsp2 on sp2.MaLoai=lsp2.MaLoai join danhmuc dm2 on dm2.MaDM=lsp2.MaDM where (sp2.MaSP like ? or sp2.TenSP like ?) and lsp2.MaLoai like ? and dm2.TenDM like ? and sp2.TrangThai=1)"
                        + "and (sp.MaSP like ? or sp.TenSP like ?) and lsp.TenLoai like ? and dm.TenDM like ? and sp.TrangThai = 1 order by sp.Gia " + sort;
                quantity = new SanPhamDao().selectBySql(sql, "%" + keyWord + "%", "%" + keyWord + "%", "%" + TenLoai + "%", "%" + TenDM + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + TenLoai + "%", "%" + TenDM + "%").size();
                return new SanPhamDao().selectBySql(sql, "%" + keyWord + "%", "%" + keyWord + "%", "%" + TenLoai + "%", "%" + TenDM + "%", "%" + keyWord + "%", "%" + keyWord + "%", "%" + TenLoai + "%", "%" + TenDM + "%");
            default:
                return null;
        }
    }

    public List<LoaiSP> getLSPFromDM(String tenDM) {
        String sql = "Select lsp.* from LoaiSP lsp inner join DanhMuc dm on lsp.MaDM = dm.MaDM where dm.TenDM like ?;";
        return new LoaiSPDao().selectBySql(sql, "%" + tenDM + "%");
    }

    public DanhMuc DMFromLSP(String tenLoai) {
        String sql = "Select dm.* from LoaiSP lsp inner join DanhMuc dm on lsp.MaDM = dm.MaDM where lsp.TenLoai like ?;";
        DanhMuc dm = new DanhMuc();
        try {
            ResultSet responce = JdbcHelper.query(sql, "%" + tenLoai + "%");
            // admission a ResultSet return a Box
            if (responce.next()) {
                dm = new DanhMucDao().createObjecet(responce);
            }
        } catch (Exception e) {
        }
        return dm;
    }

    int getPageNumberLSP() {

        return (int) Math.ceil(quantityLSP / 8) + 1;
    }

    private static boolean check_real_integer_number(double n) {
        //flag = 1 => số nguyên
        //flag = 0 => số thực
        boolean flag = true;
        if (Math.ceil(n) != Math.floor(n)) {
            flag = false;
        }
        return flag;
    }

    int getPageNumber() {

        return (int) Math.ceil(quantity / 8) + 1;
    }

    public List<DanhMuc> selectAll(String keyWord) {
        String sql = "select * from DanhMuc where MaDM like ? or TenDM like ?";
        return new DanhMucDao().selectBySql(sql, "%" + keyWord + "%", "%" + keyWord + "%");
    }
}
