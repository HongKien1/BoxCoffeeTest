package com.boxcf.models;

import java.util.Objects;

public class Combo {

	String MaCB;
	String TenCB;
	long Gia;
	String MaLoaiBox;
	int soluong;
	int soLuongDoUong;
	int SoLuongDoAn;
	String MoTa;

	public Combo() {
	}

	public Combo(String MaCB, String TenCB, long Gia, String MaLoaiBox, int soluong, int soLuongDoUong, int SoLuongDoAn,
			String MoTa) {
		this.MaCB = MaCB;
		this.TenCB = TenCB;
		this.Gia = Gia;
		this.MaLoaiBox = MaLoaiBox;
		this.soluong = soluong;
		this.soLuongDoUong = soLuongDoUong;
		this.SoLuongDoAn = SoLuongDoAn;
		this.MoTa = MoTa;
	}

	public String getMaCB() {
		return MaCB;
	}

	public void setMaCB(String MaCB) {
		this.MaCB = MaCB;
	}

	public String getTenCB() {
		return TenCB;
	}

	public void setTenCB(String TenCB) {
		this.TenCB = TenCB;
	}

	public long getGia() {
		return Gia;
	}

	public void setGia(long Gia) {
		this.Gia = Gia;
	}

	public String getMaLoaiBox() {
		return MaLoaiBox;
	}

	public void setMaLoaiBox(String MaLoaiBox) {
		this.MaLoaiBox = MaLoaiBox;
	}

	public int getSoLuongDoUong() {
		return soLuongDoUong;
	}

	public void setSoLuongDoUong(int soLuongDoUong) {
		this.soLuongDoUong = soLuongDoUong;
	}

	public int getSoLuongDoAn() {
		return SoLuongDoAn;
	}

	public void setSoLuongDoAn(int SoLuongDoAn) {
		this.SoLuongDoAn = SoLuongDoAn;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String MoTa) {
		this.MoTa = MoTa;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Gia, MaCB, MaLoaiBox, MoTa, SoLuongDoAn, TenCB, soLuongDoUong, soluong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combo other = (Combo) obj;
		return Gia == other.Gia && Objects.equals(MaCB, other.MaCB) && Objects.equals(MaLoaiBox, other.MaLoaiBox)
				&& Objects.equals(MoTa, other.MoTa) && SoLuongDoAn == other.SoLuongDoAn
				&& Objects.equals(TenCB, other.TenCB) && soLuongDoUong == other.soLuongDoUong
				&& soluong == other.soluong;
	}

}
