package com.company;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        mergeSortRecursion(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSortRecursion(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSortRecursion(arr, l, mid);
        mergeSortRecursion(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] tempArr = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                tempArr[k] = arr[i];
                i++;
            } else {
                tempArr[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            tempArr[k] = arr[i];
            k++;
            i++;
        }
        while (j <= r) {
            tempArr[k] = arr[j];
            k++;
            j++;
        }
        for (int elem : tempArr) {
            arr[l] = elem;
            l++;
        }
    }

    // 5, 3, 4, 2
    // 5, 3 --> 5 ( 1st recursion ) --> 3 ( 2nd recursion )
    // 4, 2

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.mergeSort(new int[]{-1, 4, 2})));
    }
}
