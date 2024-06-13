/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import java.util.Date;


public class BoxModelItem {
    int maBox;
    String TenBox;
    int MaDat;
    Date gioBD;
    Date gioKT;
    String trangThai;
    int soGio;
    LoaiBox loaiBox;
    boolean selected;

    public BoxModelItem() {
    }

    public BoxModelItem(String tenBox, String trangThai, LoaiBox loaiBox) {
//        this.maBox = maBox;
        this.TenBox = tenBox;
        this.trangThai = trangThai;
        this.loaiBox = loaiBox;
    }

    public int getMaBox() {
        return maBox;
    }

    public void setMaBox(int maBox) {
        this.maBox = maBox;
    }

    public int getMaDat() {
        return MaDat;
    }

    public void setMaDat(int MaDat) {
        this.MaDat = MaDat;
    }

    public Date getGioBD() {
        return gioBD;
    }

    public void setGioBD(Date gioBD) {
        this.gioBD = gioBD;
    }

    public Date getGioKT() {
        return gioKT;
    }

    public void setGioKT(Date gioKT) {
        this.gioKT = gioKT;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public String getTenBox() {
        return TenBox;
    }

    public void setTenBox(String TenBox) {
        this.TenBox = TenBox;
    }

    public LoaiBox getLoaiBox() {
        return loaiBox;
    }

    public void setLoaiBox(LoaiBox loaiBox) {
        this.loaiBox = loaiBox;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
}
