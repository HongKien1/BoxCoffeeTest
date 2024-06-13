package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.KhuyenMai;
import com.box.utils.JdbcHelper;

public class KhuyenMaiDao implements BoxCfDAO<KhuyenMai, String> {

	public static KhuyenMaiDao getInstant() {
		return new KhuyenMaiDao();
	}

	@Override
	public KhuyenMai createObjecet(ResultSet responce) {
		try {
			return new KhuyenMai(responce.getString(1), responce.getString(2), responce.getDate(3), responce.getDate(4),
					responce.getInt(5), responce.getInt(6), responce.getLong(7));
		} catch (Exception e) {
			throw new Error("The Error in createObjecet KhuyenMai !");
		}
	}

	@Override
	public void delete(String id) {
		String sql = "update KhuyenMai\n" + "set TrangThai = 0\n" + "where MaKM = ?";

		try {
			int responce = JdbcHelper.update(sql, id);

			if (responce == 0) {
				throw new Error("The Error in delete KhuyenMai !");
			}
		} catch (Exception e) {
			throw new Error("The Error in delete KhuyenMai !");
		}

	}

	public void destroy(String id) {
		String sql = "delete KhuyenMai\r\n" + "where MaKM = ?";

		try {
			int responce = JdbcHelper.update(sql, id);

			if (responce == 0) {
				throw new Error("The Error in delete KhuyenMai !");
			}
		} catch (Exception e) {
			throw new Error("The Error in delete KhuyenMai !");
		}

	}

	@Override
	public void insert(KhuyenMai e) {
		String sql = "Insert into KhuyenMai values ( ?, ?, ?, ?, ?, ?, ?, 1)";

		try {
			int responce = JdbcHelper.update(sql, e.getMaKM(), e.getTenKM(), e.getNgayBD(), e.getNgayKT(),
					e.getSoLuot(), e.getPhanTram(), e.getDieuKienGiam());

			if (responce == 0) {
				throw new Error("The Error in insert KhuyenMai !");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			throw new Error("The Error in insert KhuyenMai !");
		}

	}

	public int insert2(KhuyenMai e) {
		String sql = "Insert into KhuyenMai values ( ?, ?, ?, ?, ?, ?, ?, 1)";

		return JdbcHelper.update2(sql, e.getMaKM(), e.getTenKM(), e.getNgayBD(), e.getNgayKT(), e.getSoLuot(),
				e.getPhanTram(), e.getDieuKienGiam());

	}

	public void insertTest(KhuyenMai e) throws Exception {
		String sql = "Insert into KhuyenMai values ( ?, ?, ?, ?, ?, ?, ?, 1)";

		try {
			int responce = JdbcHelper.update(sql, e.getMaKM(), e.getTenKM(), e.getNgayBD(), e.getNgayKT(),
					e.getSoLuot(), e.getPhanTram(), e.getDieuKienGiam());

			if (responce == 0) {
				throw new Error("The Error in insert KhuyenMai !");
			}
		} catch (Exception ex) {
//			System.out.println(ex);
			throw new Error("The Error in insert KhuyenMai !");
		}

	}

	@Override
	public List<KhuyenMai> selectAll() {
		List<KhuyenMai> list = new ArrayList<>();
		String sql = "select * from KhuyenMai Where TrangThai = 1";

		try {
			ResultSet responce = JdbcHelper.query(sql);

			while (responce.next()) {
				list.add(createObjecet(responce));
			}

			responce.getStatement().getConnection().close();

		} catch (Exception e) {
			throw new Error("The Error in selectAll KhuyenMai !");
		}
		return list;
	}

	@Override
	public KhuyenMai selectById(String id) {
		String sql = "select * from KhuyenMai where MaKM = ? and TrangThai = 1";
		KhuyenMai km = null;
		try {

			ResultSet responce = JdbcHelper.query(sql, id);

			// admission a ResultSet return a Box
			if (responce.next()) {
				km = createObjecet(responce);
			}
			responce.getStatement().getConnection().close();
		} catch (Exception e) {
			throw new Error("The Error in selectById KhuyenMai !");
		}
		return km;
	}

	public KhuyenMai selectByIdIgnorState(String id) {
		String sql = "select * from KhuyenMai where MaKM = ?";
		KhuyenMai km = null;
		try {

			ResultSet responce = JdbcHelper.query(sql, id);

			// admission a ResultSet return a Box
			if (responce.next()) {
				km = createObjecet(responce);
			}
			responce.getStatement().getConnection().close();
		} catch (Exception e) {
			throw new Error("The Error in selectById KhuyenMai !");
		}
		return km;
	}

	@Override
	public List<KhuyenMai> selectBySql(String sql, Object... args) {
		List<KhuyenMai> list = new ArrayList<>();

		try {
			ResultSet responce = JdbcHelper.query(sql, args);

			while (responce.next()) {
				list.add(createObjecet(responce));
			}
			responce.getStatement().getConnection().close();
		} catch (Exception e) {
			System.out.println(e);
			throw new Error("The Error in selectBySql KhuyenMai !");
		}
		return list;
	}

	@Override
	public void update(KhuyenMai e) {
		String sql = "update KhuyenMai\n"
				+ "set TenKM = ?, NgayBD = ?, NgayKT = ?, SoLuot = ?, PhanTram = ?, DieuKienGiam= ? \n"
				+ "where MaKM = ? and TrangThai = 1";

		try {
			int responce = JdbcHelper.update(sql, e.getTenKM(), e.getNgayBD(), e.getNgayKT(), e.getSoLuot(),
					e.getPhanTram(), e.getDieuKienGiam(), e.getMaKM());

			if (responce == 0) {
				throw new Error("The Error in update KhuyenMai !");
			}
		} catch (Exception ex) {
			throw new Error("The Error in update KhuyenMai !");
		}

	}

	public List<KhuyenMai> selectByKeyword(String keyword) {
		String sql = "select * from KhuyenMai\n"
				+ "where  (MaKM like ? or TenKM like ? or NgayBD like ?) and TrangThai = 1";

		return selectBySql(sql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
	}

	public List<KhuyenMai> selectTrash() {
		List<KhuyenMai> list = new ArrayList<>();
		String sql = "select * from KhuyenMai Where TrangThai = 0";

		try {
			ResultSet responce = JdbcHelper.query(sql);

			while (responce.next()) {
				list.add(createObjecet(responce));
			}

			responce.getStatement().getConnection().close();

		} catch (Exception e) {
			throw new Error("The Error in selectTrash KhuyenMai !");
		}
		return list;
	}

	public List<KhuyenMai> selectByCondition(long condition) {
		List<KhuyenMai> list = new ArrayList<>();
		String sql = "select * from KhuyenMai\n" + "where DieuKienGiam <= ? and TrangThai = 1 and SoLuot > 0 ";

		try {
			ResultSet responce = JdbcHelper.query(sql, condition);

			while (responce.next()) {
				list.add(createObjecet(responce));
			}

			responce.getStatement().getConnection().close();

		} catch (Exception e) {
			System.out.println(e);
			throw new Error("The Error in selectByCondition KhuyenMai !");
		}
		return list;
	}

}
