package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.SanPham;
import com.box.utils.JdbcHelper;
import com.boxcf.models.LoaiBox;
import com.boxcf.store.Store;
import java.sql.SQLException;

public class SanPhamDao implements BoxCfDAO<SanPham, String> {

	public static SanPhamDao getInstant() {
		return new SanPhamDao();
	}

	@Override
	public SanPham createObjecet(ResultSet responce) {
		try {
			return new SanPham(responce.getString(1), responce.getString(2), responce.getLong(3), responce.getString(4),
					responce.getString(5), responce.getString(6));
		} catch (Exception e) {
			throw new Error("The Error in createObjecet SanPham !");
		}
	}

	public void delete(Integer id) {
		String sql = "delete SanPham where MaSP = ?";

		try {
			int responce = JdbcHelper.update(sql, id);

			if (responce == 0) {
				throw new Error("The Error in delete SanPham !");
			}
		} catch (Exception e) {
			throw new Error("The Error in delete SanPham !");
		}

	}

	public void destroy(String id) {
		String sql = "delete SanPham where MaSP = ?";

		try {
			int responce = JdbcHelper.update(sql, id);

			if (responce == 0) {
				throw new Error("The Error in delete SanPham !");
			}
		} catch (Exception e) {
			throw new Error("The Error in delete SanPham !");
		}

	}

	public void delete(String id) {
		String sql = "update SanPham set TrangThai = 0 where MaSP = ?";

		try {
			int responce = JdbcHelper.update(sql, id);

			if (responce == 0) {
				throw new Error("The Error in delete SanPham !");
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new Error("The Error in delete SanPham !");
		}

	}

	@Override
	public void insert(SanPham e) {
		String sql = "Insert into SanPham values (?, ?, ?, ?, ?, ?, 1)";

		try {
			int responce = JdbcHelper.update(sql, e.getMaSP(), e.getTenSP(), e.getGia(), e.getHinhAnh(), e.getMoTa(),
					e.getMaLoai());

			if (responce == 0) {
				throw new Error("The Error in insert SanPham !");
			}
		} catch (Exception ex) {
			throw new Error(ex.getMessage());
		}
	}

	public void insertTest(SanPham e) throws Exception {
		String sql = "Insert into SanPham values (?, ?, ?, ?, ?, ?, 1)";

		try {
			int responce = JdbcHelper.update(sql, e.getMaSP(), e.getTenSP(), e.getGia(), e.getHinhAnh(), e.getMoTa(),
					e.getMaLoai());

			if (responce == 0) {
				throw new Error("The Error in insert SanPham !");
			}
		} catch (Exception ex) {
			throw new Error(ex.getMessage());
		}
	}

	@Override
	public List<SanPham> selectAll() {
		List<SanPham> list = new ArrayList<>();
		String sql = "select * from SanPham";

		try {
			ResultSet responce = JdbcHelper.query(sql);

			while (responce.next()) {
				list.add(createObjecet(responce));
			}

			responce.getStatement().getConnection().close();

		} catch (Exception e) {
			System.out.println(e);
			throw new Error("The Error in selectAll SanPham !");
		}
		return list;
	}

	@Override
	public SanPham selectById(String id) {
		String sql = "select * from SanPham where MaSp = ?";
		SanPham sanPham = null;
		try {

			ResultSet responce = JdbcHelper.query(sql, id);

			// admission a ResultSet return a Box
			if (responce.next()) {
				sanPham = createObjecet(responce);
			}

			responce.getStatement().getConnection().close();

		} catch (Exception e) {
			throw new Error("The Error in selectById SanPham !");
		}
		return sanPham;
	}

	public SanPham selectByIdActive(String id) {
		String sql = "select * from SanPham where MaSp = ? and TrangThai = 1";
		SanPham sanPham = null;
		try {

			ResultSet responce = JdbcHelper.query(sql, id);

			// admission a ResultSet return a Box
			if (responce.next()) {
				sanPham = createObjecet(responce);
			}

			responce.getStatement().getConnection().close();

		} catch (Exception e) {
			throw new Error("The Error in selectById SanPham !");
		}
		return sanPham;
	}

	@Override
	public List<SanPham> selectBySql(String sql, Object... args) {
		List<SanPham> list = new ArrayList<>();

		try {
			ResultSet rs = JdbcHelper.query(sql, args);
			while (rs.next()) {
				SanPham sanpham = new SanPham();

				sanpham.setMaSP(rs.getString("MaSP"));
				sanpham.setTenSP(rs.getString("TenSP"));
				sanpham.setGia(rs.getLong("Gia"));
				sanpham.setHinhAnh(rs.getString("HinhAnh"));
				sanpham.setMaLoai(rs.getString("MaLoai"));
				sanpham.setMoTa(rs.getString("MoTa"));
				list.add(sanpham);
			}
			rs.getStatement().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(SanPham e) {
		String sql = "update SanPham set TenSP = ?, Gia = ?, HinhAnh = ?, MoTa = ?, MaLoai = ? where MaSP = ?";

		try {
			int responce = JdbcHelper.update(sql, e.getTenSP(), e.getGia(), e.getHinhAnh(), e.getMoTa(), e.getMaLoai(),
					e.getMaSP());

			if (responce == 0) {
				throw new Error("The Error in update SanPham !");
			}
		} catch (Exception ex) {
			throw new Error("The Error in update SanPham !");
		}

	}

	public List<SanPham> selectByTenLoaiSP(String keyword) {
		String sql = "SELECT sp.* FROM SanPham sp inner join LoaiSP lsp on sp.MaLoai = lsp.MaLoai where TenLoai like ?;";
		return selectBySql(sql, "%" + keyword + "%");
	}

	public List<SanPham> selectByTenDanhMuc(String keyword) {
		String sql = "SELECT sp.* FROM SanPham sp inner join LoaiSP lsp on sp.MaLoai = lsp.MaLoai inner join DanhMuc dm on lsp.MaDM=dm.MaDM where dm.TenDM like ?;";
		return selectBySql(sql, "%" + keyword + "%");
	}

	public List<SanPham> selectByKeyWord(String keyWord, int type) {
		String sql = "";
		if (type == 0) {
			sql = "select * from SanPham where TenSP like ?";
		} else if (type == 1) {
			sql = "select * from SanPham where MaSP = ?";
			return selectBySql(sql, keyWord);
		}
		return selectBySql(sql, "%" + keyWord + "%");
	}

	public List<SanPham> panigation(Integer pageCurrent) {
		// String sql = "SELECT TOP 8 * FROM SanPham WHERE MaSP NOT IN (SELECT TOP " +
		// (pageCurrent * 8 - 8) + " MaSP FROM SanPham)";

		String idCategory = DanhMucDao.getInstant().selectByName(Store.categoryName).getMaDM();

		String sql = "SELECT TOP 8 * FROM SanPham WHERE MaSP NOT IN (SELECT TOP " + (pageCurrent * 8 - 8)
				+ " MaSP FROM SanPham where MaLoai in (select MaLoai from  LoaiSP where MaDM = ?)) \n"
				+ " and MaLoai in (select MaLoai from  LoaiSP where MaDM = ?)";

		return this.selectBySql(sql, idCategory, idCategory);
	}

	public Integer getPageNumber() {
		return (int) Math.ceil(this.selectByTenDanhMuc(Store.categoryName).size() / 8) + 1;
	}

}
