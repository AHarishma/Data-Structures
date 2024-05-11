package com.company.binarysearch;

public class StaircaseCount {
    public int getStaircaseStepsCount(int noOfBlocks) {
        int left = 1;
        int right = noOfBlocks;
        int staircaseStepsCount = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int blocks = (mid * (mid + 1)) / 2;
            if (noOfBlocks >= blocks) {
                staircaseStepsCount = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return  staircaseStepsCount;
    }
}

/**
 * Find the maximum number of staircase can be built using the given square blocks to you.
 * <p>
 * noOfBlocks = 10
 * <p>
 * Brute Force:
 * public int noOfStairCase(int noOfBlocks) {
 * int height = 0;
 * while (noOfBlocks > 0) {
 * height++;
 * noOfBlocks -= height;
 * }
 * return height;
 * }
 * <p>
 * <p>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
