package com.company.stack;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> sortStack(Stack<Integer> stack) {
        int size = stack.size();
        if (size <= 1) {
            return stack;
        }
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < size / 2; i++) {
            stack2.add(stack.pop());
        }
        if(stack2.size() != 0) {
            stack = sortStack(stack);
            stack2 = sortStack(stack2);
        }
        return mergeTwoSortedStack(stack, stack2);
    }

    private Stack<Integer> mergeTwoSortedStack(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> temp = new Stack<>();
        while (!s1.empty() && !s2.empty()) {
            if (s1.peek() < s2.peek()) {
                temp.add(s1.pop());
            } else {
                temp.add(s2.pop());
            }
        }
        while (!s1.empty()) {
            temp.add(s1.pop());
        }
        while (!s2.empty()) {
            temp.add(s2.pop());
        }
        Stack<Integer> s = new Stack<>();
        while (!temp.empty()) {
            s.add(temp.pop());
        }
        return s;
    }
}

/**
 * TC: O(Nlogn)
 * SC: O(N)
 */
