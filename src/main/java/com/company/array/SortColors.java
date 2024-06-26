package com.company.array;

public class SortColors {
    public int[] _sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            }
            if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // another way
    public int[] sortColors(int[] nums) {
        int[] count = new int[3];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count[0]++;
            } else if (nums[i] == 1) {
                count[1]++;
            } else if (nums[i] == 2) {
                count[2]++;
            }
        }
        int i = 0;
        int j = 0;
        while (j < 3) {
            int loopCount = 0;
            while (loopCount < count[j]) {
                res[i] = j;
                i++;
                loopCount++;
            }
            j++;
        }
        return res;
    }
}

/**
 * https://leetcode.com/problems/sort-colors/description/
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
