package com.sb.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllTest {
	
	public static void main(String[] args) {
		
		List<EmployeeInfo> empList = Arrays.asList( new EmployeeInfo(1, "Samar", "IT","Male", 20000.00),
				new EmployeeInfo(2, "Rjeev", "IT","Male", 20000.00),
				new EmployeeInfo(4, "Yogita", "HR","Female", 23000.00),
				new EmployeeInfo(3, "Ramya", "IT","Male", 24000.00),
				new EmployeeInfo(5, "Saumya", "IT","Male", 26000.00)
				);
		
		Optional<EmployeeInfo> emp = empList.stream().max(Comparator.comparingDouble(EmployeeInfo::getSalary));
		//System.out.println(emp.get());
		
		  List<EmployeeInfo> startWithS = empList.stream()
				  .filter(e -> e.getName().startsWith("S"))
				  .collect(Collectors.toList());
		   //startWithS.forEach(System.out::println);
		   
         Optional<EmployeeInfo> empStartWithS =
        		 empList.stream().filter(e -> e.getName().startsWith("S"))
        		 .max(Comparator.comparingDouble(EmployeeInfo::getSalary));
         		//System.out.println(empStartWithS.get().empName);
         
         List<Integer> numbers = Arrays.asList(1, 2, 1, 2,3, 4,2, 4,2, 4,2);
         Set<Integer> duplicated = numbers.stream()
        		 	.filter(n -> numbers.stream().filter(x -> x == n)
        		 	.count() > 1)
        		 	.collect(Collectors.toSet());
         //System.out.println(duplicated);
         
         numbers.stream().filter(i -> Collections.frequency(numbers, i) >1)
         .collect(Collectors.toSet()).forEach(System.out::println);
         
         System.out.println("Calling get max using Instream:"+getMax(numbers));
         
         System.out.println("Calling to count Occurances of each char in given String: Samar \n");
         getOccurancesOfChar("Samar").entrySet().forEach(System.out::println);
         
         System.out.println("Get the max Occurances count from given input String: Samar -> 2");
         System.out.println("abcdaba -> "+getMaxOccurancesOfChar("abcdaba") +"\n");
         
         System.out.println("abcdaba -> "+getSecondMaxOccurancesOfChar("abcdaba"));
	
	  //Given a string find out duplicate character and its count .
      //
	  dublicateCharAndItsCount("manaojpande");
	  //Test with another input - �I am a java developer and I am proud of it �
	  //dublicateCharAndItsCounts("I am a java developer and I am proud of it\n");
	  
	  System.out.println("Verify occurances from string words..");
	  String input= "I am a java developer and I am proud of it";
	  List<String> words = Arrays.asList(input.split(" "));
      System.out.println(frequencyMap(words.stream()).entrySet().stream().filter(a -> a.getValue()>1).collect(Collectors.toList()));
      
      System.out.println("Re-Verify occurances from string words..");
      Map<String, Long> grpOfWords = Arrays.asList("I am a java developer and I am proud of it".split(" "))
      .stream().collect(
    		  Collectors.groupingBy(
    				  Function.identity(),
    				  HashMap::new,
    				  Collectors.counting()));
      
      System.out.println(grpOfWords.entrySet().stream().filter(a -> a.getValue()>1).collect(Collectors.toList()));
      
	}
	
	
	@SuppressWarnings("hiding")
	public static <String> Map<String, Long>  frequencyMap(Stream<String> elements) {
        return elements.collect(
            Collectors.groupingBy(
            Function.identity(),
            HashMap::new, // can be skipped
            Collectors.counting()
            )
        );
    }
	
	public static void dublicateCharAndItsCount(String string) {
		string.chars().mapToObj(i -> (char) i)
		.collect(Collectors.groupingBy(Object::toString, Collectors.counting()))
		.entrySet().stream().filter(a -> a.getValue()>1).forEach(System.out::println);
	}
	
	public static void dublicateCharAndItsCounts(String string) {
		Arrays.asList(string.split("")).stream()
		.collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))
		.entrySet().stream().filter(o -> o.getValue()>1).forEach(System.out::println);
	}
	
	public static Map<String, Long> getOccurancesOfChar(String str) {
		return str.chars()
		        .mapToObj(i -> (char) i)
		        .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
	}

	public static Long getMaxOccurancesOfChar(String str) {
		return str.chars()
		        .mapToObj(i -> (char) i)
		        .collect(Collectors.groupingBy(Object::toString, Collectors.counting()))
		        .values().stream()
		        .mapToLong(e -> e)
                .max()
                .orElse(Integer.MIN_VALUE);
	}
	
	public static Long getSecondMaxOccurancesOfChar(String str) {
		
		return str.chars()
		        .mapToObj(i -> (char) i)
		        .collect(Collectors.groupingBy(Object::toString, Collectors.counting()))
		        .values().stream()
		        .mapToLong(e -> e).skip(1)
                .max()
                .orElse(Integer.MIN_VALUE);
	}
	
	public static Integer getMax(List<Integer> list)
	{
	    return list.stream()                        // Stream<Integer>
	                .mapToInt(v -> v)               // IntStream
	                .max()                          // OptionalInt
	                .orElse(Integer.MIN_VALUE);     // Integer
	}
}
