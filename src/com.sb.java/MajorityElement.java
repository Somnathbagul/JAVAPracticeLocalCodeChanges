package com.sb.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MajorityElement {

    public static void main(String[] args) {
        int[] a ={2,3,4,5,2,3,3,3,3,3};
        System.out.println("MajorityElement from Array is: "+ findMajorityElement(a, a.length));
    }
    public static int findMajorityElement(int[] nums, int n) {
        return IntStream.of(nums).boxed()
                .collect(Collectors.groupingBy(i->i , Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > n/2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    /*public static int findMajorityElement(int[] nums, int n) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i->i , Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > n/2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }
    private static int findMajorityElement(int a[] , int size) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i:a){
            Integer val = map.get(i);
            if(val==null){
                map.put(i,1);
            }else{
                map.put(i,val+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){

            if(entry.getValue() > size / 2){
                return entry.getKey();
            }
        }
        return -1;
    }*/
}
