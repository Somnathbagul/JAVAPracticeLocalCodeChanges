package com.sb.java;

import java.util.Arrays;

/*
 * 
 The equilibrium index of an array is an index such that 
 the sum of elements at lower indexes is equal to the sum of elements at higher indexes. 

Examples: 
Input: A[] = {-7, 1, 5, 2, -4, 3, 0}  Output: 3  3 is an equilibrium index, because:  A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
Input: A[] = {1, 2, 3} 

Output: -1


Input A[] = {1,3,9,4}
Output = 2


Input A[] = {8, 6, -6}
Output = 0

steps:
loop: j lenght-1
	loop: i
	letf,right=0
	1. check i with i+1 if it's gretter than i then lett+i; 0 = 13
	2. check i with i+1 if it's smaller than i then right+i;0+9= 9
	if(letf=right){ 5=9
	return arr[i];
	}else{
	 return -1
	}
	end loop
end loop;

 */



public class EqulibriumIndex {

	public static void main(String[] args) {

		//int A[] = {1,3,9,4};
		//int A[] = {8, 6, -6};
		  int A[] = {1, 2, 3};
		int result = equlibriumIndex( A, A.length);
		if(result!= -1) {
			System.out.println("equilibrium check: index - "+result + " value from given array A["+A[result] +"]");
		}else {
			System.out.println("Don't have any equilibrium index of an array In Given Array "+A);
		}
	}

	private static int equlibriumIndex(int[] a, int length) {

		int totalSum =0;
		int leftSum =0;
		
		totalSum = Arrays.stream(a).sum();
		
		for(int i =0; i <length; i++)
		{
			int rightSum = totalSum - leftSum - a[i];
			if(leftSum == rightSum) {
				return i;
			}
			leftSum = leftSum + a[i];
		}
		
		return -1;
	}

}
