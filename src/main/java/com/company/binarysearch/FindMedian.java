package com.company.binarysearch;

public class FindMedian {

    public int findMedian(int[] array1, int[] array2) {
        if (array1.length == 0) {
            if (array2.length % 2 == 0) {
                return (array2[array2.length / 2] + array2[array2.length / 2 - 1]) / 2;
            }
            return array2[array2.length / 2];
        }

        if (array2.length == 0) {
            if (array1.length % 2 == 0) {
                return (array1[array1.length / 2] + array1[array1.length / 2 - 1]) / 2;
            }
            return array1[array1.length / 2];
        }
        if ((array1.length + array2.length) % 2 == 0) {
            return (getMid(array1, array2, (array1.length + array2.length) / 2 - 1) + getMid(array1, array2, (array1.length + array2.length) / 2)) / 2;
        }

        return getMid(array1, array2, (array1.length + array2.length) / 2);
    }

    private int getMid(int[] array1, int[] array2, int length) {
        int left = Math.min(array1[0], array2[0]);
        int right = Math.max(array1[array1.length - 1], array2[array2.length - 1]);
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = lessThanOrEqual(array1, mid) + lessThanOrEqual(array2, mid); //TC: logn + logm = log(nm)
            if (count >= length) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private int lessThanOrEqual(int[] arr, int value) {
        int answer = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] < value) {
                answer = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    /**
     * TC: O(logn)
     * SC: O(1)
     */
}

/**
 * Given two sorted arrays. Find the median of it.
 * <p>
 * Array 1: [1, 6, 9, 15, 19, 24, 29, 30]
 * <p>
 * Array 2: [2, 4, 8, 11, 13, 20, 21]
 * <p>
 * [1, 2, 4, 6, 8, 9, 11, 13, 15, 19, 20, 21, 24, 29, 30] -- 13
 * Total number of elements = 15/2 = 7
 * <p>
 * [1, 2, 4, 6, 8, 9, 11, 12, 13, 15, 19, 20, 21, 24, 29, 30] - (12 + 13)/2 = 12.5
 * <p>
 * Brute Force:
 * mid = 7
 * index1 = 0
 * index2 = 0
 * <p>
 * Repeat for mid times
 * a1[i1] < a2[i2]
 * i1++;
 * else
 * i2++;
 * <p>
 * TC: O(N+M)
 * SC: O(1)
 * <p>
 * 10000 -> 5000 -> 2500 -> 1250 -> 625 -> 312 -> 156 -> 78 -> 39 -> 19 -> 9 -> 4 -> 2 -> 1
 * <p>
 * Left Region: < (N + M) / 2
 * Right Region: >= (N + M) / 2
 * <p>
 * R -> Max(a[], b[]) - Min(a[], b[]), where R is range
 * TC: O(logRlog(nm))
 * SC: O(1)
 * <p>
 * <p>
 * [100000000000, 100000000000001]
 * [20000, 300000, 400000]
 * left = 20000
 * right = 100000000000001
 * <p>
 * length = (array1.length + array2.length) / 2; //odd  = 7
 * length = ((array1.length + array2.length) / 2)  and ((array1.length + array2.length) / 2) - 1 // even = 16/2 and 16/2 - 1 = (7, 8)
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1
 */