package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.Combo;
import com.box.utils.JdbcHelper;
import com.boxcf.models.Box;
import java.sql.SQLException;

public class ComboDao implements BoxCfDAO<Combo, String> {

    public static ComboDao getInstant() {
        return new ComboDao();
    }

    @Override
    public Combo createObjecet(ResultSet responce) {
        try {
            return new Combo(
                    responce.getString("MaCB"),
                    responce.getString("TenCB"),
                    responce.getLong("Gia"),
                    responce.getString("MaLoaiBox"),
                    responce.getInt("SoLuong"),
                    responce.getInt("SoLuong_DoUong"),
                    responce.getInt("SoLuong_Mon"),
                    responce.getString("MoTa")
            );
        } catch (Exception e) {
            throw new Error("The Error in createObjecet Combo !");
        }

    }

    @Override
    public void delete(String id) throws ExceptionInInitializerError {
        String sql = "delete Combo where MaCB = ?";

        int responce = JdbcHelper.update(sql, id);

        if (responce == 0) {
            throw new Error("The Error in delete Combo !");
        }

    }
    
    

    @Override
    public void insert(Combo e) {
        String sql = "Insert into Combo values ( ?, ?, ?, ?, ?, ?, ?, ? )";

        try {
//            int responce = JdbcHelper.update(sql,
//                    e.getMaCB(),
//                    e.getTenCB(),
//                    e.getGia(),
//                    e.getMaLoaiBox(),
//                    e.getSoLuongDoUong(),
//                    e.getSoLuongDoAn(),
//                    e.getMoTa()
//
//            );
            int responce = JdbcHelper.update(sql,
                    e.getMaCB(),
                    e.getTenCB(),
                    e.getGia(),
                    e.getMoTa(),
                    e.getMaLoaiBox(),
                    e.getSoLuongDoAn() + e.getSoLuongDoUong() + 1,
                    e.getSoLuongDoUong(),
                    e.getSoLuongDoAn()
            );

            if (responce == 0) {
                throw new Error("The Error in insert Combo !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in insert Combo !");
        }

    }
    
    public void insertTest(Combo e) throws Exception {
        String sql = "Insert into Combo values ( ?, ?, ?, ?, ?, ?, ?, ? )";

        try {

            int responce = JdbcHelper.update(sql,
                    e.getMaCB(),
                    e.getTenCB(),
                    e.getGia(),
                    e.getMoTa(),
                    e.getMaLoaiBox(),
                    e.getSoLuongDoAn() + e.getSoLuongDoUong() + 1,
                    e.getSoLuongDoUong(),
                    e.getSoLuongDoAn()
            );

            if (responce == 0) {
                throw new Error("The Error in insert Combo !");
            }
        } catch (Exception ex) {
//            System.out.println(ex);
            throw new Error("The Error in insert Combo !");
        }

    }

    @Override
    public List<Combo> selectAll() {
        List<Combo> list = new ArrayList<>();
        String sql = "select * from Combo";

        try {
            ResultSet responce = JdbcHelper.query(sql);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectAll Combo !");
        }
        return list;
    }

    @Override
    public Combo selectById(String id) {
        String sql = "select * from Combo where MaCB = ?";
        Combo c = null;
        try {

            ResultSet responce = JdbcHelper.query(sql, id);

            if (responce.next()) {
                c = createObjecet(responce);
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectById Combo !");
        }
        return c;
    }
    
    

    @Override
    public List<Combo> selectBySql(String sql, Object... args) {
        List<Combo> list = new ArrayList<>();

        try {
            ResultSet responce = JdbcHelper.query(sql, args);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectBySql Combo !");
        }
        return list;
    }

    @Override
    public void update(Combo e) {
        String sql = "update Combo set TenCB = ?, Gia = ?, MaLoaiBox = ?, SoLuong_DoUong = ?,SoLuong_Mon= ?, MoTa = ? where MaCB = ?";

        try {
            int responce = JdbcHelper.update(sql, e.getTenCB(), e.getGia(), e.getMaLoaiBox(), e.getSoLuongDoUong(), e.getSoLuongDoAn(), e.getMoTa(), e.getMaCB());

            if (responce == 0) {
                throw new Error("The Error in update Combo !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in update Combo !");
        }

    }

    public String getMaxId() throws SQLException {
        String sql = "SELECT TOP 1 * FROM Combo ORDER BY MaCB DESC";
        List<Combo> list = this.selectBySql(sql);

        return list.get(0).getMaCB();
    }

    public List<Combo> selectByLoaiBox(String maLoai) {
        String sql = "SELECT * FROM Combo WHERE MaLoaiBox = ?";
        return selectBySql(sql, maLoai);
    }

    public List<Combo> selectByKeyWord(String keyword) {
        if (selectById(keyword) != null) {
            return selectBySql("SELECT * FROM Combo WHERE MaCB = ?", keyword);
        }
        return selectBySql("SELECT * FROM Combo WHERE TenCB LIKE ?", "%" + keyword + "%");
    }

    public List<Combo> panigation(Integer pageCurrent) {
        String sql = "SELECT TOP 8 * FROM Combo WHERE MaCB NOT IN (SELECT TOP " + (pageCurrent * 8 - 8) + " MaCB FROM Combo)";
        return this.selectBySql(sql);
    }

    public Integer getPageNumber() {
        return (int) Math.ceil(this.selectAll().size() / 8) + 1;
    }
}
