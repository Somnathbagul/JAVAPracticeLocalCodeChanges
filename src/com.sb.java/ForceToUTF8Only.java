package com.sb.java;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ForceToUTF8Only {

		public static void main(String[] args) {
		    printCharacterDetails("最");
		    
		    String s = "एक गाव में एक किसान";
		    System.out.println("Original:"+ s);
		    String out;
			try {
				out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
				System.out.println(out);
				out = new String(s.getBytes("UTF16"), "ISO-8859-1");
				System.out.println(out);
				
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		}

		public static void printCharacterDetails(String character){
		    System.out.println("Unicode Value for "+character+"="+Integer.toHexString(character.codePointAt(0)));
		    byte[] bytes = character.getBytes();
		    System.out.println("The UTF-8 Character="+character+"  | Default: Number of Bytes="+bytes.length);
		    String stringUTF16 = new String(bytes, StandardCharsets.UTF_16);
		    System.out.println("The corresponding UTF-16 Character="+stringUTF16+"  | UTF-16: Number of Bytes="+stringUTF16.getBytes().length);
		    System.out.println("----------------------------------------------------------------------------------------");
		}

}

