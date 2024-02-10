package com.company.graph;

import java.util.Arrays;

public class KnightArrangements {
    int[] rowIndex = new int[]{-2, -2, 2, 2, -1, 1, -1, 1};
    int[] colIndex = new int[]{-1, 1, -1, 1, -2, -2, -2, 2};

    public int getNumberOfKnightArrangements(int[][] chessboard) {
        int result = 1;
        boolean[][] visited = new boolean[chessboard.length][chessboard[0].length];
        Arrays.stream(visited).forEach(array -> Arrays.fill(array, false));
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if (chessboard[i][j] == 2 && !visited[i][j]) {
                    int factorial = 1;
                    int numberOfKnights = dfs(chessboard, i, j, visited);
                    for (int k = numberOfKnights; k > 0; k--) {
                        factorial *= k;
                    }
                    result *= factorial;
                }
            }
        }
        return result;
    }

    private int dfs(int[][] chessboard, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        int numberOfKnights = 1;
        for (int i = 0; i < rowIndex.length; i++) {
            int row = x + rowIndex[i];
            int col = y + colIndex[i];
            if (row >= 0 && row < chessboard.length && col >= 0 && col < chessboard[0].length && chessboard[row][col] == 2 && !visited[row][col]) {
                numberOfKnights += dfs(chessboard, row, col, visited);
            }
        }
        return numberOfKnights;
    }
}

/**
 * Given a n x n chessboard, and k knights in the board. If two knights are adjacent in terms of their movement, then you can swap those two knights.
 * Find the number of arrangement of knights in given board.
 * <p>
 * A, B, C
 * B, A, C
 * A, C, B
 * C, A, B
 * B, C, A
 * C, B, A
 * 1. Find number of knights in each connected component.
 * 2. Find the factorial of number of knights.
 * 3. Multiply all the values.
 * <p>
 * Given a matrix which has k knights marked their positions with 'K'
 */
