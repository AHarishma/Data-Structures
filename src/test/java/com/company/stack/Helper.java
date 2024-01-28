package com.company.stack;

import java.util.Stack;

public class Helper {
    public static boolean areStacksEqual(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.empty() && !stack2.empty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }
        return stack1.empty() && stack2.empty();
    }

    public static Stack createStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int elem : arr) {
            stack.push(elem);
        }
        return stack;
    }
}
