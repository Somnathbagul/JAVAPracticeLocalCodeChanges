package com.sb.java;
import java.util.Arrays;
public class ThirdHighestNumber {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 15, 30, 25};
        int thirdHighest = findThirdHighest(arr);
        System.out.println("Third highest number is: " + thirdHighest);
        int nHighest = 3;
        int highestNumber = findThirdHighestNum(arr, nHighest);
        System.out.println(nHighest+" Highest number is: " + highestNumber);
    }

    public static int findThirdHighest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }
        }
        return third;
    }

    public static int findThirdHighestNum(int[] arr, int nHighest) {
        return Arrays.stream(arr)
                .distinct()
                .sorted()
                .skip(Math.max(0, arr.length - nHighest))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid input"));
    }
}
