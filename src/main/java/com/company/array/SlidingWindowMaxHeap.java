package com.company.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaxHeap {
    public int[] slidingWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || n < k) {
            return new int[0];
        }
        int j = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] result = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        result[j++] = maxHeap.peek();
        for (int i = k; i < nums.length; i++) {
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
            result[j++] = maxHeap.peek();
        }
        return result;
    }
}
