package com.company.binarysearch;

public class FloorValue {
    public int findFloorValue(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int floorValue = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(value == arr[mid]) {
                return mid;
            }
            if(value > arr[mid]) {
                floorValue = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return floorValue;
    }
}

/**
 * Array: [1, 5, 7, 10, 13, 19, 25, 30, 35], value: 14
 * <p>
 * Output: 13
 *
 * Note: Floor of an element in an array represents the greatest value lesser than or equal to the given element.
 */
