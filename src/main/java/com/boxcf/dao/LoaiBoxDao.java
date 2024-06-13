package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.LoaiBox;
import com.box.utils.JdbcHelper;
import java.sql.SQLException;

public class LoaiBoxDao implements BoxCfDAO<LoaiBox, String> {

    public static LoaiBoxDao getInstance() {
        return new LoaiBoxDao();
    }

    final String INSERT_SQL = "INSERT INTO LoaiBox VALUES (?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE LoaiBox SET TenLoaiBox = ?, GiaLoai = ?, Mota = ? WHERE MaLoaiBox = ?";
    final String DELETE_SQL = "DELETE FROM LoaiBox WHERE MaLoaiBox = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM LoaiBox";
    final String SELECT_BY_ID_SQL = "SELECT * FROM LoaiBox WHERE MaLoaiBox = ?";
    final String SELECT_BY_NAME_SQL = "SELECT * FROM LoaiBox WHERE TenLoaiBox LIKE ?";

    @Override
    public void insert(LoaiBox loaiBox) {
        JdbcHelper.update(INSERT_SQL, loaiBox.getMaLoaiBox(), loaiBox.getTenLoaiBox(), loaiBox.getGiaLoai(), loaiBox.getMoTa());
    }

    @Override
    public void update(LoaiBox loaiBox) {
        JdbcHelper.update(UPDATE_SQL, loaiBox.getTenLoaiBox(), loaiBox.getGiaLoai(), loaiBox.getMoTa(), loaiBox.getMaLoaiBox());
    }

    @Override
    public void delete(String id) throws ExceptionInInitializerError{
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<LoaiBox> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LoaiBox selectById(String id) {
        List<LoaiBox> list = selectBySql(SELECT_BY_ID_SQL, id);

        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
    
    public LoaiBox selectByIdBox(String id) {
        List<LoaiBox> list = selectBySql(SELECT_BY_ID_SQL, id);

        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public List<LoaiBox> selectBySql(String sql, Object... args) {
        List<LoaiBox> list = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                LoaiBox loaiBox = new LoaiBox();

                loaiBox.setMaLoaiBox(rs.getString("MaLoaiBox"));
                loaiBox.setTenLoaiBox(rs.getString("TenLoaiBox"));
                loaiBox.setGiaLoai(rs.getLong("GiaLoai"));
                loaiBox.setMoTa(rs.getString("MoTa"));

                list.add(loaiBox);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public LoaiBox createObjecet(ResultSet responce) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<LoaiBox> selectByKeyWord(String keyword) {
        if (selectById(keyword) != null) {
            return selectBySql(SELECT_BY_ID_SQL, keyword);
        }
        return selectBySql(SELECT_BY_NAME_SQL, "%" + keyword + "%");
    }
    
    
}
