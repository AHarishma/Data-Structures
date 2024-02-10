package com.company.stack;

import java.util.Stack;

public class MergeInAscendingOrder {
    public Stack mergeTwoSortedStack(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> s = new Stack<>();
        while(!s1.empty() && !s2.empty()) {
            if(s1.peek() < s2.peek()) {
                temp.add(s1.pop());
            } else {
                temp.add(s2.pop());
            }
        }
        while(!s1.empty()) {
            temp.add(s1.pop());
        }
        while(!s2.empty()) {
            temp.add(s2.pop());
        }

        while(!temp.empty()) {
            s.add(temp.pop());
        }
        return s;
    }
}
/**
 * Given two sorted stack in ascending order. Merge it and return in ascending order.
 *
 */
