package com.company.bitmanipulation;

public class MaxAndValue {
    int findMaxAndValue(int[] arr) {
        int answer = 0;
        int bitLength = getBitLengthOfMaxLength(arr);
        for (int i = bitLength; i >= 0; i--) {
            int count = 0;
            for (int val : arr) {
                if (((val >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count > 1) {
                answer |= (1 << i);
                for (int j = 0; j < arr.length; j++) {
                    if (((arr[j] >> i) & 1) == 0) {
                        arr[j] = 0;
                    }
                }
            }
        }
        return answer;
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
