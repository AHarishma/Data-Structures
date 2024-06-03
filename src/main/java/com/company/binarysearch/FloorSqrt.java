package com.company.binarysearch;

public class FloorSqrt {
    public long floorSqrt(long n) {
        long left = 1;
        long right = n;
        long answer = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == n) {
                return mid;
            }
            if (square < n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}

/**
 * Floor of Square root of Integer
 * Given a number, find the floor of square root of it.
 * Input: 9; Output: 3
 * Input: 10; Output: 3
 * Input: 8; Output: 2
 * <p>
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */