package com.techgig;
import java.io.*;
public class CandidateCode 
{ 

    public static int traveltime(int[] input1,int input2)
    {
    int max=0;
        for(int i=0;i<input2;i++){
            for(int j=i+1;j<input2;j++){
                int val=Math.min(getClockWiseValue(input1,i,j),getCounterClockwiseValue(input1,input2,i,j));
                if(max<val){
                    max=val;
                }    
            }
        }
    return max;
    }
    private static int getClockWiseValue(int []input,int i,int j){
    int val=input[i]+input[j]+Math.abs(j-i);
    return val;
    }
    
    private static int getCounterClockwiseValue(int []input,int size, int i,int j){
        int val=input[i]+input[j]+(size-Math.abs(j-i));
        return val;
    }
}