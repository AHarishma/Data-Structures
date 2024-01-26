package com.company.stack;

import java.util.Stack;

public class Merge2SortedStack {
    public Stack mergeTwoSortedStack(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> s = new Stack<>();
        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(s1.peek() < s2.peek()) {
                s.add(s1.pop());
            } else {
                s.add(s2.pop());
            }
        }

        while(!s1.empty()) {
            s.add(s1.pop());
        }
        while(!s2.empty()) {
            s.add(s2.pop());
        }

        return s;
    }
}

/**
 * S1: [1, 7, 10]
 * S2: [2, 5, 9, 12]
 * S: [1,2,5,7,9,10,12]
 */