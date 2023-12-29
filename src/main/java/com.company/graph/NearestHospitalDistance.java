package com.company.graph;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class NearestHospitalDistance {
    private int[] rowIndex = new int[]{-1, 0, 0, 1};
    private int[] colIndex = new int[]{0, -1, 1, 0};

    public int[][] nearestHospital(int[][] matrix) {
        int[][] distance = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<PointInfo> queue = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j< matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new PointInfo(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            PointInfo node = queue.poll();
            distance[node.x][node.y] = node.distance;
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
        return distance;
    }

    @AllArgsConstructor
    private class PointInfo {
        int x;
        int y;
        int distance;
    }
}

/**
 * Nearest distance to the hospital from each house
 */
