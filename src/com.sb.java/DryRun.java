package com.sb.java;

import java.util.Arrays;

public class DryRun {

    public static void main(String[] args) {
        //find the min max
        int [] inputarr = {-4,1,2,3,4};
        findMinAndMax(inputarr);
    }

    private static void findMinAndMax(int[] inputarr) {
        int min = inputarr[0];
        int max = inputarr[0];

        for(int i =1 ; i < inputarr.length; i++){
            if(inputarr[i] < min){
                min = inputarr[i];
            }
            if(inputarr[i]> max ){
                max = inputarr[i];
            }
        }
        System.out.println("Input array :"+ Arrays.toString(inputarr));
        System.out.println("Min from Array "+min);
        System.out.println("Max from Array "+max);

    }

}
