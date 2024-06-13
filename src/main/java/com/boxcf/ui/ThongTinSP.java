/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.JdbcHelper;
import com.box.utils.UI;
import com.box.utils.XImage;
import com.boxcf.dao.DanhMucDao;
import com.boxcf.dao.LoaiSPDao;
import com.boxcf.dao.SanPhamDao;
import com.boxcf.models.LoaiSP;
import com.boxcf.models.SanPham;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThongTinSP extends javax.swing.JFrame {

    String maSP;
    SanPhamView spview = Store.spView;

    int index = -1;
    DanhMucDao dmDAO = new DanhMucDao();
    LoaiSPDao lspDAO = new LoaiSPDao();
    SanPhamDao spDAO = new SanPhamDao();
    List<SanPham> list = spDAO.selectAll();

    public ThongTinSP() {
        initComponents();
        init();
    }

    void fillComboBox() {
        for (LoaiSP lsp : lspDAO.selectAll()) {
            cboLoaiSP.addItem(lsp.getTenLoai());
        }

    }

    boolean confirmUpdate() {
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn câp nhật sản phẩm " + maSP + " ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return false;
        }
        return true;
    }

    boolean validateForm() {
        //check null
        StringBuilder sb = new StringBuilder();

        if (txtTenSP.getText().isEmpty()) {
            sb.append("\nTên sản phẩm không thể trống! \n");
        }
        if (txtGia.getText().isEmpty()) {
            sb.append("\nGiá sản phẩm không thể trống! \n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return false;
        } else {
            //check gia
            int gia = 0;
            try {
                gia = Integer.parseInt(txtGia.getText());
            } catch (Exception e) {
                sb.append("Giá phải là số! \n");
            }
            if (gia <= 1000) {
                sb.append("Giá phải lớn hơn 1000 \n");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb);
                return false;
            }
        }
        return true;
    }

    boolean checkTrungID() {
        String maSP = txtMaSP.getText();
        for (SanPham sp : list) {
            if (maSP.equals(sp.getMaSP())) {
                return true;
            }
        }
        return false;
    }

    void getViTri() {
        if (maSP == null) {
            return;
        }
        for (SanPham sanPham : list) {
            if (sanPham.getMaSP().equals(maSP)) {
                index = list.indexOf(sanPham);
                break;
            }
        }
    }

    void editw() {
        try {
            if (maSP == null) {
                clear();
                return;
            }
            SanPham sp = list.get(index);
            setModel(sp);
            setStatus();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setModel(SanPham sp) {
        this.maSP = sp.getMaSP();

        getViTri();
        setStatus();

        LoaiSP lsp = lspDAO.selectById(sp.getMaLoai());
        txtMaSP.setText("" + sp.getMaSP());
        txtTenSP.setText("" + sp.getTenSP());
        txtGia.setText("" + sp.getGia());
        if (sp.getMaLoai() == null) {
            cboLoaiSP.setSelectedIndex(0);
        } else {
            cboLoaiSP.setSelectedItem(lsp.getTenLoai());
        }
        txtMoTa.setText(sp.getMoTa());

        if (sp.getHinhAnh() != null) {
            lblHinh.setToolTipText(sp.getHinhAnh());
            ImageIcon img = XImage.read(sp.getHinhAnh());
            Image img2 = XImage.resize(img.getImage(), lblHinh.getWidth(), lblHinh.getHeight());
            ImageIcon img3 = new ImageIcon(img2);
            lblHinh.setIcon(img3);
        }
    }

    void setStatus() {
        boolean edit = this.index >= 0;
        boolean first = this.index > 0;
        boolean last = this.index < list.size() - 1;
        cboLoaiSP.setEnabled(!edit);
        btnCapNhatSP.setEnabled(edit);
        btnCapNhatSP.setBackground(edit ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnThemSP.setEnabled(!edit);
        btnThemSP.setBackground(!edit ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnFirst.setEnabled(edit && first);
        btnFirst.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnPre.setEnabled(edit && first);
        btnPre.setBackground(edit && first ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnLast.setEnabled(edit && last);
        btnLast.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
        btnNext.setEnabled(edit && last);
        btnNext.setBackground(edit && last ? Color.decode("#02ACAB") : Color.decode("#e6ddce"));
    }

    SanPham getModel() {
        SanPham sp = new SanPham();
        String maLoai = cboLoaiSP.getSelectedItem().toString();
        LoaiSP lsp = lspDAO.selectByName(maLoai);
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setGia(Long.parseLong(txtGia.getText()));
        sp.setMaLoai(lsp.getMaLoai());
        sp.setHinhAnh(lblHinh.getToolTipText());
        sp.setMoTa(txtMoTa.getText());
        return sp;
    }

    void selectImage() {
        String path = "C:\\Users\\Asus\\Desktop\\du-an-1-main\\DuAn1\\src\\main\\resources\\com\\boxcf\\images";
        JFileChooser fileChooser = new JFileChooser(path);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            XImage.save(file);

            ImageIcon img = XImage.read(file.getName());
            Image img2 = XImage.resize(img.getImage(), lblHinh.getWidth(), lblHinh.getHeight());
            ImageIcon img3 = new ImageIcon(img2);
            lblHinh.setIcon(img3);
            lblHinh.setToolTipText(file.getName());
        }
    }

    void insert() {
        if (!validateForm()) {
            return;
        }
        if (checkTrungID()) {
            JOptionPane.showMessageDialog(this, "ID đã tồn tại!");
            return;
        }

        try {
            spDAO.insert(getModel());
            spview.fillToTableSanPham();
            clear();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void clear() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGia.setText("");
        txtMoTa.setText("");
        lblHinh.setIcon(null);
        cboLoaiSP.setSelectedIndex(0);
        index = -1;
        setStatus();
    }

    void update() {
        if (!validateForm()) {
            return;
        }

        if (!confirmUpdate()) {
            return;
        }

        try {
            spDAO.update(getModel());
            Store.spView.fillToTableSanPham();
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

    String getIDLast() {
        return new Store().getNextId(spDAO.selectAll().get(spDAO.selectAll().size() - 1).getMaSP());
    }

    void getMaSPAuto() {
        if (maSP != null) {
            return;
        }
        SupportSPView sp = new SupportSPView();
        String maLoai = sp.removeAccent(cboLoaiSP.getSelectedItem().toString());
        String maAuto = sp.getCodeSP(maLoai).toUpperCase();
        SanPham sp1 = sp.selectLastID(maAuto);
        if (sp1 == null) {
            txtMaSP.setText(maAuto + "001");
            return;
        }
        txtMaSP.setText(sp.getNextId(sp1.getMaSP()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        gradientPanel1 = new com.boxcf.components.GradientPanel();
        pnlNhanVien = new com.boxcf.components.GradientPanel();
        lblMaNV = new javax.swing.JLabel();
        lblMaNV1 = new javax.swing.JLabel();
        lblMaNV2 = new javax.swing.JLabel();
        lblMaNV3 = new javax.swing.JLabel();
        lblMaNV8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThemSP = new com.boxcf.components.ButtonRound();
        btnCapNhatSP = new com.boxcf.components.ButtonRound();
        btnReset = new com.boxcf.components.ButtonRound();
        txtMaSP = new com.boxcf.components.TextField();
        txtTenSP = new com.boxcf.components.TextField();
        cboLoaiSP = new com.boxcf.components.Combobox();
        txtGia = new com.boxcf.components.TextField();
        btnClose = new com.boxcf.components.ButtonRound();
        lblHinh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new com.boxcf.components.ButtonRound();
        btnPre = new com.boxcf.components.ButtonRound();
        btnNext = new com.boxcf.components.ButtonRound();
        btnLast = new com.boxcf.components.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientPanel1.setColor1(new java.awt.Color(102, 102, 102));
        gradientPanel1.setColor2(new java.awt.Color(102, 102, 102));
        gradientPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        pnlNhanVien.setBackground(new java.awt.Color(102, 102, 102));
        pnlNhanVien.setColor1(new java.awt.Color(245, 250, 255));
        pnlNhanVien.setColor2(new java.awt.Color(245, 250, 255));
        pnlNhanVien.setMinimumSize(new java.awt.Dimension(942, 738));
        pnlNhanVien.setPreferredSize(new java.awt.Dimension(942, 738));
        pnlNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV.setText("Mã SP");
        pnlNhanVien.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 80, -1));

        lblMaNV1.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV1.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV1.setText("Tên SP");
        pnlNhanVien.add(lblMaNV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 80, -1));

        lblMaNV2.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV2.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV2.setText("Giá (VNĐ)");
        pnlNhanVien.add(lblMaNV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 100, -1));

        lblMaNV3.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV3.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV3.setText("Mô tả");
        pnlNhanVien.add(lblMaNV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 80, -1));

        lblMaNV8.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblMaNV8.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV8.setText("Loại SP");
        pnlNhanVien.add(lblMaNV8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 100, -1));

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        txtMoTa.setRows(2);
        jScrollPane1.setViewportView(txtMoTa);

        pnlNhanVien.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 570, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 48, 84));
        jLabel1.setText("THÔNG TIN SẢN PHẨM");
        pnlNhanVien.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        btnThemSP.setBackground(new java.awt.Color(2, 172, 171));
        btnThemSP.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSP.setText("LƯU");
        btnThemSP.setFocusable(false);
        btnThemSP.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnCapNhatSP.setBackground(new java.awt.Color(2, 172, 171));
        btnCapNhatSP.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatSP.setText("CẬP NHẬT");
        btnCapNhatSP.setFocusable(false);
        btnCapNhatSP.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnCapNhatSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSPActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(2, 172, 171));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("LÀM MỚI");
        btnReset.setFocusable(false);
        btnReset.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
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
                .addGap(32, 32, 32)
                .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhatSP, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pnlNhanVien.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 390, 80));

        txtMaSP.setEditable(false);
        txtMaSP.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        txtMaSP.setLabelText("");
        pnlNhanVien.add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 568, 38));

        txtTenSP.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        txtTenSP.setLabelText("");
        pnlNhanVien.add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 568, 38));

        cboLoaiSP.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        cboLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPActionPerformed(evt);
            }
        });
        pnlNhanVien.add(cboLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 230, -1));

        txtGia.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        txtGia.setLabelText("");
        pnlNhanVien.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 280, 38));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlNhanVien.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 50, 50));

        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });
        pnlNhanVien.add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 260, 300));

        btnFirst.setBackground(new java.awt.Color(2, 172, 171));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.setFocusable(false);
        btnFirst.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setBackground(new java.awt.Color(2, 172, 171));
        btnPre.setForeground(new java.awt.Color(255, 255, 255));
        btnPre.setText("<<");
        btnPre.setFocusable(false);
        btnPre.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(2, 172, 171));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.setFocusable(false);
        btnNext.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(2, 172, 171));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.setFocusable(false);
        btnLast.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
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
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlNhanVien.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 620, 260, 80));

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 940, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 736, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        insert();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnCapNhatSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSPActionPerformed
        update();
    }//GEN-LAST:event_btnCapNhatSPActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        prev();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.exit();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        selectImage();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void cboLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSPActionPerformed
        // TODO add your handling code here:
        getMaSPAuto();
    }//GEN-LAST:event_cboLoaiSPActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound btnCapNhatSP;
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.ButtonRound btnFirst;
    private com.boxcf.components.ButtonRound btnLast;
    private com.boxcf.components.ButtonRound btnNext;
    private com.boxcf.components.ButtonRound btnPre;
    private com.boxcf.components.ButtonRound btnReset;
    private com.boxcf.components.ButtonRound btnThemSP;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.boxcf.components.Combobox cboLoaiSP;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaNV1;
    private javax.swing.JLabel lblMaNV2;
    private javax.swing.JLabel lblMaNV3;
    private javax.swing.JLabel lblMaNV8;
    private com.boxcf.components.GradientPanel pnlNhanVien;
    private com.boxcf.components.TextField txtGia;
    private com.boxcf.components.TextField txtMaSP;
    private javax.swing.JTextArea txtMoTa;
    private com.boxcf.components.TextField txtTenSP;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.prepareUI();
        fillComboBox();

        getViTri();
        setStatus();
    }

    private void prepareUI() {
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.changeTransBG(new Color(0, 0, 0, 0), txtGia, txtMaSP, txtTenSP);
    }

    private void exit() {
        this.dispose();
    }
}

