/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.dao;

import com.box.utils.JdbcHelper;
import com.boxcf.models.DatTruoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DatTruocDao implements BoxCfDAO<DatTruoc, Integer> {

    public static DatTruocDao getInstant() {
        return new DatTruocDao();
    }

    @Override
    public void insert(DatTruoc e) {
        String sql = "insert into DatTruoc \n"
                + "values(?, ?, ?, ?, 1)";

        try {
            int responce = JdbcHelper.update(sql, e.getMaBox(), e.getTenKH(), e.getGioBD(), e.getGioKT());

            if (responce == 0) {
                throw new Error("The Error in insert ComboCT !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in insert ComboCT !");
        }
    }

    @Override
    public void update(DatTruoc e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        String sql = "update DatTruoc\n"
                + "set TranThai = 0\n"
                + "where MaDT = ?";

        try {
            int responce = JdbcHelper.update(sql, id);

            if (responce == 0) {
                throw new Error("The Error in delete ComboCT !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in delete ComboCT !");
        }
    }

    @Override
    public List<DatTruoc> selectAll() {
        List<DatTruoc> list = new ArrayList<>();
        String sql = "select * from DatTruoc";

        try {
            ResultSet responce = JdbcHelper.query(sql);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectAll Dattruoc !");
        }
        return list;
    }

    public List<DatTruoc> selectAllWithIdBox(int idBox) {
        List<DatTruoc> list = new ArrayList<>();
        String sql = "select * from DatTruoc where MaBox = ? and TranThai = 1 order by GioKT";

        try {
            ResultSet responce = JdbcHelper.query(sql, idBox);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectAllWithIdBox Dattruoc !");
        }
        return list;
    }

    public List<DatTruoc> selectAllWithIdBoxActive(int idBox) {
        List<DatTruoc> list = new ArrayList<>();
        String sql = "select * from DatTruoc\n"
                + "where TranThai = 1 and MaBox = ?\n"
                + "order by GioKT ";

        try {
            ResultSet responce = JdbcHelper.query(sql, idBox);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            System.out.println(e);
            throw new Error("The Error in selectAllWithIdBox Dattruoc !");
        }
        return list;
    }

    @Override
    public DatTruoc selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DatTruoc> selectBySql(String sql, Object... args) {
        List<DatTruoc> list = new ArrayList<>();

        try {
            ResultSet responce = JdbcHelper.query(sql, args);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectBySql DATBOX !");
        }
        return list;
    }

    @Override
    public DatTruoc createObjecet(ResultSet responce) {
        try {
            return new DatTruoc(
                    responce.getInt(1),
                    responce.getInt(2),
                    responce.getString(3),
                    responce.getTimestamp(4),
                    responce.getTimestamp(5),
                    responce.getBoolean(6)
            );
        } catch (Exception e) {
            throw new Error("The Error in createObjecet ComboCT !");
        }
    }

   

}
