/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author HP
 */
public interface BoxCfDAO<E, K> {
    void insert(E e);
    void update(E e);
    void delete(K id);
    List<E> selectAll();
    E selectById(K id);
    List<E> selectBySql(String sql, Object... args);
    E createObjecet(ResultSet responce);    
}
