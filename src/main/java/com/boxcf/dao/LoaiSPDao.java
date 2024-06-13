package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.LoaiSP;
import com.box.utils.JdbcHelper;

public class LoaiSPDao implements BoxCfDAO<LoaiSP, String> {

    public static LoaiSPDao getInstant() {
        return new LoaiSPDao();
    }

    @Override
    public LoaiSP createObjecet(ResultSet responce) {
        try {
            return new LoaiSP(
                    responce.getString(1),
                    responce.getString(2),
                    responce.getString(3)
            );
        } catch (Exception e) {
            throw new Error("The Error in createObjecet LoaiSP !");
        }
    }

    @Override
    public void delete(String id) {
        String sql = "delete LoaiSP where MaLoai = ?";

        try {
            int responce = JdbcHelper.update(sql, id);

            if (responce == 0) {
                throw new Error("The Error in delete LoaiSP !");
            }
        } catch (Exception e) {
            throw new Error("The Error in delete LoaiSP !");
        }

    }

    @Override
    public void insert(LoaiSP e) {
        String sql = "Insert into LoaiSP values ( ?, ?, ?)";

        try {
            int responce = JdbcHelper.update(sql, e.getMaLoai(), e.getTenLoai(), e.getMaDM());

            if (responce == 0) {
                throw new Error("The Error in insert LoaiSP !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in insert LoaiSP !");
        }

    }

    @Override
    public List<LoaiSP> selectAll() {
        List<LoaiSP> list = new ArrayList<>();
        String sql = "select * from LoaiSP";

        try {
            ResultSet responce = JdbcHelper.query(sql);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectAll LoaiSP !");
        }
        return list;
    }

    @Override
    public LoaiSP selectById(String id) {
        String sql = "select * from LoaiSP where MaLoai = ?";

        LoaiSP loaiSP = null;
        try {

            ResultSet responce = JdbcHelper.query(sql, id);

            // admission a ResultSet return a Box
            if (responce.next()) {
                loaiSP = createObjecet(responce);
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectById LoaiSP !");
        }
        return loaiSP;
    }

    @Override
    public List<LoaiSP> selectBySql(String sql, Object... args) {
        List<LoaiSP> list = new ArrayList<>();

        try {
            ResultSet responce = JdbcHelper.query(sql, args);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectBySql LoaiSP !");
        }
        return list;
    }

    @Override
    public void update(LoaiSP e) {
        String sql = "update LoaiSP set TenLoai = ?, MaDM = ? where MaLoai = ?";

        try {
            int responce = JdbcHelper.update(sql, e.getTenLoai(), e.getMaDM(), e.getMaLoai());

            if (responce == 0) {
                throw new Error("The Error in update LoaiSP !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in update LoaiSP !");
        }
    }

    public LoaiSP selectByName(String name) {
        String sql = "select * from LoaiSP where TenLoai = ?";
        LoaiSP loaiSP = null;
        try {

            ResultSet responce = JdbcHelper.query(sql, name);

            // admission a ResultSet return a Box
            if (responce.next()) {
                loaiSP = createObjecet(responce);
            }

        } catch (Exception e) {
            throw new Error("The Error in selectById LoaiSP !");
        }
        return loaiSP;
    }

    public List<LoaiSP> selectByKeyWord(String keyWord, int type) {

        String sql = "";
        if (type == 0) {
            sql = "select * from LoaiSP where TenLoai like ?";
        } else if (type == 1) {
            sql = "select * from LoaiSP where MaLoai like ?";
        }

        return selectBySql(sql, "%" + keyWord + "%");
    }

    public List<LoaiSP> selectByDM(String id) {

        String sql = "select * from LoaiSP\n"
                + "where MaDM = ?";

        return selectBySql(sql, id);
    }

}
