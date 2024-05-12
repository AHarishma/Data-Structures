package com.company.binarysearch;

public class SearchElement {
    public int search(int[] arr, int target) {
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
}

/**
 * Binary Search:
 * 1. Binary Search is a searching algorithm which searches an element in array by reducing the search space by half everytime and it will narrow down to the target element.
 * 0-----1000
 * 0--500 or 500---1000
 * 2. Because of reducing the search space everytime by half, the time complexity of binary search is O(logn)
 * Search Space: 1----N
 * N + N/2 + N/4 + N/8 + N/16 + N/32 + .... 0 = log(base2)n
 * 3. Space complexity of binary search: O(1) (Iterative approach). It can be done using recursion as well (Space complexity: O(logbase2n))
 * 4. Examples: Search word in a dictionary.
 * <p>
 * Binary Search Algorithm:
 * 1. Divide the search space into two halves by finding the mid.
 * 2. Identify the logic to find where our actual target exists (In left side or ride side)
 * 3. Accordingly ignore the other half from the search space.
 * 4. Go to step 1 until you find the respective target.
 * <p>
 * 1. Given a sorted array with distinct elements, search an element in it.
 * <p>
 * Array: [1, 5, 7, 9, 17, 27], target: 27
 * left = 0, right = 5
 * mid = (0 + 5) / 2 = 2
 * arr[mid] = 7 < 27 (ignore left half of search space) => left = mid + 1
 * left = 3, right = 5
 * mid = (3 + 5) / 2 = 4
 * arr[mid] = 17 < 27
 * left = 5, right = 5
 * mid = (5 + 5) / 2 = 5
 * arr[mid] = 27 == 27 (true)
 * left = 1000000000, right = 10000000000
 * 0----100
 * diff = 100
 * diff/2 = 50
 * left + diff/2 = 0 + 50 = 50
 * 10-----100
 * diff = 90
 * diff/2 = 45
 * left + diff/2 = 10 + 45 = 55
 *
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */