/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import java.util.Date;

/**
 *
 * @author PC
 */
public class LichSu extends HoaDon {

    private String TenNV;

    public LichSu(int MaHD, Date NgayTao, String TenKH, String TenNV, long TONGTIEN, String MaKM) {
        super(MaHD, NgayTao, TenKH, TONGTIEN, MaKM);
        this.TenNV = TenNV;
    }

    public LichSu(HoaDon data, String TenNV) {
        super(data.getMaHD(), data.getNgayTao(), data.getTenKH(), data.getTONGTIEN(), data.getMaKM());
        this.TenNV = TenNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public long getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(long TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    @Override
    public String toString() {
        return "LichSu{" + "TenNV=" + TenNV + '}';
    }

}
