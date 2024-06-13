
package com.boxcf.ui;

import com.box.utils.Auth;
import com.box.utils.MsgBox;
import com.box.utils.Validator;
import com.boxcf.dao.NhanVienDao;
import com.boxcf.models.NhanVien;
import java.awt.geom.RoundRectangle2D;

public class DangNhapView extends javax.swing.JFrame {


    public DangNhapView() {
        initComponents();
        init();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new com.boxcf.components.GradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new com.boxcf.components.TextField();
        txtPassword = new com.boxcf.components.PasswordField();
        buttonRound1 = new com.boxcf.components.ButtonRound();
        clsoeButton1 = new com.boxcf.components.ClsoeButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gradientPanel1.setColor1(new java.awt.Color(254, 254, 254));
        gradientPanel1.setColor2(new java.awt.Color(254, 254, 254));
        gradientPanel1.setPreferredSize(new java.awt.Dimension(476, 320));
        gradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("UTM BryantLG", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ĐĂNG NHẬP");
        gradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 25, -1, -1));

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setLabelText("Mã nhân viên");
        gradientPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 71, 400, 54));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setLabelText("Mật khẩu");
        gradientPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 154, 400, -1));

        buttonRound1.setBackground(new java.awt.Color(109, 191, 184));
        buttonRound1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound1.setText("ĐĂNG NHẬP");
        buttonRound1.setFocusable(false);
        buttonRound1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });
        gradientPanel1.add(buttonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 240, 400, 43));

        clsoeButton1.setBackground(new java.awt.Color(255, 255, 255));
        clsoeButton1.setMinimumSize(new java.awt.Dimension(30, 30));
        clsoeButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        gradientPanel1.add(clsoeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 40, 40));
        clsoeButton1.getAccessibleContext().setAccessibleName("");

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
        handleLogin();
    }//GEN-LAST:event_buttonRound1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ButtonRound buttonRound1;
    private com.boxcf.components.ClsoeButton clsoeButton1;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private com.boxcf.components.PasswordField txtPassword;
    private com.boxcf.components.TextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void init() {
        clsoeButton1.initEvent(this);
        prepareUI();
    }
    
    private void prepareUI() {
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public boolean validator() {
        boolean flag = true;
        String mess = "";
        
        if (Validator.isEmpty(txtUsername)) {
            mess += "Bạn chưa nhập username \n";
            flag = false;
        }
        
        if (Validator.isEmpty(txtPassword)) {
            mess += "Bạn chưa nhập password \n";
            flag = false;
        }
        
        if (!flag) {
            MsgBox.alert(this, mess);
            return flag;
        }
        
        return flag;
    }
    
    public void handleLogin() {
        NhanVien user = null;
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        if (!validator()) {
            return;
        }
        
        user = NhanVienDao.getInstant().login(username, password);
        
        if (user == null) {
            MsgBox.alert(this, "Mã nhân viên hoặc mật khẩu không đúng !");
            return;
        }
        
        Auth.user = user;
        this.dispose();
        new Main().setVisible(true);
        
    }
}
