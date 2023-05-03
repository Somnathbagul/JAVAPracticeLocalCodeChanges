package com.sb.java.listtomap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ConvertListToMapMain {
 
    public static void main(String[] args) {
        List<Movie> moviesList=getListOfMovies();
        //list to map.
		/*
		 * Map<String, String> moviesMap = moviesList.stream()
		 * .collect(Collectors.toMap((m)->m.getName(), (m)->m.getGenre()));
		 */
        
        // dealing with duplicate items in the list
        System.out.println("List of movies:");
        moviesList.forEach(System.out::println);
        Map<String, String> moviesMap = moviesList.stream()
                .collect(Collectors.toMap((m)->m.getName(), (m)->m.getGenre(),
                        (oldValue,newValue) -> newValue
                ));
        
        System.out.println(moviesMap);
        TreeMap<String, String> sortedMoviesMap = moviesList.stream()
                .collect(Collectors.toMap( (m)->m.getName(), (m)->m.getGenre(),
                        (oldValue,newValue) -> newValue, TreeMap::new));
        System.out.println("sortedMoviesMap:" +sortedMoviesMap);
        Map<String, List<String>> moviesGenMap = moviesList.stream()
                .collect(Collectors.groupingBy(Movie::getGenre
                                              ,Collectors.mapping(Movie::getName, Collectors.toList())));
        System.out.println(moviesGenMap);
       
        // list sort base on First Char of string and listed it
        List<String> myList = Arrays.asList("a1", "a2", "a3", "a4", "b1", "b2", "c1", "c3", "c2");

        myList.stream()
        	.filter(s -> s.startsWith("c"))
        	.map(String::toUpperCase)
        	.sorted()
        	.forEach(System.out::println);
        
        Map<String, Integer> items = new HashMap<>();

        items.put("A", 10);
        items.put("B", 10);
        items.put("C", 10);
        items.put("D", 70);
        items.put("E", 100);

        // stream() and filter()
        items.values().stream().filter((v) -> (v > 0 && v< 50)).forEach((v)-> System.out.println("Count : " + v));
        	
 
        List<String> studentName = Arrays.asList("hector", "hana", "stone");

        List<String> result = studentName.stream()	// Convert list to stream
        	.filter(name -> !"hana".equals(name))	// remove "hana" hana from list
        	.collect(Collectors.toList());			// collect the output and convert Stream to List

        // print using method reference
        result.forEach(System.out::println);
        
        //uses the reduce method
        String[] myArray = { "this", "is", "a", "sentence" };
        System.out.println("Given sentence in array form :"+Arrays.toString(myArray));
        String reduceresult = Arrays.stream(myArray).reduce("", (a,b) -> a + b);
        System.out.println(reduceresult);
        //
        
        
    }  
 
    public static List<Movie> getListOfMovies()
    {
        List<Movie> moviesList=new ArrayList<>();
 
        Movie m1=new Movie("3 idiots","Comedy");
        Movie m2=new Movie("Interstellar","SciFi");
        Movie m3=new Movie("Forest gump","Comedy");
        Movie m4=new Movie("Matrix","SciFi");
        Movie m5=new Movie("The Hangover","Comedy");
        Movie m6=new Movie("Matrix","Comedy");
 
        moviesList.add(m1);
        moviesList.add(m2);
        moviesList.add(m3);
        moviesList.add(m4);
        moviesList.add(m5);
        moviesList.add(m6);
 
        return moviesList;
    }
}