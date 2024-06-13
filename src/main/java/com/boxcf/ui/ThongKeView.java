package com.boxcf.ui;

import com.boxcf.components.material.CategoryChartItem;
import com.boxcf.components.material.OverviewItem;
import com.boxcf.constands.Messages;
import com.boxcf.dao.ThongKeDao;
import com.boxcf.models.ModelOverview;
import com.boxcf.models.ModelStatistical;
import com.boxcf.store.Store;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author HP
 */
public class ThongKeView extends javax.swing.JPanel {

    private ThongKeDao dTk = ThongKeDao.getInstant();
    List<ModelStatistical> list = null;

    public final String dt = "Doanh Thu";
    public final String spbc = "Sản Phẩm Bán Chạy";
    public final String dsnv = "Doanh Số Nhân Viên";
    public final String lshd = "Lịch Sử Bán Hàng";

    public ThongKeView() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlOrverview = new javax.swing.JPanel();
        gradientPanel1 = new com.boxcf.components.GradientPanel();
        chart = new com.raven.chart.Chart();
        cboTime = new com.boxcf.components.Combobox();
        lblTitleChart = new javax.swing.JLabel();
        btnDetail = new javax.swing.JLabel();
        pnlCategoryChart = new com.boxcf.components.GradientPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TỔNG QUAN");

