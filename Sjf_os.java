/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sjf_os;

import java.util.*;
import javax.swing.SwingUtilities;
/**
 *
 * @author Ahmed Shaaban
 */
public class Sjf_os {
   
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        
        
    }
    
    public static int validation (String x){
        int n = -1;
        try {
            n = Integer.parseInt(x);
            if (n>-1)
                return n;
            else
                GUI.error();
        }catch(NumberFormatException e){
            GUI.error();
        }
        return n;
    }
}
