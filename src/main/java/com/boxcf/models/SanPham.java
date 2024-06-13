
package com.boxcf.models;

import java.util.Objects;

public class SanPham {

    String MaSP;
    String TenSP;
    long Gia;
    String HinhAnh;
    String MoTa;
    String MaLoai;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, long Gia, String HinhAnh, String MoTa, String MaLoai) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.HinhAnh = HinhAnh;
        this.MoTa = MoTa;
        this.MaLoai = MaLoai;
    }

    public SanPham(String MaSP, String TenSP, long Gia) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Gia = Gia;
    }
    
    

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public long getGia() {
        return Gia;
    }

    public void setGia(long Gia) {
        this.Gia = Gia;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String toStrings() {
        return "SanPham{" + "MaSP=" + MaSP + ", TenSP=" + TenSP + ", Gia=" + Gia + ", HinhAnh=" + HinhAnh + ", MoTa=" + MoTa + ", MaLoai=" + MaLoai + '}';
    }

    @Override
    public String toString() {
        return TenSP;
    }

	@Override
	public int hashCode() {
		return Objects.hash(Gia, HinhAnh, MaLoai, MaSP, MoTa, TenSP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Gia == other.Gia && Objects.equals(HinhAnh, other.HinhAnh) && Objects.equals(MaLoai, other.MaLoai)
				&& Objects.equals(MaSP, other.MaSP) && Objects.equals(MoTa, other.MoTa)
				&& Objects.equals(TenSP, other.TenSP);
	}
    
    
    
    

}
