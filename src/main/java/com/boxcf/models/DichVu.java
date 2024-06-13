/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

/**
 *
 * @author ji
 */
public class DichVu {
   String MaDV;
   String TenDV; 

    public DichVu() {
    }

    public DichVu(String MaDV, String TenDV) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }
   
   
}
