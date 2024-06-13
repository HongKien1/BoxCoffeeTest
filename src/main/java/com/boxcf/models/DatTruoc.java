/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author PC
 */
public class DatTruoc {

    private int MaDT;
    private int MaBox;
    private String TenKH;
    private Date GioBD;
    private Date GioKT;
    boolean TranThai;

    public DatTruoc(int MaDT, int MaBox, String TenKH, Date GioBD, Date GioKT, boolean TranThai) {
        this.MaDT = MaDT;
        this.MaBox = MaBox;
        this.TenKH = TenKH;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
        this.TranThai = TranThai;
    }

    public DatTruoc(int MaBox, String TenKH, Date GioBD, Date GioKT) {
        this.MaBox = MaBox;
        this.TenKH = TenKH;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
    }

    public DatTruoc(int MaBox, String TenKH, Date GioBD, Date GioKT, boolean TranThai) {
        this.MaBox = MaBox;
        this.TenKH = TenKH;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
        this.TranThai = TranThai;
    }

    public DatTruoc() {
    }

    public int getMaDT() {
        return MaDT;
    }

    public void setMaDT(int MaDT) {
        this.MaDT = MaDT;
    }

    public int getMaBox() {
        return MaBox;
    }

    public void setMaBox(int MaBox) {
        this.MaBox = MaBox;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setGioBD(Timestamp GioBD) {
        this.GioBD = GioBD;
    }

    public Date getGioBD() {
        return GioBD;
    }

    public void setGioBD(Date GioBD) {
        this.GioBD = GioBD;
    }

    public Date getGioKT() {
        return GioKT;
    }

    public void setGioKT(Date GioKT) {
        this.GioKT = GioKT;
    }

    public void setGioKT(Timestamp GioKT) {
        this.GioKT = GioKT;
    }

    public boolean isTranThai() {
        return TranThai;
    }

    public void setTranThai(boolean TranThai) {
        this.TranThai = TranThai;
    }

    @Override
    public String toString() {
        return "DatTruoc{" + "MaDT=" + MaDT + ", MaBox=" + MaBox + ", TenKH=" + TenKH + ", GioBD=" + GioBD + ", GioKT=" + GioKT + ", TranThai=" + TranThai + '}';
    }

}
