package com.sb.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InvoiceService {
		static String DATEFORMAT="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
       private List<Invoice> getInvoiceList() throws ParseException {
       
       List<Invoice> invoices = Arrays.asList(
                            new Invoice(101, 496.67, "SQ078OPQ", new SimpleDateFormat(DATEFORMAT).parse("2022-07-10T10:42:42.257Z")),
                            new Invoice(102, 229.75, "QJ098OJH", new SimpleDateFormat(DATEFORMAT).parse("2022-07-10T10:35:47.257Z")),
                            new Invoice(103, 494.28, "RT048OQT", new SimpleDateFormat(DATEFORMAT).parse("2022-07-06T10:41:46.256Z")),
                            new Invoice(104, 195.56, "SR048OPR", new SimpleDateFormat(DATEFORMAT).parse("2022-07-06T10:39:46.247Z")),
                            new Invoice(106, 195.56, "SR048OPR", new SimpleDateFormat(DATEFORMAT).parse("2022-07-06T10:39:47.247Z")),
                            new Invoice(105, 285.50, "JT048OTK", new SimpleDateFormat(DATEFORMAT).parse("2022-07-01T10:42:46.237Z"))
      );
      return invoices;
}

      public static void main(String[] args) throws ParseException {

               InvoiceService service = new InvoiceService();
               List<Invoice> list = service.getInvoiceList();
                
               Comparator<Invoice> comparatorDate = (c1, c2) -> {
            	   return c1.getCreatedOn().compareTo(c2.getCreatedOn());
               };
                Comparator<Invoice> comparator = (c1, c2) -> { 
                        return Long.valueOf(c1.getCreatedOn().getTime()).compareTo(c2.getCreatedOn().getTime()); 
                };

               Collections.sort(list, comparatorDate.thenComparing(comparator));             
        list.forEach(System.out::println);    // System.out.println("Sorted List : " +list);             
       }
}