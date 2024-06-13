/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import com.boxcf.constands.BoxState;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ji
 */
public class PhieuDatBox {

    int maHD;
    String maBox;
    String TenKH;
    java.sql.Timestamp GioBD;
    java.sql.Timestamp GioKT;
    int soGio;
    int traTruoc = 0;
    int thanhTien;
    int tienThucNhan;
    String TrangThai;
    String ghiChu;

    public PhieuDatBox() {
    }

    public PhieuDatBox(int maHD, String maBox, String TenKH, Timestamp GioBD, Timestamp GioKT, int soGio, int tratruoc, int thanhTien, String TrangThai, String ghiChu) {
        this.maHD = maHD;
        this.maBox = maBox;
        this.TenKH = TenKH;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
        this.soGio = soGio;
        this.traTruoc = tratruoc;
        this.thanhTien = thanhTien;
        this.TrangThai = TrangThai;
        this.ghiChu = ghiChu;
    }

    public PhieuDatBox(int maHD, String maBox, String TenKH, Timestamp GioBD, Timestamp GioKT, int soGio, int tratruoc, int thanhTien, int tienThucNhan, String TrangThai, String ghiChu) {
        this.maHD = maHD;
        this.maBox = maBox;
        this.TenKH = TenKH;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
        this.soGio = soGio;
        this.traTruoc = tratruoc;
        this.thanhTien = thanhTien;
        this.tienThucNhan = tienThucNhan;
        this.TrangThai = TrangThai;
        this.ghiChu = ghiChu;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getMaBox() {
        return maBox;
    }

    public void setMaBox(String maBox) {
        this.maBox = maBox;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public Date getGioBD() {
        return GioBD;
    }

    public void setGioBD(Timestamp GioBD) {
        this.GioBD = GioBD;
    }

    public Timestamp getGioKT() {
        return GioKT;
    }

    public void setGioKT(Timestamp GioKT) {
        this.GioKT = GioKT;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTraTruoc() {
        return traTruoc;
    }

    public void setTraTruoc(int traTruoc) {
        this.traTruoc = traTruoc;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public int getTienThucNhan() {
        return tienThucNhan;
    }

    public void setTienThucNhan(int tienThucNhan) {
        this.tienThucNhan = tienThucNhan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "PhieuDatBox{" + "maHD=" + maHD + ", maBox=" + maBox + ", TenKH=" + TenKH + ", GioBD=" + GioBD + ", GioKT=" + GioKT + ", soGio=" + soGio + ", traTruoc=" + traTruoc + ", thanhTien=" + thanhTien + ", TrangThai=" + TrangThai + ", ghiChu=" + ghiChu + '}';
    }

}
