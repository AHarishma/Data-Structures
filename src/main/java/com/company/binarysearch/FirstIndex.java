package com.company.binarysearch;

public class FirstIndex {
    public int firstIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int resultIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > array[mid]) {
                left = mid + 1;
            } else {
                if (target == array[mid]) {
                    resultIndex = mid;
                }
                right = mid - 1;
            }
        }
        return resultIndex;
    }
}
/**
 * Given a sorted array with duplicate elements, find the first index of a given value. If the element is not present return -1.
 * <p>
 * Array: [1, 2, 3, 3, 6, 8, 8, 8, 10, 10, 40, 40, 50], target: 10
 * <p>
 * answer = -1;
 * left = 0, right = 12
 * mid = (0 + 12) / 2 = 6
 * arr[mid] = 8 < 10
 * <p>
 * left = 7, right = 12
 * mid = (7 + 12) / 2 = 9
 * arr[mid] = 10 answer = 9
 * <p>
 * left = 7, right = 8
 * mid = (7 + 8) / 2 = 7
 * arr[mid] = 8 < 10
 * <p>
 * left = 8, right = 8
 * mid = (8 + 8) / 2 = 8
 * arr[mid] = 10 answer = 8
 * <p>
 * left = 8, right = 7
 * return answer
 *
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
