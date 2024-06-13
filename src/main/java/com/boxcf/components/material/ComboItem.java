/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.boxcf.components.material;

import com.box.utils.Formats;
import com.boxcf.constands.BoxState;
import com.boxcf.models.ModelItem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ComboItem extends javax.swing.JPanel {
    
    boolean selected;
    private ModelItem combo;
    
    public ComboItem() {
        initComponents();
        setOpaque(false);
        init();
    }
    
    public ModelItem getData() {
        return combo;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    
    
    public void setData(ModelItem combo) {
        this.combo = combo;
        lblMaCB.setText(combo.getMaItem().toString());
        lblTenCB.setText(combo.getTen());
        lblGia.setText(Formats.toCurency(combo.getGia()));
        lblSLDoUong.setText(String.valueOf(combo.getSLDoUong()));
        lblSLDoAn.setText(String.valueOf(combo.getSLDoAn()));
        this.repaint();
    }
    
    private void init() {
    }
    
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(109, 191, 184));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        if (selected) {
            g2.setColor(new Color(251, 210, 105));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        }
        g2.dispose();
        super.paint(grphcs);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTenCB = new javax.swing.JLabel();
        lblMaCB = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        lblGia2 = new javax.swing.JLabel();
        lblGia3 = new javax.swing.JLabel();
        lblSLDoAn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSLDoUong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 150, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(230, 200));
        setPreferredSize(new java.awt.Dimension(230, 200));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenCB.setFont(new java.awt.Font("UTM Aptima", 1, 18)); // NOI18N
        lblTenCB.setForeground(new java.awt.Color(255, 255, 255));
        lblTenCB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenCB.setText("Combo1");
        add(lblTenCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 30));

        lblMaCB.setBackground(new java.awt.Color(0, 0, 255));
        lblMaCB.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblMaCB.setForeground(new java.awt.Color(255, 255, 255));
        lblMaCB.setText("CB001S");
        add(lblMaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        lblGia.setBackground(new java.awt.Color(255, 255, 255));
        lblGia.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblGia.setForeground(new java.awt.Color(0, 51, 51));
        lblGia.setText("50.000");
        add(lblGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 100, 30));

        lblGia2.setFont(new java.awt.Font("UTM Aptima", 0, 18)); // NOI18N
        lblGia2.setForeground(new java.awt.Color(0, 51, 51));
        lblGia2.setText("SL đồ ăn");
        add(lblGia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 80, 20));

        lblGia3.setFont(new java.awt.Font("UTM Aptima", 0, 18)); // NOI18N
        lblGia3.setForeground(new java.awt.Color(0, 51, 51));
        lblGia3.setText("SL đồ uống");
        add(lblGia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 30));

        lblSLDoAn.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblSLDoAn.setForeground(new java.awt.Color(0, 51, 51));
        lblSLDoAn.setText("0");
        add(lblSLDoAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 70, 40));

        jLabel1.setFont(new java.awt.Font("UTM Aptima", 0, 18)); // NOI18N
        jLabel1.setText("Giá");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, -1));

        lblSLDoUong.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblSLDoUong.setForeground(new java.awt.Color(0, 51, 51));
        lblSLDoUong.setText("0");
        add(lblSLDoUong, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 70, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblGia2;
    private javax.swing.JLabel lblGia3;
    private javax.swing.JLabel lblMaCB;
    private javax.swing.JLabel lblSLDoAn;
    private javax.swing.JLabel lblSLDoUong;
    private javax.swing.JLabel lblTenCB;
    // End of variables declaration//GEN-END:variables

}
