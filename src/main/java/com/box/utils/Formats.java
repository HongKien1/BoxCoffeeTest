/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.box.utils;

import java.text.DecimalFormat;

/**
 *
 * @author PC
 */
public class Formats {

    public static String toCurency(long number) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(number) + " VND";

    }

    public static String toCurency(double number) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(number) + " VND";
    }

}
