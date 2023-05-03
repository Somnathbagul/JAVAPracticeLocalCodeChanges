package com.sb.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class NthNonRepeatableChar {
    public static void main(String[] args) {
        String input = "aabbcdddeeefg";
        int n = 3;
        //char nthNonRepeatableChar = findNthNonRepeatableChar(input, n);
       // System.out.println("The " + n + "th non-repeating character in the string is: " + nthNonRepeatableChar);
    }

    /*public static char findNthNonRepeatableChar(String input, int n) {
        Optional<Character> optionalChar = input.chars()
                .mapToObj(c -> (char) c)
                .collect(LinkedHashMap::new, (map, c) -> map.merge(c, 1, Integer::sum), LinkedHashMap::putAll)
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(n - 1)
                .findFirst();
        if (optionalChar.isPresent()) {
            return optionalChar.get();
        } else {
            throw new IllegalArgumentException("There are less than " + n + " non-repeating characters in the string.");
        }
    }*/
}
