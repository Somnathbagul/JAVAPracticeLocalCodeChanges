package com.sb.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class L2Evaluation {

    public static void main(String[] args) {

        String sample = "abcdeffghiikkjj";
        //find second repetative character in sample
        System.out.println("find second repetative character in sample is " + findSecondRepetativeCharacter(sample));

        int number = 5;
        //Program to check if a number is prime or not
        System.out.println("Number " + number + " Is prime or not? " + isPrime(number));
        //Program to reverse a string
        System.out.println("String abc and it's reverse string is " + reverseString("abc"));
        //Program to find the factorial of a number
        System.out.println("Calculate factorial of given number " + number + " is " + factorial(number));
        //Program to check if a string is a palindrome
        String inputString = "mam";
        System.out.println("Check the given String as " + inputString + " is palindrome? " + isPalindrome(inputString));
        //Program to find the largest and smallest elements in an array
        int[] inputArray = {1, 2, 4, 5};
        findMinMax(inputArray);

        //Program to find the second-largest element in an array
        System.out.println("second-largest number from array " + Arrays.toString(inputArray) + " is: " + findSecondLargest(inputArray));

        //Program to check if two strings are anagrams
        String str1 = "abc";
        String str2 = "bac";
        System.out.println("check Strings are anagrams or not?" + areAnagrams(str1, str2));

        //program to find the highest element in an array
        Optional<Integer> highestElement = Arrays.stream(inputArray).boxed().distinct().sorted(Collections.reverseOrder()).findFirst();
        System.out.println("highestElement is :" + highestElement.orElse(0) + " from an input array : " + Arrays.toString(inputArray));

        //program to find lowest element in an array
        Optional<Integer> lowestElement = Arrays.stream(inputArray).boxed().distinct().sorted().findFirst();
        System.out.println("lowestElement is :" + lowestElement.orElse(0) + " from an input array : " + Arrays.toString(inputArray));

        //program to find the middle element in an array
        Optional<Integer> middleElement = Arrays.stream(inputArray).boxed().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst();
        System.out.println("middleElement is :" + middleElement.orElse(0) + " from an input array : " + Arrays.toString(inputArray));

        //program to check if a number is even or odd
        System.out.println("Number " + number + " is even or odd? " + isEvenOrOdd(number));


    }

    private static String findSecondRepetativeCharacter(String sample) {
        int index = 0;
        for (int i = 0; i < sample.length() - 1; i++) {
            if (sample.charAt(i) == sample.charAt(index)) {
                index++;
            } else {
                index = 0;
            }
        }
        return sample.charAt(index) + "";
    }

    private static String isEvenOrOdd(int number) {
        if (number % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static int findSecondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Given Input Array is " + Arrays.toString(arr));
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equals(reversed);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }


}
