package com.company.binarysearch;

public class SearchForRange {
    public int[] searchForRange(int[] arr, int target) {
        int index = binarySearch(arr, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int firstIndex = findFirstIndex(arr, target);
        int lastIndex = findLastIndex(arr, target);
        return new int[]{firstIndex, lastIndex};
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findFirstIndex(int[] array, int target) {
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

    private int findLastIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int resultIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < array[mid]) {
                right = mid - 1;
            } else {
                if (target == array[mid]) {
                    resultIndex = mid;
                }
                left = mid + 1;
            }
        }
        return resultIndex;
    }
}

/**
 * Given a sorted array which may have duplicate elements and target. Find the starting and ending index of target in the given array.
 * If the target is not available in the given array then you can return (-1, -1)
 * <p>
 * Array: [1, 2, 3, 3, 6, 8, 8, 8, 10, 10, 40, 40, 50], target = 8
 * Output: [5, 7]
 * <p>
 * Array: [1, 2, 3, 3, 6, 8, 8, 8, 10, 10, 40, 40, 50], target = 9
 * Output: [-1, -1]
 * <p>
 * Algorithm:
 * 1. Do normal binary search and check if the element exists in an array. If it doesn't exist return [-1, -1]
 * 2. Have two functions (firstIndex() and lastIndex())
 * 3. Call firstIndex() and lastIndex()
 * 4. Return [firstIndex, lastIndex]
 */