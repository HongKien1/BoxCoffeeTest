
package com.box.utils;

import java.awt.Component;
import javax.swing.JOptionPane;


public class MsgBox {
    
    public static void alert(Component parent, String mess) {
        JOptionPane.showMessageDialog(parent, mess, "Box Coffee", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean confirm(Component parent, String mess) {
        int option = JOptionPane.showConfirmDialog(parent, mess, "Box Coffee", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return option == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component parent, String mess) {
        return JOptionPane.showInputDialog(parent, mess, "Box Coffee", JOptionPane.INFORMATION_MESSAGE);
    }
}
