package com.company.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MishaAndCandies {

    private int solve(int[] array, int b) {
        int count = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            minHeap.add(array[i]);
        }
        for (int i = 0; i < minHeap.size(); i++) {
            int minElement = minHeap.poll();
            if (minElement <= b) {
                int chocolateEatenCount = minElement / 2;
                count += chocolateEatenCount;
                minHeap.add(minElement - chocolateEatenCount + minHeap.poll());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t;
        System.out.print("Enter no of test cases : ");
        t = scanner.nextInt();
        while (t-- > 0) {
            System.out.print("Enter size of array : ");
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }
            System.out.print("Enter B : ");
            int b = scanner.nextInt();
            MishaAndCandies mishaAndCandies = new MishaAndCandies();
            int result = mishaAndCandies.solve(array, b);
            System.out.println(result);
        }
    }
}

/**
 * Misha and Candies
 * <p>
 * Problem Description
 * Misha loves eating candies. She has been given N boxes of Candies.
 * <p>
 * She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
 * Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
 * <p>
 * NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
 * <p>
 * NOTE 2: The same box will not be chosen again.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i] <= 105
 * <p>
 * 1 <= B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
 * The second argument is B, the maximum number of candies Misha like in a box.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the number of candies Misha will eat.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 2, 3]
 * B = 4
 * Input 2:
 * <p>
 * A = [1, 2, 1]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 * 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 * She will not eat from the 3rd box as now it has candies greater than B.
 * So the number of candies Misha eat is 2.
 * Explanation 2:
 * <p>
 * 1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
 * 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
 * She will not eat from the 2nd box as now it has candies greater than B.
 * So the number of candies Misha eat is 1.
 */