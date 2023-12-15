package com.company.bitmanipulation;

public class XorSum {

    // 3, 5, 6, 8, 2
    public int xorSumAllPairs(int[] arr) {
        int bitLength = getBitLengthOfMaxLength(arr);
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

    public int getBitLengthOfMaxLength(int[] arr) {
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }
        int bitLength = 0;
        if (maxElement == 0) {
            return 1;
        }

        while (maxElement > 0) {
            maxElement >>= 1;
            bitLength++;
        }
        return bitLength;
    }
}
