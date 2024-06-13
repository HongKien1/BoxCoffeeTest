package com.boxcf.models;

public class ComboCT {

    int maHd;
    String MaCB;
    String maSp;
    String maBox;
    int soLuong;
    String GhiChu;

    public ComboCT() {
    }

    public ComboCT(int maHd, String MaCB, String maSp, String maBox, int soLuong, String GhiChu) {
        this.maHd = maHd;
        this.MaCB = MaCB;
        this.maSp = maSp;
        this.maBox = maBox;
        this.soLuong = soLuong;
        this.GhiChu = GhiChu;
    }
    
    public ComboCT(int maHd, String MaCB, String maSp, String maBox, int soLuong) {
        this.maHd = maHd;
        this.MaCB = MaCB;
        this.maSp = maSp;
        this.maBox = maBox;
        this.soLuong = soLuong;
    }

    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public String getMaCB() {
        return MaCB;
    }

    public void setMaCB(String MaCB) {
        this.MaCB = MaCB;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getMaBox() {
        return maBox;
    }

    public void setMaBox(String maBox) {
        this.maBox = maBox;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return "ComboCT{" + "maHd=" + maHd + ", MaCB=" + MaCB + ", maSp=" + maSp + ", maBox=" + maBox + ", soLuong=" + soLuong + ", GhiChu=" + GhiChu + '}';
    }

}
