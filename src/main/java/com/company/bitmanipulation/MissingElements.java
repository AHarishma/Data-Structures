package com.company.bitmanipulation;

public class MissingElements {
    public int[] findMissingElement(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n + 2; i++) {
            xor ^= i;
        }
        int setBitPos = -1;
        for (int i = 0; i < 31; i++) {
            if (((xor >> i) & 1) == 1) {
                setBitPos = i;
                break;
            }
        }
        int bag1Xor = 0;
        int bag2Xor = 0;
        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] >> setBitPos) & 1) == 1) {
                bag1Xor ^= arr[i];
            } else {
                bag2Xor ^= arr[i];
            }
        }
        for (int i = 1; i <= n + 2; i++) {
            if (((i >> setBitPos) & 1) == 1) {
                bag1Xor ^= i;
            } else {
                bag2Xor ^= i;
            }
        }
        return new int[]{bag1Xor, bag2Xor};
    }
}

/**
 * Given an array of size N. Array contains all elements in [1, N + 2] except two elements.
 * Find the two missing elements.
 * N = 4
 * Array: [3, 6, 1, 4]
 * Output: [2, 5]
 */
