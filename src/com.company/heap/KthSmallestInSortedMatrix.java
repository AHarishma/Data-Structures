package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    int findKthSmallestInSortedMatrix(int[][] matrix, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(matrix[o1[0]][o1[1]], matrix[o2[0]][o2[1]]);
            }
        });

        for (int i = 0; i < matrix[0].length; i++) {
            priorityQueue.add(new int[]{i, 0});
        }

        while (k > 0 && !priorityQueue.isEmpty()) {
            int[] polledElement = priorityQueue.poll();
            if (polledElement[1] + 1 < matrix[0].length) {
                priorityQueue.add(new int[]{polledElement[0], polledElement[1] + 1});
            }
            k--;
            if (k == 0) {
                return matrix[polledElement[0]][polledElement[1]];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 9, 11}, {8, 11, 13}, {12, 13, 15}};
        int k = 8;
        KthSmallestInSortedMatrix kthSmallestInSortedMatrix = new KthSmallestInSortedMatrix();
        System.out.println(kthSmallestInSortedMatrix.findKthSmallestInSortedMatrix(matrix, k));
    }
}

/**
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