class SupportSPView {

    String getCodeSP(String LoaiSP) {
        char f = LoaiSP.charAt(0);
        char l = ' ';
        LoaiSP = LoaiSP.trim();
        for (int i = 0; i < LoaiSP.length(); i++) {
            if (LoaiSP.charAt(i) == ' ') {
                l = LoaiSP.charAt(i + 1);
                break;
            }
        }
        return "" + f + l;
    }

    public String getNextId(String maxId) {
//        String maxId = "PC09999";

        String first = maxId.substring(0, 2);
        String last = maxId.substring(2);
        Integer number = Integer.parseInt(last);
        Integer log = number / 10;

        if (log == 0) {
            maxId = first + "00" + ++number;
        } else if (log > 1000) {
            maxId = first + ++number;
        } else if (log > 100) {
            maxId = first + "" + ++number;
        } else if (log > 10) {
            maxId = first + "" + ++number;
        } else if (log > 0) {
            maxId = first + "0" + ++number;
        }

        return maxId;
    }

    private static char[] SOURCE_CHARACTERS = {'À', 'Á', 'Â', 'Ã', 'È', 'É',
        'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â',
        'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý',
        'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ',
        'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ',
        'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ',
        'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ',
        'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
        'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ',
        'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ',
        'ữ', 'Ự', 'ự',};

    // Mang cac ky tu thay the khong dau
    private static char[] DESTINATION_CHARACTERS = {'A', 'A', 'A', 'A', 'E',
        'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
        'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
        'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
        'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
        'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
        'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
        'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
        'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
        'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
        'U', 'u', 'U', 'u',};

    /**
     * Bo dau 1 ky tu
     *
     * @param ch
     * @return
     */
    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    public static String removeAccent(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }

    public SanPham selectLastID(String codeSP) {
        String sql = "select top 1 * from sanpham where MaSP like ? order by MaSP desc;";
        SanPham sanPham = null;
        try {
            ResultSet responce = JdbcHelper.query(sql, "%" + codeSP + "%");

            // admission a ResultSet return a Box
            if (responce.next()) {
                sanPham = new SanPhamDao().createObjecet(responce);
            }

            responce.getStatement().getConnection().close();

        } catch (Exception e) {
            throw new Error("The Error in selectById SanPham !");
        }
        return sanPham;
    }
}
