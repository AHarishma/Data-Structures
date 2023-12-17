package com.company.bitmanipulation;

public class MaxAndValue {
    public int findMaxAndValue(int[] arr) {
        int answer = 0;
        int bitLength = Helper.getBitLengthOfMaxLength(arr);
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
}
