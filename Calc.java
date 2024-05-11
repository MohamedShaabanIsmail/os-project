/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sjf_os;

/**
 *
 * @author Ahmed Shaaban
 */
public class Calc {
    
    public static float[][] order (int n, int []arrTime, int []burTime){
        
//        int []ord = new int[n];
//        int []finsh = new int[n];
//        int [][]arr = new int[n][3];
//        int current = Integer.MAX_VALUE;
//        
//        for(int i=0 ; i<n ; i++){
//            if(arrTime[i] < current)
//                current = arrTime[i];
//        }
//        int count = 0;
//        while(true){
//            int min = Integer.MAX_VALUE;
//            for(int i=0; i<n ; i++){
//                if(burTime[i] < min && finsh[i] != 1 && arrTime[i] <= current){
//                    min = burTime[i];
//                    ord[count] = i;
//                }
//            }
//            finsh[ord[count]] = 1;
//            arr[count][0] = ord[count];
//            arr[count][1] = current - arrTime[ord[count]];
//            arr[count][2] = ord[count];
//            count++;
//            
//        }
//        
//        for(int i=1 ; i<n ; i++){
//            for(int e=0 ; e<n ; e++){
//                if(burTime[ord[i]] > burTime[e] && finsh[e] != 1 && arrTime[e] <= min)
//                    ord[i] = e;
//                
//            }
//            finsh[ord[i]] = 1;
//        }
 

        int pid[] = new int[n];
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n];  //wt means waiting time
        int f[] = new int[n];  // f means it is flag it checks process is completed or not
        int st=0, tot=0;
        float avgwt=0, avgta=0;
        float [][]result = new float[n+2][5];
        
        for(int i=0 ; i<n ; i++){
            pid[i] = i+1;
            f[i] = 0;
        }

        while(true){
            int c=n, min=999;
            if (tot == n) // total no of process = completed process loop will be terminated
                break;
            for (int i=0; i<n; i++)
            {
                if ((arrTime[i] <= st) && (f[i] == 0) && (burTime[i]<min)){
                    min=burTime[i];
                    c=i;
                }
            }
            /* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
            if (c==n)
                st++;
            else{
                ct[c] = st + burTime[c];
                st += burTime[c];
                ta[c] = ct[c] - arrTime[c];
                wt[c] = ta[c] - burTime[c];
                f[c] = 1;
                pid[tot] = c;
                tot++;
            }
        }
        
        for(int i=0 ; i<n ; i++){
            avgwt += wt[i];
            avgta += ta[i];           
        }
        avgwt /= n;
        avgta /= n;
        
        for(int i=0 ; i<n ; i++){
            result[i][0] = (float)pid[i];
            result[i][1] = (float)burTime[pid[i]];
            result[i][2] = (float)arrTime[pid[i]]; 
            result[i][3] = (float)wt[pid[i]]; 
            result[i][4] = (float)ta[pid[i]]; 
        }
        result[n][0] = avgwt;
        result[n+1][0] = avgta;
        return result;
    }

    
}
