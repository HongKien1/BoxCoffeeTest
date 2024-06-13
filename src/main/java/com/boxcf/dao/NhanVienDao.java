package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.NhanVien;
import com.box.utils.JdbcHelper;

public class NhanVienDao implements BoxCfDAO<NhanVien, String> {

	public static NhanVienDao getInstant() {
		return new NhanVienDao();
	}

	@Override
	public NhanVien createObjecet(ResultSet response) {
		try {
			return new NhanVien(response.getString(1), response.getString(2), response.getDate(3),
					response.getString(4), response.getString(5), response.getString(6), response.getString(7),
					response.getDate(8), response.getString(9), response.getBoolean(11));
		} catch (Exception e) {
			System.out.println(e);
			throw new Error("The Error in createObjecet NhanVien !");
		}
	}

	@Override
	public void delete(String id) {
		String sql = "update NhanVien \n" + "set TrangThai = 0 \n" + "where MaNV = ?";

		try {
			int response = JdbcHelper.update(sql, id);

			if (response == 0) {
				throw new Error("The Error in delete NhanVien !");
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new Error("The Error in delete NhanVien !");
		}

	}

	public void destroy(String id) {
		String sql = "delete NhanVien\r\n" + "where MaNV = ?";

		try {
			int response = JdbcHelper.update(sql, id);

			if (response == 0) {
				throw new Error("The Error in delete NhanVien !");
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new Error("The Error in delete NhanVien !");
		}

	}

	@Override
	public void insert(NhanVien e) {
		String sql = "Insert into NhanVien values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?)";

		try {
			int response = JdbcHelper.update(sql, e.getMaNV(), e.getTenNV(), e.getNgaySinh(), e.getSDT(), e.getDiaChi(),
					e.getMatKhau(), e.getHinhAnh().equals("") ? null : e.getHinhAnh(), e.getNgayVaoLam(), e.getVaiTro(),
					e.isGioiTinh());

			if (response == 0) {
				throw new Error("The Error in insert NhanVien !");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			throw new Error("The Error in insert NhanVien !");
		}

	}
	
	public int insert2(NhanVien e) {
		String sql = "Insert into NhanVien values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?)";
		
		return JdbcHelper.update2(sql, e.getMaNV(), e.getTenNV(), e.getNgaySinh(), e.getSDT(), e.getDiaChi(),
				e.getMatKhau(), e.getHinhAnh().equals("") ? null : e.getHinhAnh(), e.getNgayVaoLam(), e.getVaiTro(),
				e.isGioiTinh());
	}
	
//	@Override
//	public int insert2(NhanVien e) {
//		String sql = "Insert into NhanVien values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?)";
//		
//			int response = JdbcHelper.update(sql, e.getMaNV(), e.getTenNV(), e.getNgaySinh(), e.getSDT(), e.getDiaChi(),
//					e.getMatKhau(), e.getHinhAnh().equals("") ? null : e.getHinhAnh(), e.getNgayVaoLam(), e.getVaiTro(),
//							e.isGioiTinh());
//			return response;
//
//	}

//	public int insert2(NhanVien e) throws Exception {
//		String sql = "Insert into NhanVien values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?)";
//
//		try {
//			int response = JdbcHelper.update(sql, e.getMaNV(), e.getTenNV(), e.getNgaySinh(), e.getSDT(), e.getDiaChi(),
//					e.getMatKhau(), e.getHinhAnh().equals("") ? null : e.getHinhAnh(), e.getNgayVaoLam(), e.getVaiTro(),
//					e.isGioiTinh());
//
//			if (response == 0) {
//				throw new Error("The Error in insert NhanVien !");
//			}
//		} catch (Exception ex) {
////            System.out.println(ex);
//			throw new Error("The Error in insert NhanVien !");
//		}
//
//	}

	@Override
	public List<NhanVien> selectAll() {
		List<NhanVien> list = new ArrayList<>();
		String sql = "select * from NhanVien where TrangThai = 1";

		try {
			ResultSet response = JdbcHelper.query(sql);

			while (response.next()) {
				list.add(createObjecet(response));
			}
			response.getStatement().getConnection().close();
		} catch (Exception e) {
			System.out.println(e);

			throw new Error("The Error in selectAll NhanVien !");
		}
		return list;
	}

	@Override
	public NhanVien selectById(String id) {
		String sql = "select * from NhanVien where MaNV = ?";
		NhanVien nv = null;
		try {

			ResultSet response = JdbcHelper.query(sql, id);

			// admission a ResultSet return a Box
			if (response.next()) {
				nv = createObjecet(response);
			}

			response.getStatement().getConnection().close();

		} catch (Exception e) {
			throw new Error("The Error in selectById NhanVien !");
		}
		return nv;
	}

	public NhanVien selectByIdActive(String id) {
		String sql = "select * from NhanVien where MaNV = ? and TrangThai = 1";
		NhanVien nv = null;
		try {

			ResultSet response = JdbcHelper.query(sql, id);

			// admission a ResultSet return a Box
			if (response.next()) {
				nv = createObjecet(response);
			}

			response.getStatement().getConnection().close();

		} catch (Exception e) {
			throw new Error("The Error in selectById NhanVien !");
		}
		return nv;
	}

	public NhanVien login(String username, String password) {
		String sql = "select * from NhanVien\n" + "where MatKhau = ? and MaNV = ? and TrangThai = 1";
		NhanVien nv = null;
		try {

			ResultSet response = JdbcHelper.query(sql, password, username);

			// admission a ResultSet return a Box
			if (response.next()) {
				nv = createObjecet(response);
			}

			response.getStatement().getConnection().close();

		} catch (Exception e) {
			throw new Error("The Error in login NhanVien !");
		}
		return nv;
	}

	@Override
	public List<NhanVien> selectBySql(String sql, Object... args) {
		List<NhanVien> list = new ArrayList<>();

		try {
			ResultSet response = JdbcHelper.query(sql, args);

			while (response.next()) {
				list.add(createObjecet(response));
			}

			response.getStatement().getConnection().close();
		} catch (Exception e) {
			throw new Error("The Error in selectBySql NhanVien !");
		}
		return list;
	}

	@Override
	public void update(NhanVien e) {
		String sql = "update NhanVien set TenNV = ?, NgaySinh = ?, SDT = ?, DiaChi = ?, MatKhau = ?, HinhAnh = ? , NgayVaoLam = ?, VaiTro = ? where MaNV = ?";

		try {
			int response = JdbcHelper.update(sql, e.getTenNV(), e.getNgaySinh(), e.getSDT(), e.getDiaChi(),
					e.getMatKhau(), e.getHinhAnh(), e.getNgayVaoLam(), e.getVaiTro(), e.getMaNV());

			if (response == 0) {
				throw new Error("The Error in update NhanVien !");
			}
		} catch (Exception ex) {
			throw new Error("The Error in update NhanVien !");
		}
	}

	public List<NhanVien> selectByKeyword(String keyword) {
		String sql = "select * from NhanVien\n"
				+ "where (TenNV like ? or MaNV like ? or NgaySinh like ? or SDT like ? or NgayVaoLam like ? or DiaChi like ?) and TrangThai = 1";

		if (keyword.equals("") || keyword == null) {
			return selectAll();
		}

		keyword = "%" + keyword + "%";
		return selectBySql(sql, keyword, keyword, keyword, keyword, keyword, keyword);

	}

	public String getMaxId() {
		String sql = "SELECT TOP 1 * FROM NhanVien\n" + "ORDER BY MaNV desc";
		List<NhanVien> list = this.selectBySql(sql);

		return list.get(0).getMaNV();
	}

	public List<NhanVien> selectTrash() {
		String sql = "select * from NhanVien where TrangThai = 0";
		return selectBySql(sql);
	}

	public boolean refreshPass(String manv, String newPass) {
		String sql = "update NhanVien\n" + "set MatKhau = ? \n" + "where MaNV = ? and TrangThai = 1";

		try {
			int response = JdbcHelper.update(sql, newPass, manv);

			return response >= 1;
		} catch (Exception ex) {
			System.out.println(ex);
			throw new Error("The Error in insert NhanVien !");
		}

	}

	public static void main(String[] args) {
		System.out.println("nhan vien: " + NhanVienDao.getInstant().getMaxId());
	}

}
