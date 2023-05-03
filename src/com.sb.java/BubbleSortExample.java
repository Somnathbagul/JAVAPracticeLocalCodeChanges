package com.sb.java;

import java.util.Arrays;

public class BubbleSortExample {
    public static void main(String[] args) {
        int[] array = { 5, 3, 8, 6, 7, 2 };

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(array));

        bubbleSort(array);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // Swap elements
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }

            n--;
        }
    }
}
