/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.boxcf.ui;

import com.box.utils.Formats;
import com.box.utils.Validator;
import com.box.utils.XDate;
import com.boxcf.components.ScrollBar;
import com.boxcf.dao.ThongKeDao;
import com.boxcf.models.ModelStatistical;
import com.boxcf.models.ThongKeNhanVien;
import com.boxcf.models.ThongKeSanPham;
import com.boxcf.store.Store;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ChiTietThongKeView extends javax.swing.JDialog {

    private List<ModelStatistical> list;
    private ModelStatistical data;
    private DefaultTableModel modelTable;
    private ThongKeView tkView = Store.tkView;
    private ThongKeDao dTk = ThongKeDao.getInstant();
    private final String dt = tkView.dt;
    private final String spbc = tkView.spbc;
    private final String dsnv = tkView.dsnv;

    public ChiTietThongKeView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    public ChiTietThongKeView(List<ModelStatistical> list, ModelStatistical data) {
        super(Store.globelMain, true);
        this.list = list;
        this.data = data;
        initComponents();
        init();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPanel1 = new com.boxcf.components.GradientPanel();
        gradientPanel2 = new com.boxcf.components.GradientPanel();
        clsoeButton1 = new com.boxcf.components.ClsoeButton();
        jLabel1 = new javax.swing.JLabel();
        lblTitleChart = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblTableData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        gradientPanel1.setColor1(new java.awt.Color(102, 102, 102));
        gradientPanel1.setColor2(new java.awt.Color(102, 102, 102));

        gradientPanel2.setColor1(new java.awt.Color(245, 250, 255));
        gradientPanel2.setColor2(new java.awt.Color(245, 250, 255));

        clsoeButton1.setBackground(new java.awt.Color(245, 250, 255));
        clsoeButton1.setDoubleBuffered(false);
        clsoeButton1.setFocusCycleRoot(true);
        clsoeButton1.setRequestFocusEnabled(false);
        clsoeButton1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 48, 84));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi Tiết");

        lblTitleChart.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        lblTitleChart.setForeground(new java.awt.Color(57, 196, 138));
        lblTitleChart.setText("jLabel3");

        tblTableData.setFont(new java.awt.Font("UTM BryantLG", 1, 16)); // NOI18N
        tblTableData.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTableData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTableData.setGridColor(new java.awt.Color(204, 204, 204));
        tblTableData.setRowHeight(30);
        tblTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableDataMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTableDataMousePressed(evt);
            }
        });
        scroll.setViewportView(tblTableData);

        javax.swing.GroupLayout gradientPanel2Layout = new javax.swing.GroupLayout(gradientPanel2);
        gradientPanel2.setLayout(gradientPanel2Layout);
        gradientPanel2Layout.setHorizontalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gradientPanel2Layout.createSequentialGroup()
                        .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
                            .addComponent(lblTitleChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(gradientPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(335, 335, 335)
                        .addComponent(clsoeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        gradientPanel2Layout.setVerticalGroup(
            gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clsoeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTitleChart, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(gradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableDataMouseClicked

    }//GEN-LAST:event_tblTableDataMouseClicked

    private void tblTableDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableDataMousePressed

    }//GEN-LAST:event_tblTableDataMousePressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietThongKeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietThongKeView dialog = new ChiTietThongKeView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.ClsoeButton clsoeButton1;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private com.boxcf.components.GradientPanel gradientPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitleChart;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblTableData;
    // End of variables declaration//GEN-END:variables

    private void init() {
        clsoeButton1.initEvent(this);
        prepareUI();
        initTable();
        renderDataTable();
        lblTitleChart.setText(tkView.getLblTitleChart().getText());

    }

    private void prepareUI() {
        scroll.setVerticalScrollBar(new ScrollBar());
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        this.setShape(shape);
    }

    public void initTable() {
        modelTable = (DefaultTableModel) this.tblTableData.getModel();

        String[] cols = null;
        if (data.getCategory().equals(dt)) {
            cols = new String[]{"STT", "Thời Gian", "Doanh Số"};
        } else if (data.getCategory().equals(spbc)) {
            cols = new String[]{"STT", "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng"};
        } else if (data.getCategory().equals(dsnv)) {
            cols = new String[]{"STT", "Mã Nhân viên", "Tên nhân viên", "Ngày vào làm", "Số lượng"};
        }
        modelTable.setColumnIdentifiers(cols);

    }

    private void renderDataTable() {
        modelTable.setRowCount(0);
        int i = 1;

        for (ModelStatistical md : list) {
            if (md.getData() instanceof ThongKeSanPham) {
                ThongKeSanPham sp = (ThongKeSanPham) md.getData();
                Object row[] = {i, sp.getMaSP(), sp.getTenSP(), sp.getGia(), sp.getSoluong()};
                modelTable.addRow(row);
            } else if (md.getData() instanceof ThongKeNhanVien) {
                ThongKeNhanVien nv = (ThongKeNhanVien) md.getData();
                Object row[] = {i, nv.getMaNV(), nv.getTenNV(), XDate.toString(nv.getNgayVaoLam(), Store.partten), nv.getSoluong()};
                modelTable.addRow(row);
            } else {

                String time = "";
                if (Validator.isInt(md.getTitle()) && Integer.parseInt(md.getTitle()) <= 12) {
                    time = "Tháng " + md.getTitle();
                } else {
                    time = md.getTitle();
                }
                Object row[] = {i, time, Formats.toCurency(md.getNum())};
                modelTable.addRow(row);
            }
            i++;
        }

    }

}
