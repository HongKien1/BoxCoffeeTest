package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.ComboCT;
import com.box.utils.JdbcHelper;

public class ComboCTDao implements BoxCfDAO<ComboCT, String> {
    
    public static ComboCTDao getInstant() {
        return new ComboCTDao();
    }
    
    @Override
    public ComboCT createObjecet(ResultSet responce) {
        try {
            return new ComboCT(
                    responce.getInt(1),
                    responce.getString(2),
                    responce.getString(3),
                    responce.getString(4),
                    responce.getInt(5),
                    responce.getString(6)              
            );
        } catch (Exception e) {
            System.out.println(e);
            throw new Error("The Error in createObjecet ComboCT !");
        }
    }
    
    @Override
    public void delete(String id) {
        String sql = "delete ComboCT where MaCB = ?";
        
        try {
            int responce = JdbcHelper.update(sql, id);
            
            if (responce == 0) {
                throw new Error("The Error in delete ComboCT !");
            }
        } catch (Exception e) {
            throw new Error("The Error in delete ComboCT !");
        }
        
    }
    
    @Override
    public void insert(ComboCT e) {
        String sql = "Insert into ComboCT values (?, ?, ?, ?, ?, '')";
        
        try {
            int responce = JdbcHelper.update(sql, e.getMaHd(), e.getMaCB(), e.getMaSp(), e.getMaBox(), e.getSoLuong());
            
            if (responce == 0) {
                throw new Error("The Error in insert ComboCT !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in insert ComboCT !");
        }
        
    }
    
    public void insertProc(ComboCT e, int MaHD) {
        String sql = "Insert into ComboCT values (?, ?, ?)";
        
        try {
            int responce = JdbcHelper.update(sql, MaHD, e.getMaCB(), e.getGhiChu());
            
            if (responce == 0) {
                throw new Error("The Error in insert ComboCT !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in insert ComboCT !");
        }
        
    }
    
    @Override
    public List<ComboCT> selectAll() {
        List<ComboCT> list = new ArrayList<>();
        String sql = "select * from ComboCT";
        
        try {
            ResultSet responce = JdbcHelper.query(sql);
            
            while (responce.next()) {
                list.add(createObjecet(responce));
            }
            
        } catch (Exception e) {
            throw new Error("The Error in selectAll ComboCT !");
        }
        return list;
    }
    
    @Override
    public ComboCT selectById(String id) {
        String sql = "select * from ComboCT where MaCB = ?";
        
        try {
            
            ResultSet responce = JdbcHelper.query(sql, id);

            // admission a ResultSet return a Box
            if (responce.next()) {
                return createObjecet(responce);
            }
            
        } catch (Exception e) {
            throw new Error("The Error in selectById ComboCT !");
        }
        return null;
    }
    
    public String getMaCombo(int idHd) {
        String sql = "select MaCB from ComboCT\n"
                + "where MaHD = ?";
        
        return (String) JdbcHelper.value(sql, idHd);
    }
    
    @Override
    public List<ComboCT> selectBySql(String sql, Object... args) {
        List<ComboCT> list = new ArrayList<>();
        
        try {
            ResultSet responce = JdbcHelper.query(sql, args);
            
            while (responce.next()) {
                list.add(createObjecet(responce));
            }
            
        } catch (Exception e) {
            throw new Error("The Error in selectBySql ComboCT !");
        }
        return list;
    }
    
    @Override
    public void update(ComboCT e) {
        String sql = "update ComboCT set GhiChu = ? where MaCB = ?";
        
        try {
            int responce = JdbcHelper.update(sql, e.getGhiChu(), e.getMaCB());
            
            if (responce == 0) {
                throw new Error("The Error in update ComboCT !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in update ComboCT !");
        }
        
    }
    
    public static void main(String[] args) {

        System.out.println(ComboCTDao.getInstant().getMaCombo(266));
    }
    
}
