package com.company.backtracking;

import java.util.Arrays;

public class UniquePaths {

    int[] rowIndex = new int[]{-1, 0, 0, 1};
    int[] colIndex = new int[]{0, -1, 1, 0};
    int count = 0;

    private int solve(int[][] maze) {
        int[] start = new int[]{-1, -1};
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
            if (start[0] != -1) {
                break;
            }
        }
        if (start[0] == -1) {
            return 0;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Arrays.stream(visited).forEach(array -> Arrays.fill(array, false));
        visited[start[0]][start[1]] = true;
        dfs(maze, start[0], start[1], visited);
        return count;
    }

    private void dfs(int[][] maze, int i, int j, boolean[][] visited) {
        if (maze[i][j] == 2) {
            if (isAllVisited(maze, visited)) {
                count++;
            }
            return;
        }

        for (int k = 0; k < rowIndex.length; k++) {
            int row = i + rowIndex[k];
            int col = j + colIndex[k];
            if (row >= 0 && row < maze.length && col >= 0 && col < maze[row].length &&
                    (maze[row][col] == 0 || maze[row][col] == 2) && !visited[row][col]) {
                visited[row][col] = true;
                dfs(maze, row, col, visited);
                visited[row][col] = false;
            }
        }
    }

    private boolean isAllVisited(int[][] maze, boolean[][] visited) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {-1, -1, 2, -1}
        };
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.solve(maze);
        System.out.println("No of unique paths ::  " + uniquePaths.count);
    }
}
