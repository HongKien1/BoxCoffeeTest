/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import com.box.utils.Formats;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ji
 */
public class KhuyenMai {
    
    String MaKM;
    String TenKM;
    Date NgayBD;
    Date NgayKT;
    int SoLuot;
    int PhanTram;
    long DieuKienGiam;
    
    public KhuyenMai() {
    }
    
    public KhuyenMai(String MaKM, String TenKM, Date NgayBD, Date NgayKT, int SoLuot, int PhanTram, long DieuKienGiam) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.SoLuot = SoLuot;
        this.PhanTram = PhanTram;
        this.DieuKienGiam = DieuKienGiam;
    }
    
    public String getMaKM() {
        return MaKM;
    }
    
    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }
    
    public String getTenKM() {
        return TenKM;
    }
    
    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }
    
    public Date getNgayBD() {
        return NgayBD;
    }
    
    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }
    
    public Date getNgayKT() {
        return NgayKT;
    }
    
    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }
    
    public int getSoLuot() {
        return SoLuot;
    }
    
    public void setSoLuot(int SoLuot) {
        this.SoLuot = SoLuot;
    }
    
    public int getPhanTram() {
        return PhanTram;
    }
    
    public void setPhanTram(int PhanTram) {
        this.PhanTram = PhanTram;
    }
    
    public long getDieuKienGiam() {
        return DieuKienGiam;
    }
    
    public void setDieuKienGiam(long DieuKienGiam) {
        this.DieuKienGiam = DieuKienGiam;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final KhuyenMai other = (KhuyenMai) obj;
        if (this.SoLuot != other.SoLuot) {
            return false;
        }
        if (this.PhanTram != other.PhanTram) {
            return false;
        }
        if (this.DieuKienGiam != other.DieuKienGiam) {
            return false;
        }
        if (!Objects.equals(this.MaKM, other.MaKM)) {
            return false;
        }
        if (!Objects.equals(this.TenKM, other.TenKM)) {
            return false;
        }
        if (!Objects.equals(this.NgayBD, other.NgayBD)) {
            return false;
        }
        return Objects.equals(this.NgayKT, other.NgayKT);
    }
    
    @Override
    public String toString() {
        return MaKM + " giảm " + PhanTram + " % cho đơn từ " + Formats.toCurency(DieuKienGiam);
    }
    
    public String toStrings() {
        return "KhuyenMai{" + "MaKM=" + MaKM + ", TenKM=" + TenKM + ", NgayBD=" + NgayBD + ", NgayKT=" + NgayKT + ", SoLuot=" + SoLuot + ", PhanTram=" + PhanTram + ", DieuKienGiam=" + DieuKienGiam + '}';
    }
}
