package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxArraySumAfterNegations {

    private int solve(int[] array, int b) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            minHeap.add(array[i]);
        }
        while( b > 0) {
            minHeap.add(minHeap.poll() * -1);
            b--;
        }
        int maxArraySum = 0;
        while(!minHeap.isEmpty()) {
            maxArraySum += minHeap.poll();
        }
        return maxArraySum;
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
            MaxArraySumAfterNegations maxArraySumAfterNegations = new MaxArraySumAfterNegations();
            int result = maxArraySumAfterNegations.solve(array, b);
            System.out.println(result);
        }
    }
}

/**
 * Maximum array sum after B negations
 *
 * Problem Description
 * Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
 *
 * You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
 *
 *
 *
 * NOTE: You can perform the modification on the same element multiple times.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 5*105
 * 1 <= B <= 5 * 106
 * -100 <= A[i] <= 100
 *
 *
 *
 * Input Format
 * The first argument given is an integer array A.
 * The second argument given is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum array sum after B modifications.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [24, -68, -29, -9, 84]
 *  B = 4
 * Input 2:
 *
 *  A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 *  B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 *  196
 * Output 2:
 *
 *  362
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *
 * Operation 1: Make -29 to 29,
 * Operation 2: Make -9 to 9,
 * Operation 3: Make 9 to -9,
 * Operation 4: Make -68 to 68.
 * Thus, the final array after 4 modifications = [24, 68, 29, -9, 84]
 * Explanation 2:
 *
 *  Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 */
