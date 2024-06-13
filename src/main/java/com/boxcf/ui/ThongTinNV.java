package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.UI;
import com.box.utils.Validator;
import com.box.utils.XDate;
import com.box.utils.XImage;
import com.boxcf.components.ButtonRound;
import com.boxcf.components.ScrollBar;
import com.boxcf.dao.NhanVienDao;
import com.boxcf.models.NhanVien;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ThongTinNV extends javax.swing.JFrame {

	public static int i = -1;
	List<NhanVien> list = NhanVienDao.getInstant().selectAll();

	public ThongTinNV() {
		initComponents();
		init();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		gradientPanel1 = new com.boxcf.components.GradientPanel();
		pnlNhanVien = new com.boxcf.components.GradientPanel();
		lblMaNV = new javax.swing.JLabel();
		lblMaNV1 = new javax.swing.JLabel();
		lblMaNV2 = new javax.swing.JLabel();
		lblMaNV3 = new javax.swing.JLabel();
		lblMaNV4 = new javax.swing.JLabel();
		lblMaNV5 = new javax.swing.JLabel();
		lblMaNV6 = new javax.swing.JLabel();
		lblMaNV7 = new javax.swing.JLabel();
		dcNgaySinh = new com.toedter.calendar.JDateChooser();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtDiaChi = new javax.swing.JTextArea();
		dcNgayVaoLam = new com.toedter.calendar.JDateChooser();
		lblHinhAnh = new com.boxcf.components.ImageAvatar();
		jLabel1 = new javax.swing.JLabel();
		pnButton = new javax.swing.JPanel();
		btnAdd = new com.boxcf.components.ButtonRound();
		btnUpdate = new com.boxcf.components.ButtonRound();
		btnFirst = new com.boxcf.components.ButtonRound();
		btnPre = new com.boxcf.components.ButtonRound();
		btnNext = new com.boxcf.components.ButtonRound();
		btnLast = new com.boxcf.components.ButtonRound();
		btnClean = new com.boxcf.components.ButtonRound();
		cbNam = new com.boxcf.components.RadioCustom();
		cbNu = new com.boxcf.components.RadioCustom();
		txtMaNV = new com.boxcf.components.TextField();
		txtMatKhau = new com.boxcf.components.TextField();
		txtTenNV = new com.boxcf.components.TextField();
		lblMaNV9 = new javax.swing.JLabel();
		cbNhanVien = new com.boxcf.components.RadioCustom();
		cbQuanLi = new com.boxcf.components.RadioCustom();
		txtSDT = new com.boxcf.components.TextField();
		btnClose = new com.boxcf.components.ButtonRound();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setFocusable(false);
		setUndecorated(true);

		gradientPanel1.setColor1(new java.awt.Color(102, 102, 102));
		gradientPanel1.setColor2(new java.awt.Color(102, 102, 102));

		pnlNhanVien.setBackground(new java.awt.Color(102, 102, 102));
		pnlNhanVien.setColor1(new java.awt.Color(245, 250, 255));
		pnlNhanVien.setColor2(new java.awt.Color(245, 250, 255));
		pnlNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		lblMaNV.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV.setText("Mã NV");
		pnlNhanVien.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 84, 50, -1));

		lblMaNV1.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV1.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV1.setText("Tên NV");
		pnlNhanVien.add(lblMaNV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 50, -1));

		lblMaNV2.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV2.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV2.setText("SDT");
		pnlNhanVien.add(lblMaNV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 50, -1));

		lblMaNV3.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV3.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV3.setText("Địa chỉ");
		pnlNhanVien.add(lblMaNV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 50, -1));

		lblMaNV4.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV4.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV4.setText("Ngày Sinh");
		pnlNhanVien.add(lblMaNV4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 80, -1));

		lblMaNV5.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV5.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV5.setText("Mật khẩu");
		pnlNhanVien.add(lblMaNV5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 80, -1));

		lblMaNV6.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV6.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV6.setText("Ngày vào làm");
		pnlNhanVien.add(lblMaNV6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 101, -1));

		lblMaNV7.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV7.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV7.setText("Vai trò");
		pnlNhanVien.add(lblMaNV7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 59, -1));

		dcNgaySinh.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		dcNgaySinh.setPreferredSize(new java.awt.Dimension(82, 28));
		pnlNhanVien.add(dcNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 230, -1));

		txtDiaChi.setColumns(20);
		txtDiaChi.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		txtDiaChi.setRows(2);
		jScrollPane1.setViewportView(txtDiaChi);

		pnlNhanVien.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 570, 70));

		dcNgayVaoLam.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		dcNgayVaoLam.setPreferredSize(new java.awt.Dimension(82, 28));
		pnlNhanVien.add(dcNgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 270, 30));

		lblHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
		lblHinhAnh.setGradientColor1(new java.awt.Color(204, 204, 204));
		lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblHinhAnhMouseClicked(evt);
			}
		});
		pnlNhanVien.add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 160, 190));

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(40, 48, 84));
		jLabel1.setText("THÔNG TIN NHÂN VIÊN");
		pnlNhanVien.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

		btnAdd.setBackground(new java.awt.Color(2, 172, 171));
		btnAdd.setForeground(new java.awt.Color(255, 255, 255));
		btnAdd.setText("LƯU");
		btnAdd.setFocusable(false);
		btnAdd.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});

		btnUpdate.setBackground(new java.awt.Color(2, 172, 171));
		btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
		btnUpdate.setText("CẬP NHẬT");
		btnUpdate.setFocusable(false);
		btnUpdate.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});

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

		btnClean.setBackground(new java.awt.Color(2, 172, 171));
		btnClean.setForeground(new java.awt.Color(255, 255, 255));
		btnClean.setText("MỚI");
		btnClean.setFocusable(false);
		btnClean.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
		btnClean.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCleanActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnButtonLayout = new javax.swing.GroupLayout(pnButton);
		pnButton.setLayout(pnButtonLayout);
		pnButtonLayout
				.setHorizontalGroup(
						pnButtonLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnButtonLayout.createSequentialGroup().addGap(60, 60, 60)
										.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162,
												Short.MAX_VALUE)
										.addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(56, 56, 56)));
		pnButtonLayout.setVerticalGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnButtonLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnlNhanVien.add(pnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 820, -1));

		buttonGroup2.add(cbNam);
		cbNam.setText("Nam");
		cbNam.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		pnlNhanVien.add(cbNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, 40));

		buttonGroup2.add(cbNu);
		cbNu.setText("Nữ");
		cbNu.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		pnlNhanVien.add(cbNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, 40));

		txtMaNV.setEditable(false);
		txtMaNV.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		txtMaNV.setLabelText("");
		txtMaNV.setOpaque(false);
		pnlNhanVien.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 102, 568, 38));

		txtMatKhau.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		txtMatKhau.setLabelText("");
		txtMatKhau.setOpaque(false);
		pnlNhanVien.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, 560, 38));

		txtTenNV.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		txtTenNV.setLabelText("");
		txtTenNV.setOpaque(false);
		pnlNhanVien.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 183, 568, 38));

		lblMaNV9.setBackground(new java.awt.Color(102, 0, 204));
		lblMaNV9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaNV9.setForeground(new java.awt.Color(27, 51, 61));
		lblMaNV9.setText("Giới tính");
		pnlNhanVien.add(lblMaNV9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 59, -1));

		buttonGroup1.add(cbNhanVien);
		cbNhanVien.setText("Nhân viên");
		cbNhanVien.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		pnlNhanVien.add(cbNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, 40));

		buttonGroup1.add(cbQuanLi);
		cbQuanLi.setText("Quản lý");
		cbQuanLi.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		pnlNhanVien.add(cbQuanLi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, 40));

		txtSDT.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
		txtSDT.setLabelText("");
		txtSDT.setOpaque(false);
		pnlNhanVien.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 280, 38));

		btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
		btnClose.setFocusPainted(false);
		btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCloseActionPerformed(evt);
			}
		});
		pnlNhanVien.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 50, 50));

		javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
		gradientPanel1.setLayout(gradientPanel1Layout);
		gradientPanel1Layout
				.setHorizontalGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(gradientPanel1Layout.createSequentialGroup().addGap(2, 2, 2)
								.addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
								.addGap(2, 2, 2)));
		gradientPanel1Layout
				.setVerticalGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(gradientPanel1Layout.createSequentialGroup().addGap(2, 2, 2)
								.addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
								.addGap(2, 2, 2)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(gradientPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(gradientPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		if (!Auth.accept(this)) {
			return;
		}
		handleInsert();
	}// GEN-LAST:event_btnAddActionPerformed

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
		if (!Auth.accept(this)) {
			return;
		}
		handleUpdate();
	}// GEN-LAST:event_btnUpdateActionPerformed

	private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFirstActionPerformed
	}// GEN-LAST:event_btnFirstActionPerformed

	private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPreActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnPreActionPerformed

	private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnNextActionPerformed

	private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLastActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnLastActionPerformed

	private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCloseActionPerformed
		this.exit();
	}// GEN-LAST:event_btnCloseActionPerformed

	private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHinhAnhMouseClicked
		chooseImage();
	}// GEN-LAST:event_lblHinhAnhMouseClicked

	private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCleanActionPerformed
		if (!Auth.accept(this)) {
			return;
		}
		clear();
	}// GEN-LAST:event_btnCleanActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ThongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ThongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ThongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ThongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ThongTinNV().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.boxcf.components.ButtonRound btnAdd;
	private com.boxcf.components.ButtonRound btnClean;
	private com.boxcf.components.ButtonRound btnClose;
	private com.boxcf.components.ButtonRound btnFirst;
	private com.boxcf.components.ButtonRound btnLast;
	private com.boxcf.components.ButtonRound btnNext;
	private com.boxcf.components.ButtonRound btnPre;
	private com.boxcf.components.ButtonRound btnUpdate;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private com.boxcf.components.RadioCustom cbNam;
	private com.boxcf.components.RadioCustom cbNhanVien;
	private com.boxcf.components.RadioCustom cbNu;
	private com.boxcf.components.RadioCustom cbQuanLi;
	private com.toedter.calendar.JDateChooser dcNgaySinh;
	private com.toedter.calendar.JDateChooser dcNgayVaoLam;
	private com.boxcf.components.GradientPanel gradientPanel1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private com.boxcf.components.ImageAvatar lblHinhAnh;
	private javax.swing.JLabel lblMaNV;
	private javax.swing.JLabel lblMaNV1;
	private javax.swing.JLabel lblMaNV2;
	private javax.swing.JLabel lblMaNV3;
	private javax.swing.JLabel lblMaNV4;
	private javax.swing.JLabel lblMaNV5;
	private javax.swing.JLabel lblMaNV6;
	private javax.swing.JLabel lblMaNV7;
	private javax.swing.JLabel lblMaNV9;
	private javax.swing.JPanel pnButton;
	private com.boxcf.components.GradientPanel pnlNhanVien;
	private javax.swing.JTextArea txtDiaChi;
	private com.boxcf.components.TextField txtMaNV;
	private com.boxcf.components.TextField txtMatKhau;
	private com.boxcf.components.TextField txtSDT;
	private com.boxcf.components.TextField txtTenNV;
	// End of variables declaration//GEN-END:variables

	private void init() {
		this.prepareUI();
		initEventControl();
		clear();
	}

	private void prepareUI() {
		Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
		this.setShape(shape);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.changeTransBG(new Color(0, 0, 0, 0), txtMaNV, txtTenNV, txtSDT, txtMatKhau);
		jScrollPane1.setVerticalScrollBar(new ScrollBar());

	}

	private void exit() {
		this.dispose();
	}

	public void setModel(NhanVien nv) {
		txtDiaChi.setText(nv.getDiaChi());
		txtMaNV.setText(nv.getMaNV());
		txtMatKhau.setText(nv.getMatKhau());
		txtSDT.setText(nv.getSDT());
		txtTenNV.setText(nv.getTenNV());

		if (nv.isGioiTinh()) {
			cbNam.setSelected(true);
		} else {
			cbNu.setSelected(true);
		}

		if (nv.getVaiTro().equals("User")) {
			cbNhanVien.setSelected(true);
		} else {
			cbQuanLi.setSelected(true);
		}

		dcNgaySinh.setDate(nv.getNgaySinh());
		dcNgayVaoLam.setDate(nv.getNgayVaoLam());

		String url = nv.getHinhAnh();
		if (url != null) {
			lblHinhAnh.setToolTipText(url);
			ImageIcon icon = XImage.read(url);
			Image img = XImage.resize(icon.getImage(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
			icon = new ImageIcon(img);
			lblHinhAnh.setImage(icon);
		} else {
			lblHinhAnh.setImage(null);
		}

		getViTri(nv.getMaNV());
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

		UI.accept(btnAdd, btnUpdate, btnClean);
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
			return;
		}
		this.setModel(list.get(i));
		this.updateStatus();
		this.enableRole();
	}

	private void chooseImage() {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();

			XImage.save(file);
			ImageIcon icon = XImage.read(file.getName());
			Image img = XImage.resize(icon.getImage(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
			icon = new ImageIcon(img);
			lblHinhAnh.setImage(icon);
			lblHinhAnh.setToolTipText(file.getName());
		}
	}

	private void initEventControl() {
		for (Component com : pnButton.getComponents()) {
			ButtonRound btn = (ButtonRound) com;
			if (com instanceof ButtonRound) {
				((ButtonRound) com).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						control(btn.getText());
					}
				});
			}
		}
	}

	private void setNextId() {
		String maxId;

		maxId = NhanVienDao.getInstant().getMaxId();

		txtMaNV.setText(getNextId(maxId));
	}

	public String getNextId(String maxId) {
		if (maxId.length() < 4) {
			return " ";
		}
		String first = maxId.substring(0, 2);
		String middle = maxId.substring(2, maxId.length());
		Integer number = Integer.parseInt(middle);
		Integer log = number / 10;

		if (log == 0) {
			maxId = first + "0" + ++number;
		} else if (log > 10) {
			maxId = first + ++number;
		} else if (log > 0) {
			maxId = first + "0" + ++number;
		}

		return maxId;
	}

	private void clear() {

		setNextId();
		txtDiaChi.setText("");

		txtMatKhau.setText("");
		txtSDT.setText("");
		txtTenNV.setText("");

		dcNgaySinh.setDate(null);
		dcNgayVaoLam.setDate(XDate.now());

		cbNam.setSelected(true);
		cbNhanVien.setSelected(true);

		lblHinhAnh.setToolTipText("");
		lblHinhAnh.setImage(null);

		i = -1;
		updateStatus();
	}

	private void getViTri(String id) {
		if (id == null) {
			return;
		}
		for (NhanVien nv : list) {
			if (nv.getMaNV().equals(id)) {
				i = list.indexOf(nv);
				break;
			}
		}
	}

	private boolean validator() {
		boolean flag = true;
		String mess = "";

		if (Validator.isEmpty(txtTenNV)) {
			mess += "Bạn chưa nhập tên cho nhân viên \n";
			flag = false;
		} else {
			if (!Validator.isValidName(txtTenNV.getText())) {
				mess += "Tên không hợp lệ \n";
				flag = false;
			}
		}

		if (Validator.isEmpty(txtSDT)) {
			mess += "Bạn chưa nhập số điện thoại cho nhân viên \n";
			flag = false;
		} else {
			if (!Validator.isTel(txtSDT.getText())) {
				mess += "Số điện thoại không hợp lệ \n";
				flag = false;
			}
		}

		if (Validator.isEmpty(dcNgaySinh)) {
			mess += "Bạn chưa chọn ngày sinh của nhân viên \n";
			flag = false;
		} else {
			if (!Validator.isValidDate(dcNgaySinh.getDate())) {
				mess += "Nhân viên không đủ tuổi để làm việc phải lớn hơn 12 tuổi \n";
				flag = false;
			}
		}

		if (Validator.isEmpty(txtDiaChi)) {
			mess += "Bạn chưa nhập địa chỉ của nhân viên \n";
			flag = false;
		}

		if (Validator.isEmpty(txtMatKhau)) {
			mess += "Bạn chưa tạo mật khẩu cho nhân viên \n";
			flag = false;
		} else {
			if (!Validator.isValidPass(txtMatKhau.getText())) {
				mess += "Mật khẩu không hợp lệ \n";
				flag = false;
			}
		}

		if (!flag) {
			MsgBox.alert(this, mess);
		} else {
			if (lblHinhAnh.getToolTipText() == null || lblHinhAnh.getToolTipText().equals("")) {
				mess += "Bạn có chắt nhân viên này không cần hình ? \n";
				flag = MsgBox.confirm(this, mess);
			}
		}

		return flag;
	}

	private NhanVien getModel() {
		NhanVien nv = new NhanVien();
		nv.setMaNV(txtMaNV.getText());
		nv.setTenNV(txtTenNV.getText());
		nv.setSDT(txtSDT.getText());
		nv.setNgaySinh(dcNgaySinh.getDate());
		nv.setGioiTinh(cbNam.isSelected());
		nv.setVaiTro(cbQuanLi.isSelected() ? "Admin" : "User");
		nv.setNgayVaoLam(dcNgayVaoLam.getDate());
		nv.setDiaChi(txtDiaChi.getText());
		nv.setMatKhau(txtMatKhau.getText());
		nv.setHinhAnh(lblHinhAnh.getToolTipText());

		return nv;
	}

	private void handleInsert() {
		if (!validator()) {
			return;
		}

		NhanVien nv = getModel();

		if (nv == null) {
			return;
		}

		NhanVienDao.getInstant().insert(nv);
		MsgBox.alert(this, "Thêm thành công " + nv.getVaiTro() + " " + nv.getTenNV());
		clear();
		this.dispose();
		Store.nvView.fillDataTable();
	}

	private void handleUpdate() {
		if (!validator()) {
			return;
		}

		NhanVien nv = getModel();

		if (nv == null) {
			return;
		}

		NhanVienDao.getInstant().update(nv);
		MsgBox.alert(this, "Sửa thành công " + nv.getVaiTro() + " " + nv.getTenNV());
		clear();
		this.dispose();
		Store.nvView.fillDataTable();
	}

	public void enableRole() {
		if (Auth.user.getMaNV().equals(this.txtMaNV.getText())) {
			cbQuanLi.setEnabled(false);
			cbNhanVien.setEnabled(false);
		} else {
			cbQuanLi.setEnabled(true);
			cbNhanVien.setEnabled(true);
		}
	}
}
