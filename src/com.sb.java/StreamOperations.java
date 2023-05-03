package com.sb.java;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamOperations {

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
		
		emplist.forEach(System.out::println);
		System.out.println("Filter employee and get Map with details Empid and Name");
		Map<Integer, String> filterEmp = emplist.stream()
				.filter(emp -> emp.id > 101)
				.collect(Collectors.toMap(EmployeeDtls::getId, EmployeeDtls::getName));
		filterEmp.forEach((k,v)-> System.out.println(" ID: "+k+" | NAME: "+v));
		
		
		System.out.println("Filter employee and get Employee name Who has second highest salary:");
		Optional<EmployeeDtls> salFilterEmp = emplist.stream()
				.sorted(Comparator.comparing(EmployeeDtls::getSalary).reversed()).distinct().skip(1).findFirst();
		System.out.println("secondHSalaryEmp : "+ salFilterEmp.get().name);
		
		
		//find the position of non repetitive char in given string
		System.out.println("find the position of non repetitive char in given string");
		String inputStr = "Samar";
		System.out.println("Input String:"+ inputStr +" First Non Repetative Char is : "+getFirstNonRepeatedChar(inputStr)+" Position in given string.");
	
	  // alternative
		String str1 = "gibblegabbler";
		  System.out.println("The given string is: " + str1);
		  for (int i = 0; i < str1.length(); i++) {
		   boolean unique = true;
		   for (int j = 0; j < str1.length(); j++) {
		    if (i != j && str1.charAt(i) == str1.charAt(j)) {
		     unique = false;
		     break;
		    }
		   }
		   if (unique) {
		    System.out.println("The first non repeated character in String is: " + str1.charAt(i));
		    break;
		   }
		  }

		System.out.println(filteredProducts.size());
		System.out.println(filteredProducts);
	}

	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

	static List<Product> products = Arrays.asList(
			new Product( new Price(829.99,"USD"), "FusionTechStore", "Used - Like New", new OrigDelivery(new Date(13,"April 6"))),
			new Product( new Price(329.99,"USD"), "FusionTechStore", "Used - Like New", new OrigDelivery(new Date(13,"April 6"))),
			new Product( new Price(129.99,"USD"), "FusionTechStore", "Used - Like New", new OrigDelivery(new Date(23,"April 20"))),
			new Product( new Price(929.99,"USD"), "FusionTechStore", "Used - Like New", new OrigDelivery(new Date(26,"April 21"))),
			new Product( new Price(529.99,"USD"), "FusionTechStore", "Used - Like New", new OrigDelivery(new Date(22,"April 28")))
	);
	static List<Product> filteredProducts = products.stream()
			.filter(p -> p.getDeliveryTime() > 2 && p.getDeliveryTime() < 6) // delivery time is longer than 2 days and shorter than 6 days
			.filter(p -> {
				double highestPrice = products.stream().mapToDouble(product -> product.getPrice().getValue()).max().orElse(Double.MIN_VALUE);
				double lowestPrice = products.stream().mapToDouble(product -> product.getPrice().getValue()).min().orElse(Double.MAX_VALUE);
				double priceDifference = highestPrice - lowestPrice;
				return p.getPrice().getValue() == highestPrice || p.getPrice().getValue() == lowestPrice || priceDifference == 0;
				// include products whose price is the highest or lowest, or if the price difference is zero (i.e., all products have the same price)
			})
			.collect(Collectors.toList());


}
