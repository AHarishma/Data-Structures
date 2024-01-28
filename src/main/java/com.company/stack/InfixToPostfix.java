package com.company.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {
    public String infixToPostFix(String expression) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> precedenceMap = new HashMap<>() {{
            put('^', 3);
            put('*', 2);
            put('/', 2);
            put('+', 1);
            put('-', 1);
        }};

        StringBuilder result = new StringBuilder();
        for (char ch : expression.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '1' && ch <= '9')) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop == '(') {
                        break;
                    }
                    result.append(pop);
                }
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && precedenceMap.get(stack.peek()) >= precedenceMap.get(ch)) {
                    result.append(stack.pop());
                }
                stack.add(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}

/**
 * https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
 *
 * ^ —> Higher Precedence
 * *,/ —> Medium Precedence
 * +, - —> Lower Precedence
 * Infix: a + b
 * Postfix: ab+
 * <p>
 * Infix: a + (b * c)
 * Postfix: abc*+
 * <p>
 * Infix: a + b * c
 * Postfix: abc*+
 * <p>
 * a*(b+c)
 * abc+*
 * <p>
 * (a*b)+c
 * ab*c+
 * <p>
 * (a*(b / c))+d
 * abc/*d+
 * <p>
 * Algorithm:
 * For all characters
 * if character is between a to z
 * then add it output
 * else if character is ‘(’
 * then push it stack
 * else if character is ‘)’
 * then pop all the elements from stack until you find ‘(’ and add it to output
 * else pop all the higher precedence operator from stack until you find ‘(’ and add it to output.
 * Also add current operator to the stack.
 * <p>
 * TC: O(N)
 * SC: O(N)
 */