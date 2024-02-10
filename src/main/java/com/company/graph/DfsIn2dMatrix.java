package com.company.graph;

import java.util.Arrays;

public class DfsIn2dMatrix {
    private int[] rowIndex = new int[]{-1, 0, 0, 1};
    private int[] colIndex = new int[]{0, -1, 1, 0};

    public void depthFirstSearch(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Arrays.stream(visited).forEach(array -> Arrays.fill(array, false));
        dfs(matrix, 0, 0, visited);
    }

    private void dfs(int[][] matrix, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < rowIndex.length; i++) {
            int row = x + rowIndex[i];
            int col = y + colIndex[i];
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length && !visited[row][col]) {
                dfs(matrix, row, col, visited);
            }
        }
    }
}

/**
 * Depth First Search in 2D matrix
 * TC: O(N^2)
 * SC:O(N^2)
 */
