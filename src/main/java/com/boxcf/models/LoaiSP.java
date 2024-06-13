/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

/**
 *
 * @author ji
 */
public class LoaiSP {

    String MaLoai;
    String TenLoai;
    String MaDM;

    public LoaiSP() {
    }

    public LoaiSP(String MaLoai, String TenLoai, String MaDM) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
        this.MaDM = MaDM;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getMaDM() {
        return MaDM;
    }

    public void setMaDM(String MaDM) {
        this.MaDM = MaDM;
    }

    @Override
    public String toString() {
        return "LoaiSP{" + "MaLoai=" + MaLoai + ", TenLoai=" + TenLoai + ", MaDM=" + MaDM + '}';
    }

}
