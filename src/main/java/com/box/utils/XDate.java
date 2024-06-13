/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.box.utils;

import com.boxcf.models.Time;
import com.boxcf.store.Store;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author HP
 */
public class XDate {

    static SimpleDateFormat fm = new SimpleDateFormat();

    public static Date now() {
        return new Date();
    }

    public static Date toDate(String date, String pattern) {
        try {
            fm.applyPattern(pattern);
            return fm.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date, String pattern) {
        fm.applyPattern(pattern);
        return fm.format(date);
    }

    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 6 * 6 * 1000);
        return date;
    }

    public static Date addHours(Date date, int hours) {
        date.setTime(date.getTime() + hours * 60 * 60 * 1000);
        return date;
    }

    public static Date putHours(Date date, int hours) {
        date.setTime(date.getTime() - (hours * 60 * 60 * 1000));
        return date;
    }

    public static Date addMinus(Date date, int minus) {

        date.setTime(date.getTime() + (minus * 60 * 1000));

        return date;
    }

    public static Time toTime(String textGioKT) throws ExceptionInInitializerError {
        Time t = null;
        if (textGioKT.equals("")) {
            return null;
        }

        Date endHour = XDate.toDate(textGioKT, "MM/dd/yyyy HH:mm:ss");
        long millis = endHour.getTime();
        long useHour = millis - XDate.now().getTime();
        double totalSecond = Math.floor(useHour) / 1000;
        int hour = (int) (Math.floor(totalSecond / 3600) % 24);
        int minute = (int) (Math.floor(totalSecond / 60) % 60);
        int second = (int) (Math.floor(totalSecond % 60));

        t = new Time(hour, minute, second);
        return t;
    }

    public static Date timeClose() {
        String date = XDate.toString(XDate.now(), "MM/dd/yyyy");
        // 23h đóng cửa nên nếu thời gian bắt đầu là lớn hơn 22h vd 22h10p thì sẻ không hợp lí
        // nhưng thời gian bắt đầu là 22h thì lại hợp lí nên chỉ bỏ những giờ lớn hơn 22h
        String timeClose = date + " 22:00:00";
        return XDate.toDate(timeClose, Store.partten);
    }

    public static Date getHour(String hour) {
        String date = XDate.toString(XDate.now(), "MM/dd/yyyy");
        // 23h đóng cửa nên nếu thời gian bắt đầu là lớn hơn 22h vd 22h10p thì sẻ không hợp lí
        // nhưng thời gian bắt đầu là 22h thì lại hợp lí nên chỉ bỏ những giờ lớn hơn 22h
        String timeClose = date + " " + hour;
        return XDate.toDate(timeClose, Store.partten);
    }

    public static int getHour(Date start, Date end) {
        long secondStart = start.getTime();
        long secondEnd = end.getTime();

        long second = secondEnd - secondStart;

        int hour = (int) (second / 60 / 60 / 1000);

        return hour;
    }

    public static boolean beforeTimeClose(Date date) {
        return XDate.timeClose().before(date);
    }

    public static int fitHourWithTime(Date input) {
        int i = 1;
        while (true) {
            Date date = XDate.addHours(new Date(input.getTime()), i);

            if (XDate.beforeTimeClose(date)) {
                break;
            }

            i++;
        }
        return i;
    }

    public static int fitHourWithTime(Date input, Date limit) {
        int i = 1;
        while (true) {
            Date date = XDate.addHours(new Date(input.getTime()), i);

            if (date.after(limit)) {
                break;
            }

            i++;
        }
        return i;
    }

    public static Date convertHourAndMinusToDate(int hour, int minus) {
        String date = XDate.toString(XDate.now(), "MM/dd/yyyy");

        String timeClose = date + " " + hour + ":" + minus + ":00";
        return XDate.toDate(timeClose, Store.partten);
    }

    public static void main(String[] args) throws ParseException {
        Date t1 = XDate.getHour("18:00:00");
        Date t2 = XDate.getHour("18:01:00");

        System.out.println("hour: " +(t2.getTime() - t1.getTime()));
    }

}
