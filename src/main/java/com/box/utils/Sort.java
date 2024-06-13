/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.box.utils;

import com.boxcf.components.material.ItemBill;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author PC
 */
public class Sort {
    
    public static void sortIncreased(ArrayList list) {
        
        Comparator<ItemBill> compar = new Comparator<ItemBill>() {
            @Override
            public int compare(ItemBill o1, ItemBill o2) {
                
                return o1.getData().getMaItem().toString().compareTo(o2.getData().getMaItem().toString());
                
            }
            
        };
        
        Collections.sort(list, compar);
    }
}
