package com.sb.java;

import java.util.Arrays;

public class MinimumJumps {

    public static void main(String[] args) {
        int[] inputarr = {1,3,1,2,0,1};
        System.out.println("Minimum jumps required: " + minJumps(inputarr));
    }
    public static int minJumps(int[] steps) {
        int n = steps.length;
        int[] jumps = new int[n];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + steps[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n-1];
    }

}
