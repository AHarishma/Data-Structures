package com.company;

import java.util.Arrays;

public class Solution {
    public static int sqrt(int number) {
        for(int i = 1; i <= number / 2; i++) {
            if (i * i == number) {
                return i;
            }
        }
        return -1;
    }
    // k = 3
    // [1, 2, 3, 4, 5, 6] [ 4, 5, 6, 1, 2, 3]
    // [4, 5, 6, 1, 2, 3]
    // k = 1
    // [1, 2, 3]
    // [3, 1, 2]
    // k = 4
    //  0  1  2  3  4
    // [1, 2, 3, 4, 5]  [5, 2, 3, 4, 1] [5, 1, 2, 3, 4]
    // [2, 3, 4, 5, 1]  []
    // k = 2
    // [4, 5, 1, 2, 3]  [4, 5, 3, 1, 2] [4, 5, 1, 2, 3]
    // [5, 1, 2, 3, 4]



    public static int[] rotateArray(int[] arr, int k) {
      int i = 0;
      int j = arr.length - k;
      while(i < k &&  j < arr.length) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
          i++;
          j++;
      }

      int l = k;
      int m = arr.length;
      while(l < m &&  m < arr.length) {
          int temp = arr[l];
          arr[l] = arr[m];
          arr[m] = temp;
          l++;
          m--;
      }
      return arr;
    }

    public static void main(String[] args) {
//        System.out.println(Solution.sqrt(64));
        System.out.println(Arrays.toString(Solution.rotateArray(new int[]{1, 2, 3, 4, 5}, 2)));
    }
}

