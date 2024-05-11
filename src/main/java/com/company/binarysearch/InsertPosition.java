package com.company.binarysearch;

public class InsertPosition {
    public int findInsertPosition(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int insertPosition = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value > arr[mid]) {
                left = mid + 1;
            } else {
                insertPosition = mid;
                right = mid - 1;
            }
        }
        return insertPosition;
    }
}

/**
 * 4. Given a sorted array and the target value, find the sorted insert position of the element.
 * <p>
 * Array: [1, 5, 7, 10, 13, 19, 25, 30, 35], target: 14
 * Output: 5
 * <p>
 * Note: Find the smallest value greater than or equal to given element
 */