package com.company.stack;

import java.util.Stack;

public class RedundantBraces {
    public boolean checkRedundantBraces(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    return true;
                }
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop == '(') {
                        break;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * https://www.codingninjas.com/studio/problems/redundant-brackets_975473
 *
 * Given a string which has characters from a to z, +, -, *, /, (, ). Check if redundant braces any.
 * (a + b) = No redundant braces
 * ((a + b)) = Redundant braces
 * (a + (b * c)) = No redundant braces
 * ((a * b) + (c * d)) = No redundant braces
 * a + (b + c) = No redundant braces
 * <p>
 * TC: O(N)
 * SC: O(N)
 */
