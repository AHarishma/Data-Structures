package com.company.array;

public class GroupFiveAtStart {

    public int[] groupfiveAtStart(int[] arr) {
        int insertPos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) == 5) {
                int temp = arr[i];
                for (int j = i; j > insertPos; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[insertPos] = temp;
                insertPos++;
            }
        }
        return arr;
    }
}

/**
 * Time Complexity - O(n2)
 * Space Complexity - O(1)
 * input - {5, 5, 1, 2, 3, -5, 6, 7, 8, 7, 5, 0}
 * output - {5, 5, -5, 5, 1, 2, 3, 6, 7, 8, 7, 0}
 * Don't use extra array
 */
