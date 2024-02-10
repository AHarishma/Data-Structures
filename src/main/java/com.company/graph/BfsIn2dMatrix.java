package com.company.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BfsIn2dMatrix {
    private int[] rowIndex = new int[]{-1, 0, 0, 1};
    private int[] colIndex = new int[]{0, -1, 1, 0};

    public void bfs(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = 0; i < rowIndex.length; i++) {
                int row = node[0] + rowIndex[i];
                int col = node[1] + colIndex[i];
                if (row >= 0 && row < matrix.length &&
                        col >= 0 && col < matrix.length &&
                        !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new int[]{row, col});
                }
            }
        }
    }
}
