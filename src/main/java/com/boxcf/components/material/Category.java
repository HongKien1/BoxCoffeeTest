package com.boxcf.components.material;

import com.boxcf.models.LoaiBox;
import com.boxcf.models.LoaiSP;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author PC
 */
public class Category extends javax.swing.JPanel {
    
    private LoaiSP dataProduct;
    private LoaiBox dataBox;
    private String loai;
    private boolean active;
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
        if (active) {
            lblTitle.setForeground(new Color(56, 187, 156));
            lblTitle.setBorder(new MatteBorder(0, 0, 1, 0, new Color(56, 187, 156)));
        } else {
            lblTitle.setForeground(new Color(102, 102, 102));
            lblTitle.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0, 0)));
        }
        repaint();
    }
    
    public LoaiSP getData() {
        return dataProduct;
    }
    
    public LoaiSP getDataProduct() {
        return dataProduct;
    }
    
    public void setDataProduct(LoaiSP dataProduct) {
        this.dataProduct = dataProduct;
    }
    
    public LoaiBox getDataBox() {
        return dataBox;
    }
    
    public void setDataBox(LoaiBox dataBox) {
        this.dataBox = dataBox;
    }
    
    public void setData(LoaiSP data) {
        this.dataProduct = data;
    }
    
    public void setData(LoaiBox data) {
        this.dataBox = data;
    }
    
    public JLabel getLblTitle() {
        return lblTitle;
    }
    
    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    
    
    public Category() {
        initComponents();
    }
    
    public void addData(LoaiSP dataProduct, LoaiBox dataBox) {
        this.dataProduct = dataProduct;
        this.dataBox = dataBox;
        lblTitle.setText(dataProduct.getTenLoai());
    }
    
    public void addData(LoaiSP data) {
        this.dataProduct = data;
        lblTitle.setText(data.getTenLoai());
    }
    
    public void addData(String data) {
        this.loai = data;
        lblTitle.setText(loai);
    }
    
    public void addData(LoaiBox data) {
        this.dataBox = data;
        lblTitle.setText(data.getTenLoaiBox());
    }
    
    private boolean toggleResult(boolean value) {
        return !value;
    }
    
    public void toggleActive() {
        setActive(toggleResult(active));
    }
    
    @Override
    public String toString() {
        return "Category{" + "dataProduct=" + dataProduct + ", dataBox=" + dataBox + ", active=" + active + '}';
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(120, 30));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(120, 30));

        lblTitle.setFont(new java.awt.Font("UTM Aptima", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("jLabel1");
        lblTitle.setMinimumSize(new java.awt.Dimension(41, 30));
        lblTitle.setPreferredSize(new java.awt.Dimension(41, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}