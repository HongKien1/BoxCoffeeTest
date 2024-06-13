/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ji
 */
public class HoaDon {

    int MaHD;
    Date NgayTao;
    String TenKH;
    String MaNV;
    String GhiChu;
    long TONGTIEN;
    String MaKM;

    public HoaDon() {
    }

    public HoaDon(int MaHD, Date NgayTao, String TenKH, String MaNV, String GhiChu, long TONGTIEN, String MaKM) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TenKH = TenKH;
        this.MaNV = MaNV;
        this.GhiChu = GhiChu;
        this.TONGTIEN = TONGTIEN;
        this.MaKM = MaKM;
    }

    public HoaDon(int MaHD, Date NgayTao, String TenKH, long TONGTIEN, String MaKM) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TenKH = TenKH;
        this.TONGTIEN = TONGTIEN;
        this.MaKM = MaKM;
    }
    
    

    public HoaDon(Date NgayTao, String TenKH, String MaNV, String GhiChu, long TONGTIEN, String MaKM) {
        this.NgayTao = NgayTao;
        this.TenKH = TenKH;
        this.MaNV = MaNV;
        this.GhiChu = GhiChu;
        this.TONGTIEN = TONGTIEN;
        this.MaKM = MaKM;
    }

    public HoaDon(int MaHD, Date NgayTao, String TenKH, long TONGTIEN) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TenKH = TenKH;
        this.TONGTIEN = TONGTIEN;
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

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
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

    @Override
    public String toString() {
        return "HoaDon{" + "MaHD=" + MaHD + ", NgayTao=" + NgayTao + ", TenKH=" + TenKH + ", MaNV=" + MaNV + ", GhiChu=" + GhiChu + ", TONGTIEN=" + TONGTIEN + ", MaKM=" + MaKM + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDon other = (HoaDon) obj;

        if (this.TONGTIEN != other.TONGTIEN) {
            return false;
        }
        if (!Objects.equals(this.TenKH, other.TenKH)) {
            return false;
        }
        if (!Objects.equals(this.MaNV, other.MaNV)) {
            return false;
        }
        if (!Objects.equals(this.GhiChu, other.GhiChu)) {
            return false;
        }
        if (!Objects.equals(this.MaKM, other.MaKM)) {
            return false;
        }
        return Objects.equals(this.NgayTao, other.NgayTao);
    }

}
