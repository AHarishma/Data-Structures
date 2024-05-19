package com.company.binarysearch;

public class RotatedSortedArray {
    public boolean searchInRotatedSortedArray(int[] array, int target) {
        int pivot = getPivot(array);
        if (target > array[array.length - 1]) {
            return binarySearch(array, 0, pivot, target);
        }
        return binarySearch(array, pivot + 1, array.length - 1, target);
    }

    private int getPivot(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int pivot = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[arr.length - 1]) {
                pivot = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pivot;
    }

    private boolean binarySearch(int[] array, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            }
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

/**
 * Rotated Sorted Array
 * Array: [13, 19, 25, 30, 35, 1, 5, 7, 10], target = 25
 * <p>
 * 1, 5, 7, 10, 13, 19, 25, 30, 35 target = 45
 * <p>
 * [1, 5, 7, 10], target = 25
 * <p>
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */