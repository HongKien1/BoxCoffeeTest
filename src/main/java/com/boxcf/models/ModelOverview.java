/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

/**
 *
 * @author PC
 */
public class ModelOverview {

    private String title;
    private double num;
    private String image;

    public ModelOverview(String title, double num, String image) {
        this.title = title;
        this.num = num;
        this.image = image;
    }

    public ModelOverview() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ModelOverview{" + "title=" + title + ", num=" + num + ", image=" + image + '}';
    }

}
