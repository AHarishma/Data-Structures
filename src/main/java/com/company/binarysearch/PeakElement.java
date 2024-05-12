package com.company.binarysearch;

public class PeakElement {
    public int peakElement(int[] array) {
        if (array.length == 1 || array[0] > array[1]) {
            return array[0];
        }
        if (array[array.length - 1] > array[array.length - 2]) {
            return array[array.length - 1];
        }
        int left = 1;
        int right = array.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid - 1] < array[mid] && array[mid + 1] < array[mid]) {
                return array[mid];
            }
            if (array[mid - 1] < array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

/**
 * 1. Find the peak element of an array.
 * Array: [1, 2, 3, 4, 7, 6, 5]
 * Output: 7
 * <p>
 * Array: [1, 2, 3, 4, 5]
 * Output: 5
 * <p>
 * Array: [1, 3, 5, 4, 2]
 * Output: 5
 * <p>
 * Array: [5, 4, 3, 2, 1]
 * Output: 5
 * <p>
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
