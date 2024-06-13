/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.box.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcHelper {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;encrypt=true;database=BoxCF;trustServerCertificate=true;sslProtocol=TLSv1.2";
    private static String user = "sa";
    private static String pass = "123";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    //Khối static được thực thi trước PT main tại thười điểm tải class (nếu class có main)
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    public static PreparedStatement getPS(String sql, Object... objs) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, pass);
        PreparedStatement pst = null;

        //nếu câu lệnh SQL bắt đầu = { ==> gọi PT prepareCall() để thực thi Proc or Func
        //ngược lại sẽ thực thi prepareStatement bt
        if (sql.trim().startsWith("{")) {
            pst = conn.prepareCall(sql);
        } else {
            pst = conn.prepareStatement(sql);
        }

        for (int i = 0; i < objs.length; i++) {
            pst.setObject(i + 1, objs[i]);
        }

        return pst;
    }
    
    public static int update(String sql, Object... objs) {
    	try {
    		PreparedStatement pst = getPS(sql, objs);
    		
    		try {
    			return pst.executeUpdate();
    		} finally {
    			pst.getConnection().close();
    		}
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
    
    public static int update2(String sql, Object... objs) {
    	try {
    		PreparedStatement pst = getPS(sql, objs);
    		
    		try {
    			return pst.executeUpdate();
    		} finally {
    			pst.getConnection().close();
    		}
    	} catch (Exception e) {
    		return 0;
    	}
    }
    

    public static ResultSet query(String sql, Object... objs) throws SQLException {
        PreparedStatement pst = getPS(sql, objs);
        return pst.executeQuery();
    }

    public static Object value(String sql, Object... objs) {
        try {
            ResultSet rs = query(sql, objs);
            if (rs.next()) {
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

//    public static Connection getConnection() {
//        Connection conn = null;
//        try {
//            //tao 1 duong dan connection
//            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=QL_PHUKIENDT;user=sa; password=123;";
//
//            //nap driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//            //khoi tao connect tion bang driver cua minh
//            conn = DriverManager.getConnection(connectionUrl);
//        }catch(ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        
//        
//        return conn;
//    }
//    
//    public static void closeConnection(Connection conn) {
//        try {
//            if(conn != null) conn.close();
//        }catch(Exception e) {
//            System.out.println(e);
//        }
//    }
}
