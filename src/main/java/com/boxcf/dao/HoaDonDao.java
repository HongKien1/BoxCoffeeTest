package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.HoaDon;
import com.box.utils.JdbcHelper;
import com.box.utils.XDate;

public class HoaDonDao implements BoxCfDAO<HoaDon, Integer> {

    public static HoaDonDao getInstant() {
        return new HoaDonDao();
    }

    @Override
    public HoaDon createObjecet(ResultSet responce) {
        try {
            return new HoaDon(
                    responce.getInt(1),
                    responce.getTimestamp(2),
                    responce.getString(3),
                    responce.getString(4),
                    responce.getString(5),
                    responce.getLong(6),
                    responce.getString(7)
            );
        } catch (Exception e) {
            throw new Error("The Error in createObjecet HoaDon !");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "update HoaDon set DaXoa = 1 where MaHD = ?";

        try {
            int responce = JdbcHelper.update(sql, id);

            if (responce == 0) {
                throw new Error("The Error in delete HoaDon !");
            }
        } catch (Exception e) {
            throw new Error("The Error in delete HoaDon !");
        }

    }

    @Override
    public void insert(HoaDon e) {
        String sql = "Insert into HoaDon values ( ?, ?, ?, ?, ?, 'B0606101')";

        try {
            int responce = JdbcHelper.update(sql, e.getNgayTao(), e.getTenKH(), e.getMaNV(), e.getGhiChu(), e.getTONGTIEN());

            if (responce == 0) {
                throw new Error("The Error in insert HoaDon !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in insert HoaDon !");
        }

    }

    public int inserts(HoaDon e) {
        int maHd = 0;
//        String sql = "Insert into HoaDon values(?, ?, ?, ?, ?, ?)";
        String sql = "{ call sp_insert_bill ( ?, ?, ?, ?, ? ) }";

        String findSql = "select top 1 * from HoaDon\n"
                + "order by MaHD desc";

        try {
            int responce = JdbcHelper.update(sql, e.getTenKH(), e.getMaNV(), e.getGhiChu(), e.getTONGTIEN(), e.getMaKM());

            if (responce == 0) {
                return maHd;
            }

            HoaDon hd = selectBySql(findSql);

            if (hd != null) {
                maHd = hd.getMaHD();
            }

        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in inserts HoaDon !");
        }
        return maHd;
    }

    @Override
    public List<HoaDon> selectAll() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from HoaDon";

        try {
            ResultSet responce = JdbcHelper.query(sql);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

        } catch (Exception e) {
            throw new Error("The Error in selectAll HoaDon !");
        }
        return list;
    }

    @Override
    public HoaDon selectById(Integer id) {
        String sql = "select * from HoaDon where MaHD = ?";

        try {

            ResultSet responce = JdbcHelper.query(sql, id);

            // admission a ResultSet return a Box
            if (responce.next()) {
                return createObjecet(responce);
            }

        } catch (Exception e) {
            throw new Error("The Error in selectById HoaDon !");
        }
        return null;
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();

        try {
            ResultSet responce = JdbcHelper.query(sql, args);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

        } catch (Exception e) {
            throw new Error("The Error in selectBySql HoaDon !");
        }
        return list;
    }

    public HoaDon selectBySql(String sql) {
        HoaDon hd = null;
        try {
            ResultSet responce = JdbcHelper.query(sql);

            if (responce.next()) {
                hd = createObjecet(responce);
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectBySql HoaDon !");
        }
        return hd;
    }

    @Override
    public void update(HoaDon e) {
        String sql = "update HoaDon set DaXoa = 0 where MaHD = ?";

        try {
            int responce = JdbcHelper.update(sql, e.getMaHD());

            if (responce == 0) {
                throw new Error("The Error in update HoaDon !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in update HoaDon !");
        }
    }

    public int getNextId() {
        String sql = "select top 1 MaHD from HoaDon\n"
                + "order by MaHD desc";

        int nextId = 0;
        try {
            if ((int) JdbcHelper.value(sql) > 0) {
                int id = (int) JdbcHelper.value(sql);
                nextId = id + 1;
            }
        } catch (Exception e) {
            return 1;
        }

        return nextId;
    }

    public static void main(String[] args) {

    }
}
