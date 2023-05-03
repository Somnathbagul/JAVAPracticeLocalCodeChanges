package com.sb.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOpts {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
		    new Transaction(brian, 2011, 300),
		    new Transaction(raoul, 2012, 1000),
		    new Transaction(raoul, 2011, 400),
		    new Transaction(mario, 2012, 710),
		    new Transaction(mario, 2012, 700),
		    new Transaction(alan, 2012, 950)
		);
		
		Stream.iterate(2, n -> n + 2)
	      .limit(10)
	      .forEach(System.out::println);
		
		Stream.generate(Math::random)
	      .limit(5)
	      .forEach(System.out::println);

// Find all transactions in 2011 and sort by value (small to high)
		List<Transaction> trnc2011 = transactions.stream()
				.filter(tr -> tr.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
		System.out.println("Find all transactions in 2011 and sort by value (small to high): ");
		trnc2011.forEach(System.out::println);
/*
Find all transactions in 2011 and sort by value (small to high): 
{Trader:Brian in Cambridge, year: 2011, value:300}
{Trader:Raoul in Cambridge, year: 2011, value:400}		 
*/
		
		
// What are all the unique cities where the traders work?
		System.out.println("What are all the unique cities where the traders work :");
		transactions.stream()
		.map(elm -> elm.getTrader().getCity())
		.distinct().collect(Collectors.toList())
		.forEach(System.out::println);
		
/*
 Which are all the unique cities where the traders work :
	Cambridge
	Milan
 */
		
	//sort the transaction by Year and then it's Value in DESC order
	System.out.println("sort the transaction by Year and then it's Value in DESC order");
	List<Transaction> sortedList=transactions.stream().sorted(
				Comparator.comparing(Transaction::getYear)
				.thenComparing(Transaction::getValue).reversed()
				).collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		
/*
 sort the transaction by Year and then it's Value in DESC order
{Trader:Raoul in Cambridge, year: 2012, value:1000}
{Trader:Alan in Cambridge,  year: 2012, value:950}
{Trader:Mario in Milan,     year: 2012, value:710}
{Trader:Mario in Milan,     year: 2012, value:700}
{Trader:Raoul in Cambridge, year: 2011, value:400}
{Trader:Brian in Cambridge, year: 2011, value:300}
 */
	
	
	System.out.println("test :"+ transactions.stream().allMatch(elm -> elm.getValue() < 400));
	
	
	
	
	}
	
	
	
	

}
