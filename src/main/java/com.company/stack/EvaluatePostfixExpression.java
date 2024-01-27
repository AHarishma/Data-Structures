package com.company.stack;

import java.util.Stack;

public class EvaluatePostfixExpression {
    public int evaluatePostfixExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch >= '1' && ch <= '9') {
                stack.add((int) ch - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.add(calculate(operand1, operand2, ch));
            }
        }

        return stack.pop();
    }

    private int calculate(int operand1, int operand2, char ch) {
        switch (ch) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        return operand1 ^ operand2;
    }
}

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 */

/**
 * Given a valid postfix expression with operands as numbers. Operators are +, -, *, /
 * Input: 21+
 * Output: 3
 * <p>
 * Input: 263/*5+
 * Output: 9
 */