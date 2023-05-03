package com.sb.java;

import java.util.Objects;

public class TurneryOperator {
	
	public static void main(String[] args) {
		
		String str1 = null ;
		String str2 = null ;
		String vaildityEndDate =  Objects.nonNull(str1)?str1:str2;
		if(Objects.nonNull(vaildityEndDate)) {
			System.out.println("verify vaildityEndDate: "+vaildityEndDate);
		}
	}

}
