/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.boxcf.models;

import com.box.utils.Formats;

/**
 *
 * @author PC
 */
public class ModelCbo {

    private String title;
    private int price;

    public ModelCbo(int price) {
        this.price = price;
        this.title = Formats.toCurency(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return Formats.toCurency(price);
    }

}
