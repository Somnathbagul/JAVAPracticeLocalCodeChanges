package com.sb.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Testing {

	public static void main(String[] args) {
		
		 List<Integer> slist= new ArrayList<Integer>();
		 int max =50;
		 for(int i =1; i< max; i++) {
			 int randomWithThreadLocalRandomFromZero = ThreadLocalRandom.current().nextInt(max);
			 slist.add(randomWithThreadLocalRandomFromZero);
			 slist.add(22);
		 }
		 slist.parallelStream().filter(num -> num.toString().contains("2"))
		 .distinct()
		 .collect(Collectors.toList()).forEach(System.out::println);
		 
	
		 List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		 Optional<Integer> firstSquareDivisibleByThree =
		   someNumbers.stream()
		              .map(x -> x * x)
		              .filter(x -> x % 3 == 0)
		              .findFirst(); // 9
		 System.out.println("firstSquareDivisibleByThree: "+firstSquareDivisibleByThree.get());
	
	}

}
