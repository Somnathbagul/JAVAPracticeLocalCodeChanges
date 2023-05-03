package com.sb.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfArrayElements {

    public static void main(String[] args) {
        int [] num = {1,2,3,4,5};
        int sum1 = Arrays.stream(num).sum();
        System.out.println(sum1);
        int sum2 = IntStream.of(num).sum();
        System.out.println(sum2);
        int sum3 = Arrays.stream(num).reduce((x,y) -> x+y).getAsInt();
        System.out.println(sum3);
        int sum4 = Arrays.stream(num).reduce(Integer::sum).getAsInt();
        System.out.println(sum4);
        int sum5 = Arrays.stream(num).reduce(0,Integer::sum);
        System.out.println(sum5);
        long sum6 = Arrays.stream(num).summaryStatistics().getSum();
        System.out.println(sum6);

        //--------------------


    }
}
