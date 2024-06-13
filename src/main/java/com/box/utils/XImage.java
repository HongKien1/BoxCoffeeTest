/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.box.utils;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author HP
 */
public class XImage {

    // luu 1 file vao thuc muc co ten la logo
    //tao doi tuong File dst tro toi thu muc logos, lay ten la ten file ma ngta dua vo
    public static void save(File src) {
        //sau do kiem tra xem thu muc logos ton tai hay chua ==> neu chua tao moi
        File dst = new File("logos", src.getName());
        //dst.getParentFile() thu muc chua cai file do
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }

        //copy 1 file vao thu muc to (logos), neu file da ton tai thi thay the luon
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static Image resize(Image image, int width, int height) {
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    

}
