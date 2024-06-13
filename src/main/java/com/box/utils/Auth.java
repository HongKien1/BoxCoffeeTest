/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.box.utils;

//import com.edusys.model.NhanVien;
import com.boxcf.dao.NhanVienDao;
import com.boxcf.models.NhanVien;
import java.awt.Component;

/**
 *
 * @author HP
 */
public class Auth {

    public static NhanVien user = NhanVienDao.getInstant().selectById("NV04");

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        return Auth.isLogin() && user.getVaiTro().equalsIgnoreCase("Admin");
    }

    public static boolean accept(Component fram) {
        if (!Auth.isManager()) {
            MsgBox.alert(fram, "Bạn Không Có Quyền Thực Hiện Chức Năng Này !");
            return false;
        }
        return true;
    }

}
