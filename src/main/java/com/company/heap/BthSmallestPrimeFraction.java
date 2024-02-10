package com.company.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BthSmallestPrimeFraction {

    private int[] solve(int[] arr, int b) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare((double) arr[o1[0]] / arr[o1[1]], (double) arr[o2[0]] / arr[o2[1]]);
            }
        });

        for (int i = 0; i < arr.length - 1; i++) {
            priorityQueue.add(new int[]{i, arr.length - 1});
        }
        while (b > 0 && !priorityQueue.isEmpty()) {
            int[] polledElement = priorityQueue.poll();
            priorityQueue.add(new int[]{polledElement[0], polledElement[1] - 1});

            b--;
            if (b == 0) {
                return new int[]{arr[polledElement[0]], arr[polledElement[1]]};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        int b = 3;
        BthSmallestPrimeFraction bthSmallestPrimeFraction = new BthSmallestPrimeFraction();
        int[] result = bthSmallestPrimeFraction.solve(arr, b);
        System.out.println(Arrays.toString(result));
    }
}

/**
 * B-th Smallest Prime Fraction
 * <p>
 * Problem Description
 * Given a sorted array of integers A which contains 1 and some number of primes.
 * Then, for every p < q in the list, we consider the fraction p / q.
 * <p>
 * What is the B-th smallest fraction considered?
 * <p>
 * Return your answer as an array of integers, where answer[0] = p and answer[1] = q.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length(A) <= 2000
 * 1 <= A[i] <= 30000
 * 1 <= B <= length(A)*(length(A) - 1)/2
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains the integer array, A.
 * The second argument of input contains an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array of two integers, where answer[0] = p and answer[1] = q.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 5]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 7]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 5]
 * Output 2:
 * <p>
 * [1, 7]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The fractions to be considered in sorted order are:
 * [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
 * The third fraction is 2/5.
 * Explanation 2:
 * <p>
 * The fractions to be considered in sorted order are:
 * [1/7]
 * The first fraction is 1/7.
 */
