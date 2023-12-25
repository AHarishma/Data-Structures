package com.company.bitmanipulation;

public class DecimalToAnyBase {
    public int decimalToAnyBase(int a, int b) {
        int result = 0;
        int multiplier = 1;
        while (a > 0) {
            result += a % b * multiplier;
            a = a / b;
            multiplier *= 10;
        }
        return result;
    }
}
/**
 * Decimal to any base
 * <p>
 * Problem Description
 * Given a decimal number A and a base B, convert it into its equivalent number in base B.
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= A <= 512
 * 2 <= B <= 10
 * <p>
 * <p>
 * Input Format
 * The first argument will be decimal number A.
 * The second argument will be base B.
 * <p>
 * <p>
 * Output Format
 * Return the conversion of A in base B.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = 4
 * B = 3
 * Input 2:
 * A = 4
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 11
 * Output 2:
 * 100
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * Decimal number 4 in base 3 is 11.
 * Explanation 2:
 * Decimal number 4 in base 2 is 100.
 */