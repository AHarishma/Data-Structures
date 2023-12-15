package com.company.bitmanipulation;

public class InterestingArray {

    public String solve(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                count++;
            }
        }

        return (count & 1) == 0 ? "Yes" : "No";
    }
}

/**
 * Interesting Array
 * <p>
 * Problem Description
 * You have an array A with N elements. We have two types of operation available on this array :
 * We can split an element B into two elements, C and D, such that B = C + D.
 * We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
 * You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * <p>
 * 1 <= A[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return "Yes" if it is possible otherwise return "No".
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [9, 17]
 * Input 2:
 * <p>
 * A = [1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * Yes
 * Output 2:
 * <p>
 * No
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Following is one possible sequence of operations -
 * 1) Merge i.e 9 XOR 17 = 24
 * 2) Split 24 into two parts each of size 12
 * 3) Merge i.e 12 XOR 12 = 0
 * As there is only 1 element i.e 0. So it is possible.
 * Explanation 2:
 * <p>
 * There is no possible way to make it 0.
 */