        pnlOrverview.setBackground(new java.awt.Color(255, 255, 255));
        pnlOrverview.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 12, 5));

        gradientPanel1.setColor1(new java.awt.Color(240, 240, 240));
        gradientPanel1.setColor2(new java.awt.Color(240, 240, 240));

        chart.setBackground(new java.awt.Color(240, 240, 240));

        cboTime.setBackground(new java.awt.Color(240, 240, 240));
        cboTime.setFocusable(false);
        cboTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimeActionPerformed(evt);
            }
        });

        lblTitleChart.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        lblTitleChart.setForeground(new java.awt.Color(57, 196, 138));
        lblTitleChart.setText("jLabel3");

        btnDetail.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        btnDetail.setForeground(new java.awt.Color(51, 51, 51));
        btnDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDetail.setText("Chi Tiết ");
        btnDetail.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetail.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitleChart, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitleChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(btnDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCategoryChart.setColor1(new java.awt.Color(240, 240, 240));
        pnlCategoryChart.setColor2(new java.awt.Color(240, 240, 240));
        pnlCategoryChart.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlCategoryChart, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addComponent(pnlOrverview, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(pnlOrverview, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCategoryChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimeActionPerformed
        renderDataChart();
    }//GEN-LAST:event_cboTimeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDetail;
    private com.boxcf.components.Combobox cboTime;
    private com.raven.chart.Chart chart;
    private com.boxcf.components.GradientPanel gradientPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitleChart;
    private com.boxcf.components.GradientPanel pnlCategoryChart;
    private javax.swing.JPanel pnlOrverview;
    // End of variables declaration//GEN-END:variables

    private void init() {
        Store.tkView = this;
        initDataOrveview();
        renderDataCboTime(dt);
        chart.addLegend(cboTime.getSelectedItem().toString(), new Color(139, 229, 222));
        initCategory();
        initDetailButton();

    }

    public List<ModelStatistical> getList() {
        return list;
    }

    public void setList(List<ModelStatistical> list) {
        this.list = list;
    }

    private void initDataOrveview() {
        ArrayList<ModelOverview> list = new ArrayList<>();
        list.add(new ModelOverview("Doanh thu / ngày", dTk.revenueOfTheDay(), "/com/boxcf/images/icon/carts (3).png"));
        list.add(new ModelOverview("Sản phẩm / ngày", dTk.productOfTheDay(), "/com/boxcf/images/icon/iftar.png "));
        list.add(new ModelOverview("Box / ngày", dTk.boxOfTheDay(), "/com/boxcf/images/icon/cardboard.png "));
        list.add(new ModelOverview("Combo / ngày", dTk.comboOfTheDay(), "/com/boxcf/images/icon/combo.png "));

        for (ModelOverview md : list) {
            OverviewItem item = new OverviewItem();
            item.addData(md);
            pnlOrverview.add(item);
        }

        chart.start();
    }

    private void renderDataChart() {

        chart.clear();

        if (cboTime.getSelectedItem() == null) {
            return;
        }

        if (cboTime.getSelectedItem() instanceof ModelStatistical) {
            ModelStatistical mdCbo = (ModelStatistical) cboTime.getSelectedItem();

            chart.setLegend(cboTime.getSelectedItem().toString());
            lblTitleChart.setText(Messages.chartMess(mdCbo));

            if (mdCbo.getCategory() == null) {
                return;
            }

            if (mdCbo.getType().equals("period")) {
                Store.chart = chart;
                new ChonKhoanThoiGianView(mdCbo).setVisible(true);
                return;
            }

            if (mdCbo.getCategory().equalsIgnoreCase(dt)) {

                list = dTk.revenue(mdCbo.getType());

            } else if (mdCbo.getCategory().equalsIgnoreCase(spbc)) {

                list = dTk.product(mdCbo.getType());

            } else if (mdCbo.getCategory().equalsIgnoreCase(dsnv)) {

                list = dTk.staff(mdCbo.getType());

            } else {
                chart.clear();
            }

            if (list == null) {
                return;
            }

            for (ModelStatistical md : list) {
                chart.addData(new ModelChart(md.getTitle().length() > 10 ? md.getTitle().substring(0, 10) + "..." : md.getTitle(), new double[]{md.getNum()}));
            }

            chart.start();

        }

    }

    private void renderDataCboTime(String categoryTile) {
        ArrayList<ModelStatistical> list = new ArrayList<>();

        if (!categoryTile.equals(lshd)) {
            list.add(new ModelStatistical("7 Ngày trước", 7, "day", categoryTile));
            list.add(new ModelStatistical("7 Tháng trước", 7, "month", categoryTile));
            list.add(new ModelStatistical("7 năm gần nhất", 7, "year", categoryTile));
            list.add(new ModelStatistical("Khoản thời gian", 0, "period", categoryTile));

        } else {
            chart.clear();
            chart.setLegend("");
        }

        cboTime.removeAllItems();
        for (ModelStatistical md : list) {
            cboTime.addItem(md);
        }
        ModelStatistical mdMess = (ModelStatistical) cboTime.getSelectedItem();
        lblTitleChart.setText(Messages.chartMess(mdMess));

    }

    public void clearActiveCategory() {
        for (Component com : pnlCategoryChart.getComponents()) {
            if (com instanceof CategoryChartItem) {
                CategoryChartItem item = (CategoryChartItem) com;
                item.setActive(false);
            }
        }
    }

    private void initCategory() {
        ArrayList<ModelStatistical> list = new ArrayList<>();

        list.add(new ModelStatistical(dt, "dt"));
        list.add(new ModelStatistical(spbc, "spbc"));
        list.add(new ModelStatistical(dsnv, "dsbc"));
        list.add(new ModelStatistical(lshd, "lsbh"));
        for (ModelStatistical md : list) {
            CategoryChartItem item = new CategoryChartItem();
            item.addData(md);
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clearActiveCategory();
                    item.setActive(true);
                    if (item.isActive()) {
                        renderDataCboTime(item.getData().getCategory());
                    }


                    if (item.isActive() && item.getData().getCategory().equals(lshd)) {
                        new LichSuBanHangView().setVisible(true);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    item.hoverIn();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    item.hoverOut();
                }

            });
            pnlCategoryChart.add(item);
        }

        CategoryChartItem item = (CategoryChartItem) pnlCategoryChart.getComponents()[0];
        item.setActive(true);
    }

    public JLabel getLblTitleChart() {
        return lblTitleChart;
    }

    public void setLblTitleChart(JLabel lblTitleChart) {
        this.lblTitleChart = lblTitleChart;
    }

    public void initDetailButton() {
        btnDetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ModelStatistical mdCbo = (ModelStatistical) cboTime.getSelectedItem();
                if (mdCbo != null) {
                    new ChiTietThongKeView(list, mdCbo).setVisible(true);

                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDetail.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0, 0)));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnDetail.setBorder(new MatteBorder(0, 0, 1, 0, new Color(57, 198, 138)));
            }

        });
    }
}
