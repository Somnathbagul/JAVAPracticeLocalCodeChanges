package com.sb.java;

import java.util.HashSet;
import java.util.Set;

public class PairInGivenArray {

    public static boolean isPairInArray(int[] arr, int num1) {
        Set<Integer> complementSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (complementSet.contains(arr[i])) {
                return true;
            } else {
                complementSet.add(num1 - arr[i]);
               
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int num1 = 5;


        if (isPairInArray(arr, num1)) {
            System.out.println("There exists a pair in the array that adds up to " + num1 );
        } else {
            System.out.println("There is no pair in the array that adds up to " + num1);
        }
    }
}