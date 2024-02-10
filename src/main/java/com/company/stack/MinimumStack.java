package com.company.stack;

import lombok.AllArgsConstructor;

import java.util.Stack;

public class MinimumStack {
    Stack<ElementInfo> stack;
    MinimumStack() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        int currentMin = !stack.isEmpty() ? Math.min(stack.peek().currentMin, value) : value;
        this.stack.add(new ElementInfo(value, currentMin));
    }

    public int peek() {
        return this.stack.peek().value;
    }

    public int pop() {
        return this.stack.pop().value;
    }

    public int getMin() {
        return this.stack.peek().currentMin;
    }

    @AllArgsConstructor
    class ElementInfo {
        int value;
        int currentMin;
    }

}

/**
 *
 * https://leetcode.com/problems/min-stack/description/
 * Design a stack such that it should give the minimum element among the values in current stack in constant time.
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 */
