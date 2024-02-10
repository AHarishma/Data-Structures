package com.company.bitmanipulation;

public class XorSum {

    public int xorSumAllPairs(int[] arr) {
        int bitLength = Helper.getBitLengthOfMaxLength(arr);
        int answer = 0;
        for (int i = 0; i < bitLength; i++) {
            int ones = 0;
            int zeros = 0;
            for (int value : arr) {
                if (((value >> i) & 1) == 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }

            answer += (1 << i) * ones * zeros;
        }
        return answer << 1;
    }
}

/**
 * Calculate xor sum of all pairs in an array.
 * Array: [3, 5, 6, 8, 2]
 * Output: 148
 */
