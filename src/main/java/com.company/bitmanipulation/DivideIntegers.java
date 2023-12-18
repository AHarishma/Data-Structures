package com.company.bitmanipulation;

public class DivideIntegers {

    public int divideIntegers(int A, int B) {
        if (A <= Integer.MIN_VALUE) {
            return (A < 0) ^ (B < 0) ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
        int answer = 0;
        int a = Math.abs(A);
        int b = Math.abs(B);
        int bitLength = Helper.getBitLengthOfMaxLength(new int[]{a, b});
        for (int i = bitLength; i >= 0; i--) {
            if((b << i) <= a) {
                a -= (b << i);
                answer |= (1 << i);
            }
        }
        return (A < 0) ^ (B < 0) ? -answer : answer;
    }
}

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 *
 *
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 */