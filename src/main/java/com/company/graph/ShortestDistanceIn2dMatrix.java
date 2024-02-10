package com.company.graph;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceIn2dMatrix {
    private int[] rowIndex = new int[]{-1, 0, 0, 1};
    private int[] colIndex = new int[]{0, -1, 1, 0};

    public int shortestDistance(int[][] matrix, int sx, int sy, int dx, int dy) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<PointInfo> queue = new LinkedList<>();
        queue.add(new PointInfo(sx, sy, 0));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            PointInfo node = queue.poll();
            if (node.x == dx && node.y == dy) {
                return node.distance;
            }
            for (int i = 0; i < rowIndex.length; i++) {
                int row = node.x + rowIndex[i];
                int col = node.y + colIndex[i];
                if (row >= 0 && row < matrix.length &&
                        col >= 0 && col < matrix.length &&
                        matrix[row][col] !=0 && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new PointInfo(row, col, node.distance + 1));
                }
            }
        }
        return -1;
    }

    @AllArgsConstructor
    private class PointInfo {
        int x;
        int y;
        int distance;
    }
}

/**
 * Shortest distance from given source to destination with some blocking cells in 2D matrix
 * 1 -> traverse
 * 0 -> blocking cell
 * <p>
 * TC: O(N^2)
 * SC:O(N^2)
 */
