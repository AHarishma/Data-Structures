package com.company.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {
    public int maxChainLength(Pair arr[], int n) {
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return pair1.y - pair2.y;
            }
        });
        int endTime = 0;
        int chainLength = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].x > endTime) {
                endTime = arr[i].y;
                chainLength++;
            }
        }
        return chainLength;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }
}

/**
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
 * Output: 3
 * Explanation: The given pairs are { {5, 24}, {39, 60},
 * {15, 28}, {27, 40}, {50, 90} },the longest chain that
 * can be formed is of length 3, and the chain is
 * {{5, 24}, {27, 40}, {50, 90}}
 *
 * Link:
 * https://www.geeksforgeeks.org/problems/max-length-chain/1
 */