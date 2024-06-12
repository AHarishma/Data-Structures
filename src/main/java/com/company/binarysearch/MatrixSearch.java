package com.company.binarysearch;

public class MatrixSearch {
    public int[] searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix[0].length * matrix.length) - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}

/**
 * 2. Matrix Search
 * Given a matrix which are sorted rows and each row first column has value greater than the previous row last column's value. Find the element in it.
 * [1, 3, 4, 8]
 * [9, 10, 15, 18]
 * [20, 27, 30, 40]
 * [46, 50, 90, 100]
 * Target: 90
 * <p>
 * [0, 1, 2, 3]
 * [4, 5, 6, 7]
 * [8, 9, 10, 11]
 * [12, 13, 14, 15]
 * <p>
 * [0, 1, 2, 3, 4]
 * [5, 6, 7, 8, 9]
 * <p>
 * 1 binary search for identify row (log n) +
 * 1 binary search for identify element in a row (log m)
 * TC: logn + logm = log(nm)
 * <p>
 * Time Complexity: O(log(mn))
 * Space Complexity: O(1)
 */
