package com.sb.java;
import java.util.EmptyStackException;
import java.util.Stack;
public class BalancedBrackets {
    private static final char CURLY = '{';
    private static final char CURLY_CLOSE = '}';
    private static final char ROUND = '(';
    private static final char ROUND_CLOSE = ')';
    private static final char SQUARE = '[';
    private static final char SQUARE_CLOSE = ']';

    private static boolean isOpener(char ch) {
        return ch == CURLY || ch == ROUND || ch == SQUARE;
    }

    private static boolean isValid(String input) {
        boolean valid = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (isOpener(symbol)) {
                stack.push(symbol);
            } else {
                if (isCloser(stack.peek(), symbol)) {
                    try {
                        stack.pop();
                    } catch (EmptyStackException xEmptyStack) {
                        valid = false;
                    }
                } else {
                    valid = false;
                }
            }
        }
        if (valid) {
            valid = stack.empty();
        }
        return valid;
    }

    public static void main(String[] args) {
        String[] inputs = {"()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
                "({{{{}}}))"};
        for (String input : inputs) {
            System.out.printf("%-5b: %s%n", isValid(input), input);
        }
    }
    private static boolean isCloser(char opener, char closer) {
        return switch (opener) {
            case CURLY -> closer == CURLY_CLOSE;
            case ROUND -> closer == ROUND_CLOSE;
            case SQUARE -> closer == SQUARE_CLOSE;
            default -> false;
        };
    }

}

