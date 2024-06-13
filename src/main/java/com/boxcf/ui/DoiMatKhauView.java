
package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.Validator;
import com.boxcf.dao.NhanVienDao;
import com.boxcf.models.NhanVien;
import com.boxcf.store.Store;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.Array;
import java.util.Arrays;

public class DoiMatKhauView extends javax.swing.JFrame {

    public DoiMatKhauView() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new com.boxcf.components.GradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOldPass = new com.boxcf.components.PasswordField();
        buttonRound1 = new com.boxcf.components.ButtonRound();
        txtNewPass = new com.boxcf.components.PasswordField();
        txtComfirm = new com.boxcf.components.PasswordField();
        clsoeButton1 = new com.boxcf.components.ClsoeButton();
        txtId = new com.boxcf.components.TextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientPanel1.setColor1(new java.awt.Color(254, 254, 254));
        gradientPanel1.setColor2(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("UTM BryantLG", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ĐỔI MẬT KHẨU");

        txtOldPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOldPass.setLabelText("Mật khẩu cũ");

        buttonRound1.setBackground(new java.awt.Color(109, 191, 184));
        buttonRound1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound1.setText("ĐỔI MẬT KHẨU");
        buttonRound1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

        txtNewPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNewPass.setLabelText("Mật khẩu mới");

        txtComfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtComfirm.setLabelText("Xác nhận mật khẩu");

        clsoeButton1.setBackground(new java.awt.Color(255, 255, 255));

        txtId.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        txtId.setLabelText("");
        txtId.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Mã Nhân Viên");

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clsoeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradientPanel1Layout.createSequentialGroup()
                        .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOldPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(txtNewPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtComfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(clsoeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(txtComfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        handleRefresh();
    }//GEN-LAST:event_buttonRound1ActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhauView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound buttonRound1;
    private com.boxcf.components.ClsoeButton clsoeButton1;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.boxcf.components.PasswordField txtComfirm;
    private com.boxcf.components.TextField txtId;
    private com.boxcf.components.PasswordField txtNewPass;
    private com.boxcf.components.PasswordField txtOldPass;
    // End of variables declaration//GEN-END:variables

    private void init() {
        prepareUI();
        clsoeButton1.initEvent(this);
        showInfo();
    }

    private void prepareUI() {
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }

    private void showInfo() {
        NhanVien nv = Auth.user;
        txtId.setText(nv.getMaNV());
    }

    private boolean validator() {
        boolean flag = true;
        String mess = "";

        if (Validator.isEmpty(txtOldPass)) {
            mess += "Bạn chưa nhập mật khẩu củ   \n";
            flag = false;
        }

        if (Validator.isEmpty(txtNewPass)) {
            mess += "Bạn chưa nhập mật khẩu mới   \n";
            flag = false;
        } else {
            if (!Validator.isValidPass(new String(txtNewPass.getPassword()))) {
                mess += "Mật khẩu phải từ 6 - 15 kí tự ! \n";
                flag = false;
            }
        }

        if (flag) {
            char[] newpass = txtNewPass.getPassword();
            char[] comfir = txtComfirm.getPassword();

            if (!Arrays.equals(newpass, comfir)) {
                mess += "Xác nhận mật khẩu không chính xác ! \n";
                flag = false;
            }

            if (!new String(txtOldPass.getPassword()).equals(Auth.user.getMatKhau())) {
                mess += "Mật khẩu không chính xác ! \n";
                flag = false;
            }
        }

        if (!flag) {
            MsgBox.alert(this, mess);
        }

        return flag;
    }

    private void handleRefresh() {
        if (!validator()) {
            return;
        }

        NhanVienDao dnv = NhanVienDao.getInstant();
        boolean responce = dnv.refreshPass(txtId.getText(), new String(txtNewPass.getPassword()));

        if (responce) {
            MsgBox.alert(this, "Cập nhật mật khẩu thành công !, Vui long đăng nhập lại");
            this.dispose();
            Store.globelMain.dispose();
            new DangNhapView().setVisible(true);
            return;
        }
        MsgBox.alert(this, "Cập nhật mật khẩu không thành công !");
    }

}
