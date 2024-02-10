package com.company.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidateParenthesis2 {
    public boolean validateParenthesis(String input) {
        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Stack<Character> stack = new Stack<>();
        for (char character : input.toCharArray()) {
            if (Arrays.asList('(', '[', '{').contains(character)) {
                stack.push(character);
            } else if (Arrays.asList(')', ']', '}').contains(character)) {
                if (!stack.isEmpty()) {
                    char item = stack.pop();
                    if (item != map.get(character)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

/**
 * input
 * ({[ab]})
 * ({[ab])}
 * ({[ab
 * <p>
 * TC: O(N)
 * SC: O(N)
 */
