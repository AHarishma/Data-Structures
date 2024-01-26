package com.company.bitmanipulation;

import java.util.Arrays;

public class MinimumXORValue {
    public int findMinimumXORValue(int[] arr) {
        Arrays.sort(arr);
        int minXOR = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int xor = arr[i - 1] ^ arr[i];
            minXOR = Math.min(minXOR, xor);
        }
        return minXOR;
    }
}

/**
 * Minimum XOR Value:
 * <p>
 * Nearing number will always give minimum xor
 */

