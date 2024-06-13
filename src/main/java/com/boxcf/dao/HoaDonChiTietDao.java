package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.HoaDonCT;
import com.box.utils.JdbcHelper;

public class HoaDonChiTietDao implements BoxCfDAO<HoaDonCT, Integer> {

    public static HoaDonChiTietDao getInstant() {
        return new HoaDonChiTietDao();
    }

    @Override
    public HoaDonCT createObjecet(ResultSet responce) {
        try {
            return new HoaDonCT(
                    responce.getInt(1),
                    responce.getString(2),
                    responce.getInt(3),
                    responce.getString(4),
                    responce.getLong(5)
            );
        } catch (Exception e) {
            throw new Error("The Error in createObjecet HoaDonCT !");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete HoaDonCT where MaHDCT = ?";

        try {
            int responce = JdbcHelper.update(sql, id);

            if (responce == 0) {
                throw new Error("The Error in delete HoaDonCT !");
            }
        } catch (Exception e) {
            throw new Error("The Error in delete HoaDonCT !");
        }

    }

    @Override
    public void insert(HoaDonCT e) {
        String sql = "Insert into HoaDonCT values ( ?, ?, ?, ?, ?)";

        try {
            int responce = JdbcHelper.update(sql, e.getMaHD(),
                    e.getMaSP(),
                    e.getSoLuong(),
                    e.getGhiChu(),
                    e.getThanhTien());

            if (responce == 0) {
                throw new Error("The Error in insert HoaDonCT !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in insert HoaDonCT !");
        }

    }

    @Override
    public List<HoaDonCT> selectAll() {
        List<HoaDonCT> list = new ArrayList<>();
        String sql = "select * from HoaDonCT";

        try {
            ResultSet responce = JdbcHelper.query(sql);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

        } catch (Exception e) {
            throw new Error("The Error in selectAll HoaDonCT !");
        }
        return list;
    }

    @Override
    public HoaDonCT selectById(Integer id) {
        String sql = "select * from HoaDonCT where MaHDCT = ?";

        try {

            ResultSet responce = JdbcHelper.query(sql, id);

            // admission a ResultSet return a Box
            if (responce.next()) {
                return createObjecet(responce);
            }

        } catch (Exception e) {
            throw new Error("The Error in selectById HoaDonCT !");
        }
        return null;
    }

    @Override
    public List<HoaDonCT> selectBySql(String sql, Object... args) {
        List<HoaDonCT> list = new ArrayList<>();

        try {
            ResultSet responce = JdbcHelper.query(sql, args);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

        } catch (Exception e) {
            throw new Error("The Error in selectBySql HoaDonCT !");
        }
        return list;
    }

    public List<HoaDonCT> selectByHd(int id) {
        List<HoaDonCT> list = new ArrayList<>();
        String sql = "select * from HoaDonCT\n"
                + "where MaHD = ?\n"
                + "order by SoLuong desc";

        return selectBySql(sql, id);
    }

    @Override
    public void update(HoaDonCT e) {
        String sql = "update HoaDonCT set MaHD = ?, MaSP = ?, SoLuong = ?, GhiChu = ? , ThanhTien = ?, MaDat = ? where MaHDCT = ?";

        try {
            int responce = JdbcHelper.update(sql, e.getMaHD(), e.getMaSP(), e.getSoLuong(), e.getGhiChu(), e.getThanhTien());

            if (responce == 0) {
                throw new Error("The Error in update HoaDonCT !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in update HoaDonCT !");
        }

    }

}
