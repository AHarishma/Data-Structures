package com.company.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BClosestPointToOrigin {
    private static final int[] ORIGIN = new int[]{0, 0};

    private int[][] findBClosestPointToOrigin(int[][] points, int b) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            double distance1 = Math.pow(o1[0] - ORIGIN[0], 2) + Math.pow(o1[1] - ORIGIN[1], 2);
            double distance2 = Math.pow(o2[0] - ORIGIN[0], 2) + Math.pow(o2[1] - ORIGIN[1], 2);
            return Double.compare(distance1, distance2);
        });

        priorityQueue.addAll(Arrays.asList(points));

        int[][] result = new int[b][2];
        for (int i = 0; i < b; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int b = 2;
        BClosestPointToOrigin bClosestPointToOrigin = new BClosestPointToOrigin();
        int[][] result = bClosestPointToOrigin.findBClosestPointToOrigin(points, b);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

}

/**
 * Link: https://leetcode.com/problems/k-closest-points-to-origin/description/
 * B closest points to Origin
 * <p>
 * Problem Description
 * We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
 * <p>
 * Here, the distance between two points on a plane is the Euclidean distance.
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= B <= length of the list A <= 105
 * -105 <= A[i][0] <= 105
 * -105 <= A[i][1] <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The argument given is list A and an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the B closest points to the origin (0, 0) in any order.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [1, 3],
 * [-2, 2]
 * ]
 * B = 1
 * Input 2:
 * <p>
 * A = [
 * [1, -1],
 * [2, -1]
 * ]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [ [-2, 2] ]
 * Output 2:
 * <p>
 * [ [1, -1] ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 * So one closest point will be [-2,2].
 * Explanation 2:
 * <p>
 * The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 * So one closest point will be [1,-1].
 */
