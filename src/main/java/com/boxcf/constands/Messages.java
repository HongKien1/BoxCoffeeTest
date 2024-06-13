/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.constands;

import com.boxcf.models.ModelStatistical;

/**
 *
 * @author PC
 */
public class Messages {

    public static String waitting = "chờ...";
    public static String notUse = "not used yet...";

    public static String chartMess(ModelStatistical data) {
        if (data == null) {
            return "Chưa chọn thời gian phù hợp";
        }
        String mess = data.getCategory() + " trong " + data.getTitle();

        return mess.toUpperCase();
    }

}
