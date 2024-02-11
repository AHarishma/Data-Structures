package com.company.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximumDeque {
    public int[] slidingWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        output[0] = nums[deque.getFirst()];

        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && i - k >= deque.getFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }
}
