package com.sb.java;

public class StringReverse {

    public static void main(String[] args) {
        String inputStr = "abc";
        //Approach 1: Using a for loop
        System.out.println("ReverseString of "+inputStr+" is "+reverseStringUsingAforLoop(inputStr));
        //Approach 2: Using the StringBuilder class
        System.out.println("ReverseString of "+inputStr+" is "+reverseStringUsingTheStringBuilderClass(inputStr));
        //Approach 3: Using recursion
        System.out.println("ReverseString of "+inputStr+" is "+reverseStringUsingRecursion(inputStr));

        //fibonacci series
        int num = 7;
        System.out.println("fibonacci series for number "+num +"are as "+fibonacci(num));

    }
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


    public static String reverseStringUsingAforLoop(String str) {
        String reverse = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }
    public static String reverseStringUsingTheStringBuilderClass(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static String reverseStringUsingRecursion(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            return reverseStringUsingRecursion(str.substring(1)) + str.charAt(0);
        }
    }


}
