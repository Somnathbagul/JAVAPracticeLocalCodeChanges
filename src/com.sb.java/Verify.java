package com.sb.java;

import java.util.Arrays;

/*How to Determine the K^th character in the concatenated string
Given a list that contains N strings of lowercase English alphabets. Any number of contiguous strings can be found together to form a new string. The grouping function accepts two integers X and Y and concatenates all strings between indices X and Y (inclusive) and returns a modified string in which the alphabets of the concatenated string are sorted.

You are asked Q questions each containing two integers L and R. Determine the $K^{th}$. character in the concatenated string if we pass L and R to the grouping function.

Input Format
First Line: N(number of strings in the list)
Next N lines: String $S_i$
Next line Q(number of questions)
Next Q lines : Three space-separated integers L, R and K

Output Format
For each question, print the $K^{th}$ character of the concatenated string in a new line.
Given a list that contains N strings of lowercase English alphabets. Any number of contiguous strings can be found together to form a new string. The grouping function accepts two integers X and Y and concatenates all strings between indices X and Y (inclusive) and returns a modified string in which the alphabets of the concatenated string are sorted.

You are asked Q questions each containing two integers L and R. Determine the $K^{th}$. character in the concatenated string if we pass L and R to the grouping function.

Input Format
First Line: N(number of strings in the list)
Next N lines: String $S_i$
Next line Q(number of questions)
Next Q lines : Three space-separated integers L, R and K
Output Format
For each question, print the $K^{th}$ character of the concatenated string in a new line.

Sample Test Cases
Sample Input                 Sample Output

5                                 c
aaaaa                             d
bbbbb                             e
ccccc
ddddd
eeeee
3
3 3 3 
1 5 16
3 5 15

Explanation
Q1 Grouped String - ccccc. 3rd character is c
Q2 Grouped String - aaaaabbbbbcccccdddddeeeee. 16th character is d
Q3 Grouped String - cccccdddddeeeee. 15th character is e
Note: It is always guaranteed that the $K^{th}$ position is valid*/

public class Verify {

	public static void main(String[] args) {
		String[] str={"aaaaa","bbbbb","ccccc","ddddd","eeeee"};
				
		Verify.solve(5, str, 3, null);

	}
	
	private static char[] solve(int N, String[] str, int Q, int[][] query) {
	       StringBuilder sb = new StringBuilder();
	       char [] result = new char[Q];
	       int q_count=0;
	       while(Q>0){
	           for(int i=query[q_count][0]-1; i <= query[q_count][1]-1; i++){
	               sb.append(str[i]);
	           }
	           char [] ta = sb.toString().toCharArray();
	           Arrays.sort(ta);
	           result[q_count]= ta[query[q_count][2]-1];
	           q_count++;
	           sb.delete(0, sb.length());
	           Q--;
	       }
	       return result;
	    }

}
