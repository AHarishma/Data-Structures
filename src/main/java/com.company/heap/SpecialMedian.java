package com.company.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SpecialMedian {

    public int solve(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length - 1; i++) {
            int result = getMedianResult(minHeap, maxHeap, arr, i);
            if (result == arr[i + 1]) {
                return 1;
            }
        }

        for (int i = arr.length - 1; i > 1; i--) {
            int result = getMedianResult(minHeap, maxHeap, arr, i);
            if (result == arr[i - 1]) {
                return 1;
            }
        }

        return 0;
    }

    private int getMedianResult(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int[] arr, int i) {
        if (maxHeap.isEmpty() || arr[i] <= maxHeap.peek()) {
            maxHeap.add(arr[i]);
        } else {
            minHeap.add(arr[i]);
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }
}

/**
 * Special Median
 * <p>
 * Problem Description
 * You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:
 * <p>
 * There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
 * There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
 * The Median is the middle element in the sorted list of elements.
 * If the number of elements is even then the median will be (sum of both middle elements) / 2.
 * <p>
 * Return 1 if the array is special else return 0.
 * <p>
 * NOTE:
 * <p>
 * Do not neglect decimal point while calculating the median
 * For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
 * For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000000.
 * A[i] is in the range of a signed 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if the given array is special else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [4, 6, 8, 4]
 * Input 2:
 * <p>
 * A = [2, 7, 3, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explantion 1:
 * <p>
 * Here, 6 is equal to the median of [8, 4].
 * Explanation 2:
 * <p>
 * No element satisfies any condition.
 */