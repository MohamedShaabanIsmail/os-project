/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sjf_os;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ahmed Shaaban
 */
public class Output extends JFrame {
    
    
    public Output (int n, int []arrTime, int []burTime){
        
        float [][] out = Calc.order(n,arrTime,burTime);
        
        setTitle("Shortest Job First");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(n+3,5));
        
        JLabel label0 = new JLabel("Process");
        JLabel label1 = new JLabel("Burst Time");
        JLabel label2 = new JLabel("Arrivale Time");
        JLabel label3 = new JLabel("Waiting Time");
        JLabel label4 = new JLabel("Turnaround Time");
        JLabel label5 = new JLabel("Average Waiting Time");
        JLabel label6 = new JLabel("Average Turnaround Time");
        JLabel [][]arr = new JLabel[n+2][5];
        
        for(int i=0 ; i<n ; i++){
            arr[i][0] = new JLabel(String.valueOf(out[i][0]));
            arr[i][1] = new JLabel(String.valueOf(out[i][1]));
            arr[i][2] = new JLabel(String.valueOf(out[i][2]));
            arr[i][3] = new JLabel(String.valueOf(out[i][3]));
            arr[i][4] = new JLabel(String.valueOf(out[i][4]));
        }
        arr[n][0] = new JLabel(String.valueOf(out[n][0]));
        arr[n+1][0] = new JLabel(String.valueOf(out[n+1][0]));
        
        add(label0);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        
        for(int i=0 ; i<n ; i++){
            add(arr[i][0]);
            add(arr[i][1]);
            add(arr[i][2]);
            add(arr[i][3]);
            add(arr[i][4]);
        }
        
        add(label5);
        add(arr[n][0]);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(label6);
        add(arr[n+1][0]);
        
        
        
    }
    
}
