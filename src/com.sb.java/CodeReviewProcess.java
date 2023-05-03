package com.sb.java;

import java.util.List;
import java.util.ArrayList;

public class CodeReviewProcess {
    public static void main(String[] args) {
        // Create a list of numbers to be summed
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Call the sumOfEven method and print the result
        int sum = sumOfEven(numbers);
        System.out.println("Sum of even numbers: " + sum);
    }

    /**
     * Calculates the sum of all even numbers in a list.
     * @param numbers the list of numbers to sum
     * @return the sum of all even numbers in the list
     */
    public static int sumOfEven(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }
}
