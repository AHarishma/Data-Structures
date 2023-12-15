package com.company.bitmanipulation;

public class DivideIntegers {

    public int divideIntegers(int A, int B) {
        int answer = 0;
        int a = Math.abs(A);
        int b = Math.abs(B);
        int bitLength = getBitLengthOfMaxLength(a, b);
        for (int i = bitLength; i >= 0; i--) {
            if((b << i) <= a) {
                a -= (b << i);
                answer |= (1 << i);
            }
        }
        return (A < 0) ^ (B < 0) ? -answer : answer;
    }

    public int getBitLengthOfMaxLength(int a, int b) {
        int maxElement = Math.max(a, b);
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
