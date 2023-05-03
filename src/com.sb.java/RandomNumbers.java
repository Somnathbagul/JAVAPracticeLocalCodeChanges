package com.sb.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers {

	public static void main(String[] args) {
		
	 List<String> slist= new ArrayList<String>();
	 int max =50;
	 for(int i =1; i< max+2; i++) {
		 int randomWithThreadLocalRandomFromZero = ThreadLocalRandom.current().nextInt(max);
		 slist.add("Mandates"+randomWithThreadLocalRandomFromZero);
		 
	 }
	 //System.out.println(slist);
	 slist.stream().sorted().forEach(System.out::println);
	}

}
