package com.company.bitmanipulation;

public class SingleNumberThree {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int setBitPos = -1;
        for (int i = 0; i < 31; i++) {
            if (((xor >> i) & 1) == 1) {
                setBitPos = i;
                break;
            }
        }
        int bag1Xor = 0;
        int bag2Xor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> setBitPos) & 1) == 1) {
                bag1Xor ^= nums[i];
            } else {
                bag2Xor ^= nums[i];
            }
        }
        return new int[]{bag1Xor, bag2Xor};
    }
}
