package com.company.greedy;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

    public int findX(int[] arr) {
        Arrays.sort(arr);
        int midIndex = (0 + arr.length) / 2;
        if ((arr.length & 1) == 0) {
            return (arr[midIndex - 1] + arr[midIndex]) / 2;
        }
        return arr[midIndex];
    }
}

/**
 * Minimum Absolute Difference
 * Given an array. Find the value x such that sum of absolute difference
 * between x and all the elements should be minimum.
 * Find the value of x.
 * Array: [1, 3, 11, 12]
 * <p>
 * 1. Sort the array in ascending order
 * 2. Find the median of the array
 * <p>
 * x = 7
 * abs(7 - 1) = 6
 * abs(7 - 3) = 4
 * abs(7 - 12) = 5
 * abs(7 - 10) = 3
 * sum = 18
 * <p>
 * Another example:
 * <p>
 * …..xxx….x….x….x.xxx……x
 * 6,7,8,13,18,23,25,26,27,34
 * …..xxxxxxxxxx………………
 */
