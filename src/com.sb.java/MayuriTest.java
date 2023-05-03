package com.sb.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class MayuriTest {
	
	public static void main(String[] args) {
		
		List<EmployeeDtls> emplist = Arrays.asList(
				new EmployeeDtls("Sagar",	101,21,20000.00,"Software Developer"),
				new EmployeeDtls("Amar",	103,29,30000.00,"Software Engineer"),
				new EmployeeDtls("Samar",	102,33,40000.00,"Software Developer"),
				new EmployeeDtls("Sachin",	104,32,20000.00,"Software Developer"),
				new EmployeeDtls("Dinesh",	105,29,35000.00,"Software Developer"),
				new EmployeeDtls("Rama",	106,45,41000.00,"Software Developer"),
				new EmployeeDtls("Ramesh",	109,38,200000.00,"Software Developer"),
				new EmployeeDtls("Nitin",	99,40,30000.00,"Software Engineer"),
				new EmployeeDtls("Anil",	107,20,42000.00,"Software Developer"),
				new EmployeeDtls("Sharvil", 111,21,20000.00,"Software Developer"),
				new EmployeeDtls("Nita",	113,29,37000.00,"Software Developer"),
				new EmployeeDtls("Gita",	112,33,49000.00,"Software Engineer"),
				new EmployeeDtls("Omkar",	121,21,20000.00,"Software Developer"),
				new EmployeeDtls("Real",	125,29,30000.00,"Software Developer"),
				new EmployeeDtls("Disha",	127,33,43000.00,"Software Developer")
				
				);
		//Method Reference
		//emplist.forEach(System.out::println);
		
		//return count by designation
		emplist.stream()
		.collect(Collectors.groupingBy(EmployeeDtls::getDesignation,Collectors.counting()))
		.entrySet().forEach(System.out::println);
		
		//get the empoyees those having age less than 25 and sort by name
	   System.out.println("\n get the empoyees those having age less than 25 and sort by name \n");
		emplist.stream().filter(e -> e.getAge() < 25).sorted(Comparator.comparing(EmployeeDtls::getName))
				.collect(Collectors.toList()).forEach(System.out::println);
		
		/*
		 HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
		   map.put(1,"Mango");  //Put elements in Map  
		   map.put(2,"Apple");    
		   map.put(3,"Banana");   
		   map.put(4,"Grapes");   
		   
		 //map.forEach((key,val) -> {System.out.println(key +"|"+val);});  
		 map.forEach((key,val) -> {
			 						if(val.equals("Apple"))
			 						   System.out.println(key +"|"+val);
		 						  });  
		 System.out.println(map.containsValue("Apple")); */

	
	}
	

}
