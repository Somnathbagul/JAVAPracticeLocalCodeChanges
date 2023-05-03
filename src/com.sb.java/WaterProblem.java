package com.sb.java;

public class WaterProblem {

	public static void main(String[] args) {
		
		//given n =5 and k = 8 then function should return 2.
		
		// given N=1 and K =2 then function should return -1.
		
		//  N is no of glass as well as the capacity of glass is same as N.
		// K is the water in liter.
		
		System.out.println("Minimum requirment of glasses are : "+ solution(5, 8));
	}

	private static int solution(int n, int k) {
		// TODO Auto-generated method stub
		int ans=0;
		int arr[]= null; 
		if(n<=1)
		{	
			ans= -1;
		}else {
			for(int i= 1; i<=n;i++)
			arr[i]=i;
		}
		System.out.println(arr);
		
		return ans;
	}
}
