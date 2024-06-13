package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.DanhMuc;
import com.box.utils.JdbcHelper;

public class DanhMucDao implements BoxCfDAO<DanhMuc, String> {

    public static DanhMucDao getInstant() {
        return new DanhMucDao();
    }

    @Override
    public DanhMuc createObjecet(ResultSet responce) {
        try {
            return new DanhMuc(
                    responce.getString(1),
                    responce.getString(2)
            );
        } catch (Exception e) {
            throw new Error("The Error in createObjecet DanhMuc !");
        }
    }

    @Override
    public void delete(String id) {
        String sql = "delete DanhMuc where MaDM = ?";

        try {
            int responce = JdbcHelper.update(sql, id);

            if (responce == 0) {
                throw new Error("The Error in delete DanhMuc !");
            }
        } catch (Exception e) {
            throw new Error("The Error in delete DanhMuc !");
        }
    }

    @Override
    public void insert(DanhMuc e) {
        String sql = "Insert into DanhMuc values ( ?, ?)";

        try {
            int responce = JdbcHelper.update(sql, e.getMaDM(), e.getTenDM());

            if (responce == 0) {
                throw new Error("The Error in insert DanhMuc !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in insert DanhMuc !");
        }

    }

    @Override
    public List<DanhMuc> selectAll() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "select * from DanhMuc";

        try {
            ResultSet responce = JdbcHelper.query(sql);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

            responce.getStatement().getConnection().close();

        } catch (Exception e) {
            throw new Error("The Error in selectAll DanhMuc !");
        }
        return list;
    }

    @Override
    public DanhMuc selectById(String id) {
        String sql = "select * from DanhMuc where MaDM = ?";
        DanhMuc dm = null;
        try {

            ResultSet responce = JdbcHelper.query(sql, id);

            // admission a ResultSet return a Box
            if (responce.next()) {
                dm = createObjecet(responce);
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectById DanhMuc !");
        }
        return dm;
    }

    @Override
    public List<DanhMuc> selectBySql(String sql, Object... args) {
        List<DanhMuc> list = new ArrayList<>();

        try {
            ResultSet responce = JdbcHelper.query(sql, args);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectBySql DanhMuc !");
        }
        return list;
    }

    @Override
    public void update(DanhMuc e) {
        String sql = "update DanhMuc set TenDM = ? where MaDM = ?";

        try {
            int responce = JdbcHelper.update(sql, e.getTenDM(), e.getMaDM());

            if (responce == 0) {
                throw new Error("The Error in update DanhMuc !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in update DanhMuc !");
        }

    }

    public DanhMuc selectByName(String name) {
        String sql = "select * from DanhMuc where TenDM = ?";
        DanhMuc dm = null;
        try {

            ResultSet responce = JdbcHelper.query(sql, name);

            // admission a ResultSet return a Box
            if (responce.next()) {
                dm = createObjecet(responce);
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectById DanhMuc !");
        }
        return dm;
    }

    public List<DanhMuc> selectByKeyWord(String keyWord, int type) {
        String sql = "";
        if (type == 0) {
            sql = "select * from DanhMuc where TenDM like ?";
        } else if (type == 1) {
            sql = "select * from DanhMuc where MaDM like ?";
        }
        return selectBySql(sql, "%" + keyWord + "%");
    }

    public String selectByNameDm(String name) {
        String sql = "select MaDM from DanhMuc\n"
                + "where TenDM = ?";

        return (String) JdbcHelper.value(sql, name);
    }
}
