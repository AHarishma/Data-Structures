package com.company.stack;

import java.util.Arrays;
import java.util.Stack;

public class SameBracketExpression {
    public boolean areSameExpressions(String expression1, String expression2) {
        return Arrays.equals(calculateExpression(expression1), calculateExpression(expression2));
    }

    private char[] calculateExpression(String expression) {
        char[] result = new char[26];
        Stack<Character> stack = new Stack<>();
        stack.add('+');
        char currentSign = '+';
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-') {
                currentSign = ch;
            } else if (ch == '(') {
                if (stack.peek() == currentSign) {
                    stack.push('+');
                } else {
                    stack.push('-');
                }
                currentSign = '+';
            } else if (ch == ')') {
                stack.pop();
            } else if (ch >= 'a' && ch <= 'z') {
                result[ch - 'a'] = stack.peek() == currentSign ? '+' : '-';
            }
        }
        return result;
    }
}

/**
 * Given two expressions which has characters from a to z, +, -, (, ). Also the operands (a, b, c, etc,.) will not be repeated. Check both the expressions are same.
 * <p>
 * Expression1: -(a + (b + c))
 * Expression2: -a - (b + c)
 * <p>
 * -(-(a + (b + c)))
 * -(-(-(a + (b + c))))
 * <p>
 * Expression 2:
 * Stack: +
 * Current: +
 * a: -
 * b: -
 * c: -
 * <p>
 * Expression 1:
 * Stack: +
 * Current: +
 * a = -
 * b = -
 * c = -
 * <p>
 * TC: O(N)
 * SC: O(N)
 */
