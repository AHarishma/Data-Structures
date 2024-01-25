package com.company.graph;

import java.util.Arrays;

public class IslandCountIn2dMatrix {
    private int[] rowIndex = new int[]{-1, 0, 0, 1};
    private int[] colIndex = new int[]{0, -1, 1, 0};

    public int countIsland(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Arrays.stream(visited).forEach(array -> Arrays.fill(array, false));
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] != 0) {
                    count++;
                    dfs(matrix, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < rowIndex.length; i++) {
            int row = x + rowIndex[i];
            int col = y + colIndex[i];
            if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] != 0 && !visited[row][col]) {
                dfs(matrix, row, col, visited);
            }
        }
    }
}

/**
 * Count the number of islands in given 2D binary matrix
 */