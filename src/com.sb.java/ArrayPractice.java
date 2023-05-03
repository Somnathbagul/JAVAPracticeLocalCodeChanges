package com.sb.java;

import java.util.*;

public class ArrayPractice {
	
	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		System.out.println(array);
		int index = 3;
		System.arraycopy(array, index + 1, array, index, array.length - index - 1);
		System.out.println(array);
	}

}
