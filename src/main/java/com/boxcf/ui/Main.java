package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.Cleaner;
import com.box.utils.MsgBox;
import com.box.utils.XImage;
import com.boxcf.models.NhanVien;
import com.boxcf.store.Store;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {

    NhanVienView nvView = new NhanVienView();
    SanPhamView spView = new SanPhamView();
    BoxView boxView = new BoxView();
    ComboView cbView = new ComboView();
    OrderView order;
    KhuyenMaiView kmView = new KhuyenMaiView();
    ThongKeView tkView;

    public Main() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel4 = new com.boxcf.components.GradientPanel();
        gradientPanel2 = new com.boxcf.components.GradientPanel();
        btnSanPham = new com.boxcf.components.ButtonRound();
        buttonRound2 = new com.boxcf.components.ButtonRound();
        btnBox = new com.boxcf.components.ButtonRound();
        buttonRound4 = new com.boxcf.components.ButtonRound();
        buttonRound5 = new com.boxcf.components.ButtonRound();
        btnNhanVien = new com.boxcf.components.ButtonRound();
        buttonRound8 = new com.boxcf.components.ButtonRound();
        buttonRound9 = new com.boxcf.components.ButtonRound();
        buttonRound10 = new com.boxcf.components.ButtonRound();
        buttonRound11 = new com.boxcf.components.ButtonRound();
        buttonRound12 = new com.boxcf.components.ButtonRound();
        jLabel2 = new javax.swing.JLabel();
        avatar = new com.boxcf.components.ImageAvatar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        btnClose = new com.boxcf.components.ButtonRound();
        lblId = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradientPanel4.setColor1(new java.awt.Color(109, 191, 184));
        gradientPanel4.setColor2(new java.awt.Color(109, 191, 184));
        gradientPanel4.setPreferredSize(new java.awt.Dimension(1200, 750));

        gradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        gradientPanel2.setColor1(new java.awt.Color(109, 191, 184));
        gradientPanel2.setColor2(new java.awt.Color(109, 191, 184));
        gradientPanel2.setOpaque(true);
        gradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/iftar.png"))); // NOI18N
        btnSanPham.setText("Sản phẩm");
        btnSanPham.setFocusPainted(false);
        btnSanPham.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnSanPham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSanPham.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });
        gradientPanel2.add(btnSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, 70));

        buttonRound2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/coffee-menu (1).png"))); // NOI18N
        buttonRound2.setText("Order");
        buttonRound2.setFocusPainted(false);
        buttonRound2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        buttonRound2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRound2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });
        gradientPanel2.add(buttonRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 70));

        btnBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/cardboard.png"))); // NOI18N
        btnBox.setText("Box");
        btnBox.setFocusPainted(false);
        btnBox.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoxActionPerformed(evt);
            }
        });
        gradientPanel2.add(btnBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 70));

        buttonRound4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/combo.png"))); // NOI18N
        buttonRound4.setText("Combo");
        buttonRound4.setFocusPainted(false);
        buttonRound4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        buttonRound4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRound4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRound4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound4ActionPerformed(evt);
            }
        });
        gradientPanel2.add(buttonRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 90, 70));

        buttonRound5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/price-tag.png"))); // NOI18N
        buttonRound5.setText("Khuyến mãi");
        buttonRound5.setFocusPainted(false);
        buttonRound5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        buttonRound5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRound5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRound5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound5ActionPerformed(evt);
            }
        });
        gradientPanel2.add(buttonRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 70));

        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/barista.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setFocusPainted(false);
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhanVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        gradientPanel2.add(btnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 90, 70));

        buttonRound8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/back.png"))); // NOI18N
        buttonRound8.setText("Đăng xuất");
        buttonRound8.setFocusPainted(false);
        buttonRound8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonRound8.setIconTextGap(12);
        buttonRound8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound8ActionPerformed(evt);
            }
        });
        gradientPanel2.add(buttonRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 190, 40));

        buttonRound9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/growth.png"))); // NOI18N
        buttonRound9.setText("Thống kê");
        buttonRound9.setFocusPainted(false);
        buttonRound9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        buttonRound9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRound9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRound9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound9ActionPerformed(evt);
            }
        });
        gradientPanel2.add(buttonRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 70));

        buttonRound10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/growth.png"))); // NOI18N
        buttonRound10.setText("Thống kê");
        buttonRound10.setFocusPainted(false);
        buttonRound10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRound10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gradientPanel2.add(buttonRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 70));

        buttonRound11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/help-desk (1).png"))); // NOI18N
        buttonRound11.setText("Hướng dẫn");
        buttonRound11.setFocusPainted(false);
        buttonRound11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        buttonRound11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRound11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRound11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound11ActionPerformed(evt);
            }
        });
        gradientPanel2.add(buttonRound11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 90, 70));

        buttonRound12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/growth.png"))); // NOI18N
        buttonRound12.setText("Thống kê");
        buttonRound12.setFocusPainted(false);
        buttonRound12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRound12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gradientPanel2.add(buttonRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 90, 70));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BOX COFFEE");

        avatar.setForeground(new java.awt.Color(51, 51, 51));
        avatar.setGradientColor1(new java.awt.Color(255, 255, 255));
        avatar.setGradientColor2(new java.awt.Color(255, 255, 255));
        avatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("UTM Caviar", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã NV:");

        jLabel5.setFont(new java.awt.Font("UTM Caviar", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Chức vụ:");

        pnlContent.setBackground(new java.awt.Color(241, 248, 248));

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/exit (1).png"))); // NOI18N
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("jLabel1");

        lblRole.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("jLabel3");

        javax.swing.GroupLayout gradientPanel4Layout = new javax.swing.GroupLayout(gradientPanel4);
        gradientPanel4.setLayout(gradientPanel4Layout);
        gradientPanel4Layout.setHorizontalGroup(
            gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel4Layout.createSequentialGroup()
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addComponent(gradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        gradientPanel4Layout.setVerticalGroup(
            gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel4Layout.createSequentialGroup()
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel4Layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel4Layout.createSequentialGroup()
                                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblId))
                                .addGap(4, 4, 4)
                                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lblRole))
                                .addGap(18, 18, 18)))))
                .addGroup(gradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(gradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1300, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        if (!Auth.accept(this)) {
            return;
        }
        this.hidden(spView, boxView, kmView, tkView, cbView);
        this.active(nvView);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        this.hidden(boxView, nvView, kmView, tkView, cbView);
        this.active(spView);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoxActionPerformed

        this.hidden(spView, nvView, kmView, tkView, cbView);
        this.active(boxView);
    }//GEN-LAST:event_btnBoxActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        this.openOrder();
    }//GEN-LAST:event_buttonRound2ActionPerformed

    private void buttonRound5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound5ActionPerformed
        this.hidden(spView, nvView, boxView, tkView, cbView);
        this.active(kmView);
    }//GEN-LAST:event_buttonRound5ActionPerformed

    private void buttonRound9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound9ActionPerformed
        if (!Auth.accept(this)) {
            return;
        }

        this.hidden(spView, nvView, boxView, kmView, cbView);
        tkView = new ThongKeView();

        this.active(tkView);


    }//GEN-LAST:event_buttonRound9ActionPerformed

    private void buttonRound8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound8ActionPerformed
        handleLogout();
    }//GEN-LAST:event_buttonRound8ActionPerformed

    private void avatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatarMouseClicked
        handleRefreshPass();
    }//GEN-LAST:event_avatarMouseClicked

    private void buttonRound11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound11ActionPerformed
        handleHelp();
    }//GEN-LAST:event_buttonRound11ActionPerformed

    private void buttonRound4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound4ActionPerformed
        this.hidden(spView, boxView, kmView, tkView, nvView);
        this.active(cbView);
    }//GEN-LAST:event_buttonRound4ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    //hover
    public void hover() {
        Component[] cpns = gradientPanel2.getComponents();
        for (Component cpn : cpns) {

            if (cpn instanceof JButton) {
                cpn.setBackground(Color.decode("#F0F0F0"));
                cpn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        ((JButton) cpn).setOpaque(true);
                        cpn.setBackground(Color.decode("#9ce2c6"));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        ((JButton) cpn).setOpaque(false);
                        cpn.setBackground(Color.decode("#F0F0F0"));
                    }
                });
            }
        }
    }

    private void prepareUI() {
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
        this.hover();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        Store.globelMain = this;
        Store.kmView = kmView;
        this.prepareUI();
        handleClener();
        initAvatar();
        this.active(spView);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ImageAvatar avatar;
    private com.boxcf.components.ButtonRound btnBox;
    private com.boxcf.components.ButtonRound btnClose;
    private com.boxcf.components.ButtonRound btnNhanVien;
    private com.boxcf.components.ButtonRound btnSanPham;
    private com.boxcf.components.ButtonRound buttonRound10;
    private com.boxcf.components.ButtonRound buttonRound11;
    private com.boxcf.components.ButtonRound buttonRound12;
    private com.boxcf.components.ButtonRound buttonRound2;
    private com.boxcf.components.ButtonRound buttonRound4;
    private com.boxcf.components.ButtonRound buttonRound5;
    private com.boxcf.components.ButtonRound buttonRound8;
    private com.boxcf.components.ButtonRound buttonRound9;
    private com.boxcf.components.GradientPanel gradientPanel2;
    private com.boxcf.components.GradientPanel gradientPanel4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables

    private void activeUI(JFrame jframe) {
        jframe.setVisible(true);
    }

    private void openOrder() {
        order = new OrderView();
        order.setVisible(true);
    }

    private void hidden(JPanel... jpanel) {
        for (JPanel pnl : jpanel) {
            if (pnl != null) {
                pnl.setVisible(false);
            }
        }
    }

    private void active(JPanel jpanel) {
        pnlContent.add(jpanel);
        jpanel.setSize(pnlContent.getWidth(), pnlContent.getHeight());
        jpanel.setVisible(true);
    }

    private void initAvatar() {
        NhanVien nv = Auth.user;
        String url = nv.getHinhAnh();
        if (url != null) {
            ImageIcon icon = XImage.read(url);
            Image img = XImage.resize(icon.getImage(), avatar.getWidth(), avatar.getHeight());
            icon = new ImageIcon(img);
            avatar.setImage(icon);
        } else {
            avatar.setImage(null);
        }
        lblId.setText(nv.getMaNV());
        lblRole.setText(nv.getVaiTro());
    }

    private void handleClener() {
        new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    Thread.sleep(10000);
                    Cleaner.start();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }

        }.start();
    }

    private void handleLogout() {
        boolean flag = MsgBox.confirm(this, "Bạn sẽ không thể thao tác với tài khoản này khi đăng xuất  ");

        if (flag) {
            Auth.clear();
            this.dispose();
            new DangNhapView().setVisible(true);
        }
    }

    private void handleRefreshPass() {
        new DoiMatKhauView().setVisible(true);
    }

    private void handleHelp() {
        try {
            String url = "help/index.html";
            File file = new File(url);
            Desktop.getDesktop().browse(file.toURI());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
