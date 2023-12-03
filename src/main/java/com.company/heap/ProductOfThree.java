package com.company.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProductOfThree {
    private int[] findProductOfThree(int[] arr) {
        int[] result = new int[arr.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
                minHeap.add(arr[i]);

            if (minHeap.size() > 3) {
                minHeap.poll();
            }

            if (i < 2) {
                result[i] = -1;
            } else {
                int product = 1;
                for(int element : minHeap) {
                    product *= element;
                }
                result[i] = product;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        ProductOfThree productOfThree = new ProductOfThree();
        System.out.println(Arrays.toString(productOfThree.findProductOfThree(arr1)));

        int[] arr2 = new int[]{10, 2, 13, 4};
        System.out.println(Arrays.toString(productOfThree.findProductOfThree(arr2)));

        int[] arr3 = new int[]{5, 4, 3, 2};
        System.out.println(Arrays.toString(productOfThree.findProductOfThree(arr3)));
    }
}

/**
 * Product of 3
 * <p>
 * Problem Description
 * Given an integer array A of size N.
 * <p>
 * You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
 * <p>
 * Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 0 <= A[i] <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [10, 2, 13, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [-1, -1, 6, 24, 60]
 * Output 2:
 * <p>
 * [-1, -1, 260, 520]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * For i = 1, ans = -1
 * For i = 2, ans = -1
 * For i = 3, ans = 1 * 2 * 3 = 6
 * For i = 4, ans = 2 * 3 * 4 = 24
 * For i = 5, ans = 3 * 4 * 5 = 60
 * <p>
 * So, the output is [-1, -1, 6, 24, 60].
 * <p>
 * Explanation 2:
 * <p>
 * For i = 1, ans = -1
 * For i = 2, ans = -1
 * For i = 3, ans = 10 * 2 * 13 = 260
 * For i = 4, ans = 10 * 13 * 4 = 520
 * <p>
 * So, the output is [-1, -1, 260, 520].```````````````````````
 */