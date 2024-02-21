package com.company.stack;

import java.util.Stack;

public class NextSmallerElementInRight {
    public int[] nextSmallerElementInRight(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() &&  stack.peek() <= input[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ?  -1: stack.peek();
            stack.add(input[i]);
        }
        return result;
    }
}
