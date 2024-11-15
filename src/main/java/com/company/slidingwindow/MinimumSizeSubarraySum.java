package com.company.slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int minSubArrayLength = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minSubArrayLength = Math.min(r - l + 1, minSubArrayLength);
                sum -= nums[l];
                l++;
            }
        }
        return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
    }
}

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
