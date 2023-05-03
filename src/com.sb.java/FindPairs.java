package com.sb.java;

import java.util.*;

public class FindPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num = 9;
        findPairs(arr, num);
    }

    public static void findPairs(int[] arr, int num) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = num - arr[i];
            if (set.contains(diff)) {
                System.out.println("Pair found: " + diff + ", " + arr[i]);
            }
            set.add(arr[i]);
        }
    }
}
