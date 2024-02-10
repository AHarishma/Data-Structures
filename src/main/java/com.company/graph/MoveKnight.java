package com.company.graph;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class MoveKnight {
    int[] rowIndex = new int[]{-2, -2, 2, 2, -1, 1, -1, 1};
    int[] colIndex = new int[]{-1, 1, -1, 1, -2, -2, -2, 2};

    public int getMinimumNumberOfSteps(int[][] chessboard, int sx, int sy, int dx, int dy) {
        boolean[][] visited = new boolean[chessboard.length][chessboard[0].length];
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
                if (row >= 0 && row < chessboard.length && col >= 0 && col < chessboard[0].length && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new PointInfo(row, col, node.distance + 1));
                }
            }
        }
        return -1;
    }

    @AllArgsConstructor
    class PointInfo {
        public int x;
        public int y;
        public int distance;
    }
}

/**
 * Given a n x n chessboard, source point(x, y), destination point(x, y).
 * Find the minimum number of steps to move the knight from source to destination.
 * Try your own using normal BFS method.
 * Change row index and col index according to next knight position.
 */
