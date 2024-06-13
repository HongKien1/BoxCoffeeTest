/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import com.boxcf.constands.BoxState;

public class Box {

    String MaBox;
    String TenBox;
    String HinhAnh;
//    BoxState TrangThai;
    String MaLoaiBox;
    String moTa;

    public Box() {
    }

    public Box(String MaBox, String TenBox, String HinhAnh, String MaLoaiBox, String moTa) {
        this.MaBox = MaBox;
        this.TenBox = TenBox;
        this.HinhAnh = HinhAnh;
        this.MaLoaiBox = MaLoaiBox;
        this.moTa = moTa;
    }

    public String getMaBox() {
        return MaBox;
    }

    public void setMaBox(String MaBox) {
        this.MaBox = MaBox;
    }

    public String getTenBox() {
        return TenBox;
    }

    public void setTenBox(String TenBox) {
        this.TenBox = TenBox;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMaLoaiBox() {
        return MaLoaiBox;
    }

    public void setMaLoaiBox(String MaLoaiBox) {
        this.MaLoaiBox = MaLoaiBox;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String toStrings() {
        return "Box{" + "MaBox=" + MaBox + ", TenBox=" + TenBox + ", HinhAnh=" + HinhAnh + ", MaLoaiBox=" + MaLoaiBox + ", moTa=" + moTa + '}';
    }

    @Override
    public String toString() {
        return TenBox;
    }

}
