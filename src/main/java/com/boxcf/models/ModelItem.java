/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import com.boxcf.constands.BoxState;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.Icon;

/**
 *
 * @author PC
 */
public class ModelItem {

    // product
    private Object maItem;
    private String hinh;
    private double gia;
    private String ten;

    // box 
    Date gioBD;
    Date gioKT;
    int MaDat;
    BoxState trangThai;
    LoaiBox loaiBox;

    PhieuDatBox datTruoc;

    int traTruoc = 0;
    int tienThucNhan = 0;
    String tenKH;
    String ghiChu;

    // cả hai đều có
    private int soLuong;

    private String MaCB;
    private int SLDoUong;
    private int SLDoAn;

    public Object getMaItem() {
        return maItem;
    }

    public void setMaItem(String maItem) {
        this.maItem = maItem;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;

    }

    public int getTienThucNhan() {
        return tienThucNhan;
    }

    public void setTienThucNhan(int tienThucNhan) {
        this.tienThucNhan = tienThucNhan;
    }

    public String getHing() {
        return hinh;
    }

    public void setHing(String hing) {
        this.hinh = hing;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public int getMaDat() {
        return MaDat;
    }

    public void setMaDat(int MaDat) {
        this.MaDat = MaDat;
    }

    public BoxState getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(BoxState trangThai) {
        this.trangThai = trangThai;
    }

    public LoaiBox getLoaiBox() {
        return loaiBox;
    }

    public void setLoaiBox(LoaiBox loaiBox) {
        this.loaiBox = loaiBox;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getTraTruoc() {
        return traTruoc;
    }

    public void setTraTruoc(int traTruoc) {
        this.traTruoc = traTruoc;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    // box
    public ModelItem(Object maItem, String ten, BoxState trangThai, LoaiBox loaiBox) {
        this.maItem = maItem;
        this.ten = ten;
        this.trangThai = trangThai;
        this.loaiBox = loaiBox;
    }

    public ModelItem(Object maItem, String ten, Date gioBD, Date gioKT, LoaiBox loaiBox, int soLuong, double gia) {
        this.maItem = maItem;
        this.ten = ten;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
        this.loaiBox = loaiBox;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    // product
    public ModelItem(Object maItem, String hing, double gia, String ten, int soLuong) {
        this.maItem = maItem;
        this.hinh = hing;
        this.gia = gia;
        this.ten = ten;
        this.soLuong = soLuong;
    }

    // box
    public ModelItem(Object maItem, String ten, Date gioBD, Date gioKT, LoaiBox loaiBox, int soLuong, double gia, String tenKH) {
        this.maItem = maItem;
        this.ten = ten;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
        this.loaiBox = loaiBox;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tenKH = tenKH;
    }

    public ModelItem() {
    }

    @Override
    public String toString() {
        return "ModelItem{" + "maItem=" + maItem + ", hinh=" + hinh + ", gia=" + gia + ", ten=" + ten + ", gioBD=" + gioBD + ", gioKT=" + gioKT + ", MaDat=" + MaDat + ", trangThai=" + trangThai + ", loaiBox=" + loaiBox + ", traTruoc=" + traTruoc + ", tenKH=" + tenKH + ", ghiChu=" + ghiChu + ", soLuong=" + soLuong + ", MaCB=" + MaCB + ", SLDoUong=" + SLDoUong + ", SLDoAn=" + SLDoAn + '}';
    }

    ////////
    public int getSLDoUong() {
        return SLDoUong;
    }

    public void setSLDoUong(int SLDoUong) {
        this.SLDoUong = SLDoUong;
    }

    public int getSLDoAn() {
        return SLDoAn;
    }

    public void setSLDoAn(int SLDoAn) {
        this.SLDoAn = SLDoAn;
    }

    public String getMaCB() {
        return MaCB;
    }

    public void setMaCB(String MaCB) {
        this.MaCB = MaCB;
    }

    public ModelItem(Object maItem, double gia, String ten, LoaiBox loaiBox, int SLDoUong, int SLDoAn) {
        this.maItem = maItem;
        this.gia = gia;
        this.ten = ten;
        this.loaiBox = loaiBox;
        this.SLDoUong = SLDoUong;
        this.SLDoAn = SLDoAn;
        this.MaCB = (String) maItem;
    }

    public PhieuDatBox getDatTruoc() {
        return datTruoc;
    }

    public void setDatTruoc(PhieuDatBox datTruoc) {
        this.datTruoc = datTruoc;
    }

}
