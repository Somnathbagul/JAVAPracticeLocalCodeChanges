package com.sb.java;

import java.util.Arrays;
/*
This is two pointer solution to get sorted order to be print for given array.
Time complexity of this solution is O(n).
[-11, -2, -1, 0, 3, 5, 10]
[0, 1, 4, 9, 25, 100, 121]
*/
public class SquareOfNumbers {
    public static void main(String[] args) {
        int [] inputArr= {-11,-2,-1,0,3,5,10};
        SquareOfNumInSortedOrder(inputArr);
    }

    private static void SquareOfNumInSortedOrder(int[] numArr) {
        printArray(numArr);
        int len = numArr.length;
        int res[] = new int[len];
        int lo =0;
        int high=len -1;
        for (int i =len -1; i >=0 ;i--){
            if(Math.abs(numArr[lo])  >= Math.abs(numArr[high])){
                res[i] = numArr[lo] * numArr[lo];
                lo++;
            }else{
                res[i] = numArr[high] * numArr[high];
                high--;
            }
        }
        printArray(res);
    }
    public static void printArray(int [] arr){
        System.out.println(Arrays.toString(arr));
    }
}
