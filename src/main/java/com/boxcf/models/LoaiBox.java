/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

/**
 *
 * @author ji
 */
public class LoaiBox {

    String MaLoaiBox;
    String TenLoaiBox;
    long GiaLoai;
    String MoTa;

    public LoaiBox() {
    }

    public LoaiBox(String MaLoaiBox, String TenLoaiBox, long GiaLoai, String MoTa) {
        this.MaLoaiBox = MaLoaiBox;
        this.TenLoaiBox = TenLoaiBox;
        this.GiaLoai = GiaLoai;
        this.MoTa = MoTa;
    }

    public String getMaLoaiBox() {
        return MaLoaiBox;
    }

    public void setMaLoaiBox(String MaLoaiBox) {
        this.MaLoaiBox = MaLoaiBox;
    }

    public String getTenLoaiBox() {
        return TenLoaiBox;
    }

    public void setTenLoaiBox(String TenLoaiBox) {
        this.TenLoaiBox = TenLoaiBox;
    }

    public long getGiaLoai() {
        return GiaLoai;
    }

    public void setGiaLoai(long GiaLoai) {
        this.GiaLoai = GiaLoai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return this.TenLoaiBox;
    }

}
