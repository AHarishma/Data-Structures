package com.company.bitmanipulation;

public class Helper {
    public static int getBitLengthOfMaxLength(int[] arr) {
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
