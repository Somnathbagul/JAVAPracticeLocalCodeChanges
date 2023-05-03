package com.sb.java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class NonRepeatingCharacter {

    public static Optional<Character> findNonRepeatingCharacter(String str, long charCount) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        str.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1));


        return charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).skip(charCount-1)
                .findFirst();
    }

    public static Optional<Character> findRepeatingCharacter(String str, long charCount) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        str.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1));


        return charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }
    public static void main(String[] args) {
        String inputString = "samar";
        long charCount = 3;
        Optional<Character> result = findNonRepeatingCharacter(inputString, charCount);
        if (result.isPresent()) {
            System.out.println("The first non-repeating character in the string is: " + result.get());
        } else {
            System.out.println("There are no non-repeating characters in the string.");
        }

        Optional<Character> resultRepatiativeChar = findRepeatingCharacter(inputString, charCount);
        if (result.isPresent()) {
            System.out.println("The first repeating character in the string is: " + resultRepatiativeChar.get());
        } else {
            System.out.println("There are no repeating characters in the string.");
        }
    }
}
