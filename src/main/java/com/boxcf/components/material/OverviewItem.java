/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.boxcf.components.material;

import com.box.utils.Formats;
import com.box.utils.Validator;
import com.boxcf.models.ModelOverview;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.graphics.ShadowRenderer;

/**
 *
 * @author PC
 */
public class OverviewItem extends javax.swing.JPanel {

    public OverviewItem() {
        initComponents();
        setOpaque(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnImage = new com.boxcf.components.CircelButton();
        lblNum = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setMinimumSize(new java.awt.Dimension(244, 100));
        setPreferredSize(new java.awt.Dimension(244, 100));

        btnImage.setBackground(new java.awt.Color(57, 196, 138));
        btnImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/boxcf/images/icon/carts (3).png"))); // NOI18N
        btnImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblNum.setFont(new java.awt.Font("UTM Aptima", 1, 18)); // NOI18N
        lblNum.setForeground(new java.awt.Color(57, 196, 138));
        lblNum.setText("630.000");

        lblTitle.setFont(new java.awt.Font("UTM Aptima", 0, 14)); // NOI18N
        lblTitle.setText("DOANH THU");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btnImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.boxcf.components.CircelButton btnImage;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables

    private void init() {
    }

    public void addData(ModelOverview data) {

        btnImage.setIcon(new ImageIcon(getClass().getResource(data.getImage())));
        lblNum.setText(data.getNum() <= 0 ? 0 + " VND" : Formats.toCurency(data.getNum()));
        lblTitle.setText(data.getTitle());
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        g2.dispose();
        super.paint(grphcs);
    }

}
