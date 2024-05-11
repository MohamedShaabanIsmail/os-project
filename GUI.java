/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sjf_os;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Ahmed Shaaban
 */
public class GUI  extends JFrame{
    
    JButton button = new JButton("Next");
    JTextField []arrivalTime;
    JTextField []burstTime;
    int []arrTime;
    int []burTime;
    int n;
    
    public GUI (){

        String num = JOptionPane.showInputDialog("Enter number of process", 2);
        n = Sjf_os.validation(num);
        
        if (n>1){
            arrTime = new int[n];
            burTime = new int[n];
            setTitle("Shortest Job First");
            setSize(600,600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            JLabel []arrival = new JLabel[n];
            arrivalTime = new JTextField[n] ;
            JLabel []burst = new JLabel[n];
            burstTime = new JTextField[n];

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
            panel.setPreferredSize(new Dimension(450,500));

            for (int i=0 ; i<n ; i++){
                arrival[i] = new JLabel("Enter arrival time of process"+(i+1));
                arrivalTime[i] = new JTextField();
                arrivalTime[i].setPreferredSize(new Dimension(30,20));
                burst[i] = new JLabel("Enter burst time of process"+(i+1));
                burstTime[i] = new JTextField();
                burstTime[i].setPreferredSize(new Dimension(30,20));
            }
            for(int i=0 ; i<n ; i++){
                panel.add(arrival[i]);
                panel.add(arrivalTime[i]);
                panel.add(burst[i]);
                panel.add(burstTime[i]);
            }
            panel.add(button);
            add(panel);
            button.addActionListener(new EventAction());
            setVisible(true);
        }
        else if (n<2 && n!=-1){
            GUI.error();
        }
    } 
    
    private class EventAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == button){
                for(int i=0 ; i<n ;i++){
                    arrTime[i] = Sjf_os.validation(arrivalTime[i].getText());
                    if(arrTime[i] <= -1 )
                        return;
                    burTime[i] = Sjf_os.validation(burstTime[i].getText());
                    if(burTime[i] <= -1){
                        return;
                    }
                }
                Output out = new Output(n,arrTime,burTime);
                out.setVisible(true);
            }
        }
    } 
    
    public static void error (){
        JOptionPane.showMessageDialog(null, "Invalid input", "Validation", JOptionPane.ERROR_MESSAGE);
    }
}
