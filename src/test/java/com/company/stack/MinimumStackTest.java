package com.company.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumStackTest {
    @Test
    public void testMinimumStack() {
        MinimumStack obj = new MinimumStack();
        obj.push(1);
        obj.push(-1);
        obj.push(0);
        obj.pop();
        int top = obj.peek();
        assertEquals(-1, top);
        int min = obj.getMin();
        assertEquals(-1, min);
    }
}
