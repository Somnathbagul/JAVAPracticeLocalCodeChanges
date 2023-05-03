package com.sb.java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCompression {
    public static void main(String[] args) throws IllegalArgumentException {
        String inputString = "aaabbc";
        String compressed = inputString.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .map(e -> e.getKey() + String.valueOf(e.getValue())) // concatenate character and count
                .collect(Collectors.joining()); // join all substrings into a single string
        System.out.println(compressed); // prints "a3b2c1"

        // find first non-recurring char in given string
        String str = "Deepak";
        Character nonRecurringChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new , Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue()==1L)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(nonRecurringChar);

        // find the intersection of two arrays of integers
        int [] first ={1,2,3,4,5,6};
        int [] second = {1,2,3,7,9};
        int [] intersect = intersection(first,second);
        System.out.println("first :" +Arrays.toString(first));
        System.out.println("second :"+ Arrays.toString(second));
        System.out.println("intersect :" +Arrays.toString(intersect));

        // method that checks whether a given string is a palindrome?
        String [] stringArray = {"Samar","mam", null, ""};
        for(String strObj : stringArray){
            System.out.println(strObj+" isPalindrome ? :" + isPalindrome(strObj));
        }

        // Method to find kth LargestElement from input array
        int [] inputArray = {2,3,10,4,5,8,10};
        int kthElement = 4;
        System.out.println("Find Kth (" +kthElement+") largest element is:" + kthLargestElement(inputArray, kthElement));

        //method that calculates the factorial of a given non-negative integer
        int [] calArray = {2,-4,3,-6};
        for(int num : calArray){
            System.out.println("factorial of a given non-negative integer - "+num + " factorial is - "+factorial(num));
        }

        //  method that returns the maximum difference between two elements in an array of integers, such that the second element comes after the first one
        int [] testArray = {1,2,4}; // output : -3
        System.out.println("maxDifference -"+maxDifference(testArray));


    }
    public static int[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int kthLargestElement(int[] arr, int k) {
        return Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Collections.reverseOrder())
                .limit(k)
                .reduce((a, b) -> b)
                .orElseThrow(() -> new IllegalArgumentException("Array is empty or k is out of bounds."));
    }

    public static int factorial(int n) {
       /* if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }*/
        if(n>0){
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }else{
            return -1;
        }
    }

    public static int maxDifference(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("array must have at least 2 elements");
        }
        int min = arr[0];
        int maxDiff = 0;
        for (int i = 1; i < arr.length; i++) {
            maxDiff = Math.max(maxDiff, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return maxDiff;
    }



}
