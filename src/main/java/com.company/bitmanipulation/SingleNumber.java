package com.company.bitmanipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

/**
 * Given an array which has all the elements are repeated twice except one number. Find the number.
 * Array: [2, 4, 7, 5, 4, 7, 2, 4, 4]
 * Output: 5
 * Solution:
 * Frequency HashMap -> TC: O(N), SC: O(N)
 * Sort -> TC: O(NlogN), SC: O(1)
 */
