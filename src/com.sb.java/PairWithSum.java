package com.sb.java;

import java.util.*;

public class PairWithSum {

    public static void findPairWithSum(int[] arr, int sum) {
        Optional<Integer> found = Optional.empty();
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = sum - arr[i];
            if (complementMap.containsKey(complement)) {
                System.out.println("Pair with sum " + sum + " found: (" + complement + ", " + arr[i] + ")");
                found = Optional.of(complement);
                complementMap.put(arr[i], complement);
            } else {
                complementMap.put(arr[i], 0);
            }
        }
        //complementMap.forEach((k,v) -> System.out.println(k +" "+v));
        if(found.isEmpty()){
            System.out.println("No pair with sum " + sum + " found.");
        }
    }

    public static void main(String[] args) {
        List inputArray = new ArrayList<>(Arrays.asList(new int[]{1, 2, 6},new int[]{1,2,3,4,5,6}));
        int sum = 9;
        for(Object arr : inputArray){
            findPairWithSum((int[]) arr, sum);
        }
    }
}
