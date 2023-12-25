package com.company.bitmanipulation;

public class AnyBaseToDecimal {
    public int solve(int a, int b) {
        int sum = 0;
        int i = 0;
        while (a != 0) {
            sum += Math.pow(b, i) * a % 10;
            a = a / 10;
            i++;
        }
        return sum;
    }
}

/**
 * Any base to decimal
 * <p>
 * Problem Description
 * You are given a number A. You are also given a base B. A is a number on base B.
 * You are required to convert the number A into its corresponding value in decimal number system.
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= A <= 109
 * 2 <= B <= 9
 * <p>
 * <p>
 * Input Format
 * First argument A is an integer.
 * Second argument B is an integer.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = 1010
 * B = 2
 * Input 2:
 * A = 22
 * B = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 8
 * <p>
 * <p>
 * Example Explanation
 * For Input 1:
 * The decimal 10 in base 2 is 1010.
 * For Input 2:
 * The decimal 8 in base 3 is 22.
 */
