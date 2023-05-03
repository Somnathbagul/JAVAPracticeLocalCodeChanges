package com.sb.java;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
 
class Main
{
    public static void main(String[] args)
    {
		/*
		 * String user="MCUUAU31XXX|CUSCAU2STST"; List<String> userDataRoles =
		 * Stream.of(user.replace("|", ",").split(",")).collect(Collectors.toList());
		 * System.out.println("list to string:"+userDataRoles.toString()); String result
		 * = null; for(String str : userDataRoles) { result = result+","+str;
		 * 
		 * } System.out.println("result : "+result);
		 * System.out.println(userDataRoles.size());
		 * 
		 * Stream.of(user.replace("|",
		 * ",").split(",")).forEachOrdered(System.out::println); String res =
		 * user.replace("|", "','"); System.out.println("test-"+res);
		 */
    
		/*
		 * List<String> addtlInfo =
		 * Arrays.asList("abc","12345678901234567891234567890123456","efg123456789123");
		 * 
		 * //System.out.println("verify line with data: "+ isValid(addtlInfo, 2));
		 * System.out.println("verify line with data: "+ isValidData(addtlInfo, 2));
		 */
    	  
    boolean notBefore = LocalDate.parse("2016-06-11")
    		  .isBefore(LocalDate.parse("2016-06-12"));
    System.out.println("11 is before 12 : " + notBefore);
    boolean isAfter = LocalDate.parse("2016-06-12")
    		  .isAfter(LocalDate.parse("2016-06-11"));
    System.out.println("12 is after 11 : "+ isAfter);
    
    }
    /* 
    public static boolean isValid(List<String> addtlInfo , int line) {
    	System.out.println("list elements-> "+addtlInfo.size());
    	System.out.println("list elements data -> "+addtlInfo.get(line - 1));
    	return (addtlInfo.size()>=line);
    }
    
    public static boolean isValidData(List<String> addtlInfo , int line) {
    	int lenght = line > 2 ? 15 : 35;
    	System.out.println("list elements-> "+addtlInfo.size());
    	System.out.println("list elements data -> "+addtlInfo.get(line - 1) + " Length of data : "+lenght);
    	return (addtlInfo.size() >= line && addtlInfo.get(line - 1).length() <= lenght);
    }*/
    
    
    
    		
    
    
}